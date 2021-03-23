package genericmapper;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Generic Mapper. Mapper functions: <br/>
 * <ul>
 * <li>Construct an entity from array of objects.</li>
 * <li>Deconstruct an entity into an array of objects.</li>
 * <li>Stream an entity as FieldPairs, which is pair of String name and Object
 * value<li>
 * </ul>
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmial.com}
 * @param <E> entity type to map.
 */
public abstract class Mapper<E> {

    protected final Class<E> entityType;
    protected final Field[] entityFields;
    private final MethodHandles.Lookup lookup = MethodHandles.lookup();

    private final Function<Object[], E> allFieldsConstructor;

    /**
     * Create a mapper for given type.
     *
     * @param entityType type
     */
    protected Mapper( Class<E> entityType ) {
        this.entityType = entityType;
        entityFields = entityFields( entityType );//entityType.getDeclaredFields();
        allFieldsConstructor = findConstructor( entityFields );
    }

    /**
     * Find all declared entityFields in the class hierarchy of the entity type
     * et.
     *
     */
    final Field[] entityFields( Class<E> et ) {
        List<Field[]> list = new ArrayList<>();
        Class<?> current = et;
        while ( current != Object.class ) {
            list.add( current.getDeclaredFields() );
            current = current.getSuperclass();
        }
        Collections.reverse( list );

        return list.stream().flatMap( Stream::of ).toArray( Field[]::new );
    }

    /**
     * Returns unmodifiable list of the entity fields.
     *
     * @return the fields
     */
    public List<Field> entityFields() {
        return List.of( entityFields );
    }

    /**
     * Deconstruct the entity into an array of Objects.
     *
     * @param entity to deconstruct
     * @return the entityFields in an array
     */
    public abstract Object[] deconstruct( E entity );

    /**
     * Create an object using the field values.
     *
     * @param fieldValues to use
     * @return the constructed entity
     */
    public E construct( Object[] fieldValues ) {
        return allFieldsConstructor.apply( fieldValues );
    }

    /**
     * Stream the entity as field-name and field value pairs
     *
     * @param entity to stream
     * @return Stream of field information
     */
    public Stream<FieldPair> stream( E entity ) {
        Object[] fieldValues = deconstruct( entity );
        return IntStream
                .range( 0, entityFields.length )
                .mapToObj( i -> new FieldPair( entityFields[i].getName(),
                fieldValues[i] )
                );
    }

    /**
     * Helper to find the constructor using the entityFields definition.
     *
     * @param fields to find the signature of the constructor
     * @return a function that can construct and entity form an array
     */
    final Function<Object[], E> findConstructor( Field[] fields ) {
        Function<Object[], E> assembler = null;
        try {
            Class[] fieldTypes = Stream.of( fields )
                    .map( f -> f.getType() )
                    .toArray( gen -> new Class[ fields.length ] );
            Constructor<E> declaredConstructor = entityType.getConstructor(
                    fieldTypes );
            MethodHandle ctorHandle = lookup.unreflectConstructor(
                    declaredConstructor );
            assembler = createConstructorFunction( ctorHandle );
        } catch ( IllegalAccessException | NoSuchMethodException ex ) {
            Logger.getLogger( Mapper.class.getName() ).log( Level.SEVERE, ex
                    .getMessage() );
        }
        return assembler;
    }

    /**
     * Use a method handle to create a function that can construct an entity
     * from an array of objects.
     *
     * @param ctorHandle method handle to a found candidate Constructor
     * @return the function.
     */
    private Function<Object[], E> createConstructorFunction(
            MethodHandle ctorHandle ) {
        Function<Object[], E> assembler;
        assembler = ( Object[] a ) -> {
            E cresult = null;
            try {
                cresult = (E) ctorHandle.invokeWithArguments( a );
            } catch ( Throwable ex ) {
                Logger.getLogger( Mapper.class.getName() ).log( Level.SEVERE, ex
                        .getMessage() );
            }
            return cresult;
        };
        return assembler;
    }

    private static final ConcurrentMap<Class<?>, Mapper<?>> register = new ConcurrentHashMap<>();

    protected static void register( Mapper<?> em ) {
        register.put( em.entityType, em );
    }

    static class StringMapper extends Mapper<String> {

        private StringMapper() {
            super( String.class );
        }

        static {
            register.put( String.class, new StringMapper() );
        }

        @Override
        public Object[] deconstruct( String entity ) {
            return new Object[]{ entity };
        }
    }

    static {
        System.out.println( "loading" + StringMapper.class.toString() );
    }

    public static <Y> Mapper<Y> mapperFor( Class<Y> et ) {
        if ( !register.containsKey( et ) ) {
            loadMapperClass( et );
        }
        return (Mapper<Y>) register.get( et );
    }

    /**
     * Try to load a mapper for an entity by name. If the type == String.class,
     * do nothing, because String is special.
     *
     * @param <E>
     * @param forEntity
     * @throws a RuntimeException when the requested mapper class cannot be
     * loaded
     */
    private static <E> void loadMapperClass( Class<E> forEntity ) {
        if ( forEntity == String.class ) {
            return;
        }
        String mapperName = Constants.mapperName( forEntity );
        try {
            Class.forName( mapperName, true, forEntity.getClassLoader() );
            Logger.getLogger( Mapper.class.getName() )
                    .log( Level.INFO,
                            "mapper {0} for class {1} successfully loaded",
                            new Object[]{ mapperName, forEntity.getSimpleName() } );

        } catch ( ClassNotFoundException ex ) {
            Logger.getLogger( Mapper.class.getName() ).log( Level.SEVERE,
                    "could not find mapper {0} for class {1}",
                    new String[]{ mapperName, forEntity.getSimpleName() } );
            throw new RuntimeException( ex );
        }
    }

}

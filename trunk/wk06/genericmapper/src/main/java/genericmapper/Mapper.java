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
 * Generic Mapper.Mapper functions: <br/>
 * <ul>
 * <li>Construct an entity from array of objects.</li>
 * <li>Deconstruct an entity into an array of objects.</li>
 * <li>Stream an entity as FieldPairs, which is pair of String name and Object
 * value<li>
 * </ul>
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 * @param <M> mapper
 * @param <E> entity type to map.
 * @param <K> key for the entity
 */
public abstract class Mapper< E, K> {

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
        entityFields = entityFields( entityType );
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
     * An entity typically has some kind of identity. Primary key in a database,
     * key in a HashMap.
     *
     * The function should produce a the key given an entity. You use it like
     * this: {@code K = mapper.keyExtractor(entity);}
     *
     * @return the extractor function.
     */
    public abstract Function<? super E, ? extends K> keyExtractor();

    /**
     * Return the key defined for the entity.
     *
     * @return class of entity
     */
    public abstract Class<?> keyType();

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
            assembler = createCtorFunction( ctorHandle );
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
    private Function<Object[], E> createCtorFunction( MethodHandle ctorHandle ) {
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

    private static final ConcurrentMap<Class<?>, Mapper< ?, ?>> register = new ConcurrentHashMap<>();

    protected static void register( Mapper<?, ?> em ) {
        register.put( em.entityType, em );
    }

    static class StringMapper extends Mapper< String, String> {

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

        /**
         * simply return the string.
         *
         * @return the implementation for this extractor.
         */
        @Override
        public Function<String, String> keyExtractor() {
            return x -> x;
        }

        @Override
        public Class<?> keyType() {
            return String.class;

        }

    }

    static {
        System.out.println( "loading  StringMapper" );
        try {
            Class.forName( "genericmapper.Mapper$StringMapper" );
        } catch ( ClassNotFoundException neverhappens ) {
        }
    }

    public static <X, Y> Mapper< X, Y> mapperFor(
            Class<X> et ) {
        if ( !register.containsKey( et ) ) {
            loadMapperClass( et );
        }
        return (Mapper< X, Y>) register.get( et );
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
    static <E> void loadMapperClass( Class<E> forEntity ) {
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

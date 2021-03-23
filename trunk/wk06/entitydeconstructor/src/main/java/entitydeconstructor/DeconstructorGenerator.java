package entitydeconstructor;

import static entitydeconstructor.Constants.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

/**
 * Generate java code by reflecting on an entity and create a Deconstructor.
 *
 * The generated Deconstructor should extend the generic
 * {@code Deconstructor<E>}, where E is the entity type.
 *
 *
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 */
public class DeconstructorGenerator {

    final Class<?> entityType;

    public DeconstructorGenerator( Class<?> entityType ) {
        this.entityType = entityType;
    }

    /**
     * Assemble the java code into one String. Use a stream operation or
     * String.join(glue, Iterable).
     *
     * @return the generated java code
     */
    final String javaSource() {
        String typeName = entityType.getSimpleName();
        String paramName = typeName.substring( 0, 1 ).toLowerCase();
        String classText = String.format( CODE_TEMPLATE,
                GENERATED_PACKAGE, // <1>
                typeName, // <2>
                paramName, // <3>
                getters( entityType ) // <4>
        );
        return classText;
    }

    /**
     * Turn the fields of a class into getter call strings.
     *
     * @param type to reflect
     * @return The getters as one indented string.
     */
    final String getters( Class<?> type ) {
        String typeName = type.getSimpleName();
        String paramName = typeName.substring( 0, 1 ).toLowerCase();
        String paramNameDot = paramName + ".";
        Field[] declaredFields = getAllFieldsInClassHierarchy( type );
        String indent = "              ";
        return Stream.of( declaredFields ) //.map( this::getterName).
                .map( this::getterName )
                .map( s -> indent + paramNameDot + s )
                .collect( joining( ",\n" ) );
    }

    /**
     * Collect the declared fields of the classes in the class hierarchy and put
     * the in declaration order from top to bottom.
     *
     * The fields of the top most classes should appear first. After collecting
     * the Field[] arrays in the list, reverse the list and stream and flat-map
     * it to Fields which should the be put in array
     *
     * @param type to generate deconstructor for
     * @return all fields in the class hierarchy
     */
    final Field[] getAllFieldsInClassHierarchy( final Class<?> type ) {
        List<Field[]> fieldArrays = new ArrayList<>();
        Class<?> currentClz = type;
        //TODO walk the class hierarchy from type up
        return new Field[0];
    }

    /**
     * Create the getter call.
     *
     * @param f for field with name "someName"
     * @return getSomeName()
     */
    String getterName( Field f ) {
        //TODO create a getter name including prefix and closing ()
        return "";
    }

    public static void main( String[] args ) throws ClassNotFoundException,
            FileNotFoundException,
            IOException,
            InterruptedException {
        for ( String arg : args ) {
            System.out.println( "// generating for " + arg );
            Class<?> clz = Class.forName( arg );
            System.out.println( new DeconstructorGenerator( clz ).javaSource() );
        }
    }

}

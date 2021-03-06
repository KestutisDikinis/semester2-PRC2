package genericmapper;

import static genericmapper.Constants.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;
import nl.fontys.sebivenlo.sebiannotations.ID;

/**
 * Generates mappers for named Types. The types are fully qualified types to be
 * read from the class path.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class MapperGenerator {

    public static void main( String[] args ) throws ClassNotFoundException,
            FileNotFoundException,
            IOException,
            InterruptedException {
        System.err.println( "generic mapper generator" );
        for ( String arg : args ) {
            System.err.flush();
            System.out.println( "// generating for " + arg );
            Class<?> clz = Class.forName( arg );
            String fileName = generatedJavaFileName( clz );
            File dir = new File( fileName );
            dir.getParentFile().mkdirs();
            System.out.println( "fileName = " + fileName );
            String javaSource = new MapperGenerator( clz ).javaSource();
            System.out.println( "classText = " + javaSource );
            if ( !javaSource.isBlank() ) {
                try ( PrintStream out = new PrintStream( fileName ) ) {
                    out.print( javaSource );
                    out.flush();
                }
            }
        }
    }

    final Class<?> entityType;

    public MapperGenerator( Class<?> entitype ) {
        this.entityType = entitype;
    }

    /**
     * Generate the java code using the template MAPPER_TEMPLATE.
     *
     * @return the template text or an empty string when the class has no usable
     * id field.
     */
    final String javaSource() {
        String classText = "";
        //TODO generate the code
        return "";
    }

    /**
     * Turn the fields of a class into getter call strings.
     *
     * @param type to reflect
     * @return The getters as one indented string.
     */
    final String getters() {
        //TODO generate the setter calls.
        return "";
    }

    /**
     * Generate the array of fields in top down declaration order. Top down
     * means the super stuff first.
     *
     * @return the array of all declared fields in the class hierarchy.
     */
    final Field[] getAllFieldsInClassHierarchy() {
        List<Field[]> fieldArrays = new ArrayList<>();
        //TODO
        return new Field[0];
    }

    /**
     * Produce a getter call like getName().
     *
     * @param f for field
     * @return getName() for field name.
     */
    String getterName( Field f ) {
        //TODO
        return "get()";
    }

    /**
     * Try to find the Annotation @ID and if that fails the field called "id".
     *
     *
     * @return the field.
     * @throws NoSuchFieldError after two attempts
     */
    Field getKeyField() {
        return Stream.of( entityType.getDeclaredFields() )
                .peek( System.out::println )
                .filter( f -> f.getAnnotation( ID.class ) != null )
                .findFirst()
                .or( this::getFieldNamedId )
                .orElseThrow( () -> new NoSuchFieldError(
                "for entity '" + entityType.getName()
                + "' neither Annotated nor named id" ) );

    }

    Optional<Field> getFieldNamedId() {
        return Stream.of( entityType.getDeclaredFields() ).filter(
                f -> "id".equals( f.getName() ) )
                .findFirst();
    }
}

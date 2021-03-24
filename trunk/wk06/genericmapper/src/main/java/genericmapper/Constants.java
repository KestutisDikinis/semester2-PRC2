package genericmapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Constant String values used in Mapper api.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public enum Constants {
    ;// no values

    public static final String GENERATED_PACKAGE = "generatedmappers";
    public static final String GENERATED_DIRNAME = "out/src/main/java/"
            + GENERATED_PACKAGE.replaceAll( "\\.", "/" );

    public static String mapperName( Class<?> entityType ) {
        return GENERATED_PACKAGE + "." + entityType.getSimpleName()+"Mapper";
    }

    private static String templateText( String templateName ) {
        String text = "";
        Class clz = Constants.class;

        try ( InputStream in = clz.getResourceAsStream( templateName ) ) {
            text = new String( in.readAllBytes​() );
        } catch ( IOException ex ) {
            Logger.getLogger( Constants.class.getName() )
                    .log( Level.SEVERE, ex.getMessage() );
        }
        return text;
    }
    public static String MAPPER_TEMPLATE = templateText( 
            "CodeTemplate-java.txt" );

    public static String generatedJavaFileName( Class<?> type ) {
        String n = type.getSimpleName();
        return GENERATED_DIRNAME + "/" + n +  "Mapper.java";
    }
}

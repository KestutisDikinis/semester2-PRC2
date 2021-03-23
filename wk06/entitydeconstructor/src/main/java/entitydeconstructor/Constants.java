package entitydeconstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Constant String values used in Deconstructor api.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public enum Constants {
    ;// no values

    public static final String GENERATED_PACKAGE = "generateddeconstructors";

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
    public static String CODE_TEMPLATE = templateText( 
            "CodeTemplate-java.txt" );

}

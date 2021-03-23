package genealogy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Output the class hierarchy or ancestry of a class.
 *
 * @author hom
 */
public class Genealogy {

    int c = new ArrayList<Class>().stream().mapToInt( p -> 1 ).sum();

    /**
     * @param args the command line arguments.
     */
    public static void main( String[] args ) {
        if ( args.length == 0 ) {
            System.out.println( "genealogy.Genealogy classname"
                    + " [[classname]...]\n"
                    + "as in genealogy.Genealogy java.lang.String"
            );
        }

        Genealogy gen = new Genealogy();
        for ( String arg : args ) {
            String sb = gen.getAncestry( arg );
            System.out.format( "class hierarchy of [%s]%n", arg );
            System.out.println( sb );
        }
    }

    /**
     * Get the ancestry of the class or interface with the given name.
     *
     * @param typeName to use
     * @return a string containing the type hierarchy of the type
     */
    public String getAncestry( String typeName ) {
        //TODO implement getAncestry
        return "";
    }

}

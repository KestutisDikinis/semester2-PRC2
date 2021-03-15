package nl.fontys.sebivenlo.library;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

/**
 * Simple example.
 *
 * @author hom
 */
public class LExamples {

    /**
     * Program entry.
     *
     * @param args not used
     * @throws URISyntaxException well, what do you think
     * @throws IOException only occurs when library file cannot be found
     */
    public static void main( String[] args ) throws URISyntaxException, IOException {
        LibraryModel lm = new DefaultLibrary( Book.loadFromFile( "library.csv" ) );
        BookBusiness bookBusiness = new BookBusiness(lm);
        bookBusiness.business();
        
    }
}

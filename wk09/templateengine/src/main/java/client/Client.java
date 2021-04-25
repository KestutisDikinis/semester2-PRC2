package client;


import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import templateengine.Engine;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class Client {

    public static void main( String[] args ) throws IOException {
        Map<Object, String> map = Map.of(
                "teacher", "Richard van den Ham",
                "mod", "Programming Concepts 2 (PRC2)"
        );
        Function<String, String> lookup = ( s ) -> map.getOrDefault( s, "" );
        new Engine( "{{", "}}", lookup ).reading( "letter.txt" ).run();

        // write to file.
        new Engine( "{{", "}}", lookup )
                .reading( "letter.txt" )
                .writing( "mail-out.txt" )
                .run();
    }
}

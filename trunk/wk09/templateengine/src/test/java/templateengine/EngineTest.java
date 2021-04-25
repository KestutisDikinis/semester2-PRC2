package templateengine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test using org.junit.jupiter.params.provider.Arguments.
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class EngineTest {
    static String[] s( String... strings ) {
        return strings;
    }

    /**
     * Test data contains start and end sigils, escape char, input and expected
     * text and (optional) substitutions.
     * @return test data
     */
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments( "{{", "}}", '\\', "hello {{world}}...",
                        "hello Schöne Heimat...",
                        s( "world", "Schöne Heimat" ) ),
                arguments( "{{", "}}", '\\', "hello {{süßes}}",
                        "hello Schöne Heimat",
                        s( "süßes", "Schöne Heimat" ) ),
                arguments( "{{", "}}", '\\',
                        "now somethings with {{two}} words to {{replace}}", // template
                        "now somethings with more words to work with", // expected
                        s( "two", "more", //  kv 1 
                                "replace", "work with" ) // kv 2 
                ),
                arguments( "{{", "}}", '\\', "Niks geen substituties",
                        "Niks geen substituties",s() ),
                arguments( "{{", "}}", '\\', "Leave me {alone}}",
                        "Leave me {alone}}" ,s()), // incomplete starter 
                arguments( "{{", "}}", '\\', "Leave me { {alone}}",
                        "Leave me { {alone}}" ,s()), // broken starter 
                arguments( "{{", "}}", '\\', "Leave me {{alone}, go away",
                        "Leave me {{alone}, go away" ,s()), // broken postfix 
                arguments( "{{", "}}", '\\',
                        "Leave me {{alone}}, go away I am Broken at the {{Tail}",
                        "Leave me , go away I am Broken at the {{Tail}" ,s()), // broken postfix at tail
                // text below for escaping version only. 
                // Note the duplication of the \ char to make the strings valid Java strings. 
                arguments( "{{", "}}", '\\',
                        "Look ma, this is how you write a sigil"
                        + " text in your letter: \\{{my dear boy}}"
                        + " and I used \\\\ to write this example",
                        "Look ma, this is how you write a sigil"
                        + " text in your letter: {{my dear boy}}"
                        + " and I used \\ to write this example",
                        s( "not used", "not used either" ) // kv1 
                ),
                arguments( "{", "}", '\\',
                        "hello single char template {world}...",
                        "hello single char template Schöne Heimat...",
                        s( "world", "Schöne Heimat" ) ),
                arguments( "{{{", "}}}", '@',
                        "And it works with three and other escape as well."
                        + "text in your letter: {{{my dear boy}}}.",
                        "And it works with three and other escape as well."
                        + "text in your letter: well, that depends.",
                        s( "my dear boy", "well, that depends" ) ) // kv1
        );

    }


    /**
     * Use a StringBuilder as Appendable implementation.
     *
     * Set up an engine with standard sigils matching the test input and give it
     * the appendable to write to. Run the engine on a int stream, by streaming
     * the template text chars and apply the engine on each character.
     *
     * In the test you can inspect the contents of the StringBuilder.toString to
     * see if if is what the test data row expects.
     *
     * @param et test data set
     */
    @ParameterizedTest
    @MethodSource( "testData" )
    void testEngine( String presig, String postSig, char esc, String in,
            String expected,
            String[] kv ) {
        //TODO write engine test
        fail("test testEngine completed, this could be a good sign");
    }

    static Map<String, String> mapOf( String... kv ) {
        Map.Entry<String, String>[] entries = new Map.Entry[ kv.length / 2 ];
        Map<String, String> result = new HashMap<>();
        for ( int i = 0; i < kv.length; i += 2 ) {
            entries[ i / 2 ] = entry( kv[ i ], kv[ i + 1 ] );
        }
        return Map.ofEntries( entries );
    }


    @Test
    public void testSimpleConstructor() throws IOException {
        StringBuilder sb = new StringBuilder();
        new Engine( Map.of( "world", "Programmer" ) )
                .readingString( "Hello {{world}}" )
                .writing( sb )
                .run();

        assertThat( sb.toString() ).isEqualTo( "Hello Programmer" );
//        fail( "method testSimpleConstructor reached end. You know what to do." );
    }

    @Test
    void notSettingInputThrows() {
        StringBuilder sb = new StringBuilder();

        ThrowingCallable tc = () -> {
            new Engine( Map.of() ).writing( sb ).run();
        };

        assertThatThrownBy( tc )
                .isInstanceOf( IllegalStateException.class );

//        fail( "method notSettingInputThrows reached end. You know what to do." );
    }

}

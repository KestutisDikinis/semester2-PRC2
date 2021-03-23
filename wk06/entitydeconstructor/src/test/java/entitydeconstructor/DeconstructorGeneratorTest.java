package entitydeconstructor;

import java.util.List;
import static java.util.List.of;
import java.util.concurrent.atomic.AtomicInteger;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assumptions.assumeThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.CsvSource;
import sampleentities.Student;

/**
 *
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 */
@TestMethodOrder( MethodOrderer.MethodName.class )
public class DeconstructorGeneratorTest {

    /**
     * Helper method to clean code of unneeded whitespace and empty lines.
     *
     * @param javaCode to process
     * @return list of clean lines
     */
    static List<String> cleanCode( String javaCode ) {
        List<String> cleanCode
                = Stream.of( javaCode.split( "\n" ) )
                        .map( String::trim )
                        .filter( s -> !s.isEmpty() )
                        .collect( toList() );
        System.out.println( "<pre>" );
        // a captured object must be final, but may be muttable
        AtomicInteger counter = new AtomicInteger();
        cleanCode.forEach( l -> System.out.println( counter.getAndIncrement()
                + " " + l ) );
        System.out.println( "</pre>" );
        return cleanCode;
    }

    // to abbreviate new String[]{...} to s(...) 
    static String[] s( String... s ) {
        return s;
    }

    static Stream<Arguments> testData2() {
        return Stream.of(
                arguments( 0, s( "package", "generateddeconstructors;" ) ),
                arguments( 1, s( "import",
                        "deconstructorregistry.Deconstructor;" ) ),
                arguments( 5,
                        s( "public", "class", "StudentDeconstructor", "{" ) ),
                arguments( 10, s( "private", "StudentDeconstructor()", "{" ) ),
                arguments( 12, s( "static", "{" ) ),
                arguments( 13, s( "Mapper.register(", "Student.class,", "new",
                        "StudentDeconstructor()", ");" ) ),
                arguments( 14, s( "}" ) ),
                arguments( 19, s( "@Override" ) ),
                arguments( 20,
                        s( "public", "Object[]", "deconstruct(", "Student", "s" ) ),
                arguments( 21, s( "return", "new", "Object[]{" ) )
        );
    }
    Class<?> type = Student.class;

    /**
     * Test the preamble of the deconstructor:
     * <ol>
     * <li> package declaration</li>
     * <li> import</li>
     * <li> private constructor</li>
     * <li> static block</li>
     * <li> Register call</li>
     * <li> curly</li>
     * <li> @Override</li>
     * <li>method signature</li>
     * <li>return statement</li>
     * </ol>
     *
     * @param line number in cleaned code, see data above
     * @param elements
     */
    @Disabled("Think TDD")
    @ParameterizedTest
    @MethodSource( "testData2" )
    void t0CodeLine( int line, String[] elements ) {
        var gen = new DeconstructorGenerator( type );
        List<String> javaCode = cleanCode( gen.javaSource() );
        String[] words = javaCode.get( line ).split( "\\s+" );
        //TODO assert correctness
        fail("t0CodeLine completed succesfully; you know what to do");
    }

    /**
     * Get the getters, split into list, and check that the expected number of
     * getter is there. Test with class student. The generated code should have
     * the correct number of lines with respect to the number of fields in the
     * type.
     */
    @Disabled("Think TDD")
    @Test
    void t1Getters() {
        Class<?> type = Student.class;
        var gen = new DeconstructorGenerator( type );
        List<String> javaCode = cleanCode( gen.getters( type ) );
        int fieldCount = gen.getAllFieldsInClassHierarchy( type ).length;
        System.out.println( "fieldCount = " + fieldCount );
        //TODO count the lines 
        fail( "method t3Getters completed succesfully; you know what to do" );
    }

    /**
     * Count the {},(), and [], they should match in count.
     */
    @Disabled("Think TDD")
    @ParameterizedTest
    @CsvSource( {
        "{,}",
        "[,]",
        "(,)"
    } )
    void t2countBraces( char open, char close ) {
        Class<?> type = Student.class;
        var gen = new DeconstructorGenerator( type );
        String javaText = gen.javaSource();
        long opening = javaText.chars().filter( c -> c == open ).count();
        long closing = javaText.chars().filter( c -> c == close ).count();
        //TODO check that braces match
        fail( "method countCurlies completed succesfully; you know what to do" );
    }

    /**
     * Test that main runs exception free.
     */
    @Disabled("Think TDD")
    @Test
    void t3MainCausesNoProblems() {
        assertThatCode( () -> {
            DeconstructorGenerator
                    .main( new String[]{ "sampleentities.Student" } );
        } ).doesNotThrowAnyException();
//        fail( "method MainCausesNoProblems completed succesfully; you know what to do" );
    }

}

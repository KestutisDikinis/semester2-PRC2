package gradecapture;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test the used regular expression.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class RegexTest {

    String regex;
    Pattern pattern;

    @BeforeEach
    public void setup() {
        regex = GradeCapture.REGEX;
        System.out.println( "regex = /" + regex + "/" );
        pattern = Pattern.compile( regex );
    }

    /**
     * Test the regular expression with the test data. Note that this test
     * interprets all test data except expHasResult as Strings, it does not deal
     * with number parsing, that is the responsibility of the CollectorTest.
     *
     * @param input string
     * @param expHasResult matches
     * @param matchedGradeString the found grade string
     * @param studentId sic
     * @param grade the grade as double after conversion
     *
     */
    @Disabled( "Think TDD" )
    @ParameterizedTest
    @CsvFileSource( resources = { "testdata.csv" } )
    void testRegex( String input, boolean expHasResult,
            String matchedGradeString, String studentId, String grade ) {
        Matcher m = pattern.matcher( input );
        // TODO test regex
        fail( "Reached the end of the test, which might be a good sign)" );
    }
}

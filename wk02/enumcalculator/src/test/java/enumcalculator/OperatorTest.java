package enumcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Parameterized test for enum operation. Look in [Kaczanowski, ch 3] on how to
 * use parameterized tests.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class OperatorTest {

    /**
     * Most of the test input, including the operator symbol. In following
     * exercises you will have to do that on your own. The test data is
     * collected in a set of comma separator lines or records, in which you can
     * access the columns with an index, zero based.
     *
     *
     * @param message for test
     * @param symbol of operation
     * @param expected outcome
     * @param a first value
     * @param b second value
     */
    @ParameterizedTest
    @CsvSource( {
        // message, symbol, expected result, a,b
        "add      , '+'," + ( 2 + 3 ) + ", 2, 3 ",
        "subtract , '-'," + ( 2 - 3 ) + ", 2, 3 ", //comma separated string
        "multiply , '*'," + ( 2 * 3 ) + ", 2, 3 ",
        "divide   , '/'," + ( 2 / 3 ) + ", 2, 3 ",
        "power    ,'**'," + ( 2 * 2 * 2 ) + ", 2, 3 "
    } )
    public void testOperator( String message, String symbol, int expected, int a, int b ) {
        // use all inputs in the assertThat
        Operator operator = Operator.get(symbol);
        assertThat(operator.compute(a,b))
                .as(message)
                .isEqualTo(expected);
    }
    @Test
    void getQuestionMark(){
        assertThatThrownBy(() ->Operator.get("?")).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
}

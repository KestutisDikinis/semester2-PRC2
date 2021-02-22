package fraction;

//uncomment import static
 // import static fraction.Fraction.frac;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assumptions.assumeThat;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class FractionTest {

    /**
     *
     * @param message per test
     * @param expected value
     * @param num input
     * @param denom input
     */
    //@Disabled( "Think TDD" )
    @ParameterizedTest
    @CsvSource( {
        "whole number, 2, 2, 1 ",
        "two thirds, (2/3), 2, 3",
        "one third, (1/3), -3, -9 ",
        "minus two fifths, (-2/5), 12, -30",
        "one + two fifths, (-1+(-2/5)), 35, -25 "
    } )
    void fractionToString( String message, String expected, int num, int denom ) {
        //TODO create fraction and do assert
        fail("fractionToString completed succesfully; you know what to do");
    }

    // The compiler does not like code that call non-existing methods, so uncomment once the method has been declared.
    final Map<String, BiFunction<Fraction, Fraction, Fraction>> ops = Map.of( 
                        "times", ( f1, f2 ) -> f1.times( f2 )
            //TODO add more named lamddas to the map
            
            );

    /**
     * Test the operations defined on fraction. Expected result is expressed as
     * a String.
     *
     * @param args test data object
     */
//    //@Disabled("Think TDD")
    @ParameterizedTest
    @CsvSource(
             {
                // msg, opname, expected, a,b,c,d
                "'one half times one third is 1 sixth','times',   '(1/6)',   1,2,1,3",
                "'one thirds plus two thirds is 1'    , 'plus',       '1',   1,3,2,3",
                "'flip fraction '                     , 'flip',       '3',   1,3,1,3", // <2>
                "'one half minus two thirds is'       , 'minus' , '(-1/6)',  1,2,2,3",
                "'one half times 4 is 2'              , 'timesInt','2',      1,2,4,1",
                "'one half plus  1 is 1(1/2)'         , 'plusInt','(1+(1/2))',  1,2,1,1",
                "'5 thirds minus 2 is -1/3  '         , 'minusInt','(-1/3)', 5,3,2,1",
                "'5 thirds divided by 4 is  '         , 'divideByInt','(5/12)', 5,3,4,1",
                "'1/2 div 1/3     is 1+1/2  '         , 'divideBy','(1+(1/2))', 1,2,3,9",
                "'negate 1/5                '         , 'negate','(-1/5)', 1,5,1,5", } )
    void tFractionOps( String message, String opName, String expected, int a,
                       int b, int c, int d ) {
        BiFunction<Fraction, Fraction, Fraction> op = ops.get( opName ); // <3>
        // ignore the test if opName not found
        assumeThat( op ).isNotNull();
        //TODO create fractions and test op
        fail( "tFractionOps completed succesfully; you know what to do" );

    }

    /**
     * Make sure the fraction throws an IllegalArgumentException when denom ==
     * 0.
     */
    //@Disabled("Think TDD")
    @Test
    public void tDivideByZeroNotAllowed() {
        //TODO 
        fail( "tDivideByZeroNotAllowed completed succesfully; you know what to do" );
    }

    //@Disabled("Think TDD")
    @Test
    public void tIntAsFrac() {
        //TODO test frac(int) and indirectly new Fraction(int).
        fail( "tIntAsFrac completed succesfully; you know what to do" );
    }

    /**
     * Helper to split string separated with "|" to ints.
     *
     * @param input string
     * @return array of ints
     */
    static int[] stringToInts( String input ) {
        return Stream.of( input.split( "\\|" ) )
                .mapToInt( Integer::parseInt )
                .toArray();
    }

    /**
     * Helper to split string and turn parts into objects.
     *
     * @param <T> type of returned objects
     * @param input string to be split
     * @param fun to turn string into object, e.g. by a lookup
     * @return array of objects.
     */
    public static <T> T[] stringToObjects( String input, Function<String, T> fun ) {
        return (T[]) Stream.of( input.split( "\\|" ) )
                .map( fun )
                .toArray( Object[]::new );
    }

    /**
     * We use the Functional Interface defined in the source package to do our
     * conversion from array of ints to some fraction. The expression uses the
     * elements of the array to build an Fraction expression.
     */
    // it is a bit of a pity you can't write (a,b,c) -> (something with a, b, and c)
    // but must use (a) -> (array accessors) .
    // uncomment when you are ready
    Map<String, MultiIntToObject<Fraction>> expressionMap = Map.of( 
            //TODO add key value pairs
            
            );

    /**
     * Test with varying list of ints. Test via the toString() result.
     *
     * Use the fact that the lambda string can be used to lookup a value in the
     * map just above this method and the | separated string as args to the
     * expression The local int[] args is already waiting to be used.
     *
     * @param lambda expression
     * @param input to be used as int[]
     * @param result of the expression as string.
     */
    //@Disabled("Think TDD")
    @ParameterizedTest
    @CsvSource( {
        // 'op', abcd, string
        // quote the op string if it contains commas
        "'frac(a,b).times(c)',        1|2|3,  (1+(1/2))",
        "'frac(a,b).plus(frac(c,d))', 1|2|3|4,(1+(1/4))", } )
    public void tExpression( String lambda, String input, String result ) {
        int[] args = stringToInts( input );
        MultiIntToObject<Fraction> expression = expressionMap.get( lambda );
        assumeThat( expression ).isNotNull();
        //TODO get expression and apply on args
        fail( "tExpression reached end. You know what to do." );
    }

    /**
     * Use test helper method {
     *
     * @see verifyEqualsAndHashCode}
     *
     */
    //@Disabled("Think TDD")
    @Test
    public void tEqualsHashCode() {
        //TODO create enough fraction objects to invoke helper method verifyEqualsAndHashCode
        fail( "tEqualsHasCode completed succesfully; you know what to do" );
    }

    /**
     * The fraction should be comparable.Create a fraction and test signum of
     * compareTo result.
     *
     * @param msg message
     * @param a num in 1st frac
     * @param b denum in 1st frac
     * @param c num in 2nd frac
     * @param d denom in 2nd frac
     * @param signum expected sign or 0 if equal.
     */
    //@Disabled("Think TDD")
    @ParameterizedTest
    @CsvSource( {
        "equal,   1,2,2,4,0",
        "less,    1,2,3,4,-1",
        "greater, 1,2,1,3,1", } )
    public void tComparable( String msg, int a, int b, int c, int d, int signum ) {
        //TODO create fractions and test compareTo
        fail( "tComparable completed succesfully; you know what to do" );
    }

    /**
     * Helper for equals tests, which are tedious to get completely covered.
     *
     * @param <T> type of class to test
     * @param ref reference value
     * @param equal one that should test equals true
     * @param unEqual list of elements that should test unequal in all cases.
     */
    public static <T> void verifyEqualsAndHashCode( T ref, T equal, T... unEqual ) {
        Object object = "Hello";
        T tnull = null;
        String cname = ref.getClass().getCanonicalName();
        // I got bitten here, assertJ equalTo does not invoke equals on the
        // object when ref and 'other' are same.
        // THAT's why the first one differs from the rest.
        SoftAssertions.assertSoftly( softly -> {
            softly.assertThat( ref.equals( ref ) )
                    .as( cname + ".equals(this): with self should produce true" )
                    .isTrue();
            softly.assertThat( ref.equals( tnull ) )
                    .as( cname + ".equals(null): ref object "
                         + safeToString( ref ) + " and null should produce false"
                    )
                    .isFalse();
            softly.assertThat( ref.equals( object ) )
                    .as( cname + ".equals(new Object()): ref object"
                         + " compared to other type should produce false"
                    )
                    .isFalse();
            softly.assertThat( ref.equals( equal ) )
                    .as( cname + " ref object [" + safeToString( ref )
                         + "] and equal object [" + safeToString( equal )
                         + "] should report equal"
                    )
                    .isTrue();
            for ( int i = 0; i < unEqual.length; i++ ) {
                T ueq = unEqual[ i ];
                softly.assertThat( ref )
                        .as( "testing supposed unequal objects" )
                        .isNotEqualTo( ueq );
            }
            // ref and equal should have same hashCode
            softly.assertThat( ref.hashCode() )
                    .as( cname + " equal objects "
                         + ref.toString() + " and "
                         + equal.toString() + " should have same hashcode"
                    )
                    .isEqualTo( equal.hashCode() );
        } );
    }

    //@Disabled("Think TDD")
    @Test
    public void tGetNumerator() {
        //TODO
        fail( "tGetNumerator completed succesfully; you know what to do" );
    }

    //@Disabled("Think TDD")
    @Test
    public void tGetDenominator() {
        //TODO
        fail( "tGetDenominator completed succesfully; you know what to do" );
    }

    /**
     * ToString that deals with any exceptions that are thrown during its
     * invocation.
     *
     * When x.toString triggers an exception, the returned string contains a
     * message with this information plus class and system hashCode of the
     * object.
     *
     * @param x to turn into string or a meaningful message.
     * @return "null" when x==null, x.toString() when not.
     */
    public static String safeToString( Object x ) {
        if ( x == null ) {
            return "null";
        }
        try {
            return x.toString();
        } catch ( Throwable e ) {
            return "invoking toString on instance "
                   + x.getClass().getCanonicalName() + "@"
                   + Integer.toHexString( System.identityHashCode( x ) )
                   + " causes an exception " + e.toString();
        }
    }

}

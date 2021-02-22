package fraction;

/**
 * Immutable Fraction : numerator/denominator.
 *
 * Fraction parts are constant after construction. Immutable also means thread
 * safety. Invariants: Fraction is always normalized (greatest common divisor of
 * denominator and numerator is 1).
 *
 * Denominator is greater or equal to 1.
 *
 * @author Pieter van den Hombergh
 */
public class Fraction {


    /**
     * numerator, negative allowed.
     */
    //TODO define numerator
    /**
     * denominator, always positive.
     */
    //TODO define denominator

    /**
     * Create a Fraction.
     *
     * @param num numerator
     * @param denom denominator
     */
    public Fraction( int num, int denom ) {
        //TODO implement constructor
        
    }
    //TODO Implement Fields, constructor and methods
    
    
    /**
     * Multiply with Fraction.
     *
     * @param other Fraction
     * @return new Multiplied Fraction
     */
    public Fraction times( Fraction other ) {
        return new Fraction(1,1);
    }

    //TODO

    /**
     * Compute Greatest Common Divisor. Used to normalize fractions.
     *
     * @param a first number
     * @param b second number, gt 0
     * @return greatest common divisor.
     */
    static int gcd( int a, int b ) {
        // make sure params to computation are positive.
        if ( a < 0 ) {
            a = -a;
        }
        if ( b < 0 ) {
            b = -b;
        }
        while ( b != 0 ) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    //TODO equals and hascode
    

    //TODO tostring

    // implement compareto

    //TODO static factory frac(int,int)  and frac(int)
}

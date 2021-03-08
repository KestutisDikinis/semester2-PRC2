package fraction;

import java.util.Objects;

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
public class Fraction implements Comparable<Fraction> {


    /**
     * numerator, negative allowed.
     */
    //TODO define numerator
    private int numerator;
    /**
     * denominator, always positive.
     */
    //TODO define denominator
    private int denominator;
    /**
     * Create a Fraction.
     *
     * @param num numerator
     * @param denom denominator
     */
    public Fraction( int num, int denom ) {
        int d =  gcd(denom,num);
        num = num/d;
        denom = denom/d;
        if(denom == 0){
            throw new IllegalArgumentException();
        }
        if(denom < 0 ){
            if(num< 0){
                num *= -1;
                denom *= -1;
            } else if(num > 0){
                num *= -1;
                denom *= -1;
            }
        }
        this.numerator = num;
        this.denominator =denom;
    }
    public Fraction (int x){
         this.numerator = x;
         this.denominator = 1;
    }


    /**
     * Multiply with Fraction.
     *
     * @param other Fraction
     * @return new Multiplied Fraction
     */
    public Fraction times( Fraction other ) {

        int resultNum = this.numerator * other.getNumerator();
        int resultDenom = this.denominator * other.getDenominator();

        return new Fraction(resultNum,resultDenom);
    }

    public Fraction times(int otherN){

        Fraction fraction = frac(otherN);

        return times(fraction);
    }

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

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        if(numerator%denominator == 0){
            return ""+numerator/denominator;
        }
        if(numerator/denominator >= 1|| numerator/denominator < 0){
            int wholeNumber = numerator/denominator;
            int tempNum = numerator;
            if(numerator < 0){
                tempNum = -tempNum;
                tempNum -= denominator;
                tempNum =- tempNum;
            }else{
                tempNum -= denominator;
            }
            return "("+wholeNumber+"+("+(tempNum)+"/"+denominator+"))";
        }
        return "("+numerator+"/"+denominator+")";
    }

    public Fraction plus(Fraction f2) {
        return plus(f2.getNumerator(),f2.getDenominator());
    }

    public Fraction plus(int otherN, int otherD){
        int n1, n2;
        n1 = this.numerator * otherD;
        n2 = this.denominator * otherN;
        otherD *= this.denominator;
        otherN = n1+n2;
        return new Fraction(otherN,otherD);
    }

    public Fraction plus(int x){
        return this.plus(frac(x));
    }

    public Fraction flip() {
        return new Fraction(this.denominator,this.numerator);
    }

    public Fraction minus(Fraction f2) {
        int numf1, numf2, lcm;
        lcm = lcm(this.denominator,f2.getDenominator());
        numf1 = (lcm/this.denominator)*this.numerator;
        numf2 = (lcm/f2.getDenominator())*f2.getNumerator();
        Fraction fractionResult = new Fraction(numf1-numf2,lcm);
        return fractionResult;
    }

    public Fraction minus(int x){
        return this.minus(frac(x));
    }

    public Fraction divideBy(Fraction f2) {
        return times(f2.flip());
    }

    public Fraction divideBy(int x){
        return this.divideBy(frac(x));
    }

    public int lcm(int a, int b){
        int result = (a*b)/gcd(a,b);
        return result;
    }

    public Fraction negate() {
        return new Fraction((this.numerator*-1),this.denominator);
    }

    // TODO implement compareTo


    //TODO static factory frac(int,int)  and frac(int)

    public static Fraction frac(int a, int b){
        return new Fraction(a,b);
    }

    public static Fraction frac(int x){
        return new Fraction(x);
    }


    @Override
    public int compareTo(Fraction o) {
        int a = this.numerator;
        int b = this.denominator;
        int c = o.getNumerator();
        int d = o.getDenominator();
        int Y = a * d - b * c;

        if(Y > 0){
            return 1;
        }else if(Y == 0){
            return 0;
        }else{
            return -1;
        }
    }

}

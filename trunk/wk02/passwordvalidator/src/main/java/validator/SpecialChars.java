package validator;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.util.stream.IntStream;

/**
 * Simple program to get all 'special' chars, which are ASCII (0x20(space)-127not alpha and not digit.
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 */
public class SpecialChars {
    public static void main( String[] args ) {
        IntStream.iterate( 0x21, x -> x < 127, x->x+1 )
                .filter( x -> !(isAlphabetic( x)  || isDigit( x )))
                .forEach( y -> System.out.print((char)y));
        System.out.println( "" );
    }
}

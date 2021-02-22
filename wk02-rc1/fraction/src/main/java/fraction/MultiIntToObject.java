package fraction;

/**
 * Turns array of ints into one object.
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 * @param <R> return type
 */
public interface MultiIntToObject<R> {

    R apply( int... input );
}

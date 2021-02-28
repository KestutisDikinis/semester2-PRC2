package ps;

/**
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class UnknownBestBeforeException extends Exception {

    public UnknownBestBeforeException( String message ) {
        super( "Best before date is not set but required for perishable products" );
    }

}

package minibar;

/**
 * This exception should be thrown when a guest get the StomachException.
 *
 * @author Pia Erbrath
 */
public class DrunkenException extends RuntimeException {

    public DrunkenException() {
        super("Guest is drunk, cannot drink more");
    }
}

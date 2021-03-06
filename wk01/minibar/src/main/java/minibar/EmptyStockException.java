package minibar;

/**
 * This exception should be thrown when the stock is empty and the barkeeper
 * tries to tap beer from it.
 *
 * @author Pia Erbrath
 */
public class EmptyStockException extends Exception {

    public EmptyStockException() {
        super( "Sorry, stock is empty!" );
    }

}

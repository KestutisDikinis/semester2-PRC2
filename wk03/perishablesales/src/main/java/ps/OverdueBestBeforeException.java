package ps;

public class OverdueBestBeforeException extends Throwable {
    public OverdueBestBeforeException() {
        super("The best before date of the product lies in the past");
    }
}

package ps;

/**
 * An intergerComsumer that can throw exceptions.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
@FunctionalInterface
interface ThrowingIntConsumer<X extends Exception> {

    void accept( int v ) throws X;
}

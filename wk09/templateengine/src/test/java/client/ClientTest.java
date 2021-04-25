package client;


import static org.assertj.core.api.Assertions.assertThatCode;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.*;

/**
 * Helps to keep coverage up. Run demo app.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class ClientTest {

//    @Disabled("Do not enable this test before all other tests are green.")
    @Test
    public void test() {

        ThrowingCallable code = () -> Client.main( new String[]{} );
        assertThatCode( code ).doesNotThrowAnyException();
    }

}

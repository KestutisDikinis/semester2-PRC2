package client;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author "Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}"
 */
public class MainTest {

    @Disabled("Think TDD")
    @Test
    public void method() {
        assertThatCode( () -> {
            Main.main( new String[]{} );
        }
        ).doesNotThrowAnyException();
//        fail( "method method reached end. You know what to do." );
    }

}

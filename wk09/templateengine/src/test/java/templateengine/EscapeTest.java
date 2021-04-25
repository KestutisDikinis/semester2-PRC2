package templateengine;

import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class EscapeTest {

    @Test
    public void testMethod() {
        // TODO review the test code and remove the call to fail below.
        Engine e = new Engine( "[[", "]]", (int) '@', new HashMap<String, String>() );
        assertThat( e.isEscape( '@' ) ).isTrue();
        assertThat( e.isEscape( '\\' ) ).isFalse();
    }
}

package firstcontact;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class GreetingTest {

    @Test
    void firstContact() {

        //TODO implement firstContact
        Greeting g = new Greeting("Johnny");
        String greet = g.greet();
        assertThat(greet)
                .as("expecting polity greeting")
                .contains("Hello", "Johnny");
    }

}

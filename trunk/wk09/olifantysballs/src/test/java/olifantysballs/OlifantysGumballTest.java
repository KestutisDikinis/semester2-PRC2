package olifantysballs;

import java.util.Collection;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test the ball, for coverage.
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class OlifantysGumballTest {

    /**
     * Test of toString method, of class OlifantysGumball.
     */
    @Disabled( "Think TDD" )
    @Test
    void testToString() {
        OlifantysGumball ball = new OlifantysGumball( "CORAL" );
        assertThat( ball.toString() )
                .as( "has colour" )
                .contains( "CORAL" );
    }

    @Test
    void newBalls() {

        Collection<OlifantysGumball> balls = OlifantysGumball.newBalls( 50 );

        assertThat( balls ).hasSize( 50 );
//        fail( "method newBalls reached end. You know what to do." );
    }
}

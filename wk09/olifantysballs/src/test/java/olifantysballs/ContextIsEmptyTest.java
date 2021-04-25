package olifantysballs;

import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Cover default methods in interfaces to get a nice green.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class ContextIsEmptyTest {

    Context ctx = new Context() {

        int ballCount = 0;

        @Override
        public void addBalls( int count ) {
            ballCount = count;
        }

        @Override
        public int getBallCount() {
            return ballCount;
        }

        @Override
        public boolean isWinner() {
            throw new UnsupportedOperationException( "isWinner Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public OlifantysGumball dispense() {
            throw new UnsupportedOperationException( "dispense Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public PrintStream getOutput() {
            throw new UnsupportedOperationException( "getOutput Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void changeState( State newState ) {
            throw new UnsupportedOperationException( "changeState Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

    };

    @Test
    public void ballCount0() {

        assertThat( ctx.isEmpty() ).isTrue();
//        fail( "method ballCount0 reached end. You know what to do." );
    }

    @Test
    public void ballCount1() {
        ctx.addBalls( 5 );
        assertThat( ctx.isEmpty() ).isFalse();
//        fail( "method ballCount1 reached end. You know what to do." );
    }
}

package olifantysballs;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import util.StringOutput;

/**
 * Verify that API messages are properly forwarded to the state. Test all
 * methods that have a concrete implementation in this class.
 *
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */@DisplayName("A special test case")
@ExtendWith( MockitoExtension.class )
public class OlifantysMachineImplTest {

    @Mock
    State state;

    /**
     * Make sure the context calls exit on the old state.
     */
    @Disabled( "Think TDD" )
    @Test
    @DisplayName("Just for kicks")
    public void changeStateCallsExit() {
        // TODO test context calls exit on the old state
        fail( "changeStateCallsExit has ended and might still need implementation" );
    }

    /**
     * Make sure that the constructor enters the initial state.
     */
    @Disabled( "Think TDD" )
    @Test
    public void constructorCallsEnter() {
        // TODO test constructor enters the initial state.
        fail( "constructorCallsEnter has ended and might still need implementation" );
    }

    /**
     * Ensure method forward from draw to draw(Context).
     */
    @Test
    public void drawCallsDrawWithContext() {
        // TODO test method forward from draw to draw(Context).
        fail( "drawCallsDrawWithContext has ended and might still need implementation" );
    }

    /**
     * Ensure method forward from ejectCoin to ejectCoin(Context).
     */
    @Test
    public void ejectCoinCallsEjectCoinWithContext() {
        // TODO test method forward from ejectCoin to ejectCoin(Context).
        fail( "ejectCoinCallsEjectCoinWithContext method has ended and might still need implementation" );

    }

    /**
     * Ensure method forward from insertCoin to insertCoin(Context).
     */
    @Test
    public void insertCoinCallsInsertCoinOnContext() {
        // TODO test method forward from insertCoin to insertCoin(Context)
        fail( "insertCoinCallsInsertCoinOnContext has ended and might still need implementation" );
    }

    /**
     * Ensure method forward from refill(int) insertCoin(Context,int).
     */
    @Test
    public void refillCallsRefillWithContextAndCount() {
        // TODO test method forward from refill(int) insertCoin(Context,int).
        fail( "refillCallsRefillWithContextAndCount has ended and might still need implementation" );
    }

    /**
     * ToString is not empty.
     */
    @Test
    public void toStringTest() {
        // TODO testToString is not empty 
        fail( "toStringTest has ended and might still need implementation" );
    }

    /**
     * Assert that the default constructor called by the static method in the
     * API interface produces something useful.
     */
    @Test
    public void defaultMachinePerApiCall() {
        // TODO test the default constructor goes to initial state
        fail( "isThereEverAWinner has ended and might still need implementation" );
    }

    /**
     * Ensure that setOutput indeed sets the output that is returned by
     * getOutput.
     */
    @Disabled("Think TDD")
    @Test
    void setOutputHasEffect() {
        // TODO test set output.
        fail( "setOutputHasEffect has ended and might still need implementation" );
    }

    /**
     * Coverage, ensure that a machine is empty after the last ball is drawn.
     */
    @Disabled("Think TDD")
    @Test
    void machineWithOneBallIsEmptyAfterDispense() {
        // TODO test ensure that a machine is empty after the last ball is drawn.
        fail( "machineWithOneBallIsEmptyAfterDispense has ended and might still need implementation" );
    }
}

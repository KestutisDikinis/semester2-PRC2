package olifantysballs;

import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import util.StringOutput;

/**
 * Test the default methods in state that are not already covered.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
@ExtendWith( MockitoExtension.class )
public class StateDefaultTest {

    State state = new State() {
        @Override
        public String reason() {
            return "reason Not supported yet.";
        }
    };

    @Mock
    Context ctx;

    /**
     * output to be used.
     */
    StringOutput sout = new StringOutput();
    PrintStream out = sout.asPrintStream();

    @Test
    void testDefaultDraw() {

        Mockito.when( ctx.getOutput() ).thenReturn( out );
        state.draw( ctx );

        assertThat( sout ).asString().contains( "reason Not supported yet." );
//        fail( "method testDefaultDraw reached end. You know what to do." );
    }

    /**
     * The only purpose of this test is coverage.
     */
    @Test
    void exitAndEnterDefault() {

        ThrowingCallable c1 = () -> {
            state.enter( ctx );
        };
        ThrowingCallable c2 = () -> {
            state.exit( ctx );
        };

        assertThatCode( c1 ).doesNotThrowAnyException();
        assertThatCode( c2 ).doesNotThrowAnyException();

//        fail( "method exitAndEnterDefault reached end. You know what to do." );
    }
}

package olifantysballs;

import util.StringOutput;
import java.io.PrintStream;
import java.util.Map;
import java.util.function.BiConsumer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Example of using Parameterized tests with mockito.
 *
 * In this Junit5 test example we combine Mockito with a Parameterized test. We
 * read the test data from a CSV file
 * <b>src/test/resources/olifantysballs/testtable.csv</b>.
 *
 * The csv file is read using junit5 csvfilesource. Note that the csv file can
 * have comments, as in lines that start with a #.
 *
 * Because the directory structure under src/test/resources/ mimics the
 * structure of the test sources, the test table file is in the same package as
 * this test class.
 *
 * The advantages and disadvantages of an external file are:
 * <ul>
 * <li> Advantage: The state transition table matches the one given on the web
 * site. This makes reading it easier and allows easy verification of
 * completeness, in particular for those triggers that should not result in a
 * state change.
 * </li>
 * <li> Disadvantage: The test methods are a bit more complex because they must
 * deal * with all combinations of triggers, target states and guard values.
 * These can however easily be expressed.
 * </li>
 * </ul>
 *
 *
 * All test methods continue with mock training, e.g. set the winner and empty
 * values, lookup up the initial state, final state if given, and triggerAction
 * and then verify the outcomes. There is one test for each of the outcomes:
 * <ul>
 * <li>Proper or no state transition</li>
 * <li>Dispensing of ball</li>
 * <li>add ball invocation of refill</li>
 * <li>Proper message</li>
 * </ul>
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
@ExtendWith( MockitoExtension.class )
public class CsvFileSourceStateTest {

    /**
     * Context of the state. Mocked by Mockito in the constructor.
     */
    final Context ctx;

    /**
     * output to be used.
     */
    StringOutput sout = new StringOutput(); // <3>
    PrintStream out = sout.asPrintStream(); // <4>

    /**
     * Map the trigger name from the csv file to a lambda expression of type
     * {@code BiConsumer<Context,State>}.
     */
    static Map<String, BiConsumer<Context, State>> triggerMap = Map.of(
            "insertCoin", ( c, s ) -> s.insertCoin( c ),
            "ejectCoin", ( c, s ) -> s.ejectCoin( c ),
            "draw", ( c, s ) -> s.draw( c ),
            "refill", ( c, s ) -> s.refill( c, 5 )
    );

    /**
     * Constructor sets up the context and connect input and output.
     */
    public CsvFileSourceStateTest() {
        ctx = Mockito.mock( Context.class );
        when( ctx.getOutput() ).thenReturn( out );
        // any colour will do.
        when( ctx.dispense() ).thenReturn( new OlifantysGumball( "RED" ) );
    }

    /**
     * Assert the proper state transition. If the End State is none-null, ensure
     * that on changeState is invoked on the context with parameter of said End
     * State. If the End State is null, ensure that changeState is called 0
     * times or never.
     *
     *
     * @param nr test number in file
     * @param initialStateName sic
     * @param finalStateName sic
     * @param triggerName trigger to lookup in lambda map
     * @param winner true is winner
     * @param empty true if empty
     * @param dispenseCount the number of draws in the test, use in
     * {@code verify(..., times(..))}
     * @param addBallsCount added balls
     * @param expectedText text output by state.
     */
    //<editor-fold defaultstate="expanded" desc="TASK_1A1; __STUDENT_ID__; WEIGHT 10;">
//    @Disabled( "Think TDD" )
    @ParameterizedTest
    @CsvFileSource( resources = { "testtable.csv" } )
    public void verifyStateTransition(
            String initialStateName, String triggerName, 
            String finalStateName, boolean empty, boolean winner,
            int dispenseCount, int addBallsCount, String expectedText ) {

        //TODO test correct state transition
        fail("Test method verifyStateTransition not implemented" );
    }

    /**
     * Assert that refill invokes the adds balls on the context.
     *
     * @param nr test number in file
     * @param initialStateName sic
     * @param finalStateName sic
     * @param triggerName trigger to lookup in lambda map
     * @param winner true is winner
     * @param empty true if empty
     * @param dispenseCount the number of draws in the test, use in
     * {@code verify(..., times(..))}
     * @param addBallsCount added balls
     * @param expectedText text output by state.
     */
    @ParameterizedTest
    @CsvFileSource( resources = { "testtable.csv" } )
    public void verifyRefillAddsBalls(
             String initialStateName, String triggerName, 
            String finalStateName, boolean empty, boolean winner,
            int dispenseCount, int addBallsCount, String expectedText ) {

        //TODO implement test refill goes.
        fail("Test method verifyStateTransition not implemented" );
    }

    /**
     * Verify that a ball is dispensed.
     *
     * @param nr test number in file
     * @param initialStateName sic
     * @param finalStateName sic
     * @param triggerName trigger to lookup in lambda map
     * @param winner true is winner
     * @param empty true if empty
     * @param dispenseCount the number of draws in the test, use in
     * {@code verify(..., times(..))}
     * @param addBallsCount added balls
     * @param expectedText text output by state.
     */
    @ParameterizedTest
    @CsvFileSource( resources = { "testtable.csv" } )
    public void verifyDispense(
             String initialStateName, String triggerName, 
            String finalStateName, boolean empty, boolean winner,
            int dispenseCount, int addBallsCount, String expectedText ) {

        //TODO test that balls are dispensed in porper states
        fail("Test method verifyDispense not implemented" );
    }

    /**
     * Assert that correct message is produced.
     *
     * @param nr test number in file
     * @param initialStateName sic
     * @param finalStateName sic
     * @param triggerName trigger to lookup in lambda map
     * @param winner true is winner
     * @param empty true if empty
     * @param dispenseCount the number of draws in the test, use in
     * {@code verify(..., times(..))}
     * @param addBallsCount added balls
     * @param expectedText text output by state.
     */
    @ParameterizedTest
    @CsvFileSource( resources = { "testtable.csv" } )
    public void assertMessage(
             String initialStateName, String triggerName, 
            String finalStateName, boolean empty, boolean winner,
            int dispenseCount, int addBallsCount, String expectedText ) {

        //TODO make sure the message contains the correct info
        fail("Test method assertMessage not implemented" );
    }

}

package olifantysballs;

import java.io.PrintStream;

/**
 * Minimal public API for a gum ball state machine.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public interface GumBallAPI {

    /**
     * Give the coin back, if any.
     */
    void ejectCoin();

    /**
     * Insert a new coin.
     */
    void insertCoin();

    /**
     * Add balls.
     *
     * @param count of balls to add.
     *
     */
    void refill( int count );

    /**
     * Draw to get a ball.
     */
    void draw();

    /**
     * Create a machine.
     *
     * @return a brand new machine
     */
    static GumBallAPI createMachine() {
        return new OlifantysBallMachine();
    }

    /**
     * Connect to output.
     *
     * @param output to use for messages
     */
    void setOutput( PrintStream output );
}

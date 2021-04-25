package olifantysballs;

/**
 * Implements State behaviors.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
enum StateEnum implements State {

    /**
     * NO_COIN only reacts tho insertCoin and will go to hasCoin.
     */
    //<editor-fold defaultstate="expanded" desc="TASK_1A2; __STUDENT_ID__; WEIGHT 10;">
    NO_COIN( "You must put in a coin before you can continue" ) {
        // TODO 1A2 implement state NO_COIN
        
    },
    //</editor-fold>

    /**
     * HAS_COIN reacts to draw and ejectCoint.
     *
     * <ul>
     * <li>draw dispenses one ball and outputs the result to the machine's
     * output. If machine is new empty, go to SOLD_OUT, else if winner then go
     * to WINNER else to NO_COIN.</li>
     * <li>eject coin goes to NO_COIN.
     * </ul>
     */
    //<editor-fold defaultstate="expanded" desc="TASK_1A3; __STUDENT_ID__; WEIGHT 10;">
    HAS_COIN( "You should draw to get your ball" ) {
        // TODO 1A3 implementg state HAS_COIN
        
    },
    //</editor-fold>

    /**
     * SOLD_OUT reacts only to refill and with that goes to NO_COIN.
     */
    //<editor-fold defaultstate="expanded" desc="TASK_1A4; __STUDENT_ID__; WEIGHT 10;">
    SOLD_OUT( "Machine is empty, waiting for refill" ) {
        //TODO 1A4 implement state SoldOout
        
    },
    //</editor-fold>

    /**
     * WINNER reacts only to draw and goes to either SOLD_OUT or NO_COIN.
     */
    //<editor-fold defaultstate="expanded" desc="TASK_1A5; __STUDENT_ID__; WEIGHT 10;">
    WINNER( "You should draw once more to get an extra ball" ) {
        //TODO 1A5 implement state WINNER 
        
    };
    //</editor-fold>

    final String reason;

    /**
     * Enum value constructor taking the reason string.
     *
     * @param reason for this state
     */
    private StateEnum( String reason ) {
        this.reason = reason;
    }

    /**
     * Implement the reason string by returning the reason field.
     *
     * @return the reason
     */
    @Override
    public String reason() {
        return reason;
    }
}

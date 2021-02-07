package minibar;

import java.time.LocalTime;

/**
 * This class represent the barkeeper of the pub.
 *
 * @author Pia Erbrath
 */
public class Barkeeper {

    /**
     * This method taps a beer from the stock.
     *
     * @param stock from where the beer should be taps.
     * @param orderer the guest which is ordered.
     * @param volume the size of the beer which is ordered.
     * @return a new Beer object.
     * @throws EmptyStockException when the stock does not have enough liter for
     * this beer
     */
    public Beer tapBeer( Stock stock, Guest orderer, double volume ) throws
            EmptyStockException {
        //TODO 14 implement draw
        return null;
    }

}

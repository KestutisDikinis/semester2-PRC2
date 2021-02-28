package ps;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class to be developed test driven with mockito.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
class CashRegister implements ThrowingIntConsumer {

    private final Clock clk;
    private final Printer printer;
    private final UI ui;
    private final SalesService salesService;
    //End Solution::replacewith::// declare business fields
    final Map<Product, SalesRecord> perishable = new LinkedHashMap<>();
    final Map<Product, SalesRecord> nonPerishable = new LinkedHashMap<>();
    private Product lastScanned = null;
    private LocalDate lastBBDate = null;
    private int lastSalesPrice = 0;

    //End Solution::replacewith::
    /**
     * Create a business object
     *
     * @param clk wall clock
     * @param printer to use
     * @param ui to use
     * @param salesService to use
     */
    CashRegister( Clock clk, Printer printer, UI ui, SalesService salesService ) {
        this.clk = clk;
        this.printer = printer;
        this.ui = ui;
        this.salesService = salesService;
    }

    @Override
    public void accept( int barcode ) throws UnknownBestBeforeException {
        //TODO implement accept
        
    }

    /**
     * Submit the sales to the sales service, finalizing the transaction.
     *
     */
    public void submit() throws UnknownBestBeforeException {
        //TODO implement submit()
        
    }

    /**
     * Correct the sales price of the last scanned product by considering the
     * given best before date, then submit the product to the service and save
     * in list.
     *
     * This method consults the clock to see if the * product is eligible for a
     * price reduction because it is near or at its best before date.
     *
     * @param bestBeforeDate
     */
    public void correctSalesPrice( LocalDate bestBeforeDate ) throws UnknownBestBeforeException {
        //TODO implement correctSalesPrice
        
    }

    /**
     * Print the receipt for all the sold products, to hand the receipt to the
     * customer.
     */
    public void printReceipt() throws UnknownBestBeforeException {
        //TODO implement printReceipt
        
    }

    //TODO maybe helpers?
    
}

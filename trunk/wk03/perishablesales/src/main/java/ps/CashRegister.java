package ps;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

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
    final Map<Product, LinkedHashMap<Integer, SalesRecord>> perishable = new LinkedHashMap<>();
    final Map<Product, LinkedHashMap<Integer, SalesRecord>> nonPerishable = new LinkedHashMap<>();
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
        if(lastScanned != null){
            throw new UnknownBestBeforeException("not good");
        }else{
            lastScanned  = salesService.lookupProduct(barcode);
            lastSalesPrice = lastScanned.getPrice();
            ui.displayProduct(lastScanned);
            if(lastScanned.isPerishable()){
                ui.displayCalendar();
            }
        }
    }

    /**
     * Submit the sales to the sales service, finalizing the transaction.
     *
     */
    public void submit() {
        SalesRecord salesRecord;

        if (lastScanned.isPerishable()) {
            manageEntry(perishable);
            salesRecord = perishable.get(lastScanned).get(lastSalesPrice);
        } else {
            manageEntry(nonPerishable);
            salesRecord = nonPerishable.get(lastScanned).get(lastSalesPrice);
        }
        salesService.sold(salesRecord);
        this.resetLastProductFields();
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
    public void correctSalesPrice( LocalDate bestBeforeDate ) {
        //TODO implement correctSalesPrice
        LocalDate currentTime = LocalDate.now(clk);
        lastBBDate = bestBeforeDate;
        long daysBetween = DAYS.between(currentTime, bestBeforeDate);
        if (daysBetween == 0) {
            lastSalesPrice = (int) (lastSalesPrice*0.35);
        } else if (daysBetween <= 2) {
            lastSalesPrice =  (int) (lastSalesPrice*0.65);
        }

        
    }

    /**
     * Print the receipt for all the sold products, to hand the receipt to the
     * customer.
     */
    public void printReceipt() {
        //TODO implement printReceipt
        Map<Product, LinkedHashMap<Integer, SalesRecord>> productMap;
        productMap = perishable;
        String currentReceiptLine;
        String shortName;
        for(int i = 0; i < 2; i++) {
            for (Product p : productMap.keySet()) {
                for (Integer price : productMap.get(p).keySet()) {
                    shortName = p.getShortName();
                    shortName = shortName.substring(0, 1).toUpperCase() + shortName.substring(1);
                    currentReceiptLine = "Name: " + shortName;
                    currentReceiptLine += ", Price: " + price
                            + ", Quantity: " + productMap.get(p).get(price).getQuantity();
                    printer.println(currentReceiptLine);
                    System.out.println(currentReceiptLine);
                }
            }
            productMap = nonPerishable;
        }
        
    }

    //TODO maybe helpers?

    private void manageEntry(Map<Product, LinkedHashMap<Integer, SalesRecord>> mapToReceiveAddition) {
        if (!mapToReceiveAddition.containsKey(lastScanned)) {
            constructNewMapEntry(mapToReceiveAddition, false);
        } else {
            if (mapToReceiveAddition.get(lastScanned).containsKey(lastSalesPrice)) {
                mapToReceiveAddition.get(lastScanned).get(lastSalesPrice).addAnotherItem();
            } else {
                constructNewMapEntry(mapToReceiveAddition, true);
            }
        }
    }

    private void constructNewMapEntry(Map<Product, LinkedHashMap<Integer, SalesRecord>> mapToReceiveAddition, boolean containsKey) {
        SalesRecord tempRecord =  new SalesRecord(
                lastScanned.getBarcode(),
                lastBBDate,
                LocalDate.now(clk),
                lastScanned.getPrice(),
                lastSalesPrice
        );
        if (!containsKey) {
            LinkedHashMap<Integer, SalesRecord> recordMap = new LinkedHashMap<>();
            recordMap.put(lastSalesPrice, tempRecord);
            mapToReceiveAddition.put(lastScanned, recordMap);
        } else {
            mapToReceiveAddition.get(lastScanned).put(lastSalesPrice, tempRecord);
        }
    }

    public int getLastSalesPrice(){
        return lastSalesPrice;
    }

    private void resetLastProductFields(){
        this.lastScanned = null;
        this.lastSalesPrice = 0;
        this.lastBBDate = null;

    }

    
}

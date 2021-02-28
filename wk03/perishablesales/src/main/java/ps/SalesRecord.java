package ps;

import java.time.LocalDate;

/**
 * Simple sales record.
 *
 * Optimistically the bestBefore is LocalDate.MAX for a non-perishable product.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class SalesRecord {

    private final int barcode;
    private final LocalDate bestBefore;
    private final LocalDate soldOn;
    private final int labelPrice;
    private final int salesPrice;
    private int quantity = 1;

    public SalesRecord( int barcode, LocalDate bestBefore, LocalDate soldOn, int labelPrice, int salesPrice ) {
        this.barcode = barcode;
        this.bestBefore = bestBefore;
        this.soldOn = soldOn;
        this.labelPrice = labelPrice;
        this.salesPrice = salesPrice;
    }

    public int getBarcode() {
        return barcode;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDate getSoldOn() {
        return soldOn;
    }

    public int getLabelPrice() {
        return labelPrice;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    @Override
    public String toString() {
        return "SalesRecord{" + "barcode=" + barcode
                + ", bestBefore=" + bestBefore + ", soldOn=" + soldOn + " qty " + quantity
                + ", labelPrice=" + labelPrice + ", salesPrice=" + salesPrice + '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

}

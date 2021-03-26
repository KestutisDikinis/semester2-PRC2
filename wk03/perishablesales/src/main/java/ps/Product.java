package ps;

import java.math.BigDecimal;

/**
 * Simple Product.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class Product {

    private final String shortName;
    private final String description;
    private final BigDecimal price;
    private final int barcode;
    private final boolean perishable;

    public Product(String shortName, String description, BigDecimal price, int barcode, boolean perisable ) {
        this.shortName = shortName;
        this.description = description;
        this.price = price;
        this.barcode = barcode;
        this.perishable = perisable;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getBarcode() {
        return barcode;
    }

    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public String toString() {
        return "Product{" + "shortName=" + shortName 
                + ", description=" + description 
                + ", price=" + price 
                + ", barcode=" + barcode 
                + ( perishable ? " perishable" : "" ) + '}';
    }

    
}

package ps;

import java.util.Optional;

/**
 * Service to lookup product and to register sales.
 * 
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public interface SalesService {

    /**
     * Lookup a product by barcode
     * @param barcode input
     * @return the product if any
     */
    Product lookupProduct( int barcode );

    /**
     * Register a sale;
     * @param sale to register
     * @return the line for the invoice
     */
    String sold( SalesRecord sale );
}

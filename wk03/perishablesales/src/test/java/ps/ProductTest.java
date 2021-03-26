package ps;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class ProductTest {
    //@Disabled

    /**
     * Since Product is a simple value class, we only test constructor getters
     * and toString
     */
    @Test
    void testProductToString() {

        Product p = new Product( "elstar", "Elstar Appels, los", BigDecimal.valueOf(100), 952134574, true );
        assertThat( p.toString() ).contains( "elstar", "Elstar Appels, los", "100", "952134574", "perishable" );
//        fail( "testProduct reached it's and. You will know what to do." );
    }

    @ParameterizedTest
    @CsvSource( value = {
        "'shortName','string', 'fyffes'",
        "'description','string','Fyffes Bananen'",
        "'price','bigDecimal',100",
        "'barcode','int',384736876",
        "'perishable','boolean',true"
    } )
    void getters(ArgumentsAccessor args) {
        Product p = new Product( "fyffes", "Fyffes Bananen", BigDecimal.valueOf(100), 384736876, true );
        String property = args.getString(0);
        String  type = args.getString(1);
        switch ( type ) {
            case "bigDecimal":
                assertThat( p ).extracting( property ).isEqualTo( BigDecimal.valueOf(args.getInteger(2)) );
                break;
            case "boolean":
                assertThat( p ).extracting( property ).isEqualTo(args.getBoolean(2) );
                break;
            case "string":
                assertThat( p ).extracting( property ).isEqualTo( args.getString(2) );
                break;
            case "int":
                assertThat( p ).extracting( property ).isEqualTo( args.getInteger(2) );
        }
//       fail( "test getters reached it's and. You will know what to do." );

    }
}

package ps;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class SalesRecordTest {
    //@Disabled

    /**
     * Since Product is a simple value class, we only test constructor getters
     * and toString
     */
    @Test
    void testProductToString() {
        LocalDate bb = LocalDate.now().plusDays( 1 );
        LocalDate today = LocalDate.now();
        SalesRecord p = new SalesRecord( 952134574, bb, today, 100, 65 );
        assertThat( p.toString() ).contains(
                "952134574", bb.toString(),
                today.toString(),
                Integer.toString( 100 ),
                Integer.toString( 65 ) );
//        fail( "testProduct reached it's and. You will know what to do." );
    }

    @ParameterizedTest
    @CsvSource( value = {
        "'barcode','int',384736876",
        "'bestBefore','date', '2020-03-20'",
        "'soldOn','date','2020-03-19'",
        "'labelPrice','int',100",
        "'salesPrice','int',65"
    } )
    void getters(ArgumentsAccessor args) {
        LocalDate bb = LocalDate.of(2020, 3,20);
        LocalDate today = LocalDate.of(2020,3,19);
        String property = args.getString(0);
        String type = args.getString(1);
        SalesRecord sr = new SalesRecord( 384736876, bb, today, 100, 65 );
        switch ( type ) {
            case "int":
                assertThat( sr ).extracting( property ).isEqualTo( args.getInteger(2) );
                break;
            case "date":
                assertThat( sr ).extracting( property ).isEqualTo( LocalDate.parse(args.getString(2)) );
                break;
        }
//       fail( "test getters reached it's and. You will know what to do." );

    }
}

package ps;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * CashRegister is the business class to test. It accepts barcode scanner input
 * and ui input and uses the SalesService.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
@ExtendWith( MockitoExtension.class )
public class CashRegisterTest {

    Product lamp = new Product( "led lamp", "Led Lamp", 250, 1_234, false );
    Product banana = new Product( "banana", "Bananas Fyffes", 150, 9_234, true );
    Product cheese = new Product( "cheese", "Gouda 48+", 800, 7_687, true );
    Clock clock = Clock.systemDefaultZone();

    @Mock
    Printer printer;

    @Mock
    SalesService salesService;

    @Mock
    UI ui;

    CashRegister register;

    @BeforeEach
    void setupMocks() {
        printer = mock( Printer.class );
        ui = mock( UI.class );
        salesService = mock( SalesService.class );
        clock = Clock.fixed(
                LocalDate.of(2020, 06, 24).atStartOfDay(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault());

        register = new CashRegister( clock, printer, ui, salesService );
    }

    /**
     * Test that after a scan, the product is looked up and correctly displayed.
     * Test product is non-perishable, e.g. led lamp. This is a example test.
     * <ul>
     * <li>Ask the (mocked) sales service if a lookup has been done.
     * <li>Ask the UI if the correct product has been displayed through the
     * mocked UI.</li>
     * <li>Ensure that ui.displayCalendar is not called.</li>
     * </ul>
     *
     * <b>NOTE</b> This method is only meant to show the various asserts or
     * verifications you can do. Otherwise it is a <b>BAD</b>
     * example, because it is not focused enough. A perfect test method would
     * verify only one aspect, like lookup of the proper product.
     */
    //@Disabled( "tiny steps please" )
    @Test
    public void isProductLookedUpAndDisplayed() {
        register = new CashRegister( clock, printer, ui, salesService );
        when( salesService.lookupProduct( lamp.getBarcode() ) ).thenReturn( lamp );
        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass( Product.class );

        assertThatCode( () -> {
            register.accept( lamp.getBarcode() );
        } ).doesNotThrowAnyException();

        verify( salesService ).lookupProduct( lamp.getBarcode() );

        verify( ui, times( 1 ) ).displayProduct( productCaptor.capture() );

        List<Product> displayedProducts = productCaptor.getAllValues();
        assertThat( displayedProducts ).contains( lamp );

        verify( ui, never() ).displayCalendar();
//        fail( "test isProductLookedUpAndDisplayed reached it's and. You will know what to do." );
    }

    /**
     * Test that both the product and calendar are displayed when a perishable
     * product is scanned.
     *
     * @throws ps.UnknownBestBeforeException when best before not set on
     * previous perishable.
     */
    //@Disabled( "tiny steps please" )
    @Test
    public void lookupandDisplayPerishableProduct() throws UnknownBestBeforeException {
        //TODO implement test lookupandDisplayPerishableProduct
        when(salesService.lookupProduct(cheese.getBarcode())).thenReturn(cheese);

        register.accept(cheese.getBarcode());
        verify(ui).displayProduct(cheese);
        verify(ui).displayCalendar();
        fail( "method lookupandDisplayPerishableProduct reached end. You know what to do." );
    }

    /**
     * Scan a product, and press submit, then verify that the correct
     * salesRecord is sent to the SalesService. Use a non-perishable product.
     * SalesRecord has no equals method (and do not add it), instead use
     * {@code assertThat(...).isEqualToComparingFieldByField()}.
     *
     */
    //@Disabled( "tiny steps please" )
    @Test
    public void submitSold() throws UnknownBestBeforeException {
        //TODO implement test submitSold
        fail( "method submitSold reached end. You know what to do." );
    }

    /**
     * Verify that a price reduction of 35% is applied for a perishable product
     * when sold 2 days before best before.
     */
    //@Disabled( "tiny steps please" )
    @Test
    public void priceReductionNearBestBefore() throws UnknownBestBeforeException {
        //TODO implement priceReductionNearBestBefore
        fail( "method priceReductionNearBestBefore reached end. You know what to do." );
    }

    /**
     * When multiple products are scanned, the resulting lines on the receipt
     * should be perishable first, not perishables last. Scan a banana, led lamp
     * and a cheese. The products should appear on the printed receipt in
     * banana, cheese, lamp order. What is printed per line depends on the cash
     * register, but the product line on the receipt should at least contain the
     * short name of the product. Your safest bet is to use an argument captor
     * and verify that the short names appear in the captured lines in the
     * correct order. You cannot do this with one assertThat, but you may want
     * to use assertj's soft assertions which allow you to combine multiple
     * failures into one.
     *
     */
    //@Disabled( "tiny steps please" )
    @Test
    public void printInProperOrder() throws UnknownBestBeforeException {
        //TODO implement test printInProperOrder
        fail( "method printInProperOrder reached end. You know what to do." );
    }

}

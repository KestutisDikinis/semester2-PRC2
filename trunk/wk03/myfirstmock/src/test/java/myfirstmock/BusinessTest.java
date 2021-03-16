package myfirstmock;

import java.util.Scanner;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Mock the DOC!
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 * @author Linda Urselmans
 */
@ExtendWith( MockitoExtension.class )
public class BusinessTest {

    // automagically mocked by class annotation ExtendsWith
    @Mock
    Printer printer;

    // Created in setup method
    Business business;

    // provide a scanner, with and some non-empty string to satisfy constructor parameters.
    Scanner scanner = new Scanner( "What ever" );

    @BeforeEach
    void setup() {
        //TODO setup business with mock
        business = new Business(printer,scanner);
    }

    /**
     * Let us see the business use the printer
     */
    //@Disabled
    @Test
    public void doesItPrint() {
        //TODO use mocks to test the business
        business.work("Kestutis");
        verify(printer).printLn(anyString());
    }

    /**
     * Check if the business uses the printer to calculate the printing cost
     */
    @Test
    void calculatePrintingCosts() {
        //TODO train the printer, verify it is used, assert that the business works
        business.computePrintingCost(8);
        verify(printer).countCharactersPrinted();
    }

    /**
     * Ensure that the business prints the proper text to the (mocked) printer.
     */
    @Test
    void doesPrinterGetCorrectArgument() {
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class );

        //TODO use the ArgumentCaptor to collect what printer receives and verify proper printing
        business.work("Kestutis");
        verify(printer).printLn(stringCaptor.capture());
        assertThat(stringCaptor.getAllValues()).contains("Hello Kestutis");
    }

    /**
     * To satisfy Coverage.
     */
    //@Disabled("Think TDD")
    @Test
    public void tUseScanner() {
        assertThatCode(
                () -> {
            business.useScanner();
        } ).doesNotThrowAnyException();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genealogy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class GenealogyTest {

    /**
     * Test with javax.swing.JButton.
     */
    @Test
    public void genealogyJButton() {
        //TODO test with JButton
        fail( "method genealogyJButton reached end. You know what to do." );
    }

    /**
     * Test with self, genealogy.Genealogy.
     */
    @Test
    public void testSelf() {
        //TODO test Self
        fail( "method testSelf reached end. You know what to do." );
    }

    @Test
    public void testMain() {
        String[] args = { "samples.Student" };
        assertThatCode( () -> {
            Genealogy.main( args );
        } ).doesNotThrowAnyException();
//        fail( "method testMain reached end. You know what to do." );
    }

    /**
     * This test is for coverage of the main method. 
     * To make it a 'meaningfull' test, we ensure that application does
     * not throw an exception. 
     */
    @Test
    public void testMainExceptionsCaught() {
        String[] args = { "samples.NoStudent" };
        assertThatCode( () -> {
            Genealogy.main( args );
        } ).doesNotThrowAnyException();;
//        fail( "method testMain reached end. You know what to do." );
    }
    
    /**
     * This test is for coverage of the main method. 
     * To make it a 'meaningfull' test, we ensure that application does
     * not throw an exception. 
     */
    @Test
    public void noArgsNoException() {
        assertThatCode( () -> {
            Genealogy.main( new String[0] );
        } ).doesNotThrowAnyException();
//        fail( "method noArgsNoException reached end. You know what to do." );
    }
}

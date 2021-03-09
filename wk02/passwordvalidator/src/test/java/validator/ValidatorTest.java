package validator;

import java.util.Arrays;
import java.util.EnumSet;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Test validator with Parameterized test.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class ValidatorTest {

    // Write parameterized test method
    @ParameterizedTest
    @CsvSource(
            {
                    // password, expected result
                    "1234!, Uls",
                    "kestas1234!, U",
                    "kestas1234, U#",
                    "Kestasdikinis!, 8",
                    "kestas, U8#s",
                    "KESTAS, l8#s"
             } )
    void invalidPassword(String password, String expected){
        Validator validator = new Validator();
        String encodings = "";
        try{
            validator.validate(password);
        }catch (InvalidPasswordException e){
            encodings = e.getMessage();
        }
        assertThat(encodings).isEqualTo(expected);

    }



    @Test
    void validPassword(){

    }
    
    // Write parameterized test method
}

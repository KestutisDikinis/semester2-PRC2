package validator;

import java.util.ArrayList;
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
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<String> expectedMessages = new ArrayList<>();
        EnumSet<Flaw> flaws = Flaw.stringToFlawSet(expected);
        for(Flaw flaw : flaws){
            expectedMessages.add(flaw.getDescription());
        }
        try{
            validator.validate(password);
        }catch (InvalidPasswordException e){
            encodings = e.getMessage();
        }

        flaws = Flaw.stringToFlawSet(encodings);
        for(Flaw flaw : flaws){
            messages.add(flaw.getDescription());
        }
        assertThat(messages.equals(expectedMessages)).isTrue();
    }



    @ParameterizedTest
    @CsvSource(
            {
                    // password, expected result
                    "Kestas1234!, ''",
                    "Gabrieleeee1234%, ''",
                    "Estas1234@, ''",
                    "Kestasdikinis!^@12!, ''",
                    "PasswordIsForSureValid1234%!^%!, ''",
                    "ThisIsAlsoCorrect333&^*!, ''"
            } )
    void validPassword(String password, String expected){
        Validator validator =new Validator();
        String encodings = "";
        try{
            validator.validate(password);
        }catch (InvalidPasswordException e){
            encodings = e.getMessage();
        }

        assertThat(encodings.isEmpty()).isTrue();
    }
    
    // Write parameterized test method
}

package validator;

import java.util.ArrayList;
import java.util.EnumSet;
import static java.util.stream.Collectors.joining;
import static validator.Flaw.*;

/**
 * Password validator using lambdas and maps.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class Validator {

    void validate( String password ) throws InvalidPasswordException{
        EnumSet<Flaw> flaws = EnumSet.allOf( Flaw.class );

        if(password.length() >= 10 ){
            flaws.remove(TOO_SHORT);
        }
        String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        for(char character : password.toCharArray()){
            for(char letter : specialChars.toCharArray()){
                if(letter == character){
                    flaws.remove(NOSPECIAL);
                }
            }
            if(Character.isUpperCase(character)){
                flaws.remove(NOUPPER);
            }
            if(Character.isLowerCase(character)){
                flaws.remove(NOLOWER);
            }
            if(Character.isDigit(character)){
                flaws.remove(NODIGIT);
            }
        }

        String encodings = "";
        for (Flaw flaw : flaws){
            encodings += flaw.getDescription()+" ";
        }
        if(!encodings.isEmpty()){
            throw new InvalidPasswordException(encodings);
        }

    }

}

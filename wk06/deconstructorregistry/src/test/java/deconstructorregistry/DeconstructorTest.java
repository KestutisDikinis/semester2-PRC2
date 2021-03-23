package deconstructorregistry;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import sampleentities.Student;
import static deconstructorregistry.TestData.jan;

/**
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class DeconstructorTest {

    /**
     * Assert that you can get a Deconstructor for Type Student.class, and that
     * the deconstructed array for a student has length 10.
     */
    @Disabled("Think TDD")
    @Test
    public void tStudent() {
        
        Deconstructor<Student> dec = Deconstructor.forType( Student.class );
        Student x = jan;
        //TODO check that deconstructor can be looked up
        fail( "method Student completed succesfully; you know what to do" );
    }

    /**
     * Assert that the cache works, that is the first and 2nd deconstructors are the same.
     */
    @Disabled("Think TDD")
    @Test
    void tRegistryCaches() {
        Deconstructor<Student> dec1 = Deconstructor.forType( Student.class );
        Deconstructor<Student> dec2 = Deconstructor.forType( Student.class );
        
        //TODO check cache
        fail( "method RegistryCaches completed succesfully; you know what to do" );
    }
}

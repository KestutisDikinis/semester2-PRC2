package simple;

import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import static simple.Student.Gender.*;

/**
 * Streams with assertJ.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class SimpleStreamTest {

    List<Student> students = Students.getStudents();

    /**
     * Count the number of students. Expect 50 students.
     */
//    @Disabled
    @Test
    public void testCountStudents() {
        int expected = 50;
        //TODO use stream and count
        fail( "testCountStudents completed. Review the code and comment or delete this line" );
    }

    /**
     * Get the number of male students. Expect a count to be 16.
     *
     */
//    @Disabled
    @Test
    public void testGetMaleStudents() {

        int expected = 16;
        //TODO count male students
        fail( "test testGetMaleStudents " );
    }

    /**
     * Get the youngest students. Expect this to be student with number 3134539.
     * Youngest means max birth date.
     * used Stream.max() which returns an optional. Since the list is not empty,
     * you may expect the option to have a value. Use assertThat().extracting(
     * lambda) to retrieve the student number and verify this to be equals to
     * 3134539, identifying Shirleen Simpson.
     */
//    @Disabled
    @Test
    public void testGetYoungestStudent() {
        //TODO get student who is youngest
        fail( "testGetYoungestStudent completed. Review the code and comment or delete this line" );
    }

    /**
     * Get all student as list the girls whose first name starts with an A. Verify that the students with numbers
     * 3134531, 3134557, and 3134562 are in there, in this order, no more and no less.
     */
//    @Disabled
    @Test
    public void get_female_student_whose_firstname_start_withA() {
        //TODO get the girls with first name A...
        fail( "method get_female_student_whose_firstname_start_withA completed. You know what to do." );
    }
}

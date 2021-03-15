package nl.fontys.sebivenlo.csvobjectstream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import nl.fontys.sebivenlo.csvobjectstream.Factories.Student;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//import org.junit.Test;

/**
 * Test class for cvs object stream util class. This test class contains one
 * test only. See {@link CSVObjectStreamTest#test_with_students()}
 *
 * @author Pieter van den Hombergh (p dot vandenhombergh at fontys dot nl)
 */
public class CSVObjectStreamTest {

    /**
     * Test the CSVObjectStream class.
     * <ol>
     * <li>For the constructor call use {@code Factories::createStudent} as
     * creator. From the String "students.csv", create a Path
     * {@link java.nio.file.Path} using the Paths utility class in the same
     * package.
     * </li>
     * <li>Start the stream with {@code Student.class} as objectType parameter
     * and Use the regular expression (String) {@code "^\\d+$"} to create a
     * lambda expression as the predicate to ensure that the first string in the
     * array of strings contains only digits.
     * </li>
     * <li> Collect the resulting stream in a list and assert
     * <ul>
     * <li>The list is not null.</li>
     * <li>The list is not empty.</li>
     * <li>The list has 50 elements.</li>
     * <li>The list contains a student with the name "Olympia Oliphant" at index
     * three.</li>
     * </ul>
     * In all the asserts, use a message and make sure you put the arguments to
     * the assertXXX method in the proper order.
     * </li>
     * </ol>
     *
     * @throws URISyntaxException error on path
     * @throws IOException error with file
     */
    @Test
    public void test_with_students() throws URISyntaxException,
            IOException {
        //TODO  1 implement CSVObjectStreamTest.test_with_students.
        fail( "test_with_students not yet implemented. Review the code and comment or delete this line" );

    }

    //</editor-fold>
    /**
     * Test the ass list method. List is same as in previous method and contains
     * 50 elements, third element is Olympia.
     *
     * @throws URISyntaxException unexpected in test
     * @throws MalformedURLException unexpected in test
     * @throws IOException unexpected in test
     */
    @Test
    public void testAsList() throws URISyntaxException, MalformedURLException,
            IOException {
        //TODO 3 implement test as list.
        fail( "testAsList not yet implemented. Review the code and comment or delete this line" );
    }

}

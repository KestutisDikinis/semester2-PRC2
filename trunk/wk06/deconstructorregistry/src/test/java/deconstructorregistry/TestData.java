package deconstructorregistry;

import java.lang.reflect.Field;
import java.time.LocalDate;
import static java.time.LocalDate.of;
import java.util.stream.Stream;
import sampleentities.Course;
import sampleentities.Student;
import sampleentities.Tutor;

/**
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmial.com}
 */
public class TestData {

    static final Integer snummer = 123;
    static final String lastName = "Klaassen";
    static final String tussenVoegsel = null;
    static final String firstName = "Jan";
    static final LocalDate dob = of( 2001, 10, 07 );
    static final int cohort = 2018;
    static final String email = "jan@home.nl";
    static final String gender = "M";
    static final String group = "INF-ABC";
    static final Boolean active = true;

    static String[] fieldNamesOf( Class<?> clz ) {
        return Stream.of( clz.getDeclaredFields() ).map( Field::getName )
                .toArray( String[]::new );
    }
    static String[] studentFieldNames = fieldNamesOf( Student.class );
//    {
//        "snummer", "lastname", "tussenvoegsel", "firstname", "dob", "cohort",
//        "email", "gender", "student_class", "active"
//    };
    static Student jan = new Student(
            snummer, lastName, tussenVoegsel, firstName, dob, cohort, email,
            gender, group, true
    );

    static Student jan2 = new Student(
            snummer, lastName, tussenVoegsel, firstName, dob, cohort, email,
            gender, group, true
    );

    static Object[] sData = {
        snummer, lastName, tussenVoegsel, firstName, dob, cohort, email, gender,
        group, active
    };

    static final int courseId = 1234;
    static final String courseName = "PRC2";
    static final int credits = 5;
    static final String description = "Programing concepts 2 using Java ";
    static final short semester = 2;

    static String[] courseFieldNames = fieldNamesOf( Course.class );
    static String[] tutorFieldNames = fieldNamesOf( Tutor.class );

    static Object[] prc2Data = {
        courseId, courseName, credits, description, semester
    };

    static Course prc2 = new Course( courseId, courseName, credits, description,
            semester );

    static final String tutorFirstname = "Suzan";
    static final String tutorLastname = "Janzen";

    static final String tutorTussenvoegsel = null;
    static final String tutorAcademicTitle = "MSc";
    static final LocalDate tutorDob = LocalDate.of( 1991, 12, 3 );
    static final String tutorGender = "F";
    static final String teaches = "PRJ2|PRC2";

    static Tutor suzan = new Tutor( tutorFirstname, tutorLastname,
            tutorTussenvoegsel,
            tutorAcademicTitle, tutorDob, tutorGender, teaches );
    static Object[] suzanData = { tutorFirstname, tutorLastname,
        tutorTussenvoegsel,
        tutorAcademicTitle, tutorDob, tutorGender, teaches

    };
}

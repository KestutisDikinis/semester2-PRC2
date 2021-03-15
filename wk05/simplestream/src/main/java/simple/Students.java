package simple;

import java.time.LocalDate;
import static java.time.LocalDate.of;
import java.util.Arrays;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import static simple.Student.Gender.F;
import static simple.Student.Gender.M;

/**
 * Sample  students.
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class Students {

    private static final List<Student> students = unmodifiableList( Arrays.asList(
            st( 3134521, "Malvina", "Moulden", of( 1995, 1, 25 ), F ),
            st( 3134522, "Eugenio", "Elias", of( 1998, 8, 9 ), M ),
            st( 3134523, "Eleanore", "Estey", of( 1996, 7, 28 ), F ),
            st( 3134524, "Olympia", "Oliphant", of( 1997, 3, 8 ), F ),
            st( 3134525, "Candi", "Cortinas", of( 1997, 2, 23 ), F ),
            st( 3134526, "Edmundo", "Evett", of( 1999, 4, 1 ), M ),
            st( 3134527, "Nicol", "Neufeld", of( 1995, 5, 22 ), F ),
            st( 3134528, "Dewitt", "Dossey", of( 1994, 8, 12 ), M ),
            st( 3134529, "Waneta", "Woodley", of( 1997, 6, 6 ), F ),
            st( 3134530, "Patrica", "Paden", of( 1998, 11, 14 ), F ),
            st( 3134531, "Alanna", "Ardoin", of( 1999, 10, 31 ), F ),
            st( 3134532, "Sixta", "Savala", of( 1999, 4, 9 ), F ),
            st( 3134533, "Melva", "Maillet", of( 1993, 1, 16 ), F ),
            st( 3134534, "Basilia", "Benge", of( 1996, 3, 29 ), F ),
            st( 3134535, "Mirna", "Mcglothin", of( 1995, 7, 22 ), F ),
            st( 3134536, "Laurie", "Lampley", of( 1994, 7, 6 ), F ),
            st( 3134537, "Enid", "Eddins", of( 1997, 12, 6 ), F ),
            st( 3134538, "Leanna", "Luton", of( 1996, 1, 30 ), F ),
            st( 3134539, "Shirleen", "Simpson", of( 1999, 12, 30 ), F ),
            st( 3134540, "Elida", "Esposito", of( 1998, 5, 13 ), F ),
            st( 3134541, "Dominga", "Dinapoli", of( 1997, 11, 28 ), F ),
            st( 3134542, "Terence", "Toenjes", of( 1996, 4, 5 ), M ),
            st( 3134543, "Lavette", "Lockman", of( 1993, 6, 16 ), F ),
            st( 3134544, "Sofia", "Shoulders", of( 1997, 7, 10 ), F ),
            st( 3134545, "Marci", "Mayon", of( 1995, 1, 21 ), F ),
            st( 3134546, "Horace", "Halbert", of( 1997, 10, 20 ), M ),
            st( 3134547, "Ethan", "Eisenberg", of( 1996, 3, 19 ), M ),
            st( 3134548, "Greg", "Gumm", of( 1998, 11, 23 ), M ),
            st( 3134549, "Jeremy", "Jin", of( 1997, 5, 29 ), M ),
            st( 3134550, "Shaunte", "Stollings", of( 1995, 9, 15 ), M ),
            st( 3134551, "Jovita", "Jacobi", of( 1997, 5, 23 ), F ),
            st( 3134552, "Jonathan", "Junkin", of( 1997, 6, 15 ), M ),
            st( 3134553, "Willetta", "Woelfel", of( 1998, 5, 3 ), F ),
            st( 3134554, "Mara", "Malcom", of( 1999, 12, 11 ), F ),
            st( 3134555, "Charles", "Coward", of( 1999, 5, 8 ), M ),
            st( 3134556, "Tisha", "Tischler", of( 1995, 12, 18 ), F ),
            st( 3134557, "Armandina", "Aldrete", of( 1999, 5, 25 ), F ),
            st( 3134558, "Talisha", "Tomasi", of( 1997, 12, 25 ), F ),
            st( 3134559, "Jude", "Jarrett", of( 1998, 6, 17 ), M ),
            st( 3134560, "Nona", "Napoles", of( 1994, 3, 22 ), F ),
            st( 3134561, "Ma", "Montelongo", of( 1995, 3, 9 ), F ),
            st( 3134562, "Arleen", "Anderton", of( 1994, 7, 2 ), F ),
            st( 3134563, "Glayds", "Gathers", of( 1996, 5, 24 ), F ),
            st( 3134564, "Khadijah", "Kozel", of( 1993, 5, 24 ), F ),
            st( 3134565, "Deja", "Darnell", of( 1999, 9, 13 ), F ),
            st( 3134566, "Dave", "Dycus", of( 1995, 9, 27 ), M ),
            st( 3134567, "Analisa", "Alam", of( 1997, 7, 3 ), M ),
            st( 3134568, "Otto", "Oconnell", of( 1996, 6, 2 ), M ),
            st( 3134569, "Scottie", "Summa", of( 1996, 5, 27 ), M ),
            st( 3134570, "Lynda", "Lundberg", of( 1999, 1, 30 ), F )
    ) );

    public static List<Student> getStudents() {
        return students;
    }

    static Student st( int snummer, String firstName, String lastName, LocalDate of,
            Student.Gender gender ) {
        return new Student( snummer, firstName, lastName, of, gender );
    }
}

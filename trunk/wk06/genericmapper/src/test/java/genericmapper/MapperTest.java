package genericmapper;

import static genericmapper.TestData.jan;
import static genericmapper.TestData.sData;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import sampleentities.Student;

/**
 * For TestData see separate test data class.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class MapperTest {

    @Disabled("Think TDD")
    @Test
    public void tStudentMapperConstructs() {
        //TODO construct jan from sData
        fail( "method StudentMapper completed succesfully; you know what to do" );
    }

    @Disabled("Think TDD")
    @Test
    public void tStudentMapperDeconstructs() {
        //TODO decontruct jan and check you have sData back
        fail( "method StudentMapperDeconstructs completed succesfully; you know what to do" );
    }

    @Disabled("Think TDD")
    @Test
    public void tMapperStreams() {
        Mapper<Student> mapper = Mapper.mapperFor( Student.class );
        Stream<FieldPair> stream = mapper.stream( jan );
        assertThat( stream ).contains( fp( "lastname", "Klaassen" ), fp(
                "cohort", 2018 ) );
//        fail( "method MapperStreams completed succesfully; you know what to do" );
    }

    // helper
    private FieldPair fp( String fName, Object fValue ) {
        return new FieldPair( fName, fValue );
    }

    @Disabled("Think TDD")
    @Test
    public void tgetMapper() {
        //TODO check cache caches
        fail( "method Stream completed succesfully; you know what to do" );
    }
}

package genericmapper;

import static genericmapper.TestData.jan;
import static genericmapper.TestData.sData;
import static genericmapper.TestData.snummer;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import testentities.Course;
import testentities.Student;
import testentities.Tutor;

/**
 * For TestData see separate test data class.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class MapperTest {

    @BeforeAll
    static void loadMapper() throws ClassNotFoundException {
        Class<?> forName = Class.forName( "client.StudentMapper" );
        System.out.println( "loaded studentmapper " + forName.getName() );
    }

    Mapper< Student, Integer> mapper = Mapper
            .mapperFor( Student.class );

    /**
     * Assert that constructed xJan equals the real jan.
     */
//    @Disabled( "Think TDD" )
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
        fail( "method getMapper completed succesfully; you know what to do" );
    }

    /**
     * Check stream contents. It is sufficient to test for fieldpair with non
     * primitives, e.g. lastname and one with primitive, e.g. cohort.
     */
    @Disabled("Think TDD")
    @Test
    void tStream() {
        //TODO test stream
        fail( "method tStream completed succesfully; you know what to do" );
    }

    @Test
    public void tUnknownClassShouldThrow() {
        ThrowingCallable code = () -> {
            var mapper1 = Mapper.mapperFor( Course.class );
        };

        assertThatThrownBy( code )
                .isInstanceOf( RuntimeException.class );
    }

    @Disabled("Think TDD")
    @Test
    void tExtractorTest() {
        assertThat( mapper.keyExtractor().apply( jan ) ).isEqualTo( snummer );
//        fail( "method ExtractorTest completed succesfully; you know what to do" );
    }
    
    @Disabled("Think TDD")
    @Test
    void tLoadTutor() {
        
        assertThatCode(()->{
            Mapper<Tutor, Object> tutorMapper = Mapper.mapperFor( testentities.Tutor.class);
            assertThat(tutorMapper.keyType()).isSameAs( Integer.class);
        }).doesNotThrowAnyException();
//        fail( "method LoadTutor completed succesfully; you know what to do" );
    }
    
    @Disabled("Think TDD")
    @Test
    void tLoadEntityFields() {
        assertThatCode(()->{
            Mapper<Tutor, Object> tutorMapper = Mapper.mapperFor( testentities.Tutor.class);
            assertThat(tutorMapper.entityFields()).hasSize( 9);
        }).doesNotThrowAnyException();
//        fail( "method LoadEnityFields completed succesfully; you know what to do" );
    }
}

package genericdao.pgdao;

import entities.Employee;
import genericmapper.Mapper;
import java.lang.reflect.Field;
import static java.util.stream.Collectors.joining;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class QueryFactoryTest {

    Mapper<?, ?> mapper = Mapper.mapperFor( Employee.class );
    QueryFactory fac = new QueryFactory( mapper );

    @Disabled("Think TDD")
    @Test
    void tSaveQueryText() {
        String queryText = fac.saveQueryText();
        //TODO
        fail( "tSaveQueryText completed succesfully; you know what to do" );
    }

    @Disabled("Think TDD")
    @Test
    void tDeleteQueryText() {
        String queryText = fac.deleteQueryText();
        //TODO
        fail( "tDeleteQueryText completed succesfully; you know what to do" );
    }

    @Disabled("Think TDD")
    @Test
    void tUpdateQueryText() {
        String queryText = fac.updateQueryText();
        //TODO
        fail( "tUpdateQueryText completed succesfully; you know what to do" );
    }

    @Disabled("Think TDD")
    @Test
    void tSelectQueryText() {
        String queryText = fac.getQueryText();
        //TODO
        fail( "tSelectQueryText completed succesfully; you know what to do" );
    }

    @Disabled("Think TDD")
    @Test
    void tSelectAllQueryText() {
        String queryText = fac.allQuery();
        //TODO
        fail( "tSelectAllQueryText completed succesfully; you know what to do" );
    }

}

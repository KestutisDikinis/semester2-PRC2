package templateengine;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test class to trigger exception handling in Engine. Purpose in this case is
 * coverage and proper use of logger.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class AppendableThrowsTest {

    @Test
    public void mapAndFlush() throws IOException {
        Appendable out = mock( Appendable.class );
        Logger engineLogger = Logger.getLogger( Engine.class.getName() );
//        engineLogger.s
        Handler handler = mock( Handler.class );

        Engine engine = new Engine( Map.of( "Hello", "Hola" ) ).readingString( "{{Hello}} world" ).writing( out );
        engineLogger.addHandler( handler );

        Mockito.doThrow( new IOException( "test" ) ).when( out ).append( any() );

        engine.run();

        verify( handler ).publish( any() );

//        fail( "method flush reached end. You know what to do." );
    }

    @Test
    public void flush() throws IOException {
        Appendable out = mock( Appendable.class );
        Logger engineLogger = Logger.getLogger( Engine.class.getName() );
        Handler handler = mock( Handler.class );
        engineLogger.addHandler( handler );
        Mockito.doThrow( new IOException( "test" ) ).when( out ).append( 'o' );

        Engine engine = new Engine( Map.of() ).readingString( "Hello world" ).writing( out );
        engine.run();

        verify( handler, atLeast( 1 ) ).publish( any() );

//        fail( "method flush reached end. You know what to do." );
    }
    
    @Test
    public void flushAll() throws IOException {
        Appendable out = mock( Appendable.class );
        Logger engineLogger = Logger.getLogger( Engine.class.getName() );
//        engineLogger.s
        Handler handler = mock( Handler.class );

        Engine engine = new Engine( Map.of("world","Welt") ).readingString( "Hello { {world}} " ).writing( out );
        engineLogger.addHandler( handler );

        Mockito.doThrow( new IOException( "test" ) ).when( out ).append( '{' );

        engine.run();

        verify( handler, atLeast( 1 ) ).publish( any() );

//        fail( "method flush reached end. You know what to do." );
    }

}

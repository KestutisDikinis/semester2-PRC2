package templateengine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import static templateengine.TemplateState.*;

/**
 * Simple templating engine that can substitute words in special pre and post
 * fixes.
 *
 * Example: "Hello {{world}}" will be turned into "Hello You" when pre and
 * postfix are "{{" and "}}", and the map maps key "world" to "You".
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public final class Engine {

    private ObjIntConsumer<Engine> state = FORWARDING;
    final Function<String, String> lookup;
    final SigilMatcher prefix;
    final SigilMatcher postfix;
    final int escape;

    final StringBuilder assemblyBuffer = new StringBuilder();
    Appendable out = System.out;
    
    /**
     * The actual stream that is read by the engine, one accept (see state
     * diagram) at a time. This inStream needs to be set before the engine can
     * be started.
     */
    private IntStream inStream;

    /**
     * Create an engine with pre and postfix of the words to be substituted.
     * Defaults escape char to '\\'.
     *
     * @param prefix of keys
     * @param postfix of keys
     * @param lookup callback to translate key into value
     */
    public Engine( String prefix, String postfix,
            Function<String, String> lookup ) {
        this( prefix, postfix, '\\', lookup );
    }

    /**
     * Create an engine with pre and postfix of the words to be substituted.
     *
     * @param prefix of keys
     * @param postfix of keys
     * @param escape escape character
     * @param lookup callback to translate key into value
     */
    public Engine( String prefix, String postfix, int escape,
            Function<String, String> lookup ) {
        Objects.requireNonNull( prefix );
        Objects.requireNonNull( postfix );
        Objects.requireNonNull( lookup );
        this.escape = escape;
        this.prefix = new SigilMatcher( prefix );
        this.postfix = new SigilMatcher( postfix );
        this.lookup = lookup;
    }

    /**
     * Engine that uses a simple Map for key to value mapping. Default escape =
     * '\\'. Sigils as {{ and }}. When a key is not found the resulting value
     * will be the empty String.
     *
     * @param lookup map of lookup.
     */
    public Engine( final Map<String, String> lookup ) {
        this( "{{", "}}", '\\', s -> lookup.getOrDefault( s, "" ) );
    }

    /**
     * Engine that uses a simple Map for key to value mapping.
     *
     * @param prefix sigil
     * @param postfix sigil
     * @param escape character to use
     * @param lookup map of lookup.
     */
    public Engine( String prefix, String postfix, int escape,
            final Map<String, String> lookup ) {
        this( prefix, postfix, escape, ( s ) -> lookup.getOrDefault( s, "" ) );
    }

    /**
     * Set the engine's state.
     *
     * @param nState next state.
     */
    void changeStateTo( ObjIntConsumer<Engine> nState ) {
        state = nState;
    }

    /**
     * Is the sigil matcher complete.
     *
     * @param sm matcher
     * @return return the state of the sigil matcher
     */
    boolean sigilComplete( SigilMatcher sm ) {
        return sm.isCompleted();
    }

    /**
     * Feed the given character to the sigil matcher and get the result if this
     * sigil matcher has expected that character at this position in the string.
     *
     * @param sm matcher
     * @param c char to test
     * @return true if sigil has accepted and advanced for the next character.
     */
    boolean isSigil( SigilMatcher sm, int c ) {
        return sm.isCurrent( (char) c );
    }

    /**
     * Append the character to the assembly buffer.
     *
     * @param c the char
     */
    void assemble( char c ) {
        assemblyBuffer.append( c );
    }

    /**
     * Assemble the int as char.
     *
     * @param c char to assemble
     */
    void assemble( int c ) {
        assemble( (char) c );
    }

    /**
     * Flush the assembly buffer to the output and clear the assembly buffer.
     *
     * @throws IOException when out cannot be written to.
     */
    void flush() throws IOException {
        out.append( assemblyBuffer.toString() );
        assemblyBuffer.setLength( 0 ); // clear
    }

    /**
     * Use the specified Appendable to do the writing.
     *
     * @param out the appendable to use
     *
     * @return this engine
     */
    public Engine writing( Appendable out ) {
        this.out = out;
        return this;
    }

    /**
     * Flush the input as character to the set output.
     *
     * @param c character to output
     */
    void flush( int c ) {
        flush( (char) c );
    }

    /**
     * Flush (append) the character to the output.
     *
     * @param c to flush
     */
    void flush( char c ) {
        if ( c == '\0' ) {
            return;
        }
        try {
            out.append( c );
        } catch ( IOException ex ) {
            Logger.getLogger( Engine.class.getName() ).log( Level.SEVERE, null,
                    ex );
        }
    }

    /**
     * Translate found key to value using the lookup function and append the
     * result to the configured output.
     */
    void mapAndFlush() {
        try {
            String key = assemblyBuffer.toString();
            assemblyBuffer.setLength( 0 );
            assemblyBuffer.append( lookup.apply( key ) );
            flush();
            prefix.reset();
            postfix.reset();
        } catch ( IOException ex ) {
            Logger.getLogger( Engine.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    /**
     * Accept the next character. The required method of
     * {@link java.util.function.IntConsumer}.
     *
     * Reach the character to the current state of this engine.
     *
     * @param c to accept.
     */
    public void accept( int c ) {
        state.accept( this, c );
    }

    /**
     * Flush all collected to the output and reset matchers.
     */
    void flushAll() {
        try {
            prefix.flush( out );
            out.append( assemblyBuffer.toString() );
            assemblyBuffer.setLength( 0 );
            postfix.flush( out );
        } catch ( IOException ex ) {
            Logger.getLogger( Engine.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    /**
     * Put char in assembly buffer and flushAll.
     *
     * @param c to save
     */
    void assembleAndFlushAll( int c ) {
        assemble( c );
        flushAll();
    }

    /**
     * Configure this engine to take the IntStream as input to read.
     *
     * @param stream to read
     * @return this configured engine
     */
    public Engine reading( IntStream stream ) {
        this.inStream = stream;
        return this;
    }

    /**
     * Configure this engine to read the given string.
     *
     * @param in to read
     * @return this configured engine.
     */
    public Engine readingString( String in ) {
        return this.reading( in.chars() );
    }

    /**
     * Configure the engine to read from a named file. HINT: translate the
     * filename to a path, use the Files utility class to read the lines in the
     * input as a stream, an map that stream into a stream of ints, ready for
     * processing by this engine using the reading(IntStream method).
     *
     *
     * @param fileName of the file to read
     * @return this engine configured to read the specified file.
     * @throws java.io.IOException when file cannot be read
     */
    public Engine reading( String fileName ) throws IOException {
        //TODO make the engine read files
        return this;
    }

    /**
     * Configure the output of this engine to write to the named file.
     *
     * @param filename to write to
     * @return this configured engine.
     * @throws java.io.FileNotFoundException sic
     */
    public Engine writing( String filename ) throws FileNotFoundException {
        out = new PrintStream( filename );
        return this;
    }

    /**
     * Run the engine.
     *
     * After a run the engine should no longer be used, because it may be in a
     * un-startable state.
     */
    public void run() {
        if ( null == inStream ) {
            throw new IllegalStateException( "input source not set" );
        }
        try ( IntStream is = inStream ) {
            is.forEach( this::accept );
            this.accept( '\0' ); // forced terminator
        }

    }

    /**
     * It the given char the configured escape character?
     *
     * @param c to test
     * @return true if c equals configured escape, false otherwise.
     */
    boolean isEscape( int c ) {
        return escape == c;
    }

}

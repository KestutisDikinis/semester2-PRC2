package templateengine;

import java.io.IOException;

/**
 * State full matcher of sigil. Advances current index on matching input.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
class SigilMatcher {

    private final char[] sigils;
    private int current = 0;

    SigilMatcher( String sigils ) {
        this.sigils = sigils.toCharArray();
    }

    /**
     * Offer the next character and update state to point to next expected on
     * match.
     *
     * @param c character to match against the current expected value.
     *
     * @return true on match.
     */
    boolean isCurrent( char c ) {
        if ( current < sigils.length && sigils[ current ] == c ) {
            current++;
            return true;
        }
        return false;
    }

    void reset() {
        current = 0;
    }

    boolean isCompleted() {
        return current == sigils.length;
    }

    /**
     * Flush the matched characters of this matcher to the appendable.
     * @param a to append to
     * @throws IOException forwarded from the appendable.
     */
    void flush( Appendable a ) throws IOException {
        for ( int i = 0; i < current; i++ ) {
            a.append( sigils[ i ] );
        }
        current = 0;
    }
}

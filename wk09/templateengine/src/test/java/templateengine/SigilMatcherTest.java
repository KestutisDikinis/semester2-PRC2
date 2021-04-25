package templateengine;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class SigilMatcherTest {

    @Test
    public void testIsCurrent() {
        SigilMatcher sm = new SigilMatcher( "[[" );
        SoftAssertions.assertSoftly( softly -> {
            softly.assertThat( sm.isCurrent( '[' ) ).isTrue();
            softly.assertThat( sm.isCurrent( '.' ) ).isFalse();
            softly.assertThat( sm.isCurrent( '[' ) ).isTrue();
            softly.assertThat( sm.isCompleted() ).isTrue();
        } );
//        fail("The test case is a prototype.");
    }

}

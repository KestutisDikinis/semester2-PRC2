package boxes;

import static boxes.TestUtil.verifyEqualsHasCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test simple pair.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
class PairTest {

    @Test
    void pairStringInt() {
        // test Pair<String,Integer>
        Pair<String, Integer> p1 = new Pair<>("Kestutis",5);
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(p1.getP()).isEqualTo("Kestutis");
            softAssertions.assertThat(p1.getQ()).isEqualTo(5);
        });
    }

    @Test
    void equalsHash() {
        //TODO test hashEquals
        Pair<String, Integer> p1 = new Pair<>("Kestutis",5);
        Pair<String, Integer> p2 = new Pair<>("Kestutis",5);
        Pair<String, Integer> p3 = new Pair<>("Me",5);
        verifyEqualsAndHashCode(p1,p2,p3);
    }

    @Test
    void toStringTest() {
        //TODO test to string.
        Pair<String, Integer> p1 = new Pair<>("Kestutis",5);
        assertThat(p1.toString()).contains("Kestutis","5");
    }

    public static <T> void verifyEqualsAndHashCode( T ref, T equal, T... unEqual ) {
        Object object = "Hello";
        T tnull = null;
        String cname = ref.getClass().getCanonicalName();
        // I got bitten here, assertJ equalTo does not invoke equals on the
        // object when ref and 'other' are same.
        // THAT's why the first one differs from the rest.
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat( ref.equals( ref ) )
                    .as( cname + ".equals(this): with self should produce true" )
                    .isTrue();
            softly.assertThat( ref.equals( tnull ) )
                    .as( cname + ".equals(null): ref object "
                            + safeToString( ref ) + " and null should produce false"
                    )
                    .isFalse();
            softly.assertThat( ref.equals( object ) )
                    .as( cname + ".equals(new Object()): ref object"
                            + " compared to other type should produce false"
                    )
                    .isFalse();
            softly.assertThat( ref.equals( equal ) )
                    .as( cname + " ref object [" + safeToString( ref )
                            + "] and equal object [" + safeToString( equal )
                            + "] should report equal"
                    )
                    .isTrue();
            for ( int i = 0; i < unEqual.length; i++ ) {
                T ueq = unEqual[ i ];
                softly.assertThat( ref )
                        .as( "testing supposed unequal objects" )
                        .isNotEqualTo( ueq );
            }
            // ref and equal should have same hashCode
            softly.assertThat( ref.hashCode() )
                    .as( cname + " equal objects "
                            + ref.toString() + " and "
                            + equal.toString() + " should have same hashcode"
                    )
                    .isEqualTo( equal.hashCode() );
        } );
    }

    public static String safeToString( Object x ) {
        if ( x == null ) {
            return "null";
        }
        try {
            return x.toString();
        } catch ( Throwable e ) {
            return "invoking toString on instance "
                    + x.getClass().getCanonicalName() + "@"
                    + Integer.toHexString( System.identityHashCode( x ) )
                    + " causes an exception " + e.toString();
        }
    }
}

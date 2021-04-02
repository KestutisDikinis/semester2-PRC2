package boxes;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;



public class BoxTest {

    /**
     *test for Box<Integer>
     */
    @Test
    void integerBox() {
        int expected = 5;
        Box<Integer> iBox = new Box<Integer>(5);
        assertThat(iBox.get()).isEqualTo(expected);
    }

    /**
     * test for Box<String>
     */
    @Test
    void stringBox() {
        String expected = "Kestutis";
        Box<String> iBox = new Box<String>("Kestutis");
        assertThat(iBox.get()).isEqualTo(expected);
    }

    /**
     * test equals and hash code for coverage
     */
    @Test
    void equalsAndHashCode() {
        Box<String> b1 = new Box<String>("Kestutis");
        Box<String> b2 = new Box<String>("Kestutis");
        Box<Integer> b3 = new Box<Integer>(5);
        verifyEqualsAndHashCode(b1,b2,b3);
    }

    @Test
    void toStringContains() {
        //TODO test toString with Box<Long>
        String expected = "1234567890";
        Box<Long> b1 = new Box<Long>(1234567890L);
        assertThat(b1.toString()).contains(expected);

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

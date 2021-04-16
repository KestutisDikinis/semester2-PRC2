package fxtriangulate;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class BindingBusinessTest {

    /**
     * Assert that the center points land at the expected place.
     */
    @Test
    public void testCreateCircle() {
        Circle c = new Circle( 10, 20, 10, Color.CORAL );

        double centerX = c.getCenterX();
        double centerY = c.getCenterY();
        assertThat( centerX ).isCloseTo( 10.0, within( 0.1 ) );
        assertThat( centerY ).isCloseTo( 20.0, within( 0.1 ) );
    }

    /**
     * Test connecting two circles by a straight line. Test that line starts at
     * first circle and ends at last.
     */
    @Test
    public void testConnect() {
        BindingBusiness bb = new BindingBusiness();
        Circle c1 = new Circle( 10, 10, 10, Color.CORAL );
        Circle c2 = new Circle( 10, 50, 10, Color.CORAL );

        Line line = new Line();
        bb.connect( line, c1, c2 );

        double startX1 = line.getStartX();
        double startY1 = line.getStartY();
        double endX1 = line.getEndX();
        double endY1 = line.getEndY();

        assertThat( startX1 ).isCloseTo( 10.0, within( 0.1 ) );
        assertThat( startY1 ).isCloseTo( 10.0, within( 0.1 ) );
        assertThat( endX1 ).isCloseTo( 10.0, within( 0.1 ) );
        assertThat( endY1 ).isCloseTo( 50.0, within( 0.1 ) );
    }

    /**
     * assert that the midpoint of a line is where it is supposed to be.
     */
    @Test
    public void testMidPointBinding() {
        BindingBusiness bb = new BindingBusiness();
        Circle c1 = new Circle( 10, 10, 10, Color.CORAL );
        Circle c2 = new Circle( 10, 50, 10, Color.CORAL );
        Line line = new Line();
        bb.connect( line, c1, c2 );
        DoubleBinding midpointXBinding
                = bb.midpointBinding( line.startXProperty(), line.
                        endXProperty() );
        DoubleBinding midpointYBinding
                = bb.midpointBinding( line.startYProperty(), line.
                        endYProperty() );

        double midX = midpointXBinding.get();
        double midY = midpointYBinding.get();
       
        assertThat( midX ).isCloseTo( 10.0, within( 0.1 ) );
        assertThat( midY).isCloseTo( 30.0, within( 0.1 ) );
    }

    /**
     * Assert that the length computation of the binding produces the correct
     * results.
     */
    @Test
    public void testLengthBinding() {
        //TODO  test the binding
        fail( "testLengthBinding not yet implemented. Review the code and comment or delete this line" );
    }

    /**
     * assert that the area computation produces the correct result.
     */
    @Test
    public void testAreaBinding() {
        //TODO test the binding
        fail( "testAreaBinding not yet implemented. Review the code and comment or delete this line" );
    }
}

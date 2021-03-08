package shapes;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shapes.basic.Circle;
import shapes.basic.Disk;
import shapes.basic.Point2D;
import shapes.basic.Shape;
import shapes.basic.Sphere;

/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class ShapeManagerTest {

    final List<Circle> circles = new ArrayList<>();
    final List<Disk> disks = new ArrayList<>();
    final Circle circle = new Circle( new Point2D( 0, 0 ), 42 );
    final Sphere sphere = new Sphere( new Point2D( 150, 350 ), 60 );
    final Disk disk = new Disk( new Point2D( 10, 50 ), 30 );
    ShapeManager toy = new ShapeManager();

    @BeforeEach
    public void setup() {
        circles.add( circle );
        circles.add( sphere );
        circles.add( disk );
        disks.add( disk );
    }

    /**
     * Test that shapes can be added from a list. Toy should contain exactly
     * circle, sphere and disk.
     */
    @Disabled("Think TDD")
    @Test
    public void testAddShapes() {

//        toy.addShapes( circles );
        //TODO test addShapes
        fail("test method testAddShapes not yetimplemented");
    }

    @Disabled("Think TDD")
    @Test
    /**
     * Test that collect shape receives only disk and sphere.
     */
    public void testCollectDisk() {

        toy.addShapes( circles );
        toy.addShapes( disks );
        //TODO test collectShapesOfType
        fail("test method testCollectDisk not yet implemented");
    }

}

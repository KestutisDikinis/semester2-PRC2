package shapes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import shapes.basic.Shape;

/**
 *
 * @author hom
 */
public class ShapeManager {

    private final List<Shape> shapes = new ArrayList<>();

    /**
     * Add shapes from list to this. ShapesToAdd is the "producer" of the shapes
     * to add. Note the the types in the signature are place holders and are NOT
     * correct.
     *
     * @param shapesToAdd
     */
    //TODO implement addShapes
    void addShapes( List shapesToAdd ) {}
    /**
     * Filter objects of type from shapes. Collect the specified shape  in this into a
     * collection. The specification (Generic Type and all) should accept
     * t-s. The collection is a "consumer" of Shape. Note the the types in
     * the given signature are place holders and are NOT correct.
     *
     * @param collection that accepts the shape of type t
     */
    //TODO implement collectShapesOfType
    void collectShapesOfType( Collection receiver, Class acceptedType ) {}

    /**
     * Does this toy contain a shape. Helper method for tests.
     *
     * @param s
     * @return
     */
    boolean contains( Shape s ) {
        return shapes.contains( s );
    }

    /**
     * How many shapes are contained? Helper method for tests.
     *
     * @return the count
     */
    int shapeCount() {
        return shapes.size();
    }
}

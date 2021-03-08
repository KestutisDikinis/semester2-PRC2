package shapes.basic;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class Rectangle extends AbstractShape {

    private Point2D topleft;
    private double width, height;

    public Rectangle( Point2D topleft, double width, double height ) {
        this.topleft = topleft;
        this.width = width;
        this.height = height;
    }

    public Point2D getTopleft() {
        return topleft;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static int getCountCreated() {
        return countCreated;
    }

    public boolean isDrawFilled() {
        return drawFilled;
    }

}

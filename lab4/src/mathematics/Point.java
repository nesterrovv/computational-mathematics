package mathematics;

import java.util.Objects;

/**
 * Class with point description
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class Point {

    /** X coordinate */
    double x;
    /** Y coordinate */
    double y;

    /**
     * Constructor for this class
     * @param x is x coordinate
     * @param y is y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * X field getter
     * @return values of x field
     */
    public double getX() {
        return x;
    }

    /**
     * Y field getter
     * @return values of y field
     */
    public double getY() {
        return y;
    }

    /**
     * Method for comparing this object with other
     * @param o object for comparing
     * @return result of comparing
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    /**
     * Method for hash calculation
     * @return hash of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

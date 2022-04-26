package mathematics;

import java.util.List;

/**
 * Class for function description.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class Function {

    /** List of points for this function */
    private List<Point> points;

    /** Default constructor */
    public Function() {}

    /**
     * Constructor for this class
     * @param points is list of points for function
     */
    public Function(List<Point> points) {
        this.points = points;
    }

    /**
     * Getter for points field
     * @return points field
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Method for receiving array of x coordinates
     * @return array with x coordinates
     */
    public double[] getArrayX() {
        return getPoints().stream()
                .mapToDouble(Point::getX)
                .toArray();
    }

    /**
     * Method for receiving array of x coordinates
     * @return array with x coordinates
     */
    public double[] getArrayY() {
        return getPoints().stream().mapToDouble(Point::getY).toArray();
    }

}
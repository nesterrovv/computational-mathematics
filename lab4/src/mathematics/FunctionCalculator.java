package mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating new set of points.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class FunctionCalculator {

    /**
     * Method for creating new set of points.
     * @param function is function for calculating
     * @param newY is set of new y coordinates
     * @return set of new points
     */
    public static List<Point> calculate(Function function, List<Double> newY) {
        List<Point> result = new ArrayList<>();
        List<Point> points = function.getPoints();
        for (int i = 0; i < points.size(); i++) {
            result.add(new Point(points.get(i).getX(), newY.get(i)));
        }
        return result;
    }

}
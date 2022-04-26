package application;

import approximationMethods.*;
import mathematics.*;
import user.IOManipulator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class with main numerical method of this works. Allows approximate function
 * using least squares method.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class LeastSquaresMethod {

    /**
     * Method for printing result of approximation.
     */
    public static void leastSquaresMethodRunner() {
        int functionChoose = IOManipulator.getFunctionChoose();
        int approximationChoose = IOManipulator.getApproximationChoose();
        approximationRunner(Functions.getFunction(functionChoose), Approximations.getApproximation(approximationChoose));
    }

    /**
     * Method with least square method logic implementation
     * @param function is function which is given as function for approximation
     * @param approximation is function which is given as approximation function
     */
    private static void approximationRunner(Function function, Approximation approximation) {
        Function firstApproximation = approximation.approximation(function, approximation);
        Point max = findPointWithMaxDifference(function, firstApproximation);
        Function functionAfterExclusion = functionAfterExclusion(function, max);
        Function approximationAfterExclusion = approximation.approximation(functionAfterExclusion, approximation);
        IOManipulator.printDeviation(getDeviation(getDifference(function, firstApproximation)));
        Graphics.drawGraphic(function, firstApproximation, approximationAfterExclusion, max);
    }

    /**
     * Method for counting difference between values of given and approximation function values
     * @param function is function which is given for approximation
     * @param approximation is approximation function
     * @return list of points with counted value difference
     */
    private static List<Double> getDifference(Function function, Function approximation) {
        List<Double> functionPoints = function.getPoints()
                .stream()
                .map(Point::getY)
                .collect(Collectors.toList());
        double[] newY = approximation.getArrayY();
        List<Double> difference = new ArrayList<>();
        for (int i = 0; i < newY.length; i++) {
            difference.add(newY[i] - functionPoints.get(i));
        }
        return difference;
    }

    /**
     * Method for finding points with maximal difference
     * @param function is function which is given for approximation
     * @param approximation is approximation function
     * @return point with maximal difference between approximation and given functions
     */
    public static Point findPointWithMaxDifference(Function function, Function approximation) {
        double max = 0;
        double x = 0;
        List<Point> points = function.getPoints();
        double[] newY = approximation.getArrayY();
        for (int i = 0; i < points.size(); i++) {
            double y = points.get(i).getY();
            if (Math.abs(newY[i] - y) > max) {
                x = points.get(i).getX();
                max = Math.abs(newY[i] - y);
            }
        }
        double finalX = x;
        return points.stream()
                .filter(point -> (point.getX() == finalX))
                .findFirst()
                .get();
    }

    /**
     * Function for returning counted deviation
     * @param difference list of points with counted difference
     * @return counted deviation
     */
    private static double getDeviation(List<Double> difference) {
        return difference.stream()
                .mapToDouble(dig -> dig * dig)
                .sum();
    }

    /**
     * Method for returning function description after given exclusion point
     * @param function is function for approximation
     * @param point is exclusion point
     * @return modified function
     */
    private static Function functionAfterExclusion(Function function, Point point) {
        List<Point> pointsAfterExclusion = function.getPoints().stream()
                .filter(entity -> entity.getX() != point.getX())
                .collect(Collectors.toList());
        return new Function(pointsAfterExclusion);
    }

}
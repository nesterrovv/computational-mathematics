package approximationMethods;

import mathematics.Function;
import mathematics.GaussMethod;
import mathematics.FunctionCalculator;
import user.IOManipulator;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Interface for approximation logic realisation.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public interface Approximation {

    /**
     * Method used for getting function value in current point after approximation
     * @param x is x coordinate of necessary point
     * @param params is set of parameters for approximations
     * @return value of function in given x point after approximation
     */
    double getApproximationFunction(double x, double... params);

    /**
     * Method for getting approximation description
     * @return string with approximation type description
     */
    String typeOfApproximation();

    /**
     * Method for returning sum of x coordinate values
     * @param x is array of x coordinate values
     * @return sum of x[] array item values
     */
    default double sumX(double[] x) {
        return Arrays.stream(x).sum();
    }

    /**
     * Method for returning sum of y coordinate values
     * @param y is array of y coordinate values
     * @return sum of y[] array item values
     */
    default double sumY(double[] y) {
        return Arrays.stream(y).sum();
    }

    /**
     * Method for returning left side of equation
     * @param function is function for approximation
     * @param approximation is approximation function
     * @return matrix of coefficients
     */
    double[][] getMatrixLeftSide(Function function, Approximation approximation);

    /**
     * Method for returning right side of equation
     * @param function is function for approximation
     * @param approximation is approximation function
     * @return matrix of coefficients
     */
    double[] getMatrixRightSide(Function function, Approximation approximation);

    /**
     * Method for counting sum of x^2 values for function
     * @param x is array of x values
     * @return result of counting
     */
    default double sumXX(double[] x) {
        return Arrays.stream(x).map(digit -> digit * digit).sum();
    }

    /**
     * Method for counting x * y for function's points
     * @param function is function for approximation
     * @return result of counting
     */
    default double sumXY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> point.getX() * point.getY())
                .sum();
    }

    /**
     * Method for receiving sum of x^2 + y function values
     * @param function is function for approximation
     * @return result of calculating
     */
    default double sumXXY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> Math.pow(point.getX(), 2) * point.getY())
                .sum();
    }

    /**
     * Method for receiving sum of x^3 function values
     * @param x is array of x values
     * @return result of calculating
     */
    default double sumXXX(double[] x) {
        return Arrays.stream(x).map(digit -> Math.pow(digit, 3)).sum();
    }

    /**
     * Method for receiving sum of x^4 function values
     * @param x is array of x values
     * @return result of calculating
     */
    default double sumX_4(double[] x) {
        return Arrays.stream(x).map(digit -> Math.pow(digit, 4)).sum();
    }

    /**
     * Method for receiving sum of x * ln(y) function values
     * @param function is function for approximation
     * @return result of calculating
     */
    default double sumXLnY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> point.getX() * Math.log(point.getY()))
                .sum();
    }

    /**
     * Method for receiving sum of x * ln(y) function values
     * @param y is array of x values
     * @return result of calculating
     */
    default double sumLnY(double[] y) {
        return Arrays.stream(y).map(Math::log).sum();
    }

    /**
     * Method for receiving list of new function coefficients
     * @param function is function for approximation
     * @param params is array of coefficients
     * @return list of new coefficients
     */
    default List<Double> getNewYPoints(Function function, double[] params) {
        return Arrays.stream(function.getArrayX())
                .boxed()
                .map(xCoordinate -> getApproximationFunction(xCoordinate, params)).collect(toList());
    }

    /**
     * Method for approximation of given function
     * @param function is function for approximation
     * @param approximation is approximation function
     * @return approximated function
     */
    default Function approximation(Function function, Approximation approximation) {
        double[][] matrix = getMatrixLeftSide(function, approximation);
        double[] results = getMatrixRightSide(function, approximation);
        double[] params = GaussMethod.getUnknownColumn(matrix, results);
        IOManipulator.printParams(params);
        List<Double> newY = getNewYPoints(function, params);
        return new Function(FunctionCalculator.calculate(function, newY));
    }
}
package approximationMethods;

import mathematics.Function;
import mathematics.GaussMethod;
import user.IOManipulator;
import mathematics.FunctionCalculator;
import java.util.List;

/**
 * Class with exponential approximation logic realization.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class ExponentialApproximation extends Function implements Approximation {

    /** Default constructor */
    public ExponentialApproximation() {}

    /**
     * Method for getting approximation description
     * @return string with approximation type description
     */
    @Override
    public String typeOfApproximation() {
        return "Exponential approximation";
    }

    /**
     * Method used for getting function value in current point after approximation
     * @param x is x coordinate of necessary point
     * @param params is set of parameters for approximations
     * @return value of function in given x point after approximation
     */
    @Override
    public double getApproximationFunction(double x, double... params) {
        return params[0] * Math.exp(x * params[1]);
    }

    /**
     * Method for getting left part of equation
     * @param function is function which is given for approximation
     * @param approximation is approximation function
     * @return left part of equation as a matrix of coefficients
     */
    @Override
    public double[][] getMatrixLeftSide(Function function, Approximation approximation) {
        double[] x = function.getArrayX();
        return new double[][]{
                {function.getPoints().size(), approximation.sumX(x)},
                {approximation.sumX(x), approximation.sumXX(x)}
        };
    }

    /**
     * Method for returning right side of equation
     * @param function is function for approximation
     * @param approximation is approximation function
     * @return matrix of coefficients
     */
    @Override
    public double[] getMatrixRightSide(Function function, Approximation approximation) {
        return new double[]{approximation.sumLnY(function.getArrayY()), approximation.sumXLnY(function)};
    }

    /**
     * Method for exponential approximation of given function
     * @param function is function for approximation
     * @param approximation is approximation function
     * @return approximated function
     */
    @Override
    public Function approximation(Function function, Approximation approximation) {
        double[][] matrix = getMatrixLeftSide(function, approximation);
        double[] results = getMatrixRightSide(function, approximation);
        double[] params = GaussMethod.getUnknownColumn(matrix, results);
        params[0] = Math.exp(params[0]);
        IOManipulator.printParams(params);
        List<Double> newY = getNewYPoints(function, params);
        return new Function(FunctionCalculator.calculate(function, newY));
    }

}

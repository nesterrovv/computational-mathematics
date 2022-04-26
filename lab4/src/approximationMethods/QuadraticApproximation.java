package approximationMethods;

import mathematics.Function;

public class QuadraticApproximation extends Function implements Approximation {

    /** Default constructor */
    public QuadraticApproximation() {}

    /**
     * Method for getting approximation description
     * @return string with approximation type description
     */
    @Override
    public String typeOfApproximation() {
        return "Quadratic approximation";
    }

    /**
     * Method used for getting function value in current point after approximation
     * @param x is x coordinate of necessary point
     * @param params is set of parameters for approximations
     * @return value of function in given x point after approximation
     */
    @Override
    public double getApproximationFunction(double x, double... params) {
        return params[0] + params[1] * x + params[2] * Math.pow(x, 2);
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
                {function.getPoints().size(), approximation.sumX(x), approximation.sumXX(x)},
                {approximation.sumX(x), approximation.sumXX(x), approximation.sumXXX(x)},
                {approximation.sumXX(x), approximation.sumXXX(x), approximation.sumX_4(x)}
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
        return new double[]{approximation.sumY(function.getArrayY()), approximation.sumXY(function),
                approximation.sumXXY(function)};
    }


}
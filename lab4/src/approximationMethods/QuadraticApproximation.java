package approximationMethods;

import mathematics.Function;

public class QuadraticApproximation extends Function implements Approximation {

    @Override
    public String typeOfApproximation() {
        return "Quadratic approximation";
    }

    @Override
    public double getApproximationFunction(double x, double... params) {
        return params[0] + params[1] * x + params[2] * Math.pow(x, 2);
    }

    @Override
    public double[][] getMatrixLeftSide(Function function, Approximation approximation) {
        double[] x = function.getArrayX();
        return new double[][]{
                {function.getPoints().size(), approximation.sumX(x), approximation.sumXX(x)},
                {approximation.sumX(x), approximation.sumXX(x), approximation.sumXXX(x)},
                {approximation.sumXX(x), approximation.sumXXX(x), approximation.sumX_4(x)}
        };
    }

    @Override
    public double[] getMatrixRightSide(Function function, Approximation approximation) {
        return new double[]{approximation.sumY(function.getArrayY()), approximation.sumXY(function), approximation.sumXXY(function)};
    }


}
package approximationMethods;

import mathematics.Function;

public class LinearApproximation extends Function implements Approximation {

    public LinearApproximation() {}

    @Override
    public String typeOfApproximation() {
        return "Linear approximation";
    }

    @Override
    public double getApproximationFunction(double x, double... params) {
        return params[0] * x + params[1];
    }


    @Override
    public double[][] getMatrixLeftSide(Function function, Approximation approximation) {
        double[] x = function.getArrayX();
        return new double[][]{
                {approximation.sumXX(x), approximation.sumX(x)},
                {approximation.sumX(x), function.getPoints().size()}
        };
    }

    @Override
    public double[] getMatrixRightSide(Function function, Approximation approximation) {
        return new double[]{approximation.sumXY(function), approximation.sumY(function.getArrayY())};
    }

}
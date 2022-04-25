package approximationMethods;

import mathematics.Function;
import mathematics.GaussMethod;
import mathematics.FunctionCalculator;
import user.IOManipulator;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public interface Approximation {

    double getApproximationFunction(double x, double... params);

    String typeOfApproximation();

    default double sumX(double[] x) {
        return Arrays.stream(x).sum();
    }

    default double sumY(double[] y) {
        return Arrays.stream(y).sum();
    }

    double[][] getMatrixLeftSide(Function function, Approximation approximation);

    double[] getMatrixRightSide(Function function, Approximation approximation);

    default double sumXX(double[] x) {
        return Arrays.stream(x).map(digit -> digit * digit).sum();
    }

    default double sumXY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> point.getX() * point.getY())
                .sum();
    }

    default double sumXXY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> Math.pow(point.getX(), 2) * point.getY())
                .sum();
    }

    default double sumXXX(double[] x) {
        return Arrays.stream(x).map(digit -> Math.pow(digit, 3)).sum();
    }

    default double sumX_4(double[] x) {
        return Arrays.stream(x).map(digit -> Math.pow(digit, 4)).sum();
    }

    default double sumXLnY(Function function) {
        return function.getPoints().stream()
                .mapToDouble(point -> point.getX() * Math.log(point.getY()))
                .sum();
    }

    default double sumLnY(double[] y) {
        return Arrays.stream(y).map(Math::log).sum();
    }

    default List<Double> getNewYPoints(Function function, double[] params) {
        return Arrays.stream(function.getArrayX())
                .boxed()
                .map(xCoordinate -> getApproximationFunction(xCoordinate, params)).collect(toList());
    }

    default Function approximation(Function function, Approximation approximation) {
        double[][] matrix = getMatrixLeftSide(function, approximation);
        double[] results = getMatrixRightSide(function, approximation);
        double[] params = GaussMethod.getUnknownColumn(matrix, results);
        IOManipulator.printParams(params);
        List<Double> newY = getNewYPoints(function, params);
        return new Function(FunctionCalculator.calculate(function, newY));
    }
}
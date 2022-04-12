package calculations;

public class SimpsonMethodSolver {

    private final FunctionManipulator function;
    private final double bottomLimit;
    private final double topLimit;
    private final double accuracy;
    private int steps;
    private double error;
    private double result;

    public FunctionManipulator getFunction() {
        return function;
    }

    public double getBottomLimit() {
        return bottomLimit;
    }

    public double getTopLimit() {
        return topLimit;
    }

    public int getSteps() {
        return steps;
    }

    public double getError() {
        return error;
    }

    public double getResult() {
        return result;
    }

    public SimpsonMethodSolver(FunctionManipulator function, double bottomLimit, double topLimit, double accuracy) {
        this.function = function;
        this.accuracy = accuracy;
        if (bottomLimit > topLimit) {
            this.bottomLimit = topLimit;
            this.topLimit = bottomLimit;
        } else {
            this.bottomLimit = bottomLimit;
            this.topLimit = topLimit;
        }
    }

    public int integrate() {
        double firstBorder;
        double secondBorder;
        double height;
        if (topLimit != bottomLimit) {
            for (int n = 4; n <= 10000; n += 2) {
                double sum1 = 0;
                double sum2 = 0;
                height = (topLimit - bottomLimit) / n;
                for (int index = 1; index < n; index++) {
                    sum1 += 4 * function.calculateFunction(bottomLimit + index * height);
                    index++;
                    sum1 += 2 * function.calculateFunction(bottomLimit + index * height);
                }
                firstBorder = (sum1 + function.calculateFunction(bottomLimit) - function.calculateFunction(topLimit))
                        * height / 3;

                height = (topLimit - bottomLimit) / (2 * n);
                for (int index = 1; index < 2 * n; index++) {
                    sum2 += 4 * function.calculateFunction(bottomLimit + index * height);
                    index++;
                    sum2 += 2 * function.calculateFunction(bottomLimit + index * height);
                }
                secondBorder = (sum2 + function.calculateFunction(bottomLimit) - function.calculateFunction(topLimit))
                        * height / 3;
                if (Math.abs(secondBorder - firstBorder) / 15 < accuracy) {
                    result = secondBorder;
                    steps = n;
                    error = Math.abs(secondBorder - firstBorder) / 15;
                    return 0;
                }
                if (n == 10000) {
                    steps = 0;
                    return -1;
                }
            }
        }
        else {
            result = 0;
            steps = 0;
            return 1;
        }
        return -1;
    }

}

package calculations;

/**
 * Class with Simpson method implementation.
 * Used for numerical integrating.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/11/2022
 */
public class SimpsonMethodSolver {

    /** Field for function storing. */
    private final FunctionManipulator function;
    /** Field for bottom limit storing. */
    private final double bottomLimit;
    /** Field for top limit storing. */
    private final double topLimit;
    /** Field for accuracy storing. */
    private final double accuracy;
    /** Field for steps amount storing. */
    private int steps;
    /** Field for error value storing. */
    private double error;
    /** Field for result value storing. */
    private double result;

    /** Method for function field value getting.
     * @return function field value
     */
    public FunctionManipulator getFunction() {
        return function;
    }

    /** Method for bottom limit field value getting.
     * @return bottom limit field value
     */
    public double getBottomLimit() {
        return bottomLimit;
    }

    /** Method for top limit field value getting.
     * @return top limit field value
     */
    public double getTopLimit() {
        return topLimit;
    }

    /** Method for steps field value getting.
     * @return steps field value
     */
    public int getSteps() {
        return steps;
    }

    /** Method for error field value getting.
     * @return error field value
     */
    public double getError() {
        return error;
    }

    /** Method for result field value getting.
     * @return result field value
     */
    public double getResult() {
        return result;
    }

    /**
     * Constructor of this class.
     * @param function is function for integrating
     * @param bottomLimit is bottom limit for integrating
     * @param topLimit is top limit for integrating
     * @param accuracy is necessary accuracy for integrating
     */
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

    /**
     * Method for numerical integrating of given function.
     * @return result code of integrating
     */
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

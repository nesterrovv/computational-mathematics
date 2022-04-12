package calculations;

/**
 * Class for giving possibility for working with
 * one of three example functions.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/11/2022
 */
public enum FunctionManipulator {

    /** First function. */
    FIRST("y = x^2"),
    /** Second function. */
    SECOND("y = sin(x)"),
    /** Third function. */
    THIRD("y = 1/x");

    /** Field for function storing. */
    private final String function;

    /** Constructor of this class.
     * @param function is field for function storing. Fulls by user.
     */
    FunctionManipulator(String function) {
        this.function = function;
    }

    /**
     * Method for function value calculating.
     * @param x is function argument
     * @return value of function with entered argument
     */
    public double calculateFunction(double x) {
        switch (this) {
            case FIRST:
                return (x * x);
            case SECOND:
                return Math.sin(x);
            case THIRD:
                return 1 / x;
            default:
                return 0;
        }
    }

    /** Method for printing function view in string representation.
     * @return function view in string representation
     */
    @Override
    public String toString() {
        return this.function;
    }

}
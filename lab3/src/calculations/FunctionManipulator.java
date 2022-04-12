package calculations;

public enum FunctionManipulator {

    FIRST("y = x^2"),
    SECOND("y = sin(x)"),
    THIRD("y = 1/x");

    private final String function;

    FunctionManipulator(String function) {
        this.function = function;
    }

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

    @Override
    public String toString() {
        return this.function;
    }

}
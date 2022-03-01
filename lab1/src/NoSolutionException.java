public class NoSolutionException extends Exception {

    private final String defaultMessage = "\nThere are no solutions of this system! Determinant of this matrix is zero.";

    @Override
    public String getMessage() {
        return defaultMessage;
    }

}

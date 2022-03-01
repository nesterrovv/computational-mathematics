public class PermissionDeniedException extends Exception {

    private final String defaultMessage = "File cannot be read! Permission denied!";

    @Override
    public String getMessage() {
        return defaultMessage;
    }

}

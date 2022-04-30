package exceptions;

/**
 * Class with description of exceptions about invalid data entering.
 * Prints necessary message after .getMessage() method usage
 */
public class InvalidDataException extends Exception {

    /**
     * Constructor of this message
     * @param message is message which will be printed when exception
     * will be handled
     */
    public InvalidDataException(String message){
        super(message);
    }

}
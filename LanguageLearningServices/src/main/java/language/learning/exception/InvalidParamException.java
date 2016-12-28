package language.learning.exception;

/**
 * Created by Cristi on 12/28/2016.
 */

public class InvalidParamException extends Exception {
    public InvalidParamException() {
    }

    public InvalidParamException(String msg) {
        super(msg);
    }
}

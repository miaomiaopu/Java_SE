package pers.yzcam.sensible.exception;

/**
 * @author cat
 */
public class TypeNotSupportedException extends Exception {
    private String message = "类型";

    public TypeNotSupportedException() {
    }

    public TypeNotSupportedException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

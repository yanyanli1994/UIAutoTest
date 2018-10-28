package exceptionTools;

/**
 * Created by lixx on 2018-09-15.
 * 数据错误异常类
 * @author  lixx
 * @version
 */
public class ErrorOnDataException extends RuntimeException{
    /**
     * Constructs a ErrorOnDataException with no detail message.
     */
    public ErrorOnDataException() {
        super();
    }
    /**
     * Constructs a ErrorOnDataException with the specified detail message.
     * @param message
     *            the detail message
     */
    public ErrorOnDataException(String message) {
        super(message);
    }

    /**
     * Constructs a ErrorOnDataException with the specified detail message and cause.
     * @param message
     *            the detail message
     * @param cause
     *             the cause
     */
    public ErrorOnDataException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     * Constructs a ErrorOnDataException with the specified  cause.
     * @param cause
     *             the cause
     */
    public ErrorOnDataException(Throwable cause) {
        super(cause);
    }

//    public ErrorOnDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
}

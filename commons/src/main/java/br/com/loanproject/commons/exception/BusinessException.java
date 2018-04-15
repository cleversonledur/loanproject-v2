package br.com.loanproject.commons.exception;

public class BusinessException extends Exception {
	private Exception exception;

    /**
     * Creates a new ServiceLocatorException wrapping another exception, and
     * with a detail message.
     *
     * @param message
     *            the detail message.
     * @param exception
     *            the wrapped exception.
     */
    public BusinessException(String message, Exception exception) {
        super(message);
        this.exception = exception;
        return;
    }

    /**
     * Creates a ServiceLocatorException with the specified detail message.
     *
     * @param message
     *            the detail message.
     */
    public BusinessException(String message) {
        this(message, null);
        return;
    }

    /**
     * Creates a new ServiceLocatorException wrapping another exception, and
     * with no detail message.
     *
     * @param exception
     *            the wrapped exception.
     */
    public BusinessException(Exception exception) {
        this(null, exception);
        return;
    }

    /**
     * Gets the wrapped exception.
     *
     * @return the wrapped exception.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Retrieves (recursively) the root cause exception.
     *
     * @return the root cause exception.
     */
    public Exception getRootCause() {
        if (exception instanceof BusinessException) {
            return ((BusinessException) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    public String toString() {
        if (exception instanceof BusinessException) {
            return ((BusinessException) exception).toString();
        }
        return exception == null ? super.toString() : exception.toString();
}
}

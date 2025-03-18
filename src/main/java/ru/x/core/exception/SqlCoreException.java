package ru.x.core.exception;

public class SqlCoreException extends RuntimeException {

    public SqlCoreException(final String message) {
        super(message);
    }

    public SqlCoreException(final Throwable cause) {
        super(cause);
    }

    public SqlCoreException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

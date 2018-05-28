package com.urp.exception;

/**
 * Created by a on 2018/5/18.
 */
public class PlatformException extends RuntimeException {

    private String message;

    public PlatformException() {
        super();
    }

    public PlatformException(String message) {
        super(message);
        this.message=message;
    }

    public PlatformException(String message, Throwable cause) {
        super(message, cause);
        this.message=message;
    }

    public PlatformException(Throwable cause) {
        super(cause);
    }
}

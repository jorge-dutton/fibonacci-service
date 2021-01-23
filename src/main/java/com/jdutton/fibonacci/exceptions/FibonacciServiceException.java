package com.jdutton.fibonacci.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Number is too big for processing")
public class FibonacciServiceException extends Exception {
    public FibonacciServiceException() {
        super();
    }

    public FibonacciServiceException(String message) {
        super(message);
    }

    public FibonacciServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FibonacciServiceException(Throwable cause) {
        super(cause);
    }

    protected FibonacciServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

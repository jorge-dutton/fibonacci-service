package com.jdutton.fibonacci.exceptions;

public class FibonacciBadArgumentException extends FibonacciServiceException {
    public FibonacciBadArgumentException() {
        super();
    }

    public FibonacciBadArgumentException(String message) {
        super(message);
    }

    public FibonacciBadArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public FibonacciBadArgumentException(Throwable cause) {
        super(cause);
    }
}

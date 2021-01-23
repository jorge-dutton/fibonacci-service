package com.jdutton.fibonacci.exceptions;

public class FibonacciOutOfMemoryException extends FibonacciServiceException {
    public FibonacciOutOfMemoryException() {
        super();
    }

    public FibonacciOutOfMemoryException(String message) {
        super(message);
    }

    public FibonacciOutOfMemoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FibonacciOutOfMemoryException(Throwable cause) {
        super(cause);
    }
}

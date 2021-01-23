package com.jdutton.fibonacci.domain;

public class FibonacciErrorInfo {
    public final int status;
    public final String exception;

    public FibonacciErrorInfo(final int status, final Exception exception) {
        this.status = status;
        this.exception = exception.getLocalizedMessage();
    }
}

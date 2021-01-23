package com.jdutton.fibonacci.domain;

import java.math.BigInteger;

public class FibonacciNumber {

    private BigInteger number;

    public FibonacciNumber(BigInteger number) {
        this.number = number;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }
}

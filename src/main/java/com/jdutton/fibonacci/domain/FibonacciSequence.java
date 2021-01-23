package com.jdutton.fibonacci.domain;

import java.math.BigInteger;
import java.util.List;

public class FibonacciSequence {
    private List<BigInteger> sequence;

    public FibonacciSequence(List<BigInteger> sequence) {
        this.sequence = sequence;
    }

    public List<BigInteger> getSequence() {
        return sequence;
    }

    public void setSequence(List<BigInteger> sequence) {
        this.sequence = sequence;
    }
}

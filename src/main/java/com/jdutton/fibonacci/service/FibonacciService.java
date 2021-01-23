package com.jdutton.fibonacci.service;

import com.jdutton.fibonacci.domain.FibonacciNumber;
import com.jdutton.fibonacci.domain.FibonacciSequence;
import com.jdutton.fibonacci.exceptions.FibonacciServiceException;

public interface FibonacciService {

    FibonacciSequence getFibonacciSequence() throws FibonacciServiceException;
    FibonacciSequence getFibonacciSequence(Integer topNumber) throws FibonacciServiceException;
    FibonacciNumber getFibonacciNumber(Integer position) throws FibonacciServiceException;
}

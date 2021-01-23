package com.jdutton.fibonacci.service.impl;

import com.jdutton.fibonacci.domain.FibonacciNumber;
import com.jdutton.fibonacci.domain.FibonacciSequence;
import com.jdutton.fibonacci.exceptions.FibonacciBadArgumentException;
import com.jdutton.fibonacci.exceptions.FibonacciOutOfMemoryException;
import com.jdutton.fibonacci.exceptions.FibonacciServiceException;
import com.jdutton.fibonacci.service.FibonacciService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciServiceImpl.class);

    @Value("${fibonacci.maximum.number}")
    private long fibonacciMaximumNumber;

    @Override
    public FibonacciSequence getFibonacciSequence() throws FibonacciServiceException {

        List<BigInteger> result;

        try {
            LOGGER.info("Calculating Fibonacci sequence until number {}", fibonacciMaximumNumber);
            result = calculateFibonacciSequence(fibonacciMaximumNumber);
        } catch (OutOfMemoryError e) {
            LOGGER.error("Out of memory. topNumber is too big");
            throw new FibonacciOutOfMemoryException("Top number is too big");
        }
        return new FibonacciSequence(result);
    }

    @Override
    public FibonacciSequence getFibonacciSequence(Integer topNumber) throws FibonacciServiceException {

        if (topNumber < 0) {
            throw new FibonacciBadArgumentException("Top number cannot be negative");
        }

        List<BigInteger> result;

        try {
            LOGGER.info("Calculating Fibonacci sequence until number {}", topNumber);
            result = calculateFibonacciSequence(topNumber);
        } catch (OutOfMemoryError e) {
            LOGGER.error("Out of memory. topNumber is too big");
            throw new FibonacciOutOfMemoryException("Top number is too big");
        }
        return new FibonacciSequence(result);
    }

    @Override
    public FibonacciNumber getFibonacciNumber(Integer position) throws FibonacciServiceException {
        if (position < 0) {
            throw new FibonacciBadArgumentException("Number cannot be negative");
        }
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5)/2;
        int nthTerm = (int) ((Math.pow(phi, position) - Math.pow(-phi, -position))/squareRootOf5);
        return new FibonacciNumber(BigInteger.valueOf(nthTerm));
    }

    private List<BigInteger> calculateFibonacciSequence(long topNumber) {
        return Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, p -> new BigInteger[]{p[1], p[0].add(p[1])})
                .limit(topNumber)
                .map(n -> n[0])
                .collect(Collectors.toList());
    }
}

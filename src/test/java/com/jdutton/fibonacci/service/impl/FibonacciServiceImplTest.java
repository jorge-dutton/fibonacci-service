package com.jdutton.fibonacci.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.jdutton.fibonacci.domain.FibonacciNumber;
import com.jdutton.fibonacci.domain.FibonacciSequence;
import com.jdutton.fibonacci.exceptions.FibonacciBadArgumentException;
import com.jdutton.fibonacci.exceptions.FibonacciOutOfMemoryException;
import com.jdutton.fibonacci.service.FibonacciService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;


class FibonacciServiceImplTest {

    private FibonacciService fibonacciService = new FibonacciServiceImpl();

    @Test
    void whenTopNumber_thenReturnFibonacciSequence() throws Exception {
        FibonacciSequence result = fibonacciService.getFibonacciSequence(100);
        assertEquals(result.getSequence().get(12), BigInteger.valueOf(144));
    }

    @Test
    void whenTopNumberTooBig_thenThrowFibonacciOutOfMemoryException() {
        assertThrows(FibonacciOutOfMemoryException.class, () -> {
             fibonacciService.getFibonacciSequence(445000);
        });
    }

    @Test
    void whenTopNumberNegative_thenThrowFibonacciBadArgumentException() {
        assertThrows(FibonacciBadArgumentException.class, () -> {
            fibonacciService.getFibonacciSequence(-1);
        });
    }

    @Test
    void whenNumberRequested_thenReturnFibonacciNumber() throws Exception {
        FibonacciNumber result = fibonacciService.getFibonacciNumber(10);
        assertEquals(result.getNumber(), BigInteger.valueOf(55));
    }

    @Test
    void whenNegativeNumberRequested_thenThrowFibonacciBadArgumentException() throws Exception {
        assertThrows(FibonacciBadArgumentException.class, () -> {
                    fibonacciService.getFibonacciNumber(-1);
                });
    }
}

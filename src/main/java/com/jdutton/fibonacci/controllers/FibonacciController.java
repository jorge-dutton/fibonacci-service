package com.jdutton.fibonacci.controller;

import com.jdutton.fibonacci.domain.FibonacciNumber;
import com.jdutton.fibonacci.domain.FibonacciSequence;
import com.jdutton.fibonacci.exceptions.FibonacciServiceException;
import com.jdutton.fibonacci.service.FibonacciService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/fibonacci")
public class FibonacciController {

    private static Logger LOGGER = LoggerFactory.getLogger(FibonacciController.class);

    private FibonacciService fibonacciService;
    
    public FibonacciController(FibonacciService fibonacciService) {
        super();
        this.fibonacciService = fibonacciService;
    }
    
    @GetMapping("/sequence/{topNumber}")
    public FibonacciSequence getFibonacciSequence(@PathVariable Integer topNumber, HttpServletResponse response)  {
        FibonacciSequence sequence = null;
        try {
            sequence = fibonacciService.getFibonacciSequence(topNumber);
        } catch (Exception e) {
            LOGGER.error ("Exception " + e.getMessage());
        }
        return sequence;
    }

    @GetMapping("/number/{number}")
    public FibonacciNumber getFibonacciNumber(@PathVariable Integer number) {
        return fibonacciService.getFibonacciNumber(number);
    }
}

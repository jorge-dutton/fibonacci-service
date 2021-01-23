package com.jdutton.fibonacci.controllers;

import com.jdutton.fibonacci.service.FibonacciService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class BaseControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;;

    public MockMvc mockMvc;

    @MockBean
    FibonacciService fibonacciService;

    @MockBean
    FibonacciController fibonacciController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }
}

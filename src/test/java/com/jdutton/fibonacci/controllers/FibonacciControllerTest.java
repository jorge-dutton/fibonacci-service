package com.jdutton.fibonacci.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

@WebMvcTest
class FibonacciControllerTest extends BaseControllerTest {

    @Test
    void getFibonacciSequence() throws Exception {
        mockMvc.perform(get("/api/v1/fibonacci/100"))
                .andExpect(status().isOk());
    }

    @Test
    void getFibonacciSequenceWithNoTopNumber() throws Exception {
        mockMvc.perform(get("/api/v1/fibonacci"))
                .andExpect(status().isOk());
    }

    @Test
    void getFibonacciNumber() throws Exception {
        mockMvc.perform(get("/api/v1/fibonacci/number/100"))
                .andExpect(status().isOk());
    }
}

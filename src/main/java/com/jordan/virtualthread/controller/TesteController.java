package com.jordan.virtualthread.controller;

import com.jordan.virtualthread.service.TestStructuredConcurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    private final TestStructuredConcurrencyService testStructuredConcurrencyService;

    public TesteController(TestStructuredConcurrencyService testStructuredConcurrencyService) {
        this.testStructuredConcurrencyService = testStructuredConcurrencyService;
    }

    @GetMapping
    public void test() {
        testStructuredConcurrencyService.execute();
    }
}

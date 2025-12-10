package com.jordan.virtualthread.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;

@Service
public class TestStructuredConcurrencyService {

    private final ProcessService processService;

    public TestStructuredConcurrencyService(ProcessService processService) {
        this.processService = processService;
    }

    public void execute() {
        var numbers = List.of(10, 20, 30, 40, 50, 10, 20, 30, 40, 50, 10, 20, 30, 40, 50);

        try (var scope = StructuredTaskScope.open(Joiner.awaitAllSuccessfulOrThrow())) {

            numbers.forEach(n -> scope.fork(() -> processService.heavyTask(n)));

            scope.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

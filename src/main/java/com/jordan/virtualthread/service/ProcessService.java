package com.jordan.virtualthread.service;

import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProcessService {

    @ConcurrencyLimit(3)
    public void heavyTask(int number) {
        try {
            Thread.sleep(Duration.ofSeconds(1));
            System.out.println("1. Worker (Item " + number + "): " + Thread.currentThread() + " Time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

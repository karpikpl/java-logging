package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String generateLogs(@RequestParam int count, @RequestParam int length, @RequestParam boolean log) {
        StringBuilder logMessage = new StringBuilder();
        for (int i = 0; i < length; i++) {
            logMessage.append('A');
        }

        if (log) {
            for (int i = 0; i < count; i++) {
                logger.info(logMessage.toString());
            }
        }

        try {
            Thread.sleep(10);  // Add 10ms delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Log generation interrupted";
        }

        return "Logs generated";
    }
}
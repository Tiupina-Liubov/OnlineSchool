package com.example.online_school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for logging demonstration purposes.
 *
 * Класс контроллера для демонстрации логирования.
 */
@RestController
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     * Endpoint to trigger logging.
     * Конечная точка для вызова логирования.
     *
     * @return A message confirming that logs have been recorded.
     *         Сообщение о том, что журналы были записаны.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/log")
    public String log() {
        logger.info("This is an info log message");
        logger.error("This is an error log message");
        return "Logs have been recorded";
    }
}

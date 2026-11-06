package org.example.btthss11.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(HttpNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(HttpNotFoundException ex) {
        log.warn("[WARN] NOT FOUND {}", ex.getMessage());
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<?> handleValidDataException(InsufficientBalanceException ex) {
        log.warn("[WARN] INSUFFICIENT BALANCE {}", ex.getMessage());
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleInternalServerError(Exception ex) {
        log.error("[ERROR] {}", ex.getMessage());
        return ResponseEntity.status(500).body(ex.getMessage());
    }

}

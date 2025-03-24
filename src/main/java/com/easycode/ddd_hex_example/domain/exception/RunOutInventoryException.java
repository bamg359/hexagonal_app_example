package com.easycode.ddd_hex_example.domain.exception;

public class RunOutInventoryException extends RuntimeException {
    public RunOutInventoryException(String message) {
        super(message);
    }
}

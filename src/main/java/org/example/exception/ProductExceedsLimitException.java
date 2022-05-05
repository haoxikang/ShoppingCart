package org.example.exception;

public class ProductExceedsLimitException extends Exception {
    public ProductExceedsLimitException(String message) {
        super(message);
    }
}

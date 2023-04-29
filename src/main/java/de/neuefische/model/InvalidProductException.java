package de.neuefische.model;

public class InvalidProductException extends Exception{
    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

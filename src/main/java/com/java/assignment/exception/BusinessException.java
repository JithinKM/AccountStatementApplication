package com.java.assignment.exception;

/**
 * Exception class for BusinessException.
 *
 * @author Jithin KM
 */
public class BusinessException extends RuntimeException {
    public BusinessException(final String value) {
        super(value);
    }
}

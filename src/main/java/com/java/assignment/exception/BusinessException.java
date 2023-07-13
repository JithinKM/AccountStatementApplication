package com.java.assignment.exception;

/**
 * Exception class for BusinessException
 *
 * @author Jithin KM
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String value) {
        super(value);
    }
}

package com.java.assignment.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {

        super(String.format("No data found for id:  %d", id));
    }
}

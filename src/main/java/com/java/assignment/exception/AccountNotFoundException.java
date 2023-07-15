package com.java.assignment.exception;

import com.java.assignment.constants.AppConstants;

/**
 * Exception class for AccountNotFoundException.
 *
 * @author Jithin KM
 */
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(final Long id) {

        super(String.format(AppConstants.ACCOUNT_NOT_FOUND, id));
    }
}

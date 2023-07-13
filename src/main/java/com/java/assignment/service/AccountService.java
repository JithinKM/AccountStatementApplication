package com.java.assignment.service;

import com.java.assignment.model.AccountStatement;

/**
 * Account service
 *
 * @author Jithin KM
 */
public interface AccountService {
    AccountStatement getAccountStatements(long id, String fromDate, String toDate, long fromAmount, long toAmount);
}

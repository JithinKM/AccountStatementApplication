package com.java.assignment.service;

import com.java.assignment.model.Account;
import com.java.assignment.model.AccountStatement;

import java.util.List;

/**
 * Account service.
 *
 * @author Jithin KM
 */
public interface AccountService {

    List<Account> getAllAccounts();
    AccountStatement getAccountStatements(long id, String fromDate, String toDate, long fromAmount, long toAmount);
}

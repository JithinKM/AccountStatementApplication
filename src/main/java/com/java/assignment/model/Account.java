package com.java.assignment.model;

import java.util.List;

/**
 * Model class for storing account details.
 *
 * @author Jithin KM
 */
public final class Account {

    private long accountId;

    private String accountType;

    private String accountNumber;

    public Account(final long accountId, final String accountType, final String accountNumber) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(final long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

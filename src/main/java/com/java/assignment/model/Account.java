package com.java.assignment.model;

import java.util.List;

/**
 * Model class for storing account details
 *
 * @author Jithin KM
 */
public class Account {

    private long accountId;

    private String accountType;

    private String accountNumber;

    public Account(long accountId, String accountType, String accountNumber) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

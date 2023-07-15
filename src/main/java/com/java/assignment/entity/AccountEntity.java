package com.java.assignment.entity;

/**
 * Entity class for account.
 *
 * @author Jithin KM
 */
public final class AccountEntity {

    private long id;

    private String accountType;
    private String accountNumber;

    public AccountEntity(final long id, final String accountType, final String accountNumber) {
        this.id = id;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    public AccountEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
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

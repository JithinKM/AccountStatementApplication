package com.java.assignment.entity;

/**
 * Entity class for account
 *
 * @author Jithin KM
 */
public class AccountEntity {

    private long id;

    private String accountType;
    private String accountNumber;

    public AccountEntity(long id, String accountType, String accountNumber) {
        this.id = id;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    public AccountEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

package com.java.assignment.model;

import java.util.List;

/**
 * Model class for storing account statements
 *
 * @author Jithin KM
 */
public class AccountStatement {

    private long accountId;

    private String accountNumber;

    private List<Statement> statementList;

    public AccountStatement(long accountId, String accountNumber, List<Statement> statementList) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.statementList = statementList;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<Statement> statementList) {
        this.statementList = statementList;
    }
}

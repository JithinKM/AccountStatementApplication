package com.java.assignment.model;

import java.util.List;

/**
 * Model class for storing account statements.
 *
 * @author Jithin KM
 */
public final class AccountStatement {

    private long accountId;

    private String accountNumber;

    private List<Statement> statementList;

    public AccountStatement(final long accountId, final String accountNumber, final List<Statement> statementList) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.statementList = statementList;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(final long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }

    public void setStatementList(final List<Statement> statementList) {
        this.statementList = statementList;
    }
}

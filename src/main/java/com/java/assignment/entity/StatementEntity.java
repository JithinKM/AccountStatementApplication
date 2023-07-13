package com.java.assignment.entity;

/**
 * Entity class for statement
 *
 * @author Jithin KM
 */
public class StatementEntity {

    private long id;

    private long accountId;
    private String dateField;
    private String amount;

    public StatementEntity(long id, long accountId, String dateField, String amount) {
        this.id = id;
        this.accountId = accountId;
        this.dateField = dateField;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getDateField() {
        return dateField;
    }

    public void setDateField(String dateField) {
        this.dateField = dateField;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

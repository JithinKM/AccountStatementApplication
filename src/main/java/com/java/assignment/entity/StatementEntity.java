package com.java.assignment.entity;

/**
 * Entity class for statement.
 *
 * @author Jithin KM
 */
public final class StatementEntity {

    private long id;

    private long accountId;
    private String dateField;
    private String amount;

    public StatementEntity(final long id, final long accountId, final String dateField, final String amount) {
        this.id = id;
        this.accountId = accountId;
        this.dateField = dateField;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(final long accountId) {
        this.accountId = accountId;
    }

    public String getDateField() {
        return dateField;
    }

    public void setDateField(final String dateField) {
        this.dateField = dateField;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }
}

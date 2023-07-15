package com.java.assignment.model;

/**
 * Model class for storing statement details.
 *
 * @author Jithin KM
 */
public final class Statement {

    private String dateField;
    private String amount;

    public Statement(final String dateField, final String amount) {
        this.dateField = dateField;
        this.amount = amount;
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

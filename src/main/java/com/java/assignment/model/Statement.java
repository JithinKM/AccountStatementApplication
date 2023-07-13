package com.java.assignment.model;

/**
 * Model class for storing statement details
 *
 * @author Jithin KM
 */
public class Statement {

    private String dateField;
    private String amount;

    public Statement(String dateField, String amount) {
        this.dateField = dateField;
        this.amount = amount;
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

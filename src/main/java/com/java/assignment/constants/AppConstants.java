package com.java.assignment.constants;

/**
 * App Constants class.
 *
 * @author Jithin KM
 */
public class AppConstants {

    private AppConstants() {
    }

    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String SHA_ALGO = "SHA-256";

    //User roles
    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    //Log messages
    public static final String ACCOUNT_NOT_FOUND = "No data found for id:  %d";

    public static final String INVALID_ALGO = "Error getting hashing algorithm: %s";
    public static final String INVALID_DATE = "Error parsing date: %s";
    public static final String INCORRECT_DATE = "fromDate should be less than the toDate: ";
    public static final String INCORRECT_AMOUNT = "fromAmount should be less than the toAmount: ";
}

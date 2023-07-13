package com.java.assignment.utils;

import com.java.assignment.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility class for date operations
 *
 * @author Jithin KM
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_FORMAT);

    /**
     * Parse the date string to the specified date format
     *
     * @param dateString the date value in string format
     * @return parsed date
     */
    public static LocalDate parseDate(final String dateString) {

        LocalDate date = null;
        try {
             date = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            logger.error("Error parsing date: " + e.getMessage());
        }

        return date;
    }
}

package com.java.assignment.utils;

import com.java.assignment.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * DateUtils test class
 *
 * @author Jithin KM
 */
@RunWith(MockitoJUnitRunner.class)
public class DateUtilsTest {

    @Test
    public void parseDateSuccessTest() {
        LocalDate localDate = DateUtils.parseDate("15-11-2020");
        assertEquals(2020, localDate.getYear());
        assertEquals(11, localDate.getMonthValue());
        assertEquals(15, localDate.getDayOfMonth());
    }

    @Test(expected = BusinessException.class)
    public void parseDateFailureTest() {
        try {
            DateUtils.parseDate("abcd");
        } catch (BusinessException e) {
            String expectedMessage = "Error parsing date: abcd";
            assertEquals(expectedMessage, e.getMessage());
            throw e;
        }

        fail("BusinessException did not throw!");
    }
}

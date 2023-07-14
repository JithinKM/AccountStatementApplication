package com.java.assignment.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * StringHashUtils test class
 *
 * @author Jithin KM
 */
@RunWith(MockitoJUnitRunner.class)
public class StringHashUtilsTest {

    @Test
    public void getHashedStringSuccessTest() {
        String hashedString = StringHashUtils.getHashedString("abcd");
        assertEquals("88d4266fd4e6338d13b845fcf289579d209c897823b9217da3e161936f031589", hashedString);
    }
}

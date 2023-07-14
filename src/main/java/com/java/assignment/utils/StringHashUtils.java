package com.java.assignment.utils;

import com.java.assignment.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for String hashing
 *
 * @author Jithin KM
 */
public class StringHashUtils {

    private static final Logger logger = LoggerFactory.getLogger(StringHashUtils.class);

    /**
     * Generate hashed string
     *
     * @param originalString the string values to be hashes
     * @return hashed string
     */
    public static String getHashedString(final String originalString) {

        String hashedString = "";
        try {
            MessageDigest digest = MessageDigest.getInstance(AppConstants.SHA_ALGO);
            byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

            //Generate hash string from the byte array
            hashedString = bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error getting hashing algorithm: " + e.getMessage());
        }

        return hashedString;
    }

    /**
     * Generate string from the byte array
     *
     * @param hash the hashed byte array
     * @return hashed string
     */
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

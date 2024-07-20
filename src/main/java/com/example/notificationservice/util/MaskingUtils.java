package com.example.notificationservice.util;

public class MaskingUtils {

    /**
     * Masks account numbers in the given string.
     * @param input The input string potentially containing account numbers.
     * @return The input string with account numbers masked.
     */
    public static String maskAccountNumbers(String input) {
        if (input == null) {
            return null;
        }
        // Regex pattern to match account numbers in the format of 1234-5678-9012-3456
        return input.replaceAll("(\\d{4}-\\d{4}-\\d{4}-)\\d{4}", "$1****");
    }
}


package com.airtribe.learntrack.util;


public class InputValidator {
    private InputValidator() {}

    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}
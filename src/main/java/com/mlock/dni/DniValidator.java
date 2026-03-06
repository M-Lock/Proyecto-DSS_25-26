package com.mlock.dni;

public final class DniValidator {
    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    private DniValidator() {
    }

    public static boolean isValid(String dni) {
        if (dni == null) {
            return false;
        }

        String normalized = dni.trim().toUpperCase();
        if (!normalized.matches("\\d{8}[A-Z]")) {
            return false;
        }

        int number = Integer.parseInt(normalized.substring(0, 8));
        char expectedLetter = DNI_LETTERS.charAt(number % 23);
        char providedLetter = normalized.charAt(8);

        return expectedLetter == providedLetter;
    }
}

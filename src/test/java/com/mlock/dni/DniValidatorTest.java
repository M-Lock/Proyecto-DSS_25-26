package com.mlock.dni;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DniValidatorTest {

    @Test
    void shouldAcceptValidDni() {
        assertTrue(DniValidator.isValid("12345678Z"));
    }

    @Test
    void shouldAcceptNormalizedDni() {
        assertTrue(DniValidator.isValid(" 12345678z "));
    }

    @Test
    void shouldRejectWrongLetter() {
        assertFalse(DniValidator.isValid("12345678A"));
    }

    @Test
    void shouldRejectInvalidFormat() {
        assertFalse(DniValidator.isValid("1234A"));
        assertFalse(DniValidator.isValid("ABCDEFGHZ"));
        assertFalse(DniValidator.isValid(null));
    }
}

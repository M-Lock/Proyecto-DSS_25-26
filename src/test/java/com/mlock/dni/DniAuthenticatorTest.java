package com.mlock.dni;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DniAuthenticatorTest {

    @Test
    void shouldAuthenticateAuthorizedValidDni() {
        DniAuthenticator authenticator = new DniAuthenticator(Set.of("12345678Z"));

        assertTrue(authenticator.authenticate("12345678Z"));
    }

    @Test
    void shouldRejectValidButNotAuthorizedDni() {
        DniAuthenticator authenticator = new DniAuthenticator(Set.of("12345678Z"));

        assertFalse(authenticator.authenticate("00000000T"));
    }

    @Test
    void shouldRejectInvalidDniEvenIfIncluded() {
        DniAuthenticator authenticator = new DniAuthenticator(Set.of("12345678A"));

        assertFalse(authenticator.authenticate("12345678A"));
    }

    @Test
    void shouldNormalizeInputBeforeCheckingAuthorization() {
        DniAuthenticator authenticator = new DniAuthenticator(Set.of("12345678Z"));

        assertTrue(authenticator.authenticate(" 12345678z "));
    }
}

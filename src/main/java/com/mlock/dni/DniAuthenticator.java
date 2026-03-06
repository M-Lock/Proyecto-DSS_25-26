package com.mlock.dni;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class DniAuthenticator {
    private final Set<String> allowedDnis;

    public DniAuthenticator(Set<String> allowedDnis) {
        this.allowedDnis = new HashSet<>();
        for (String dni : allowedDnis) {
            this.allowedDnis.add(normalize(dni));
        }
    }

    public boolean authenticate(String dni) {
        String normalized = normalize(dni);
        return DniValidator.isValid(normalized) && allowedDnis.contains(normalized);
    }

    private String normalize(String dni) {
        return dni == null ? "" : dni.trim().toUpperCase(Locale.ROOT);
    }
}

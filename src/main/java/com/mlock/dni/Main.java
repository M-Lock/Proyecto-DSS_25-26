package com.mlock.dni;

import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Set<String> authorizedDnis = Set.of(
            "12345678Z",
            "00000000T",
            "11111111H"
        );

        DniAuthenticator authenticator = new DniAuthenticator(authorizedDnis);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce tu DNI (8 numeros + letra): ");
            String inputDni = scanner.nextLine();

            if (!DniValidator.isValid(inputDni)) {
                System.out.println("DNI invalido. Revisa formato y letra.");
                return;
            }

            boolean authenticated = authenticator.authenticate(inputDni);
            if (authenticated) {
                System.out.println("Autenticacion correcta. DNI autorizado.");
            } else {
                System.out.println("DNI valido pero no autorizado.");
            }
        }
    }
}

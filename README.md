# Proyecto DSS 25-26

## Práctica 1 — Introducción a Git y GitHub Copilot

En esta primera práctica se trabaja una introducción a Git y al control de versiones: inicialización de repositorio, gestión de cambios con *add/commit*, creación de ramas y resolución básica de conflictos, así como la sincronización con un repositorio remoto.

Además, se introduce el uso de GitHub Copilot como asistente de programación en VS Code, aplicándolo para acelerar tareas habituales (generación de snippets, ayuda con comandos y documentación) y revisando buenas prácticas de uso.

## Miembros del grupo

- Marco Molins
- Marcos Jimenez

## Mini proyecto Java: autenticador de DNI

Se ha anadido un mini proyecto en Java que valida DNIs espanoles y comprueba si estan autorizados.

### Estructura

- `src/main/java/com/mlock/dni/DniValidator.java`: valida formato y letra del DNI.
- `src/main/java/com/mlock/dni/DniAuthenticator.java`: autentica contra un listado de DNIs autorizados.
- `src/main/java/com/mlock/dni/Main.java`: aplicacion de consola para probar autenticacion.

### Compilar y ejecutar (PowerShell)

```powershell
New-Item -ItemType Directory -Force out
javac --release 11 -d out src/main/java/com/mlock/dni/*.java
java -cp out com.mlock.dni.Main
```

### Ejecutar con Maven (recomendado)

```powershell
mvn clean test
mvn package
java -jar target/dni-authenticator-1.0.0.jar
```

### Tests automaticos

- Los tests unitarios estan en `src/test/java/com/mlock/dni/`.
- GitHub Actions ejecuta `mvn -B test` en cada push y pull request a `main`.
- Workflow: `.github/workflows/ci-tests.yml`.

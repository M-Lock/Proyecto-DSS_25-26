# Aplicacion DNI

## Que hace
La aplicacion pide un DNI por consola y:
1. Valida formato (`8 digitos + letra`).
2. Verifica que la letra sea correcta segun el algoritmo oficial.
3. Comprueba si el DNI esta autorizado.

## Componentes
- `DniValidator`: logica de validacion del DNI.
- `DniAuthenticator`: validacion + autorizacion.
- `Main`: punto de entrada CLI.

## Ejecucion local
```powershell
New-Item -ItemType Directory -Force out
javac --release 11 -d out src/main/java/com/mlock/dni/*.java
java -cp out com.mlock.dni.Main
```

## Mejora sugerida
- Añadir tests unitarios y migrar build a Maven para gestionar dependencias y CI de forma estandar.

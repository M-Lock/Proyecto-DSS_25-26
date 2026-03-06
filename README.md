# Proyecto DSS 25-26

## Práctica 1 — Introducción a Git y GitHub Copilot

En esta primera práctica se trabaja una introducción a Git y al control de versiones: inicialización de repositorio, gestión de cambios con *add/commit*, creación de ramas y resolución básica de conflictos, así como la sincronización con un repositorio remoto.

Además, se introduce el uso de GitHub Copilot como asistente de programación en VS Code, aplicándolo para acelerar tareas habituales (generación de snippets, ayuda con comandos y documentación) y revisando buenas prácticas de uso.

## Listar repositorios de GitHub

El script `listar_repositorios.py` utiliza la API de GitHub para mostrar los repositorios de un usuario.

**Uso básico** (repositorios públicos):

```bash
# Con el usuario por defecto (M-Lock)
python listar_repositorios.py

# Especificando otro usuario
GITHUB_USER=octocat python listar_repositorios.py
```

**Con token de acceso personal** (incluye repositorios privados):

```bash
GITHUB_USER=<tu_usuario> GITHUB_TOKEN=<tu_token> python listar_repositorios.py
```

## Miembros del grupo

- Marco Molins
- Marcos Jimenez

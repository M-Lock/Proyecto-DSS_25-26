"""
Script para listar los repositorios de un usuario de GitHub usando la API de GitHub.
"""

import urllib.request
import urllib.error
import json
import os
import sys


def listar_repositorios(usuario: str, token: str | None = None) -> list[dict]:
    """
    Devuelve la lista de todos los repositorios de un usuario de GitHub.

    Recorre automáticamente todas las páginas de resultados de la API.

    Args:
        usuario: Nombre de usuario de GitHub.
        token: Token de acceso personal (opcional, necesario para repos privados).

    Returns:
        Lista de diccionarios con información de cada repositorio.

    Raises:
        urllib.error.HTTPError: Si la API devuelve un error HTTP.
        urllib.error.URLError: Si no se puede conectar con la API.
    """
    headers = {"Accept": "application/vnd.github+json", "X-GitHub-Api-Version": "2022-11-28"}
    if token:
        headers["Authorization"] = f"Bearer {token}"

    repos: list[dict] = []
    page = 1
    while True:
        url = f"https://api.github.com/users/{usuario}/repos?per_page=100&sort=updated&page={page}"
        req = urllib.request.Request(url, headers=headers)
        with urllib.request.urlopen(req) as response:
            pagina = json.loads(response.read().decode())
        if not pagina:
            break
        repos.extend(pagina)
        page += 1

    return repos


def mostrar_repositorios(repos: list[dict]) -> None:
    """Muestra por pantalla los repositorios de forma legible."""
    if not repos:
        print("No se encontraron repositorios.")
        return

    ancho_nombre = max(len(repo.get("name", "")) for repo in repos)
    ancho_nombre = max(ancho_nombre, len("Nombre"))

    print(f"\n{'Nombre':<{ancho_nombre}} {'Privado':<10} {'Descripción'}")
    print("-" * (ancho_nombre + 10 + 40))
    for repo in repos:
        nombre = repo.get("name", "")
        privado = "Sí" if repo.get("private") else "No"
        descripcion = repo.get("description") or ""
        print(f"{nombre:<{ancho_nombre}} {privado:<10} {descripcion}")


if __name__ == "__main__":
    usuario = os.environ.get("GITHUB_USER", "M-Lock")
    token = os.environ.get("GITHUB_TOKEN")

    print(f"Repositorios de {usuario}:")
    try:
        repos = listar_repositorios(usuario, token)
    except urllib.error.HTTPError as e:
        print(f"Error HTTP {e.code}: {e.reason}", file=sys.stderr)
        sys.exit(1)
    except urllib.error.URLError as e:
        print(f"Error de conexión: {e.reason}", file=sys.stderr)
        sys.exit(1)
    mostrar_repositorios(repos)

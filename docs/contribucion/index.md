# Contribuir

Guía para contribuir al proyecto.

## Requisitos

- Java 21+
- Maven 3.9+
- Git

## Configuración del entorno

```bash
git clone https://github.com/cazucito/java-collections.git
cd java-collections
mvn clean verify
```

## Flujo de trabajo

1. Crea una rama: `git checkout -b feature/nueva-caracteristica`
2. Implementa tus cambios
3. Ejecuta tests: `mvn clean verify`
4. Commit: `git commit -m "feat: descripción"`
5. Push: `git push origin feature/nueva-caracteristica`
6. Crea un Pull Request

## Estándares de código

- Sigue las convenciones de Google Java Format
- Todos los tests deben pasar
- Cobertura mínima: 60%
- Sin warnings de Checkstyle ni SpotBugs

## Próximamente

Guía detallada de contribución.

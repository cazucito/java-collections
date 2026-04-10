# Estándares de Código

Reglas para mantener calidad en el proyecto.

## Formato

- Google Java Format (automático con Spotless)
- Indentación: 2 espacios
- Límite de línea: 100 caracteres

## Nombrado

```java
// Clases: PascalCase
public class ArrayListExample { }

// Métodos: camelCase
public void demonstrateAddOperation() { }

// Constantes: UPPER_SNAKE_CASE
private static final int DEFAULT_CAPACITY = 10;

// Variables: camelCase
private List<String> elementList;
```

## Tests

```java
// Feature files: lowercase_with_underscores.feature
// Step classes: PascalCaseSteps.java
// Scenarios: Descriptivos en español
```

## Documentación

- Javadoc para clases públicas
- Comentarios solo cuando necesario
- Gherkin en español (ADR-002)

## Calidad

```bash
# Ejecutar antes de commit
mvn clean verify
```

Debe pasar:
- ✅ Compilación
- ✅ Tests (217+)
- ✅ Checkstyle
- ✅ SpotBugs
- ✅ Spotless
- ✅ JaCoCo (>60% coverage)

## Próximamente

Guía completa de estándares.

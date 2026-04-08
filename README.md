# Java Collections Examples

> Ejemplos del API Java Collections con enfoque **BDD/TDD** y **especificación primero**.

## 🎯 Objetivo

Este proyecto ejemplifica el uso del API Java Collections mediante casos de uso reales, siguiendo las mejores prácticas de desarrollo de software.

## 📚 Contenido

- **List:** ArrayList, LinkedList, operaciones de ordenamiento
- **Set:** HashSet, TreeSet, LinkedHashSet
- **Map:** HashMap, TreeMap, LinkedHashMap
- **Queue:** PriorityQueue, Deque
- **Streams:** Operaciones funcionales con Collections

## 🚀 Cómo empezar

### Requisitos

- Java 21 o superior
- Maven 3.9+

### Compilación y ejecución

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar todos los tests
mvn test

# Verificar calidad de código
mvn clean verify

# Formatear código automáticamente
mvn spotless:apply
```

## 🧪 Enfoque de Desarrollo

Este proyecto sigue **BDD (Behavior Driven Development)**:

1. **Especificar:** Escribir escenarios en Gherkin (Given-When-Then)
2. **Definir:** Crear step definitions
3. **Implementar:** Escribir código mínimo que pase los tests
4. **Refactorizar:** Mejorar manteniendo tests verdes

### Ejemplo de especificación

```gherkin
Feature: Gestión de elementos con ArrayList

  Scenario: Agregar elementos a un ArrayList vacío
    Given un ArrayList vacío
    When agrego el elemento "Java"
    Then el tamaño de la lista debe ser 1
```

## 📝 Convenciones

- **Código fuente:** Inglés
- **Documentación:** Español neutro
- **Commits:** Conventional Commits (`feat:`, `fix:`, `test:`, etc.)
- **Versionado:** SemVer (MAJOR.MINOR.PATCH)

## 🔧 Herramientas de Calidad

| Herramienta | Propósito | Comando |
|-------------|-----------|---------|
| **Checkstyle** | Verificar estilo de código | `mvn checkstyle:check` |
| **SpotBugs** | Detectar bugs potenciales | `mvn spotbugs:check` |
| **Spotless** | Formateo automático | `mvn spotless:apply` |
| **JaCoCo** | Cobertura de código | `mvn jacoco:report` |

## 📖 Documentación para Agentes de IA

Consulta [`AGENTS.md`](AGENTS.md) para guías detalladas sobre:
- Convenciones de nomenclatura
- Estructura de paquetes
- Estándares de código
- Flujo de trabajo BDD/TDD

## 📄 Licencia

Apache License 2.0

---

**Autor:** cazucito

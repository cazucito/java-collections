# Java Collections Examples

[![CI](https://github.com/cazucito/java-collections/actions/workflows/ci.yml/badge.svg)](https://github.com/cazucito/java-collections/actions)
[![Java 21](https://img.shields.io/badge/Java-21-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)

> **Ejemplos prácticos del API Java Collections con enfoque BDD/TDD**

Este proyecto demuestra el uso del API Java Collections mediante **217 escenarios BDD** que cubren desde los conceptos básicos hasta técnicas avanzadas como generics, concurrencia y optimización de rendimiento.

## ¿Qué encontrarás aquí?

### 🎯 Para principiantes
- **Fundamentos**: ArrayList, HashSet, HashMap explicados paso a paso
- **Primeros pasos**: Tu primer escenario BDD con Cucumber
- **Instalación**: Setup completo en 5 minutos

### 🚀 Para desarrolladores intermedios
- **Casos de uso reales**: Cachés, procesamiento por lotes, gestión de sesiones
- **Streams API**: Operaciones funcionales con colecciones
- **Algoritmos**: Collections.sort(), binarySearch(), y más

### 🔧 Para desarrolladores avanzados
- **Generics avanzados**: Wildcards, PECS, Type Erasure
- **Concurrencia**: CopyOnWriteArrayList, ConcurrentHashMap
- **Anti-patrones**: Errores comunes y cómo evitarlos

## Estadísticas del Proyecto

| Métrica | Valor |
|---------|-------|
| **Escenarios BDD** | 217 |
| **Cobertura de código** | >80% (JaCoCo) |
| **Colecciones implementadas** | 10+ |
| **Calidad de código** | Checkstyle, SpotBugs, Spotless |
| **Java** | 21 LTS |

## Estructura del Proyecto

```
java-collections/
├── src/main/java/          # Implementaciones de ejemplo
├── src/test/java/          # Step definitions (BDD)
├── src/test/resources/     # Escenarios Gherkin
├── docs/                   # Esta documentación
└── .github/workflows/      # CI/CD con GitHub Actions
```

## Navegación rápida

<div class="grid cards" markdown>

-   :material-play-circle:{ .lg .middle } **Empezar**

    ---

    Configura tu entorno y ejecuta tu primer test en minutos.

    [:octicons-arrow-right-24: Instalación](introduccion/instalacion.md)

-   :material-format-list-bulleted:{ .lg .middle } **Colecciones**

    ---

    Aprende List, Set, Map, Queue con ejemplos prácticos.

    [:octicons-arrow-right-24: Ver colecciones](colecciones/index.md)

-   :material-lightbulb:{ .lg .middle } **Casos de Uso**

    ---

    Soluciones reales: cachés, procesamiento de datos, y más.

    [:octicons-arrow-right-24: Ver casos](casos-de-uso/index.md)

-   :material-alert:{ .lg .middle } **Anti-Patrones**

    ---

    Errores comunes y cómo evitar memory leaks y excepciones.

    [:octicons-arrow-right-24: Ver anti-patrones](anti-patrones/index.md)

</div>

## Filosofía del Proyecto

Este proyecto sigue los principios de **Behavior Driven Development (BDD)**:

1. **Especificar** → Escribir escenarios en lenguaje natural (Gherkin)
2. **Definir** → Crear step definitions que conectan especificación con código
3. **Implementar** → Escribir el código mínimo necesario
4. **Refactorizar** → Mejorar manteniendo todos los tests verdes

```gherkin
# Ejemplo de escenario BDD
Escenario: Agregar elemento a ArrayList
  Dado un ArrayList vacío
  Cuando agrego el elemento "Java"
  Entonces el tamaño del ArrayList es 1
  Y el ArrayList contiene "Java"
```

## Contribuir

¿Quieres agregar una nueva colección o escenario? Revisa nuestra [guía de contribución](contribucion/index.md).

## Licencia

Este proyecto está licenciado bajo [Apache 2.0](LICENSE).

---

**Hecho con ❤️ y muchos tests pasando** :material-check-all:

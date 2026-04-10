# Java Collections Examples

![CI](https://img.shields.io/badge/CI-passing-brightgreen?logo=githubactions&logoColor=white)
![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)
![License](https://img.shields.io/badge/License-Apache%202.0-green?logo=apache&logoColor=white)

> **Ejemplos prácticos del API Java Collections con enfoque BDD/TDD**

Este proyecto demuestra el uso del API Java Collections mediante **217 escenarios BDD** que cubren desde los conceptos básicos hasta técnicas avanzadas como generics, concurrencia y optimización de rendimiento.

Cada colección incluye ejemplos ejecutables con Cucumber y JUnit 5, siguiendo las mejores prácticas de Behavior Driven Development.

---

## Estadísticas del Proyecto

| Métrica | Valor | Descripción |
|---------|:-----:|-------------|
| Escenarios BDD | 217 | Tests ejecutables con Cucumber |
| Cobertura de código | >80% | Medido con JaCoCo |
| Colecciones | 10+ | ArrayList, HashMap, TreeSet, etc. |
| Calidad | ✅ | Checkstyle, SpotBugs, Spotless |
| Java | 21 LTS | Última versión LTS |

---

## Contenido por Nivel

### 🌱 Principiantes
- **Fundamentos**: ArrayList, HashSet, HashMap explicados paso a paso
- **Primeros pasos**: Tu primer escenario BDD con Cucumber
- **Instalación**: Setup completo en 5 minutos

### ⚡ Intermedios
- **Casos de uso reales**: Cachés, procesamiento por lotes, gestión de sesiones
- **Streams API**: Operaciones funcionales con colecciones
- **Algoritmos**: Collections.sort(), binarySearch(), y más

### 🔥 Avanzados
- **Generics**: Wildcards, PECS, Type Erasure
- **Concurrencia**: CopyOnWriteArrayList, ConcurrentHashMap
- **Anti-patrones**: Errores comunes y cómo evitarlos

---

## Estructura del Proyecto

```
java-collections/
├── src/main/java/          # Implementaciones de ejemplo
├── src/test/java/          # Step definitions (BDD)
├── src/test/resources/     # Escenarios Gherkin (.feature)
├── docs/                   # Esta documentación
└── .github/workflows/      # CI/CD con GitHub Actions
```

---

## Navegación Rápida

- 🏁 [Empezar](introduccion/instalacion.md) - Instalación y primeros pasos
- 📚 [Colecciones](colecciones/index.md) - List, Set, Map, Queue
- 💡 [Casos de Uso](casos-de-uso/index.md) - Soluciones reales
- ⚠️ [Anti-Patrones](anti-patrones/index.md) - Errores comunes

---

## Ejemplo de Escenario BDD

```gherkin
# language: es
Característica: Operaciones básicas de ArrayList

  Escenario: Agregar elemento a ArrayList
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Entonces el tamaño del ArrayList es 1
    Y el ArrayList contiene "Java"
```

---

## Contribuir

¿Quieres agregar una nueva colección o escenario? Revisa nuestra [guía de contribución](contribucion/index.md).

## Licencia

Este proyecto está licenciado bajo [Apache 2.0](LICENSE).

---

**Hecho con ❤️ y muchos tests pasando**

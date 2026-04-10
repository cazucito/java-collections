# Java Collections Examples

[![CI](https://img.shields.io/github/actions/workflow/status/cazucito/java-collections/ci.yml?branch=main&label=CI)](https://github.com/cazucito/java-collections/actions/workflows/ci.yml)
[![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/21/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green?logo=apache&logoColor=white)](LICENSE)
[![Documentation](https://img.shields.io/badge/docs-online-blue)](https://cazucito.github.io/java-collections/)

> **Ejemplos prácticos del API Java Collections con enfoque BDD/TDD**

Este proyecto demuestra el uso del **Java Collections Framework** mediante **217 escenarios BDD** ejecutables, cubriendo desde conceptos básicos hasta técnicas avanzadas como generics, concurrencia y optimización de rendimiento.

📖 **[Documentación completa](https://cazucito.github.io/java-collections/)**

---

## 📊 Estadísticas

| Métrica | Valor |
|---------|-------|
| **Escenarios BDD** | 217 |
| **Cobertura de código** | >80% (JaCoCo) |
| **Colecciones implementadas** | 10+ |
| **Calidad** | Checkstyle, SpotBugs, Spotless |
| **Java** | 21 LTS |

---

## 📚 Contenido

### Colecciones Core
- **List:** ArrayList, LinkedList
- **Set:** HashSet, TreeSet, LinkedHashSet
- **Map:** HashMap, TreeMap, LinkedHashMap
- **Queue/Deque:** PriorityQueue, ArrayDeque

### Temas Avanzados
- **Streams API:** Operaciones funcionales
- **Generics:** Wildcards, PECS, Type Erasure
- **Algoritmos:** Collections.sort(), binarySearch()
- **Concurrencia:** CopyOnWriteArrayList, ConcurrentHashMap
- **Anti-Patrones:** Memory leaks, ConcurrentModificationException

---

## 🚀 Cómo empezar

### Requisitos

- Java 21 o superior
- Maven 3.9+

### Instalación

```bash
# Clonar el repositorio
git clone https://github.com/cazucito/java-collections.git
cd java-collections

# Compilar y ejecutar tests
mvn clean verify
```

### Comandos útiles

```bash
# Ejecutar todos los tests
mvn test

# Ejecutar tests específicos
mvn test -Dcucumber.filter.tags="@arraylist"

# Verificar calidad de código
mvn clean verify

# Formatear código
mvn spotless:apply

# Generar reporte de cobertura
mvn jacoco:report
```

---

## 🧪 Enfoque BDD

Este proyecto sigue **Behavior Driven Development**:

1. **Especificar** → Escribir escenarios en Gherkin
2. **Definir** → Crear step definitions
3. **Implementar** → Código mínimo que pase los tests
4. **Refactorizar** → Mejorar manteniendo tests verdes

### Ejemplo

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

## 🔧 Calidad de Código

| Herramienta | Propósito | Configuración |
|-------------|-----------|---------------|
| **Checkstyle** | Estilo de código | [Google Java Style](https://google.github.io/styleguide/javaguide.html) |
| **SpotBugs** | Bugs estáticos | Análisis completo |
| **Spotless** | Formato automático | Google Java Format |
| **JaCoCo** | Cobertura | Mínimo 60% |

---

## 📁 Estructura del Proyecto

```
java-collections/
├── src/
│   ├── main/java/          # Implementaciones
│   ├── test/java/          # Step definitions (BDD)
│   └── test/resources/     # Features Gherkin
├── docs/                   # Documentación MkDocs
├── .github/workflows/      # CI/CD
├── README.md               # Este archivo
└── pom.xml                 # Configuración Maven
```

---

## 📝 Convenciones

- **Código fuente:** Inglés
- **Documentación:** Español neutro
- **Commits:** [Conventional Commits](https://www.conventionalcommits.org/)
- **BDD:** Gherkin en español

---

## 🤝 Contribuir

Las contribuciones son bienvenidas. Ver [guía de contribución](https://cazucito.github.io/java-collections/contribucion/).

1. Fork el repositorio
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`)
3. Commitea tus cambios (`git commit -m 'feat: agregar...'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

---

## 📄 Licencia

[Apache License 2.0](LICENSE)

---

**Desarrollado con ❤️ por [cazucito](https://github.com/cazucito)**

[![GitHub stars](https://img.shields.io/github/stars/cazucito/java-collections?style=social)](https://github.com/cazucito/java-collections)

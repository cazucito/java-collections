# Escenarios BDD Completos

Listado completo de los 217 escenarios implementados en el proyecto.

## Resumen por milestone

| Milestone | Escenarios | Descripción |
|-----------|------------|-------------|
| M1 | Base | Configuración del proyecto |
| M2 | 27 | List (ArrayList, LinkedList) |
| M3 | 32 | Set (HashSet, TreeSet, LinkedHashSet) |
| M4 | 37 | Map (HashMap, TreeMap, LinkedHashMap) |
| M5 | 21 | Queue/Deque (PriorityQueue, ArrayDeque) |
| M6 | 28 | Algorithms & Utilities |
| M7 | 22 | Streams API |
| M8 | 39 | Advanced Features (Generics) |
| M11 | 11 | Anti-Patterns |
| **Total** | **217** | |

## Estructura de archivos feature

```
src/test/resources/features/
├── list/
│   ├── arraylist_operations.feature (16 escenarios)
│   └── linkedlist_operations.feature (11 escenarios)
├── set/
│   ├── hashset_operations.feature (12 escenarios)
│   ├── treeset_operations.feature (11 escenarios)
│   └── linkedhashset_operations.feature (9 escenarios)
├── map/
│   ├── hashmap_operations.feature (14 escenarios)
│   ├── treemap_operations.feature (12 escenarios)
│   └── linkedhashmap_operations.feature (11 escenarios)
├── queue/
│   ├── priorityqueue_operations.feature (11 escenarios)
│   └── arraydeque_operations.feature (10 escenarios)
├── streams/
│   └── stream_operations.feature (22 escenarios)
├── generics/
│   └── advanced_generics.feature (39 escenarios)
├── algorithm/
│   ├── collections_utilities.feature (21 escenarios)
│   └── arrays_utilities.feature (22 escenarios)
└── antipatterns/
    └── common_antipatterns.feature (11 escenarios)
```

## Ejemplo de feature file

```gherkin
# language: es
Característica: Operaciones básicas de ArrayList
  Como desarrollador Java
  Quiero usar ArrayList para almacenar elementos
  Para poder manipular colecciones de datos

  Escenario: Agregar elemento a ArrayList vacío
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Entonces el tamaño del ArrayList es 1
    Y el ArrayList contiene "Java"

  Escenario: Agregar múltiples elementos
    Dado un ArrayList vacío
    Cuando agrego los elementos "Java", "Python", "Go"
    Entonces el tamaño del ArrayList es 3
    Y el elemento en índice 0 es "Java"
    Y el elemento en índice 1 es "Python"
    Y el elemento en índice 2 es "Go"
```

## Ejecutar tests

```bash
# Todos los tests
mvn test

# Por feature específico
mvn test -Dcucumber.features="src/test/resources/features/list/arraylist_operations.feature"

# Por tag
mvn test -Dcucumber.filter.tags="@arraylist"

# Por nombre de escenario
mvn test -Dcucumber.filter.name="Agregar elemento"
```

## Reportes

Después de ejecutar los tests, encuentra los reportes en:

```
target/
├── cucumber-report.html      # Reporte HTML de Cucumber
├── surefire-reports/         # Reportes XML de Surefire
└── site/jacoco/             # Cobertura de código
```

## Cobertura

Todos los escenarios deben cumplir:
- ✅ Compilación exitosa
- ✅ Checkstyle sin violaciones
- ✅ SpotBugs sin bugs
- ✅ Spotless formato correcto
- ✅ JaCoCo >60% cobertura

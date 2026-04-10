# Escenarios BDD

Listado completo de escenarios implementados.

## Resumen por milestone

| Milestone | Escenarios | Estado |
|-----------|------------|--------|
| M2: List | 27 | ✅ |
| M3: Set | 32 | ✅ |
| M4: Map | 37 | ✅ |
| M5: Queue | 21 | ✅ |
| M6: Algorithms | 28 | ✅ |
| M7: Streams | 22 | ✅ |
| M8: Advanced Features | 39 | ✅ |
| M11: Anti-Patterns | 11 | ✅ |
| **Total** | **217** | ✅ |

## Estructura de archivos

```
src/test/resources/features/
├── list/
│   ├── arraylist_operations.feature
│   └── linkedlist_operations.feature
├── set/
│   ├── hashset_operations.feature
│   ├── treeset_operations.feature
│   └── linkedhashset_operations.feature
├── map/
│   ├── hashmap_operations.feature
│   ├── treemap_operations.feature
│   └── linkedhashmap_operations.feature
├── queue/
│   ├── priorityqueue_operations.feature
│   └── arraydeque_operations.feature
├── streams/
│   └── stream_operations.feature
├── generics/
│   └── advanced_generics.feature
├── algorithm/
│   ├── collections_utilities.feature
│   └── arrays_utilities.feature
└── antipatterns/
    └── common_antipatterns.feature
```

## Ejecutar tests

```bash
# Todos los tests
mvn test

# Por feature
mvn test -Dcucumber.filter.tags="@arraylist"

# Por archivo
mvn test -Dcucumber.features="src/test/resources/features/list/arraylist_operations.feature"
```

## Próximamente

Documentación detallada de cada escenario.

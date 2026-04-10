# LinkedHashSet

`LinkedHashSet` combina **HashSet** con una **lista enlazada** para mantener orden de inserción.

## Características

- ✅ Mantiene orden de inserción
- ✅ Operaciones: **O(1)**
- ✅ No permite duplicados
- ❌ Mayor overhead que HashSet

## Cuándo usar

- Necesitas unicidad Y orden de inserción
- Implementación de LRU Cache (con removeEldestEntry)

## Comparación

| Set | Orden | Complejidad |
|-----|-------|-------------|
| HashSet | Ninguno | O(1) |
| TreeSet | Natural/Comparator | O(log n) |
| LinkedHashSet | Inserción | O(1) |

## Próximamente

Documentación completa con escenarios BDD.

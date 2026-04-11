# Colecciones en Java

El **Java Collections Framework** proporciona una arquitectura unificada para representar y manipular grupos de objetos. Este framework es esencial para cualquier desarrollador Java.

## Jerarquía de Interfaces

```
                    Iterable
                       │
                    Collection
                       │
        ┌──────────────┼──────────────┐
        │              │              │
       List           Set           Queue
        │              │              │
   ┌────┴────┐    ┌───┴───┐     ┌────┴────┐
   │         │    │       │     │         │
ArrayList LinkedList HashSet TreeSet PriorityQueue ArrayDeque
             │       │
             │   LinkedHashSet
             │
        CopyOnWriteArrayList
```

## Interfaces principales

### List
Colección ordenada que permite duplicados.

- **ArrayList**: Array dinámico, acceso por índice O(1)
- **LinkedList**: Lista doblemente enlazada, inserción/eliminación O(1)
- **CopyOnWriteArrayList**: Thread-safe para lecturas frecuentes

### Set
Colección sin duplicados.

- **HashSet**: Basado en hash table, operaciones O(1)
- **TreeSet**: Basado en Red-Black tree, ordenado, operaciones O(log n)
- **LinkedHashSet**: Mantiene orden de inserción

### Map
Colección de pares clave-valor.

- **HashMap**: Basado en hash table, operaciones O(1)
- **TreeMap**: Basado en Red-Black tree, ordenado por clave
- **LinkedHashMap**: Mantiene orden de inserción
- **ConcurrentHashMap**: Thread-safe para concurrencia alta

### Queue
Colección FIFO (First In, First Out).

- **PriorityQueue**: Ordenada por prioridad natural o Comparator
- **ArrayDeque**: Deque (double-ended queue) eficiente
- **LinkedList**: También implementa Queue

## Tabla comparativa rápida

| Colección | Ordenada | Duplicados | Thread-safe | Complejidad acceso |
|-----------|----------|------------|-------------|-------------------|
| ArrayList | Sí (índice) | Sí | No | O(1) |
| LinkedList | Sí (índice) | Sí | No | O(n) |
| HashSet | No | No | No | O(1) |
| TreeSet | Sí (natural) | No | No | O(log n) |
| HashMap | No | Claves únicas | No | O(1) |
| TreeMap | Sí (por clave) | Claves únicas | No | O(log n) |
| PriorityQueue | Sí (por prioridad) | Sí | No | O(1) peek |

## ¿Cuál usar?

### 📋 Necesitas orden e índices
- Usa **ArrayList** si accedes por índice frecuentemente
- Usa **LinkedList** si insertas/eliminas en medio frecuentemente

### 🎯 Necesitas unicidad
- Usa **HashSet** para búsquedas rápidas sin orden
- Usa **TreeSet** si necesitas elementos ordenados

### 🗺️ Necesitas pares clave-valor
- Usa **HashMap** para acceso rápido por clave
- Usa **TreeMap** si necesitas orden por clave

### 📥 Necesitas procesar en orden
- Usa **PriorityQueue** para procesar por prioridad
- Usa **ArrayDeque** como stack o queue eficiente

## Navegación

- 📚 [ArrayList](list/arraylist.md) - Array dinámico
- 📚 [LinkedList](list/linkedlist.md) - Lista enlazada
- 📚 [Cuándo usar List](list/cuando-usar.md) - Guía de decisión
- 📚 [HashSet](set/hashset.md) - Conjunto hash
- 📚 [TreeSet](set/treeset.md) - Conjunto ordenado
- 📚 [HashMap](map/hashmap.md) - Mapa hash
- 📚 [PriorityQueue](queue/priorityqueue.md) - Cola con prioridad

## Temas relacionados

- [Complejidad algorítmica](../rendimiento/complejidad.md)
- [Colecciones thread-safe](../avanzado/concurrencia.md)

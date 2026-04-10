# TreeMap

`TreeMap` implementa la interfaz `Map` usando un **Red-Black Tree**. Mantiene las claves ordenadas.

## Características

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Red-Black Tree (árbol auto-balanceado) |
| **Orden** | Claves ordenadas (natural o Comparator) |
| **Claves únicas** | No permite duplicados |
| **Operaciones** | get, put, remove: O(log n) |
| **Null** | **NO** permite clave `null` |

## Cuándo usar

- Necesitas claves ordenadas
- Búsquedas por rango (subMap, headMap, tailMap)
- Ordenación natural de claves

## Ejemplos

```java
// Orden natural
Map<String, Integer> notas = new TreeMap<>();
notas.put("Carlos", 85);
notas.put("Ana", 92);
notas.put("Beatriz", 78);
// Itera: Ana → Beatriz → Carlos

// Comparator personalizado (inverso)
Map<String, Integer> descendente = new TreeMap<>(
    Comparator.reverseOrder()
);

// Rango de búsqueda
SortedMap<String, Integer> aprobados = 
    notas.tailMap("C"); // Carlos en adelante
```

## Escenarios BDD

El proyecto incluye tests para:
- Ordenación de claves
- Búsquedas por rango
- Operaciones de navegación (firstKey, lastKey)

# Benchmarks

Mediciones de rendimiento para diferentes colecciones.

## Comparativas aproximadas

Basado en tests con 1,000,000 de operaciones:

### Inserción (add/put)

| Colección | Tiempo | Notas |
|-----------|--------|-------|
| ArrayList | ~50ms | Final de lista |
| LinkedList | ~80ms | Final de lista |
| HashSet | ~100ms | Sin duplicados |
| TreeSet | ~400ms | Con ordenamiento |
| HashMap | ~90ms | Sin colisiones |
| TreeMap | ~350ms | Con ordenamiento |

### Búsqueda (contains/get)

| Colección | Tiempo | Notas |
|-----------|--------|-------|
| ArrayList | ~500ms | Búsqueda lineal |
| LinkedList | ~600ms | Búsqueda lineal |
| HashSet | ~5ms | Tabla hash |
| TreeSet | ~30ms | Árbol binario |
| HashMap | ~4ms | Por clave |
| TreeMap | ~25ms | Por clave |

### Iteración completa

| Colección | Tiempo | Notas |
|-----------|--------|-------|
| ArrayList | ~10ms | Cache-friendly |
| LinkedList | ~50ms | Saltos de memoria |
| HashSet | ~20ms | Dependiente de capacidad |
| TreeSet | ~25ms | In-order traversal |

## Recomendaciones prácticas

### Para pocas operaciones (< 1000 elementos)

Cualquier colección es adecuada. Prioriza claridad del código.

```java
// Pocos elementos: usa lo que sea más legible
List<String> lista = new ArrayList<>(); // o LinkedList
```

### Para muchas operaciones (> 100000 elementos)

Elige según el patrón de uso:

```java
// Muchas búsquedas
Set<String> set = new HashSet<>();

// Muchas inserciones en extremos
Deque<String> deque = new ArrayDeque<>();

// Ordenación requerida
Set<String> sorted = new TreeSet<>();
```

## Factores que afectan el rendimiento

1. **Capacidad inicial**: Evita redimensionamientos frecuentes
   ```java
   // Mejor
   List<String> lista = new ArrayList<>(10000);
   
   // Peor (crece de 10, 15, 22, 33...)
   List<String> lista = new ArrayList<>();
   ```

2. **Load factor**: Default 0.75 es óptimo

3. **Hash quality**: Distribución uniforme reduce colisiones

4. **Cache locality**: ArrayList itera más rápido que LinkedList

## Conclusión

Las diferencias solo importan con grandes volúmenes de datos. Para la mayoría de aplicaciones, la claridad del código es más importante que la micro-optimización.

# TreeMap

`TreeMap` implementa la interfaz `Map` usando un **Red-Black Tree**.

## Características

- ✅ Claves ordenadas (natural o Comparator)
- ✅ Operaciones: **O(log n)**
- ❌ No permite null key
- ❌ Más lento que HashMap

## Cuándo usar

- Necesitas claves ordenadas
- Rangos de búsqueda (subMap, headMap, tailMap)
- Historial ordenado por timestamp

## Ejemplo

```java
Map<String, Integer> ordenado = new TreeMap<>();
ordenado.put("Charlie", 30);
ordenado.put("Alice", 25);
System.out.println(ordenado.keySet()); // [Alice, Charlie]
```

## Próximamente

Documentación completa con escenarios BDD.

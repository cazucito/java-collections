# TreeSet

`TreeSet` implementa la interfaz `Set` usando un **Red-Black Tree**.

## Características

- ✅ Elementos ordenados (natural o Comparator)
- ✅ Operaciones: **O(log n)**
- ✅ No permite duplicados
- ❌ Más lento que HashSet

## Cuándo usar

- Necesitas elementos ordenados
- Rangos de búsqueda (subSet, headSet, tailSet)
- Ordenamiento natural requerido

## Ejemplo

```java
Set<Integer> ordenados = new TreeSet<>();
ordenados.add(3);
ordenados.add(1);
ordenados.add(2);
System.out.println(ordenados); // [1, 2, 3]
```

## Próximamente

Documentación completa con escenarios BDD.

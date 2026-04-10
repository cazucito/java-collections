# HashSet

`HashSet` implementa la interfaz `Set` usando una **tabla hash**.

## Características

- ✅ Operaciones básicas: **O(1)**
- ✅ No permite duplicados
- ❌ No mantiene orden
- ❌ No es thread-safe

## Cuándo usar

- Verificar unicidad de elementos
- Operaciones de conjunto (unión, intersección, diferencia)
- Búsquedas rápidas sin necesidad de orden

## Ejemplo

```java
Set<String> unicos = new HashSet<>();
unicos.add("A");
unicos.add("B");
unicos.add("A"); // Ignorado, ya existe
System.out.println(unicos.size()); // 2
```

## Próximamente

Documentación completa con escenarios BDD.

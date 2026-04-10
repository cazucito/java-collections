# HashMap

`HashMap` implementa la interfaz `Map` usando una **tabla hash**.

## Características

- ✅ Operaciones básicas: **O(1)**
- ✅ Permite null key y null values
- ❌ No es thread-safe
- ❌ No mantiene orden

## Cuándo usar

- Cachés en memoria
- Índices de búsqueda
- Contadores de frecuencia

## Ejemplo

```java
Map<String, Integer> edades = new HashMap<>();
edades.put("Alice", 30);
edades.put("Bob", 25);
System.out.println(edades.get("Alice")); // 30
```

## Próximamente

Documentación completa con escenarios BDD.

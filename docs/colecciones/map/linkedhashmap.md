# LinkedHashMap

`LinkedHashMap` combina **HashMap** con una **lista enlazada** para mantener orden de inserción.

## Características

- ✅ Mantiene orden de inserción
- ✅ Operaciones: **O(1)**
- ✅ Permite null key y values
- ✅ Ideal para LRU Cache

## Cuándo usar

- Caché LRU (Least Recently Used)
- Configuración ordenada
- Prediccible iteración sobre entradas

## LRU Cache ejemplo

```java
Map<String, String> cache = new LinkedHashMap<>(16, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > 100; // Máximo 100 entradas
    }
};
```

## Próximamente

Documentación completa con escenarios BDD.

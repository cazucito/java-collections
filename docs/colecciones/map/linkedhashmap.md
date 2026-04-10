# LinkedHashMap

`LinkedHashMap` combina **HashMap** con una **lista enlazada** que mantiene el orden de inserción de las entradas.

## Características

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Hash table + Doubly linked list |
| **Orden** | Orden de inserción (o acceso con accessOrder=true) |
| **Claves únicas** | No permite duplicados |
| **Operaciones** | get, put: O(1) |
| **Null** | Permite clave `null` y valor `null` |

## Cuándo usar

- Necesitas orden de inserción
- Implementar LRU Cache
- Iteración predecible sobre entradas

## Ejemplo: LRU Cache

```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacidad;
    
    public LRUCache(int capacidad) {
        super(capacidad, 0.75f, true); // accessOrder = true
        this.capacidad = capacidad;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacidad;
    }
}

// Uso
LRUCache<String, String> cache = new LRUCache<>(3);
cache.put("A", "valorA");
cache.put("B", "valorB");
cache.put("C", "valorC");
cache.get("A"); // A se marca como reciente
cache.put("D", "valorD"); // B se elimina
```

## Escenarios BDD

Tests para:
- Orden de inserción
- Implementación de caché LRU
- Iteración predecible

# Memory Leaks

Evita fugas de memoria con colecciones.

## Cachés estáticos

```java
// ❌ MAL: Crece sin límite
static Map<String, Object> cache = new HashMap<>();

// ✅ BIEN: LRU cache con límite
static Map<String, Object> cache = new LinkedHashMap<>(100, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return size() > 100;
    }
};
```

## Listeners no removidos

```java
// ❌ MAL: Listener permanece después de usar
list.addListener(listener);

// ✅ BIEN: Remover cuando no se necesita
list.removeListener(listener);
```

## WeakHashMap

Para cachés que no previenen GC:

```java
Map<Key, Value> cache = new WeakHashMap<>();
```

## Próximamente

Documentación completa con escenarios BDD.

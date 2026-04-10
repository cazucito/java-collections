# Memory Leaks con Colecciones

Errores comunes que causan fugas de memoria y cómo evitarlos.

## 1. Cachés estáticos sin límite

### ❌ Problema

```java
public class Cache {
    // Crece indefinidamente
    private static final Map<String, Object> cache = new HashMap<>();
    
    public static void put(String key, Object value) {
        cache.put(key, value);
    }
}
```

### ✅ Solución

```java
public class Cache {
    // LRU cache con límite
    private static final int MAX_SIZE = 1000;
    private static final Map<String, Object> cache = 
        new LinkedHashMap<String, Object>(MAX_SIZE, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size() > MAX_SIZE;
            }
        };
}
```

## 2. Listeners no removidos

### ❌ Problema

```java
public class Component {
    public Component() {
        // Listener permanece para siempre
        EventBus.register(this);
    }
}
```

### ✅ Solución

```java
public class Component {
    public void init() {
        EventBus.register(this);
    }
    
    public void dispose() {
        EventBus.unregister(this);
    }
}
```

## 3. WeakHashMap para cachés

Cuando no quieres que el caché prevenga garbage collection:

```java
// El valor se elimina cuando la clave ya no es referenciada
Map<Key, Value> cache = new WeakHashMap<>();
```

## 4. SubList y vistas

### ❌ Problema

```java
List<String> sub = original.subList(0, 10);
original.clear(); // sub sigue referenciando a original
```

### ✅ Solución

```java
List<String> sub = new ArrayList<>(original.subList(0, 10));
original.clear(); // sub es independiente
```

## Escenarios BDD

```gherkin
Escenario: Caché con límite evita memory leak
  Dado un caché LRU con capacidad 3
  Cuando agrego 5 elementos diferentes
  Entonces solo quedan los 3 más recientes
```

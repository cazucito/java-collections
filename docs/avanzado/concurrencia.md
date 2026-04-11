# Concurrencia

Java proporciona colecciones thread-safe para entornos donde múltiples hilos acceden a datos compartidos.

## ¿Por qué colecciones thread-safe?

```java
// ❌ HashMap NO es thread-safe
Map<String, Integer> map = new HashMap<>();

// Problema: ConcurrentModificationException o datos corruptos
// cuando múltiples threads acceden simultáneamente
```

## Colecciones Concurrentes

### CopyOnWriteArrayList

Lista que copia todo el array en cada modificación. Ideal para lecturas frecuentes, escrituras raras.

```java
List<String> lista = new CopyOnWriteArrayList<>();

// Múltiples threads pueden leer simultáneamente sin bloqueo
// Escrituras crean una copia del array interno

lista.add("elemento"); // Crea copia del array
for (String s : lista) {
    // Itera sobre snapshot (no ConcurrentModificationException)
    System.out.println(s);
}
```

**Cuándo usar:**
- Lecturas frecuentes, escrituras raras
- Tamaño pequeño a mediano
- No necesitas consistencia inmediata en iteración

### ConcurrentHashMap

Map thread-safe con alta concurrencia. Divide el mapa en segmentos para reducir bloqueos.

```java
Map<String, Integer> map = new ConcurrentHashMap<>();

// Operaciones atómicas
map.put("clave", 1);
map.putIfAbsent("clave", 2); // No sobrescribe si existe
map.computeIfAbsent("clave2", k -> calcularValor(k));

// Iteración segura
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

**Operaciones atómicas:**

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

// compute: actualiza valor basado en key y valor actual
map.compute("contador", (k, v) -> v == null ? 1 : v + 1);

// merge: similar a compute pero con valor por defecto
map.merge("clave", 1, Integer::sum);

// computeIfAbsent: computa solo si no existe
map.computeIfAbsent("clave", k -> expensiveOperation());

// computeIfPresent: computa solo si existe
map.computeIfPresent("clave", (k, v) -> v * 2);
```

### CopyOnWriteArraySet

Set basado en CopyOnWriteArrayList. Misma semántica: lecturas rápidas, escrituras lentas.

```java
Set<String> set = new CopyOnWriteArraySet<>();

set.add("elemento");
// Iteración segura
for (String s : set) {
    System.out.println(s);
}
```

### ConcurrentLinkedQueue

Queue no bloqueante, basada en nodos enlazados. Alto rendimiento para operaciones concurrentes.

```java
Queue<String> queue = new ConcurrentLinkedQueue<>();

// Productor
queue.offer("tarea1");
queue.offer("tarea2");

// Consumidor
String tarea = queue.poll(); // No bloquea, retorna null si vacía
```

### BlockingQueue

Interfaz para colas bloqueantes (implementaciones: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue).

```java
BlockingQueue<String> queue = new LinkedBlockingQueue<>(100);

// Productor (bloquea si la cola está llena)
queue.put("elemento");

// Consumidor (bloquea si la cola está vacía)
String elemento = queue.take();

// Métodos no bloqueantes con timeout
boolean success = queue.offer("elemento", 5, TimeUnit.SECONDS);
String elem = queue.poll(5, TimeUnit.SECONDS);
```

## Synchronized Collections

Wrappers que agregan sincronización a colecciones no thread-safe.

```java
// Crear colecciones sincronizadas
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());

// ⚠️ Iteración requiere sincronización manual
synchronized (syncList) {
    for (String s : syncList) {
        System.out.println(s);
    }
}
```

## Comparativa

| Colección | Thread-safe | Estrategia | Rendimiento lectura | Rendimiento escritura |
|-----------|-------------|------------|---------------------|----------------------|
| HashMap | ❌ | - | Alta | Alta |
| ConcurrentHashMap | ✅ | Segment locking | Muy alta | Alta |
| Collections.synchronizedMap | ✅ | Lock global | Baja | Baja |
| ArrayList | ❌ | - | Alta | Alta |
| CopyOnWriteArrayList | ✅ | Copy-on-write | Muy alta | Baja |
| Vector | ✅ | Lock global | Baja | Baja |

## Implementación en el proyecto

```java
// Ejemplo de caché concurrente
public class ConcurrentCache<K, V> {
    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    
    public V get(K key) {
        return cache.computeIfAbsent(key, this::loadFromDatabase);
    }
    
    public void put(K key, V value) {
        cache.put(key, value);
    }
    
    private V loadFromDatabase(K key) {
        // Operación costosa
        return database.load(key);
    }
}
```

## Escenarios BDD

```gherkin
Escenario: ConcurrentHashMap permite acceso concurrente
  Dado un ConcurrentHashMap vacío
  Cuando múltiples threads agregan elementos
  Entonces todos los elementos se agregan sin excepciones

Escenario: CopyOnWriteArrayList permite lectura concurrente
  Dado una CopyOnWriteArrayList con elementos
  Cuando un thread itera y otro modifica
  Entonces la iteración no lanza excepción
```

## Best Practices

1. **Prefiere ConcurrentHashMap** sobre `Collections.synchronizedMap()`
2. **CopyOnWrite** solo cuando escrituras son raras
3. **Iteración**: Usar iteradores concurrentes o snapshot
4. **Atomicidad**: Usar métodos atómicos (`compute`, `merge`, `putIfAbsent`)
5. **Evita synchronized**: Las colecciones concurrentes modernas son más eficientes

## Conclusión

Para código concurrente, usa colecciones diseñadas para ello. `ConcurrentHashMap` y `CopyOnWriteArrayList` cubren la mayoría de casos con excelente rendimiento.

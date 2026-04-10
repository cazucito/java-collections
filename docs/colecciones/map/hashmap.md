# HashMap

`HashMap` implementa la interfaz `Map` usando una **tabla hash**. Almacena pares clave-valor con acceso rápido por clave.

## Características principales

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Array de buckets (listas enlazadas o árboles) |
| **Claves** | Únicas, basadas en `hashCode()` y `equals()` |
| **Valores** | Pueden ser duplicados |
| **Operaciones** | get, put, remove: O(1) promedio |
| **Null** | Permite una clave `null` y múltiples valores `null` |
| **Orden** | No garantiza orden |

## Cuándo usar HashMap

✅ **Ideal para:**
- Cachés en memoria (lookup rápido)
- Índices de búsqueda
- Contadores de frecuencia
- Almacenar configuraciones
- Sesiones de usuario

❌ **Evitar cuando:**
- Necesitas orden por clave (usa TreeMap)
- Necesitas orden de inserción (usa LinkedHashMap)
- Concurrencia (usa ConcurrentHashMap)

## Ejemplos de uso

### Caché simple

```java
Map<String, User> userCache = new HashMap<>();

// Almacenar
userCache.put("user123", new User("John", "john@email.com"));

// Recuperar
User user = userCache.get("user123");

// Verificar existencia
if (userCache.containsKey("user123")) {
    // Usuario en caché
}
```

### Contador de frecuencia

```java
String texto = "manzana pera manzana naranja pera manzana";
Map<String, Integer> frecuencias = new HashMap<>();

for (String palabra : texto.split(" ")) {
    frecuencias.merge(palabra, 1, Integer::sum);
    // Equivalente a:
    // frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
}

// Resultado: {manzana=3, pera=2, naranja=1}
```

### Agrupar elementos

```java
List<Person> personas = Arrays.asList(
    new Person("Ana", "Madrid"),
    new Person("Luis", "Barcelona"),
    new Person("María", "Madrid")
);

Map<String, List<Person>> porCiudad = new HashMap<>();
for (Person p : personas) {
    porCiudad.computeIfAbsent(p.getCiudad(), k -> new ArrayList<>()).add(p);
}

// Resultado:
// Madrid → [Ana, María]
// Barcelona → [Luis]
```

## Métodos útiles

### Java 8+ métodos funcionales

```java
Map<String, Integer> scores = new HashMap<>();

// putIfAbsent: solo si la clave no existe
scores.putIfAbsent("Player1", 0); // Agrega
scores.putIfAbsent("Player1", 100); // Ignora, ya existe

// compute: calcula nuevo valor basado en clave y valor actual
scores.compute("Player1", (k, v) -> v == null ? 1 : v + 10);

// computeIfAbsent: computa solo si no existe
scores.computeIfAbsent("Player2", k -> loadScoreFromDB(k));

// computeIfPresent: computa solo si existe
scores.computeIfPresent("Player1", (k, v) -> v + bonus);

// merge: combina valores
scores.merge("Player1", 50, Integer::sum); // Suma 50 al valor existente

// forEach: iterar con BiConsumer
scores.forEach((player, score) -> 
    System.out.println(player + ": " + score)
);

// getOrDefault: valor por defecto si no existe
int score = scores.getOrDefault("Unknown", 0);
```

## Iteración

```java
Map<String, Integer> map = new HashMap<>();

// 1. Iterar sobre entries (más eficiente)
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// 2. Java 8+ forEach
map.forEach((k, v) -> System.out.println(k + " = " + v));

// 3. Solo claves
for (String key : map.keySet()) {
    System.out.println(key);
}

// 4. Solo valores
for (Integer value : map.values()) {
    System.out.println(value);
}
```

## Implementación en el proyecto

```java
// HashMapExample.java demuestra:
public class HashMapExample {
    private final Map<String, String> map = new HashMap<>();
    
    public void put(String key, String value) {
        map.put(key, value);
    }
    
    public String get(String key) {
        return map.get(key);
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Almacenar y recuperar valor
  Dado un HashMap vacío
  Cuando agrego "clave" → "valor"
  Entonces obtener "clave" retorna "valor"

Escenario: Sobrescribir valor existente
  Dado un HashMap con "clave" → "valor1"
  Cuando agrego "clave" → "valor2"
  Entonces obtener "clave" retorna "valor2"

Escenario: Verificar existencia de clave
  Dado un HashMap con "existente" → "valor"
  Entonces containsKey("existente") es true
  Y containsKey("inexistente") es false
```

## Funcionamiento interno

```
Clave → hashCode() → bucket index

Bucket 0: null
Bucket 1: Entry("A", "valorA") → Entry("B", "valorB") [colisión]
Bucket 2: Entry("C", "valorC")
Bucket 3: null
```

- Java 7: Lista enlazada en colisiones
- Java 8+: Árbol binario si hay muchas colisiones (>8 elementos)

## Rendimiento

| Operación | Complejidad | Notas |
|-----------|-------------|-------|
| put() | O(1) | O(log n) en árbol si muchas colisiones |
| get() | O(1) | O(log n) en árbol si muchas colisiones |
| remove() | O(1) | O(log n) en árbol si muchas colisiones |
| containsKey() | O(1) | Igual que get() |
| containsValue() | O(n) | Debe recorrer todos los valores |
| Iteración | O(n) | n = capacidad + número de elementos |

## HashMap vs Hashtable vs ConcurrentHashMap

| Característica | HashMap | Hashtable | ConcurrentHashMap |
|----------------|---------|-----------|-------------------|
| Thread-safe | No | Sí | Sí |
| Performance | Alta | Baja | Alta |
| Null keys | Sí (una) | No | No |
| Null values | Sí | No | No |
| Iterator | Fail-fast | Fail-fast | Weakly consistent |

## Conclusión

HashMap es la implementación de Map más usada por su simplicidad y rendimiento. Úsala cuando:
- No necesitas orden
- No hay concurrencia
- Requieres acceso rápido O(1) por clave

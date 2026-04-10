# Complejidad Algorítmica

Tabla de complejidad Big O para operaciones comunes de colecciones.

## Tabla comparativa

| Colección | get | add/put | remove | contains | Iteración |
|-----------|-----|---------|--------|----------|-----------|
| **ArrayList** | O(1) | O(1)* | O(n) | O(n) | O(n) |
| **LinkedList** | O(n) | O(1) | O(1)** | O(n) | O(n) |
| **HashSet** | - | O(1) | O(1) | O(1) | O(n) |
| **TreeSet** | - | O(log n) | O(log n) | O(log n) | O(n) |
| **LinkedHashSet** | - | O(1) | O(1) | O(1) | O(n) |
| **HashMap** | O(1) | O(1) | O(1) | - | O(n) |
| **TreeMap** | O(log n) | O(log n) | O(log n) | - | O(n) |
| **LinkedHashMap** | O(1) | O(1) | O(1) | - | O(n) |
| **PriorityQueue** | O(1) peek | O(log n) | O(log n) | O(n) | O(n) |
| **ArrayDeque** | - | O(1) | O(1) | - | O(n) |

*Amortizado **En extremos

## Cuándo usar cada colección

### Por frecuencia de operación

**Acceso por índice frecuente:**
- ✅ ArrayList (O(1))
- ❌ LinkedList (O(n))

**Inserciones en medio frecuentes:**
- ✅ LinkedList (O(1) en extremos)
- ⚠️ ArrayList (O(n))

**Búsquedas frecuentes:**
- ✅ HashSet/HashMap (O(1))
- ⚠️ TreeSet/TreeMap (O(log n))
- ❌ List (O(n))

**Necesitas orden:**
- ✅ TreeSet/TreeMap (orden natural)
- ✅ LinkedHashSet/LinkedHashMap (orden inserción)
- ❌ HashSet/HashMap (sin orden)

## Ejemplos de decisiones

### Caso 1: Lista de tareas pendientes
```java
// Acceso frecuente por posición
List<Tarea> tareas = new ArrayList<>();
```

### Caso 2: Caché de usuarios
```java
// Lookup rápido por ID
Map<String, User> cache = new HashMap<>();
```

### Caso 3: Ranking de puntuaciones
```java
// Ordenado por puntuación
Set<Score> ranking = new TreeSet<>();
```

### Caso 4: Cola de procesamiento
```java
// FIFO para procesar tareas
Queue<Tarea> cola = new ArrayDeque<>();
```

## Notación Big O

| Notación | Significado | Ejemplo |
|----------|-------------|---------|
| O(1) | Tiempo constante | Acceso a ArrayList por índice |
| O(log n) | Logarítmico | Búsqueda en TreeSet |
| O(n) | Lineal | Búsqueda en ArrayList |
| O(n log n) | Lineal-logarítmico | Collections.sort() |
| O(n²) | Cuadrático | Burbuja sin optimización |

## Conclusión

Elegir la colección correcta puede mejorar el rendimiento de O(n) a O(1). Analiza tus operaciones más frecuentes antes de decidir.

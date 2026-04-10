# LinkedHashSet

`LinkedHashSet` combina **HashSet** con una **lista enlazada** que mantiene el orden de inserción de los elementos.

## Características principales

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Hash table + Doubly linked list |
| **Orden** | Orden de inserción |
| **Unicidad** | No permite duplicados |
| **Operaciones** | add, remove, contains: O(1) |
| **Iteración** | Orden predecible (inserción) |
| **Null** | Permite un elemento `null` |

## Cuándo usar LinkedHashSet

✅ **Ideal para:**
- Necesitas unicidad Y orden de inserción
- Implementar cachés LRU (Least Recently Used)
- Iteración predecible sobre elementos únicos
- Eliminar duplicados manteniendo orden original

❌ **Evitar cuando:**
- No necesitas orden (HashSet es más eficiente en memoria)
- Necesitas orden natural (usa TreeSet)
- Memoria es muy crítica (tiene overhead de lista enlazada)

## Ejemplos de uso

### Eliminar duplicados manteniendo orden

```java
List<String> original = Arrays.asList(
    "Java", "Python", "Java", "Go", "Python", "Rust"
);

// Con HashSet: orden no garantizado
Set<String> hashSet = new HashSet<>(original);
// Resultado: [Go, Java, Python, Rust] - orden aleatorio

// Con LinkedHashSet: orden de inserción
Set<String> linkedHashSet = new LinkedHashSet<>(original);
// Resultado: [Java, Python, Go, Rust] - orden original
```

### Iteración predecible

```java
LinkedHashSet<String> lenguajes = new LinkedHashSet<>();
lenguajes.add("Java");
lenguajes.add("Python");
lenguajes.add("Go");

// Siempre iterará en orden: Java → Python → Go
for (String lang : lenguajes) {
    System.out.println(lang);
}
```

### LRU Cache (Least Recently Used)

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
cache.put("A", "Valor A");
cache.put("B", "Valor B");
cache.put("C", "Valor C");
cache.get("A"); // A se vuelve más reciente
cache.put("D", "Valor D"); // B se elimina (menos usado)
```

## Funcionamiento interno

LinkedHashSet extiende HashSet y agrega:

```
Hash Table (buckets)
├── Bucket 0 → Node("Java")
├── Bucket 1 → Node("Python")
└── Bucket 2 → Node("Go")

Doubly Linked List (orden de inserción)
head → ["Java"] ↔ ["Python"] ↔ ["Go"] → tail
```

Cada nodo tiene:
- Referencias hash table (next en caso de colisión)
- Referencias lista enlazada (before, after)

## Implementación en el proyecto

```java
// LinkedHashSetExample.java demuestra:
public class LinkedHashSetExample {
    private final Set<String> elements = new LinkedHashSet<>();
    
    public boolean addElement(String element) {
        return elements.add(element);
    }
    
    public List<String> getElementsInOrder() {
        return new ArrayList<>(elements);
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Mantener orden de inserción
  Dado un LinkedHashSet vacío
  Cuando agrego "Primero", "Segundo", "Tercero"
  Entonces la iteración retorna en orden de inserción

Escenario: Eliminar duplicados con orden
  Dado una lista con duplicados en desorden
  Cuando convierto a LinkedHashSet
  Entonces no hay duplicados
  Y se mantiene el orden de primera aparición
```

## Comparativa de Sets

| Característica | HashSet | LinkedHashSet | TreeSet |
|----------------|---------|---------------|---------|
| Orden | Ninguno | Inserción | Natural/Comparator |
| add() | O(1) | O(1) | O(log n) |
| contains() | O(1) | O(1) | O(log n) |
| Iteración | O(n) | O(n) | O(n) |
| Memoria | Mínima | Media | Alta |
| Null | Sí | Sí | No |

## Rendimiento

LinkedHashSet tiene el mismo rendimiento que HashSet para operaciones básicas, con un pequeño overhead adicional para mantener la lista enlazada:

| Operación | Complejidad | Overhead vs HashSet |
|-----------|-------------|---------------------|
| add() | O(1) | Mantener referencias before/after |
| remove() | O(1) | Actualizar enlaces de lista |
| contains() | O(1) | Igual que HashSet |
| Iteración | O(n) | Más rápido (orden garantizado) |

## Conclusión

Usa **LinkedHashSet** cuando necesites:
- Unicidad de elementos
- Orden de inserción predecible
- Implementar cachés con política de orden
- Eliminar duplicados sin perder orden original

Es el "punto medio" entre HashSet (velocidad) y TreeSet (orden natural).

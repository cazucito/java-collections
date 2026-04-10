# TreeSet

`TreeSet` implementa la interfaz `Set` usando un **Red-Black Tree** (árbol binario de búsqueda auto-balanceado). Mantiene elementos ordenados.

## Características principales

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Red-Black Tree (árbol auto-balanceado) |
| **Orden** | Orden natural o Comparator personalizado |
| **Unicidad** | No permite duplicados |
| **Operaciones** | add, remove, contains: O(log n) |
| **Null** | **NO** permite elementos `null` |

## Cuándo usar TreeSet

✅ **Ideal para:**
- Necesitas elementos ordenados automáticamente
- Búsquedas por rango (subSet, headSet, tailSet)
- Encontrar elementos cercanos (floor, ceiling, lower, higher)
- Ordenación natural de elementos

❌ **Evitar cuando:**
- No necesitas orden (usa HashSet, es más rápido)
- Necesitas orden de inserción (usa LinkedHashSet)
- Requieres permitir `null`

## Ejemplos de uso

### Ordenación natural

```java
Set<Integer> numeros = new TreeSet<>();
numeros.add(5);
numeros.add(2);
numeros.add(8);
numeros.add(1);

System.out.println(numeros); // [1, 2, 5, 8]
```

### Con Comparator personalizado

```java
// Orden inverso
Set<Integer> descendente = new TreeSet<>(Comparator.reverseOrder());
descendente.addAll(Arrays.asList(5, 2, 8, 1));
System.out.println(descendente); // [8, 5, 2, 1]

// Por longitud de String
Set<String> porLongitud = new TreeSet<>(
    Comparator.comparingInt(String::length)
        .thenComparing(Comparator.naturalOrder())
);
```

### Búsquedas por rango

```java
TreeSet<Integer> scores = new TreeSet<>();
scores.addAll(Arrays.asList(45, 82, 95, 67, 78, 91, 55));

// Elementos menores a 70
Set<Integer> reprobados = scores.headSet(70); // [45, 55, 67]

// Elementos mayores o iguales a 90
Set<Integer> excelentes = scores.tailSet(90); // [91, 95]

// Rango entre 70 (inclusive) y 90 (exclusive)
Set<Integer> aprobados = scores.subSet(70, 90); // [78, 82]
```

### Búsqueda de elementos cercanos

```java
TreeSet<Integer> valores = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

// floor: menor o igual
Integer floor = valores.floor(25);      // 20

// ceiling: mayor o igual
Integer ceiling = valores.ceiling(25);  // 30

// lower: estrictamente menor
Integer lower = valores.lower(30);      // 20

// higher: estrictamente mayor
Integer higher = valores.higher(30);    // 40

// Primer y último elemento
Integer primero = valores.first();      // 10
Integer ultimo = valores.last();        // 50
```

## Implementación en el proyecto

```java
// TreeSetExample.java demuestra:
public class TreeSetExample {
    private final NavigableSet<String> elements = new TreeSet<>();
    
    public boolean addElement(String element) {
        return elements.add(element);
    }
    
    public SortedSet<String> getElements() {
        return elements;
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Ordenación natural de strings
  Dado un TreeSet vacío
  Cuando agrego "Banana", "Apple", "Cherry"
  Entonces el orden es "Apple", "Banana", "Cherry"

Escenario: Obtener subconjunto por rango
  Dado un TreeSet con números 1 al 10
  Cuando obtengo elementos entre 3 y 7
  Entonces el resultado es 3, 4, 5, 6

Escenario: Encontrar elemento cercano
  Dado un TreeSet con valores 10, 20, 30, 40
  Cuando busco el ceiling de 25
  Entonces el resultado es 30
```

## Red-Black Tree

TreeSet usa internamente un **Red-Black Tree**, un árbol binario de búsqueda auto-balanceado que garantiza:

- Altura O(log n)
- Inserción, eliminación y búsqueda en O(log n)
- Balance automático mediante rotaciones y recoloreo

```
        30(B)           <- Raíz (negra)
       /    \
    20(R)   40(R)      <- Hijos rojos
    /   \       \
 10(B) 25(B)   50(B)   <- Nietos negros
```

## Rendimiento

| Operación | Complejidad | Notas |
|-----------|-------------|-------|
| add() | O(log n) | Incluye re-balanceo |
| remove() | O(log n) | Incluye re-balanceo |
| contains() | O(log n) | Búsqueda binaria en árbol |
| first()/last() | O(log n) | Extremos del árbol |
| Iteración | O(n) | In-order traversal |

## TreeSet vs HashSet vs LinkedHashSet

| Característica | HashSet | TreeSet | LinkedHashSet |
|----------------|---------|---------|---------------|
| Orden | Ninguno | Natural/Comparator | Inserción |
| add() | O(1) | O(log n) | O(1) |
| contains() | O(1) | O(log n) | O(1) |
| Null | Permitido | No permitido | Permitido |
| Estructura | Hash table | Red-Black Tree | Hash + Linked List |

## Conclusión

Usa **TreeSet** cuando:
- Necesitas elementos ordenados
- Realizas búsquedas por rango
- Requieres encontrar elementos cercanos
- El orden es más importante que la velocidad

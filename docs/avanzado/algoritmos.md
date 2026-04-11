# Algoritmos con Collections

La clase `Collections` proporciona métodos estáticos de utilidad para operaciones comunes en colecciones.

## Ordenamiento

### sort()

Ordena una lista usando el orden natural o un Comparator.

```java
List<String> nombres = Arrays.asList("Pedro", "Ana", "Luis", "Carmen");

// Orden natural (alfabético)
Collections.sort(nombres);
// Resultado: [Ana, Carmen, Luis, Pedro]

// Orden inverso
Collections.sort(nombres, Collections.reverseOrder());
// Resultado: [Pedro, Luis, Carmen, Ana]

// Con Comparator personalizado (por longitud)
Collections.sort(nombres, Comparator.comparingInt(String::length));
// Resultado: [Ana, Luis, Pedro, Carmen]
```

### reverse()

Invierte el orden de los elementos.

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
Collections.reverse(numeros);
// Resultado: [5, 4, 3, 2, 1]
```

### shuffle()

Ordena aleatoriamente los elementos.

```java
List<String> cartas = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

// Barajar
Collections.shuffle(cartas);
// Resultado aleatorio: [3, K, 7, A, ...]

// Con semilla para reproducibilidad
Collections.shuffle(cartas, new Random(12345));
```

### rotate()

Rota los elementos de la lista.

```java
List<String> lista = Arrays.asList("A", "B", "C", "D", "E");

// Rotar 2 posiciones a la derecha
Collections.rotate(lista, 2);
// Resultado: [D, E, A, B, C]

// Rotar -1 (1 posición a la izquierda)
Collections.rotate(lista, -1);
// Resultado: [B, C, D, E, A]
```

### swap()

Intercambia dos elementos.

```java
List<String> lista = Arrays.asList("A", "B", "C");
Collections.swap(lista, 0, 2);
// Resultado: [C, B, A]
```

## Búsqueda

### binarySearch()

Búsqueda binaria O(log n). **Requiere lista ordenada**.

```java
List<Integer> numeros = Arrays.asList(1, 3, 5, 7, 9, 11, 13);
Collections.sort(numeros); // Asegurar orden

// Búsqueda exitosa
int index = Collections.binarySearch(numeros, 7);
// Resultado: 3 (índice donde se encuentra)

// Búsqueda fallida
int index = Collections.binarySearch(numeros, 6);
// Resultado: -(punto de inserción) - 1
// Ejemplo: -4 significa que debería ir en índice 3

// Insertar manteniendo orden
int pos = Collections.binarySearch(numeros, 6);
if (pos < 0) {
    numeros.add(-pos - 1, 6);
}
```

### max() / min()

Encuentra elementos extremos.

```java
List<Integer> numeros = Arrays.asList(45, 12, 78, 23, 67);

// Orden natural
Integer max = Collections.max(numeros); // 78
Integer min = Collections.min(numeros); // 12

// Con Comparator
String maxLen = Collections.max(nombres, Comparator.comparingInt(String::length));
```

### frequency()

Cuenta ocurrencias de un elemento.

```java
List<String> frutas = Arrays.asList("manzana", "pera", "manzana", "naranja", "manzana");

int count = Collections.frequency(frutas, "manzana");
// Resultado: 3
```

### indexOfSubList() / lastIndexOfSubList()

Busca una sublista dentro de otra.

```java
List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 3, 4);
List<Integer> sublista = Arrays.asList(3, 4);

int index = Collections.indexOfSubList(lista, sublista);
// Resultado: 2 (primera ocurrencia)

int lastIndex = Collections.lastIndexOfSubList(lista, sublista);
// Resultado: 5 (última ocurrencia)
```

## Modificación

### fill()

Llena la lista con un valor.

```java
List<String> lista = new ArrayList<>(Collections.nCopies(5, ""));
Collections.fill(lista, "X");
// Resultado: [X, X, X, X, X]
```

### copy()

Copia elementos de una lista a otra.

```java
List<String> fuente = Arrays.asList("A", "B", "C");
List<String> destino = new ArrayList<>(Collections.nCopies(3, ""));

Collections.copy(destino, fuente);
// Resultado destino: [A, B, C]
```

⚠️ **La lista destino debe tener al menos el tamaño de la fuente**.

### replaceAll()

Reemplaza todas las ocurrencias.

```java
List<String> lista = Arrays.asList("a", "b", "a", "c", "a");
Collections.replaceAll(lista, "a", "X");
// Resultado: [X, b, X, c, X]
```

### nCopies()

Crea una lista inmutable con n copias de un elemento.

```java
List<String> lista = Collections.nCopies(5, "X");
// Resultado: [X, X, X, X, X]

// Útil para inicializar listas
List<Integer> ceros = new ArrayList<>(Collections.nCopies(10, 0));
```

## Colecciones Inmutables

Crear colecciones que no pueden modificarse.

```java
// Lista inmutable
List<String> listaInmutable = Collections.unmodifiableList(
    Arrays.asList("A", "B", "C")
);
// listaInmutable.add("D"); // Lanza UnsupportedOperationException

// Map inmutable
Map<String, Integer> mapInmutable = Collections.unmodifiableMap(
    new HashMap<>()
);

// Set inmutable
Set<String> setInmutable = Collections.unmodifiableSet(
    new HashSet<>()
);
```

## Colecciones Singleton

Crear colecciones con un único elemento.

```java
// Lista singleton
List<String> lista = Collections.singletonList("único");

// Set singleton
Set<String> set = Collections.singleton("único");

// Map singleton
Map<String, Integer> map = Collections.singletonMap("clave", 100);
```

⚠️ **Son inmutables**.

## Colecciones Vacías

Crear colecciones vacías de tipo específico.

```java
List<String> listaVacia = Collections.emptyList();
Set<String> setVacio = Collections.emptySet();
Map<String, Integer> mapVacio = Collections.emptyMap();

// Útil para retornar en lugar de null
public List<String> getElements() {
    if (noHayElementos) {
        return Collections.emptyList(); // Mejor que null
    }
    return elementos;
}
```

## Synchronized Collections

Wrappers thread-safe (ver sección de Concurrencia).

```java
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
```

## Implementación en el proyecto

```java
// CollectionsUtilitiesExample.java
public class CollectionsUtilitiesExample {
    
    public static <T extends Comparable<T>> T findMedian(List<T> sortedList) {
        if (sortedList.isEmpty()) return null;
        
        int middle = sortedList.size() / 2;
        if (sortedList.size() % 2 == 0) {
            // Promedio de dos elementos del medio
            return sortedList.get(middle - 1);
        }
        return sortedList.get(middle);
    }
    
    public static <T> List<T> getRandomSample(List<T> list, int n) {
        List<T> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy.subList(0, Math.min(n, copy.size()));
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Ordenar lista con Collections.sort
  Dado una lista desordenada
  Cuando aplico Collections.sort
  Entonces la lista queda ordenada

Escenario: Buscar elemento con binarySearch
  Dado una lista ordenada
  Cuando busco un elemento existente
  Entonces obtengo su índice

Escenario: Contar frecuencia
  Dado una lista con elementos repetidos
  Cuando uso Collections.frequency
  Entonces obtengo el conteo correcto
```

## Resumen de métodos

| Categoría | Métodos |
|-----------|---------|
| **Ordenamiento** | sort, reverse, shuffle, rotate, swap |
| **Búsqueda** | binarySearch, max, min, frequency |
| **Modificación** | fill, copy, replaceAll |
| **Factory** | nCopies, singletonList, singletonMap, emptyList |
| **Wrappers** | unmodifiableList, synchronizedList |

## Conclusión

La clase `Collections` proporciona herramientas esenciales para manipular colecciones. Conocer estos métodos ahorra código y mejora la legibilidad.

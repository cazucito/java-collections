# Streams API

La **Streams API** (introducida en Java 8) permite procesar colecciones de forma declarativa y funcional.

## ¿Qué es un Stream?

Un Stream es una secuencia de elementos que soporta operaciones funcionales para procesarlos.

```java
List<String> nombres = Arrays.asList("Ana", "Luis", "María", "Pedro", "Carmen");

// Stream pipeline
List<String> resultado = nombres.stream()
    .filter(n -> n.length() > 3)      // Operación intermedia
    .map(String::toUpperCase)          // Operación intermedia
    .sorted()                          // Operación intermedia
    .collect(Collectors.toList());     // Operación terminal

// Resultado: [CARMEN, LUIS, MARÍA, PEDRO]
```

## Operaciones Intermedias

Transforman el stream y retornan otro stream (lazy evaluation).

### filter()

Filtra elementos según un predicado.

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// Resultado: [2, 4, 6]
```

### map()

Transforma cada elemento.

```java
List<String> nombres = Arrays.asList("ana", "luis");

List<Integer> longitudes = nombres.stream()
    .map(String::length)
    .collect(Collectors.toList());
// Resultado: [3, 4]
```

### flatMap()

Aplana estructuras anidadas.

```java
List<List<Integer>> listas = Arrays.asList(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4),
    Arrays.asList(5, 6)
);

List<Integer> aplanada = listas.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
// Resultado: [1, 2, 3, 4, 5, 6]
```

### distinct()

Elimina duplicados.

```java
List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 3, 3);

List<Integer> unicos = numeros.stream()
    .distinct()
    .collect(Collectors.toList());
// Resultado: [1, 2, 3]
```

### sorted()

Ordena elementos.

```java
List<String> nombres = Arrays.asList("Pedro", "Ana", "Luis");

List<String> ordenados = nombres.stream()
    .sorted()
    .collect(Collectors.toList());
// Resultado: [Ana, Luis, Pedro]

// Con comparator
List<String> ordenadosLongitud = nombres.stream()
    .sorted(Comparator.comparingInt(String::length))
    .collect(Collectors.toList());
// Resultado: [Ana, Luis, Pedro]
```

### limit() y skip()

Paginación de streams.

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Primeros 3
List<Integer> primeros = numeros.stream()
    .limit(3)
    .collect(Collectors.toList());
// Resultado: [1, 2, 3]

// Saltar 5, tomar siguiente
List<Integer> pagina = numeros.stream()
    .skip(5)
    .limit(3)
    .collect(Collectors.toList());
// Resultado: [6, 7, 8]
```

## Operaciones Terminales

Producen un resultado o efecto secundario.

### collect()

Recolecta en una colección.

```java
List<String> nombres = Arrays.asList("Ana", "Luis", "María");

// A List
List<String> lista = nombres.stream()
    .collect(Collectors.toList());

// A Set
Set<String> set = nombres.stream()
    .collect(Collectors.toSet());

// A Map
Map<String, Integer> map = nombres.stream()
    .collect(Collectors.toMap(
        n -> n,
        String::length
    ));
// Resultado: {Ana=3, Luis=4, María=5}

// Joining
String concatenado = nombres.stream()
    .collect(Collectors.joining(", "));
// Resultado: "Ana, Luis, María"

// Grouping
Map<Integer, List<String>> porLongitud = nombres.stream()
    .collect(Collectors.groupingBy(String::length));
// Resultado: {3=[Ana], 4=[Luis], 5=[María]}

// Partitioning
Map<Boolean, List<String>> particion = nombres.stream()
    .collect(Collectors.partitioningBy(n -> n.length() > 3));
// Resultado: {false=[Ana], true=[Luis, María]}
```

### reduce()

Reduce a un único valor.

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Suma
int suma = numeros.stream()
    .reduce(0, Integer::sum);
// Resultado: 15

// Producto
int producto = numeros.stream()
    .reduce(1, (a, b) -> a * b);
// Resultado: 120

// Concatenación
String concatenado = Stream.of("a", "b", "c")
    .reduce("", String::concat);
// Resultado: "abc"

// Máximo (Optional)
Optional<Integer> max = numeros.stream()
    .reduce(Integer::max);
```

### forEach()

Itera sobre elementos.

```java
List<String> nombres = Arrays.asList("Ana", "Luis");

nombres.stream()
    .forEach(System.out::println);
// Ana
// Luis
```

### match (allMatch, anyMatch, noneMatch)

Verifica condiciones.

```java
List<Integer> numeros = Arrays.asList(2, 4, 6, 8);

// ¿Todos son pares?
boolean todosPares = numeros.stream()
    .allMatch(n -> n % 2 == 0);
// true

// ¿Alguno es mayor que 5?
boolean algunoMayor5 = numeros.stream()
    .anyMatch(n -> n > 5);
// true

// ¿Ninguno es negativo?
boolean ningunoNegativo = numeros.stream()
    .noneMatch(n -> n < 0);
// true
```

### find (findFirst, findAny)

Busca elementos.

```java
List<String> nombres = Arrays.asList("Ana", "Luis", "María");

// Primer elemento
Optional<String> primero = nombres.stream()
    .findFirst();
// Optional[Ana]

// Cualquier elemento (eficiente en parallel streams)
Optional<String> cualquiera = nombres.stream()
    .findAny();
```

## Streams Paralelos

Procesamiento concurrente para grandes volúmenes.

```java
List<Integer> numeros = new ArrayList<>();
// ... llenar con millones de elementos

// Stream paralelo
int suma = numeros.parallelStream()
    .mapToInt(Integer::intValue)
    .sum();
```

⚠️ **Cuidado**: Solo usar cuando:
- Gran cantidad de datos (>10,000 elementos)
- Operaciones sin estado
- Sin dependencias entre elementos

## Implementación en el proyecto

```java
// StreamExample.java demuestra:
public class StreamExample {
    private final List<String> elements = new ArrayList<>();
    
    public List<String> filterByLength(int minLength) {
        return elements.stream()
            .filter(s -> s.length() >= minLength)
            .collect(Collectors.toList());
    }
    
    public Map<Integer, List<String>> groupByLength() {
        return elements.stream()
            .collect(Collectors.groupingBy(String::length));
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Filtrar elementos con Stream
  Dado una lista con "Java", "Python", "Go", "JavaScript"
  Cuando filtro elementos con longitud mayor a 3
  Entonces el resultado es "Java", "Python", "JavaScript"

Escenario: Agrupar por longitud
  Dado una lista con "a", "bb", "ccc", "dd", "eee"
  Cuando agrupo por longitud
  Entonces el grupo de longitud 1 es "a"
  Y el grupo de longitud 2 es "bb, dd"
  Y el grupo de longitud 3 es "ccc, eee"

Escenario: Reducir a suma
  Dado una lista con números 1, 2, 3, 4, 5
  Cuando calculo la suma con reduce
  Entonces el resultado es 15
```

## Best Practices

1. **No reutilizar streams**: Un stream se consume una sola vez
2. **Evitar efectos secundarios**: No modificar variables externas en forEach
3. **Preferir métodos de referencia**: `String::toUpperCase` vs `s -> s.toUpperCase()`
4. **Parallel con cuidado**: Solo para grandes datasets
5. **Optional**: Siempre manejar correctamente los Optional

## Conclusión

Streams API transforma la forma de procesar colecciones en Java, haciendo el código más legible, declarativo y funcional.

# Generics Avanzados

Los generics permiten crear clases, interfaces y métodos parametrizados por tipos, proporcionando type safety en tiempo de compilación.

## ¿Por qué usar Generics?

```java
// Sin generics: código inseguro
List lista = new ArrayList();
lista.add("texto");
String s = (String) lista.get(0); // Cast necesario, puede fallar en runtime

// Con generics: type safety
List<String> lista = new ArrayList<>();
lista.add("texto");
String s = lista.get(0); // No necesita cast, seguro en compilación
```

## Wildcards (Comodines)

### Unbounded Wildcard (`?`)

Cuando el tipo específico no importa, solo operaciones que funcionan para cualquier tipo.

```java
// Imprime cualquier lista
public static void printList(List<?> list) {
    for (Object elem : list) {
        System.out.println(elem);
    }
}

// Uso
printList(Arrays.asList(1, 2, 3));      // List<Integer>
printList(Arrays.asList("a", "b"));     // List<String>
```

⚠️ **No puedes**: Agregar elementos (excepto `null`), porque no sabes el tipo exacto.

### Upper Bounded Wildcard (`? extends T`)

Acepta `T` o cualquier subclase de `T`. **Producer** (produce elementos para leer).

```java
// Lee números de cualquier lista numérica
public static double sum(List<? extends Number> numbers) {
    double total = 0;
    for (Number n : numbers) {
        total += n.doubleValue();
    }
    return total;
}

// Uso
sum(Arrays.asList(1, 2, 3));                    // List<Integer>
sum(Arrays.asList(1.5, 2.5, 3.5));             // List<Double>
```

### Lower Bounded Wildcard (`? super T`)

Acepta `T` o cualquier superclase de `T`. **Consumer** (consume elementos para agregar).

```java
// Agrega enteros a cualquier lista que acepte Integer o sus superclases
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
    list.add(3);
}

// Uso
List<Number> numbers = new ArrayList<>();
addNumbers(numbers); // OK: Number es super de Integer

List<Object> objects = new ArrayList<>();
addNumbers(objects); // OK: Object es super de Integer
```

## Principio PECS

**P**roducer **E**xtends, **C**onsumer **S**uper

```java
// Producer: solo lee elementos (extends)
public static <T> void copyFrom(List<T> dest, List<? extends T> src) {
    for (T item : src) {  // Produce elementos
        dest.add(item);
    }
}

// Consumer: solo agrega elementos (super)
public static <T> void copyTo(List<? super T> dest, List<T> src) {
    for (T item : src) {
        dest.add(item);   // Consume elementos
    }
}

// Uso
List<Integer> integers = Arrays.asList(1, 2, 3);
List<Number> numbers = new ArrayList<>();
List<Object> objects = new ArrayList<>();

// Producer: integers produce elementos
copyTo(numbers, integers);   // OK: Number super de Integer
copyTo(objects, integers);   // OK: Object super de Integer

// Consumer: numbers consume elementos
copyFrom(numbers, integers); // OK: Integer extends Number
```

## Type Parameters con Bounds

### Single Bound

```java
// Solo tipos que extienden Number
public class Calculator<T extends Number> {
    private T value;
    
    public double getDoubleValue() {
        return value.doubleValue();
    }
}

// Uso válido
Calculator<Integer> calc1 = new Calculator<>();
Calculator<Double> calc2 = new Calculator<>();

// Uso inválido
// Calculator<String> calc3 = new Calculator<>(); // Error: String no extiende Number
```

### Multiple Bounds

```java
// T debe extender Number Y implementar Comparable
public static <T extends Number & Comparable<T>> T findMax(List<T> list) {
    T max = list.get(0);
    for (T item : list) {
        if (item.compareTo(max) > 0) {
            max = item;
        }
    }
    return max;
}

// Uso
Integer max = findMax(Arrays.asList(1, 5, 3, 9, 2)); // 9
```

## Type Erasure

Los generics solo existen en tiempo de compilación. En runtime, todo se convierte a `Object` o al primer bound.

```java
// Código fuente
List<String> strings = new ArrayList<>();
List<Integer> integers = new ArrayList<>();

// Después de compilación (erasure)
List strings = new ArrayList();
List integers = new ArrayList();

// Verificación
System.out.println(strings.getClass() == integers.getClass()); // true
```

### Consecuencias de Type Erasure

```java
// No puedes crear arrays de tipos genéricos
// List<String>[] array = new List<String>[10]; // Error de compilación

// No puedes usar instanceof con tipos específicos
// if (obj instanceof List<String>) // Error de compilación

// No puedes hacer cast seguro sin unchecked warning
List<?> wildcard = new ArrayList<String>();
// List<String> list = (List<String>) wildcard; // Warning: unchecked cast
```

## Generic Methods

Métodos genéricos independientes de la clase.

```java
public class Utils {
    // Método genérico estático
    public static <T> T getFirst(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }
    
    // Método genérico con bounds
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
    
    // Varargs con generics (cuidado)
    @SafeVarargs
    public static <T> List<T> asList(T... elements) {
        return Arrays.asList(elements);
    }
}

// Uso
String first = Utils.getFirst(Arrays.asList("a", "b", "c"));
String maxStr = Utils.max("apple", "banana");
```

## Implementación en el proyecto

```java
// AdvancedGenericsExample.java
public class AdvancedGenericsExample {
    
    // PECS principle
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (T item : src) {
            dest.add(item);
        }
    }
    
    // Bounded type parameter
    public static <T extends Number> double sum(List<T> numbers) {
        return numbers.stream()
            .mapToDouble(Number::doubleValue)
            .sum();
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Usar wildcard extends para lectura
  Dado una lista de números enteros
  Cuando calculo la suma usando wildcard extends
  Entonces obtengo la suma correcta

Escenario: Usar wildcard super para escritura
  Dado una lista de Objects
  Cuando agrego enteros usando wildcard super
  Entonces los enteros se agregan correctamente

Escenario: Bounded type parameter
  Dado una lista de números comparables
  Cuando busco el máximo
  Entonces encuentro el número mayor
```

## Resumen de Wildcards

| Wildcard | Lee (Producer) | Escribe (Consumer) | Uso típico |
|----------|----------------|-------------------|------------|
| `?` | Sí (Object) | No (solo null) | Operaciones genéricas |
| `? extends T` | Sí (T) | No | Producir elementos |
| `? super T` | Sí (Object) | Sí (T) | Consumir elementos |
| `T` | Sí (T) | Sí (T) | Ambas operaciones |

## Conclusión

Los generics avanzados (wildcards y bounds) permiten escribir código flexible y type-safe. Recuerda **PECS**: Producer Extends, Consumer Super.

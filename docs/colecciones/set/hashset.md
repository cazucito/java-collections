# HashSet

`HashSet` implementa la interfaz `Set` usando una **tabla hash**. No permite elementos duplicados y no garantiza orden.

## Características principales

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Tabla hash (array de buckets con listas enlazadas) |
| **Unicidad** | No permite duplicados (basado en `hashCode()` y `equals()`) |
| **Orden** | No garantiza orden de inserción ni orden natural |
| **Operaciones** | add, remove, contains: O(1) promedio |
| **Null** | Permite un elemento `null` |

## Cuándo usar HashSet

✅ **Ideal para:**
- Verificar unicidad de elementos
- Operaciones de conjunto (unión, intersección, diferencia)
- Búsquedas rápidas sin necesidad de orden
- Filtrar duplicados de una lista

❌ **Evitar cuando:**
- Necesitas elementos ordenados (usa TreeSet)
- Necesitas mantener orden de inserción (usa LinkedHashSet)
- Requieres orden predecible al iterar

## Ejemplos de uso

### Eliminar duplicados

```java
List<String> conDuplicados = Arrays.asList("A", "B", "A", "C", "B");
Set<String> unicos = new HashSet<>(conDuplicados);
// Resultado: ["A", "B", "C"] (orden no garantizado)
```

### Verificar unicidad

```java
Set<String> registrados = new HashSet<>();

public boolean registrarUsuario(String email) {
    return registrados.add(email);
    // Retorna false si el email ya existe
}
```

### Operaciones de conjunto

```java
Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
Set<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));

// Unión
Set<Integer> union = new HashSet<>(setA);
union.addAll(setB); // [1, 2, 3, 4, 5, 6]

// Intersección
Set<Integer> interseccion = new HashSet<>(setA);
interseccion.retainAll(setB); // [3, 4]

// Diferencia
Set<Integer> diferencia = new HashSet<>(setA);
diferencia.removeAll(setB); // [1, 2]
```

## Funcionamiento interno

```
Elemento → hashCode() → Índice bucket → equals() → Almacenar
```

1. Calcula `hashCode()` del elemento
2. Determina el bucket usando `hashCode % capacidad`
3. Si hay colisión, usa `equals()` para verificar duplicados
4. Almacena en la lista enlazada del bucket

## Implementación en el proyecto

```java
// HashSetExample.java demuestra:
public class HashSetExample {
    private final Set<String> elements = new HashSet<>();
    
    public boolean addElement(String element) {
        return elements.add(element);
    }
    
    public boolean contains(String element) {
        return elements.contains(element);
    }
}
```

## Escenarios BDD

```gherkin
Escenario: Agregar elemento único
  Dado un HashSet vacío
  Cuando agrego "Java"
  Entonces el tamaño es 1
  Y contiene "Java"

Escenario: Intentar agregar duplicado
  Dado un HashSet con "Java"
  Cuando intento agregar "Java" nuevamente
  Entonces el tamaño sigue siendo 1
  Y la operación retorna false

Escenario: Eliminar duplicados de lista
  Dado una lista con elementos duplicados
  Cuando convierto a HashSet
  Entonces no hay duplicados
```

## Rendimiento

| Operación | Complejidad | Notas |
|-----------|-------------|-------|
| add() | O(1) | O(n) si requiere rehashing |
| remove() | O(1) | O(n) en peor caso (colisiones) |
| contains() | O(1) | O(n) en peor caso |
| Iteración | O(n) | n = número de elementos |

## Recomendaciones

1. **hashCode() y equals()**: Asegúrate que tus objetos implementen ambos métodos correctamente
2. **Capacidad inicial**: Si conoces el tamaño, usa `new HashSet<>(capacidad)`
3. **Load factor**: Default 0.75 es óptimo para la mayoría de casos

## Conclusión

HashSet es la implementación de Set más rápida para operaciones básicas. Úsala cuando no necesites orden y requieras búsquedas O(1).

# ArrayList

`ArrayList` es la implementación más común de la interfaz `List`. Usa un **array dinámico** interno que crece automáticamente según sea necesario.

## Características principales

- ✅ Acceso por índice en **O(1)**
- ✅ Permite elementos duplicados
- ✅ Mantiene orden de inserción
- ❌ Inserción/eliminación en medio es **O(n)**
- ❌ No es thread-safe

## Cuándo usar ArrayList

### ✅ Ideal para
- Acceso frecuente por índice
- Recorrido secuencial
- Listas de tamaño conocido o poco cambiante

### ❌ Evitar cuando
- Inserciones/eliminaciones frecuentes en medio
- Necesitas thread-safety
- Memoria es crítica (tiene capacidad reservada)

## Ejemplo básico

```java
// Crear ArrayList
ArrayList<String> lista = new ArrayList<>();

// Agregar elementos
lista.add("Java");
lista.add("Python");
lista.add("Go");

// Acceder por índice (O(1))
String primero = lista.get(0);  // "Java"

// Iterar
for (String lenguaje : lista) {
    System.out.println(lenguaje);
}

// Tamaño
int size = lista.size();  // 3
```

## Escenarios BDD incluidos

El proyecto incluye **16 escenarios** que cubren:

### Operaciones CRUD
```gherkin
Escenario: Agregar elementos a ArrayList
  Dado un ArrayList vacío
  Cuando agrego "Java", "Python", "Go"
  Entonces el tamaño es 3
```

### Búsqueda
```gherkin
Escenario: Buscar elemento por índice
  Dado un ArrayList con "A, B, C, D"
  Cuando obtengo el elemento en índice 2
  Entonces el elemento es "C"
```

### Ordenamiento
```gherkin
Escenario: Ordenar ArrayList naturalmente
  Dado un ArrayList con "Banana, Apple, Cherry"
  Cuando ordeno la lista
  Entonces el orden es "Apple, Banana, Cherry"
```

### Gestión de capacidad
```gherkin
Escenario: Verificar crecimiento automático
  Dado un ArrayList con capacidad inicial 10
  Cuando agrego 15 elementos
  Entonces la capacidad se expande automáticamente
```

## Complejidad de operaciones

| Operación | Complejidad | Notas |
|-----------|-------------|-------|
| `get(index)` | O(1) | Acceso directo al array |
| `add(element)` | O(1)* | Amortizado, puede requerir resize |
| `add(index, element)` | O(n) | Debe mover elementos |
| `remove(index)` | O(n) | Debe mover elementos |
| `contains(element)` | O(n) | Búsqueda lineal |
| `indexOf(element)` | O(n) | Búsqueda lineal |

*O(n) cuando se requiere expandir la capacidad interna

## Capacidad vs Tamaño

```java
ArrayList<String> lista = new ArrayList<>(10);  // Capacidad: 10
lista.add("A");  // Tamaño: 1, Capacidad: 10
lista.add("B");  // Tamaño: 2, Capacidad: 10
// ...
lista.add("K");  // Tamaño: 11, Capacidad: 15 (expandido)
```

### Optimizar capacidad

Si conoces el tamaño final, inicializa con esa capacidad:

```java
// Mejor para 1000 elementos
ArrayList<String> lista = new ArrayList<>(1000);

// vs default (crece: 10 → 15 → 22 → 34 → 51 → 77 → 115 → 173...)
ArrayList<String> lista = new ArrayList<>();  // Capacidad inicial: 10
```

## ArrayList vs LinkedList

| Aspecto | ArrayList | LinkedList |
|---------|-----------|------------|
| Acceso por índice | O(1) | O(n) |
| Inserción al final | O(1)* | O(1) |
| Inserción en medio | O(n) | O(1)** |
| Memoria overhead | Menor | Mayor (nodos) |
| Iteración | Más rápida | Más lenta (cache misses) |

*Amortizado **Después de encontrar la posición

## Referencias

- [Cuándo usar List](../cuando-usar.md)
- [LinkedList](./linkedlist.md)
- [Complejidad algorítmica](../../rendimiento/complejidad.md)

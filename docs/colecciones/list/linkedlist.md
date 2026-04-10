# LinkedList

`LinkedList` implementa la interfaz `List` usando una **lista doblemente enlazada**. Cada elemento (nodo) contiene una referencia al siguiente y al anterior.

## Características principales

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Lista doblemente enlazada |
| **Acceso por índice** | O(n) - debe recorrer desde el inicio o fin |
| **Inserción/eliminación** | O(1) en extremos, O(n) en medio |
| **Memoria** | Mayor overhead (dos referencias por nodo) |
| **Implementa** | `List`, `Deque`, `Queue` |

## Cuándo usar LinkedList

✅ **Ideal para:**
- Inserciones/eliminaciones frecuentes en extremos (stack/queue)
- Implementación de algoritmos que requieren muchas modificaciones
- Necesitas operaciones `Deque` (addFirst, addLast, removeFirst, removeLast)

❌ **Evitar cuando:**
- Acceso frecuente por índice (usa ArrayList)
- Iteración secuencial simple (ArrayList es más rápido por cache)
- Memoria es crítica

## Ejemplos de uso

### Como Stack (LIFO)

```java
Deque<String> stack = new LinkedList<>();

// Apilar (push)
stack.push("Primero");
stack.push("Segundo");
stack.push("Tercero");

// Desapilar (pop)
String ultimo = stack.pop(); // "Tercero"
```

### Como Queue (FIFO)

```java
Queue<String> cola = new LinkedList<>();

// Encolar (offer)
cola.offer("Cliente 1");
cola.offer("Cliente 2");
cola.offer("Cliente 3");

// Desencolar (poll)
String siguiente = cola.poll(); // "Cliente 1"
```

### Operaciones Deque

```java
LinkedList<String> lista = new LinkedList<>();

// Agregar al inicio y fin
lista.addFirst("Inicio");
lista.addLast("Fin");
lista.addFirst("Nuevo inicio");

// Resultado: ["Nuevo inicio", "Inicio", "Fin"]

// Remover de extremos
String primero = lista.removeFirst(); // "Nuevo inicio"
String ultimo = lista.removeLast();   // "Fin"
```

## Implementación en el proyecto

El proyecto incluye ejemplos prácticos en:

```java
// LinkedListExample.java demuestra:
- Creación de lista enlazada
- Operaciones de pila (stack)
- Operaciones de cola (queue)
- Manipulación de extremos
```

## Escenarios BDD

Los tests incluyen escenarios como:

```gherkin
Escenario: Usar LinkedList como pila
  Dado una LinkedList vacía
  Cuando hago push de "A", "B", "C"
  Entonces el pop devuelve "C"
  Y el siguiente pop devuelve "B"

Escenario: Usar LinkedList como cola
  Dado una LinkedList vacía
  Cuando encolo "Cliente 1", "Cliente 2"
  Entonces el siguiente en la cola es "Cliente 1"
```

## Comparativa: ArrayList vs LinkedList

| Operación | ArrayList | LinkedList |
|-----------|-----------|------------|
| get(index) | O(1) | O(n) |
| add() al final | O(1)* | O(1) |
| add(0, element) | O(n) | O(1) |
| remove(0) | O(n) | O(1) |
| Iteración | Rápida (cache) | Más lenta |
| Memoria | Menor | Mayor |

*Amortizado

## Conclusión

Usa **LinkedList** cuando necesites:
- Operaciones frecuentes en extremos
- Implementar stacks o queues
- Inserciones/eliminaciones en cualquier posición

Usa **ArrayList** para acceso aleatorio y recorrido secuencial.

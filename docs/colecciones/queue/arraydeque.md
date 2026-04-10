# ArrayDeque

`ArrayDeque` implementa `Deque` (double-ended queue) usando un **array circular**. Es más eficiente que LinkedList para operaciones de cola.

## Características

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Array circular auto-redimensionable |
| **Capacidad** | Sin límite (crece dinámicamente) |
| **Operaciones** | addFirst/addLast/removeFirst/removeLast: O(1) |
| **Null** | **NO** permite elementos `null` |
| **Thread-safe** | No |

## Cuándo usar

- Stack (LIFO) - más rápido que Stack class
- Queue (FIFO) - más rápido que LinkedList
- Double-ended queue
- Navegación undo/redo

## Ejemplos

```java
// Como Stack (LIFO)
Deque<String> stack = new ArrayDeque<>();
stack.push("Primero");
stack.push("Segundo");
System.out.println(stack.pop()); // "Segundo"

// Como Queue (FIFO)
Deque<String> queue = new ArrayDeque<>();
queue.offer("Cliente 1");
queue.offer("Cliente 2");
System.out.println(queue.poll()); // "Cliente 1"

// Double-ended operations
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1); // [1]
deque.addLast(2);  // [1, 2]
deque.addFirst(0); // [0, 1, 2]
deque.addLast(3);  // [0, 1, 2, 3]

// Acceso a extremos
Integer primero = deque.getFirst(); // 0
Integer ultimo = deque.getLast();   // 3
```

## ArrayDeque vs LinkedList

| Operación | ArrayDeque | LinkedList |
|-----------|-----------|------------|
| addFirst() | O(1) | O(1) |
| addLast() | O(1) | O(1) |
| removeFirst() | O(1) | O(1) |
| removeLast() | O(1) | O(1) |
| Memoria | Menor | Mayor |
| Cache performance | Mejor | Peor |

## Escenarios BDD

Tests para:
- Operaciones stack (push/pop)
- Operaciones queue (offer/poll)
- Operaciones deque (addFirst/addLast)

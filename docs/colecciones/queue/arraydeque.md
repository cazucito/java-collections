# ArrayDeque

`ArrayDeque` implementa `Deque` (double-ended queue) usando un **array circular**.

## Características

- ✅ Operaciones en ambos extremos: **O(1)**
- ✅ Más rápido que LinkedList
- ✅ No permite null
- ❌ No es thread-safe
- ❌ No tiene límite de capacidad

## Cuándo usar

- Stack (LIFO): push/pop
- Queue (FIFO): offer/poll
- Navegación undo/redo
- Evaluación de expresiones

## Ejemplo

```java
Deque<String> stack = new ArrayDeque<>();
stack.push("First");
stack.push("Second");
System.out.println(stack.pop()); // Second
```

## Próximamente

Documentación completa con escenarios BDD.

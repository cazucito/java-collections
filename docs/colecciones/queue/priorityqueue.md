# PriorityQueue

`PriorityQueue` implementa una cola ordenada por **prioridad**.

## Características

- ✅ Ordenada por prioridad (natural o Comparator)
- ✅ peek/poll: **O(1)**
- ✅ insert: **O(log n)**
- ❌ No permite null
- ❌ No es thread-safe

## Cuándo usar

- Planificación de tareas por prioridad
- Algoritmos de pathfinding (Dijkstra, A*)
- Sistemas de recomendación

## Ejemplo

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(5);
pq.offer(1);
pq.offer(3);
System.out.println(pq.poll()); // 1 (menor prioridad)
```

## Próximamente

Documentación completa con escenarios BDD.

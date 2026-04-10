# PriorityQueue

`PriorityQueue` implementa una cola ordenada por **prioridad**, no por orden de llegada.

## Características

| Aspecto | Detalle |
|---------|---------|
| **Estructura** | Heap (árbol binario completo) |
| **Orden** | Por prioridad (natural o Comparator) |
| **Duplicados** | Permite duplicados |
| **Operaciones** | offer/poll: O(log n), peek: O(1) |
| **Null** | **NO** permite elementos `null` |

## Cuándo usar

- Planificación por prioridad
- Algoritmos Dijkstra/A*
- Sistemas de recomendación
- Procesamiento de tareas

## Ejemplos

```java
// Prioridad natural (menor primero)
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(5);
pq.offer(1);
pq.offer(3);
System.out.println(pq.poll()); // 1

// Comparator personalizado (mayor primero)
Queue<Integer> maxHeap = new PriorityQueue<>(
    Comparator.reverseOrder()
);

// Con objetos complejos
class Tarea implements Comparable<Tarea> {
    int prioridad;
    String nombre;
    
    @Override
    public int compareTo(Tarea o) {
        return Integer.compare(this.prioridad, o.prioridad);
    }
}

Queue<Tarea> tareas = new PriorityQueue<>();
tareas.offer(new Tarea(1, "Urgente"));
tareas.offer(new Tarea(3, "Baja"));
tareas.offer(new Tarea(2, "Media"));
// poll() retorna "Urgente" primero
```

## Escenarios BDD

Tests para:
- Ordenamiento por prioridad
- Operaciones offer/poll/peek
- Implementación de cola de tareas

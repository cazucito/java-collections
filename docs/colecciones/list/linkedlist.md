# LinkedList

`LinkedList` implementa la interfaz `List` usando una **lista doblemente enlazada**.

## Características

- ✅ Inserción/eliminación en extremos: **O(1)**
- ❌ Acceso por índice: **O(n)**
- ✅ Implementa `Deque` (double-ended queue)
- ❌ Mayor overhead de memoria (nodos)

## Cuándo usar

- Inserciones/eliminaciones frecuentes en medio de la lista
- Implementación de colas o stacks
- No necesitas acceso aleatorio frecuente

## Comparación con ArrayList

| Operación | ArrayList | LinkedList |
|-----------|-----------|------------|
| get(index) | O(1) | O(n) |
| add() al final | O(1)* | O(1) |
| add() en medio | O(n) | O(1)** |
| remove() | O(n) | O(1)** |
| Iteración | Rápida | Más lenta |

*Amortizado **Después de encontrar posición

## Próximamente

Documentación completa en desarrollo.

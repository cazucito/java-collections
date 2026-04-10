# Complejidad Algorítmica

Big O notation para operaciones de colecciones.

## Tabla de complejidad

| Colección | get | add | remove | contains | Iteración |
|-----------|-----|-----|--------|----------|-----------|
| ArrayList | O(1) | O(1)* | O(n) | O(n) | O(n) |
| LinkedList | O(n) | O(1) | O(1)** | O(n) | O(n) |
| HashSet | - | O(1) | O(1) | O(1) | O(n) |
| TreeSet | - | O(log n) | O(log n) | O(log n) | O(n) |
| HashMap | O(1) | O(1) | O(1) | - | O(n) |
| TreeMap | O(log n) | O(log n) | O(log n) | - | O(n) |
| PriorityQueue | O(1) peek | O(log n) | O(log n) | O(n) | O(n) |

*Amortizado **Después de encontrar nodo

## Cuándo cambiar

- **ArrayList → LinkedList**: Inserciones frecuentes en medio
- **HashSet → TreeSet**: Necesitas elementos ordenados
- **HashMap → TreeMap**: Necesitas orden por clave

## Próximamente

Documentación completa con escenarios BDD.

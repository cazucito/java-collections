# Preguntas Frecuentes

Respuestas a preguntas comunes sobre Java Collections.

## General

### ¿ArrayList o LinkedList?

- **ArrayList**: Acceso por índice frecuente, pocos insert/delete
- **LinkedList**: Muchos insert/delete, poco acceso aleatorio

### ¿HashSet o TreeSet?

- **HashSet**: Sin orden, operaciones O(1)
- **TreeSet**: Ordenado, operaciones O(log n)

### ¿Por qué no puedo usar tipos primitivos?

Las colecciones solo aceptan objetos. Usa los wrappers:
- `int` → `Integer`
- `double` → `Double`
- etc.

## Problemas comunes

### ConcurrentModificationException

No modifiques una colección mientras la iteras. Usa:
- `Iterator.remove()`
- `removeIf()`
- Copia la colección primero

### NullPointerException en TreeSet/TreeMap

No permiten `null` keys. Usa `HashSet`/`HashMap` si necesitas nulls.

### Rendimiento lento con colecciones grandes

- Verifica que usas la colección correcta
- Considera la capacidad inicial
- Evita iteraciones innecesarias

## Próximamente

Más preguntas y respuestas detalladas.

# Concurrencia

Colecciones thread-safe para entornos concurrentes.

## Colecciones concurrentes

### List
- **CopyOnWriteArrayList**: Lista inmutable en iteración

### Map
- **ConcurrentHashMap**: Map thread-safe de alto rendimiento
- **Collections.synchronizedMap()**: Wrapper synchronized

### Set
- **CopyOnWriteArraySet**: Set basado en CopyOnWriteArrayList
- **ConcurrentHashMap.newKeySet()**: Set thread-safe

### Queue
- **ConcurrentLinkedQueue**: Queue no bloqueante
- **BlockingQueue**: Interfaces para producer-consumer

## Cuándo usar

- Múltiples threads acceden a la colección
- Necesitas operaciones atómicas
- Performance crítica (evitar synchronized)

## Próximamente

Documentación completa con escenarios BDD.

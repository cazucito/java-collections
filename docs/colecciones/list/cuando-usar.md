# Cuándo usar cada tipo de List

Guía de decisión para elegir entre `ArrayList` y `LinkedList`.

## Diagrama de decisión

```
¿Necesitas acceso por índice frecuente?
├── SÍ → ArrayList
└── NO → ¿Insertas/eliminas en medio frecuentemente?
    ├── SÍ → LinkedList
    └── NO → ArrayList (por defecto)
```

## Casos de uso

### ArrayList
- Listas de productos con búsquedas frecuentes
- Arrays dinámicos de configuración
- Datos sensoriales secuenciales

### LinkedList
- Historial de navegación (undo/redo)
- Colas de transacciones
- Implementación de stacks

## Complejidad resumida

| Colección | Acceso | Búsqueda | Inserción | Eliminación |
|-----------|--------|----------|-----------|-------------|
| ArrayList | O(1) | O(n) | O(n) | O(n) |
| LinkedList | O(n) | O(n) | O(1)* | O(1)* |

*En extremos. O(n) si se requiere búsqueda previa.

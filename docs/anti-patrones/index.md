# Anti-Patrones

Errores comunes al usar Java Collections y cómo evitarlos.

## Índice de anti-patrones

### [Memory Leaks](memory-leaks.md)
- Cachés estáticos sin límites
- Listeners no removidos
- Referencias a objetos grandes

### [ConcurrentModificationException](concurrent-modification.md)
- Modificar colección durante iteración
- Soluciones con Iterator.remove()
- Uso de removeIf()

### [Equals vs Reference](equals-vs-reference.md)
- Uso de `==` en lugar de `equals()`
- Problemas con String.intern()
- Mutable keys en HashMap

---

Aprende de estos errores comunes para escribir código más robusto.

# ConcurrentModificationException

Evita esta excepción común al iterar colecciones.

## El problema

```java
// ❌ MAL: Lanza ConcurrentModificationException
for (String s : list) {
    if (s.equals("remove")) {
        list.remove(s); // ¡Excepción!
    }
}
```

## Soluciones

### 1. Iterator.remove()

```java
// ✅ BIEN: Usar Iterator
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (it.next().equals("remove")) {
        it.remove();
    }
}
```

### 2. removeIf() (Java 8+)

```java
// ✅ MEJOR: Método funcional
list.removeIf(s -> s.equals("remove"));
```

### 3. Copia de la colección

```java
// ✅ Alternativa: Iterar sobre copia
for (String s : new ArrayList<>(list)) {
    if (s.equals("remove")) {
        list.remove(s);
    }
}
```

## Próximamente

Documentación completa con escenarios BDD.

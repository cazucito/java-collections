# Preguntas Frecuentes

Respuestas a preguntas comunes sobre Java Collections.

## General

### ¿ArrayList o LinkedList?

**ArrayList** cuando:
- Acceso frecuente por índice
- Principalmente operaciones de lectura
- Agregas al final de la lista

**LinkedList** cuando:
- Inserciones/eliminaciones frecuentes en extremos
- Implementas stack o queue
- No necesitas acceso aleatorio

### ¿HashSet o TreeSet?

**HashSet** cuando:
- No necesitas orden
- Quieres operaciones O(1)
- Solo verificas unicidad

**TreeSet** cuando:
- Necesitas elementos ordenados
- Realizas búsquedas por rango
- El orden es más importante que la velocidad

### ¿HashMap o TreeMap?

Igual que Set: HashMap para velocidad O(1), TreeMap para orden O(log n).

### ¿Por qué no puedo usar tipos primitivos?

Las colecciones almacenan objetos. Usa los wrappers:
- `int` → `Integer`
- `double` → `Double`
- `char` → `Character`
- `boolean` → `Boolean`

Java hace autoboxing/unboxing automáticamente:
```java
List<Integer> numeros = new ArrayList<>();
numeros.add(5);      // Autoboxing: int → Integer
int n = numeros.get(0); // Unboxing: Integer → int
```

## Problemas comunes

### ConcurrentModificationException

No modifiques una colección mientras la iteras.

```java
// ❌ Mal
for (String s : lista) {
    lista.remove(s);
}

// ✅ Bien
lista.removeIf(s -> condicion);
// o
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    if (condicion) it.remove();
}
```

### NullPointerException en TreeSet/TreeMap

No permiten `null`. Usa HashSet/HashMap si necesitas nulls.

### Rendimiento lento

1. ¿Usas la colección correcta?
2. ¿Verificaste la capacidad inicial?
3. ¿Hay muchas colisiones de hash?

### equals() y hashCode()

Siempre implementa ambos juntos si usas objetos en Set o como keys en Map.

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Persona persona = (Persona) o;
    return Objects.equals(id, persona.id);
}

@Override
public int hashCode() {
    return Objects.hash(id);
}
```

## Best practices

### Inicializar con capacidad

```java
// Si sabes que tendrás ~1000 elementos
List<String> lista = new ArrayList<>(1000);
Map<String, User> map = new HashMap<>(1000);
```

### Usar interfaces

```java
// ✅ Bien
List<String> lista = new ArrayList<>();
Set<String> set = new HashSet<>();
Map<String, Integer> map = new HashMap<>();

// ❌ Evita
ArrayList<String> lista = new ArrayList<>();
```

### Preferir métodos inmutables

```java
// Java 9+
List<String> lista = List.of("A", "B", "C"); // Inmutable
Set<String> set = Set.of("A", "B", "C");
Map<String, Integer> map = Map.of("A", 1, "B", 2);
```

## Recursos adicionales

- [Documentación oficial Java Collections](https://docs.oracle.com/javase/tutorial/collections/)
- [Guía de colecciones de Baeldung](https://www.baeldung.com/java-collections)
- [Java Collections Framework Overview](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)

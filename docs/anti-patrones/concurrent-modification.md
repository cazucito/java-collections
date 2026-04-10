# ConcurrentModificationException

Error común al modificar colecciones durante iteración.

## El problema

```java
// ❌ Lanza ConcurrentModificationException
List<String> lista = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

for (String s : lista) {
    if (s.equals("B")) {
        lista.remove(s); // ¡Excepción!
    }
}
```

## Soluciones

### 1. Iterator.remove()

```java
// ✅ Usar Iterator explícito
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String s = it.next();
    if (s.equals("B")) {
        it.remove(); // Safe
    }
}
```

### 2. removeIf() (Java 8+)

```java
// ✅ Mejor solución funcional
lista.removeIf(s -> s.equals("B"));
```

### 3. Copiar la colección

```java
// ✅ Iterar sobre copia, modificar original
for (String s : new ArrayList<>(lista)) {
    if (s.equals("B")) {
        lista.remove(s);
    }
}
```

### 4. Collect y reasignar (Streams)

```java
// ✅ Filtrar con Stream
lista = lista.stream()
    .filter(s -> !s.equals("B"))
    .collect(Collectors.toList());
```

## Escenarios BDD

```gherkin
Escenario: Remover con Iterator evita excepción
  Dado una lista con elementos
  Cuando uso Iterator.remove() durante iteración
  Entonces no hay excepción
  Y el elemento se elimina

Escenario: removeIf elimina elementos
  Dado una lista con "A", "B", "C"
  Cuando uso removeIf para eliminar "B"
  Entonces la lista contiene "A" y "C"
```

## Conclusión

Nunca modifiques directamente una colección mientras la iteras. Usa Iterator.remove(), removeIf(), o crea una copia.

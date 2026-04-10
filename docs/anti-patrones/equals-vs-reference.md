# Equals vs Reference

Diferencia entre `==` y `equals()` en colecciones.

## El problema

```java
// ❌ MAL: == compara referencias
String a = new String("test");
String b = new String("test");
System.out.println(a == b); // false
```

## HashMap y equals()

```java
Map<String, Integer> map = new HashMap<>();
String key = new String("key");
map.put(key, 1);

// ✅ Funciona porque String.equals() compara contenido
System.out.println(map.get("key")); // 1
```

## Mutable keys

```java
// ❌ MAL: Key mutable en HashMap
Map<List<String>, Integer> map = new HashMap<>();
List<String> key = new ArrayList<>();
key.add("a");
map.put(key, 1);

key.add("b"); // Modifica key!
// map.get(key) puede fallar
```

## Próximamente

Documentación completa con escenarios BDD.

# Equals vs Reference (==)

Confusión común entre comparación de valores y comparación de referencias.

## El problema

```java
// ❌ Mal: == compara referencias
String a = new String("test");
String b = new String("test");
System.out.println(a == b); // false
```

## La solución

```java
// ✅ Bien: equals() compara contenido
System.out.println(a.equals(b)); // true
```

## En colecciones

### HashMap con String

```java
Map<String, Integer> map = new HashMap<>();
String key = new String("clave");
map.put(key, 100);

// ✅ Funciona porque String.equals() compara contenido
System.out.println(map.get("clave")); // 100
```

### HashMap con objetos propios

```java
// ❌ Mal: sin equals() y hashCode()
class Persona {
    String nombre;
    // Sin equals/hashCode
}

Map<Persona, Integer> map = new HashMap<>();
Persona p1 = new Persona("Ana");
map.put(p1, 100);

Persona p2 = new Persona("Ana");
// ❌ Retorna null porque usa referencia
System.out.println(map.get(p2)); // null
```

```java
// ✅ Bien: con equals() y hashCode()
class Persona {
    String nombre;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
```

## Mutable keys en HashMap

```java
// ❌ Peligroso: key mutable
Map<List<String>, Integer> map = new HashMap<>();
List<String> key = new ArrayList<>();
key.add("a");
map.put(key, 100);

key.add("b"); // ¡Modifica la key!
// map.get(key) puede fallar o retornar null
```

## Escenarios BDD

```gherkin
Escenario: Objeto con equals correcto funciona en HashMap
  Dado un HashMap con claves de tipo Persona
  Y Persona tiene equals/hashCode implementados
  Cuando busco con objeto diferente pero igual contenido
  Entonces encuentra el valor correcto
```

## Regla de oro

Siempre implementa `equals()` y `hashCode()` juntos si usas objetos como claves en Map o elementos en Set.

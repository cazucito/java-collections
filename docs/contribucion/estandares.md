# Estándares de Código

Reglas para mantener calidad y consistencia en el proyecto.

## Formato de código

### Google Java Format

El proyecto usa **Google Java Format** aplicado automáticamente por Spotless.

```bash
# Aplicar formato
mvn spotless:apply

# Verificar formato
mvn spotless:check
```

### Convenciones específicas

#### Indentación
- **2 espacios** (no tabs)
- Continuación: 4 espacios adicionales

```java
public void metodoLargo(
    String parametro1,
    String parametro2,
    String parametro3) {
  // código
}
```

#### Longitud de línea
- Máximo **100 caracteres**
- Excepciones: URLs, imports, Gherkin

#### Llaves
- Apertura en la misma línea (estilo K&R)

```java
public void metodo() {  // ✅
  if (condicion) {      // ✅
    // código
  }
}
```

## Nombrado

### Clases
```java
// ✅ Bien
public class ArrayListExample { }
public class HashSetOperations { }

// ❌ Mal
public class arraylistexample { }
public class Hash_Set_Operations { }
```

### Métodos
```java
// ✅ Bien
public void addElement(String element) { }
public boolean containsValue(String value) { }
public List<String> getAllElements() { }

// ❌ Mal
public void add_element(String element) { }
public boolean contains(String value) { } // muy genérico
```

### Variables
```java
// ✅ Bien
private List<String> elementList;
private int currentSize;
private boolean isEmpty;

// ❌ Mal
private List<String> list;     // muy genérico
private int size;              // podría confundir con método
private boolean empty;         // falta verbo
```

### Constantes
```java
// ✅ Bien
private static final int DEFAULT_CAPACITY = 10;
private static final String SEPARATOR = ", ";

// ❌ Mal
private static final int defaultCapacity = 10;
private static final String separator = ", ";
```

## Javadoc

Toda clase pública debe tener Javadoc:

```java
/**
 * Ejemplifica el uso de ArrayList para almacenar elementos.
 *
 * <p>Demuestra operaciones básicas como agregar, eliminar, 
 * acceder y buscar elementos en una lista.
 */
public class ArrayListExample {
  // ...
}
```

Métodos públicos importantes:

```java
/**
   * Agrega un elemento a la lista.
   *
   * @param element el elemento a agregar
   * @return true si se agregó correctamente
   */
  public boolean addElement(final String element) {
    // ...
  }
```

## Gherkin (BDD)

### Idioma
- Todas las features en **español**
- `# language: es` al inicio del archivo

### Estructura
```gherkin
# language: es
Característica: Operaciones básicas de ArrayList
  Como desarrollador Java
  Quiero usar ArrayList
  Para almacenar elementos

  Escenario: Agregar elemento
    Dado un ArrayList vacío
    Cuando agrego "Java"
    Entonces el tamaño es 1
```

### Step definitions
```java
@Dado("un ArrayList vacío")
public void unArrayListVacio() {
  arrayList = new ArrayList<>();
}

@Cuando("agrego el elemento {string}")
public void agregoElElemento(final String element) {
  arrayList.add(element);
}
```

## Imports

### Orden
1. `java.*`
2. `javax.*`
3. Librerías de terceros
4. `io.github.cazucito.*`

```java
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
```

## Checkstyle

El proyecto usa Checkstyle para verificar estilo. Reglas principales:

- ✅ Javadoc en clases públicas
- ✅ No wildcard imports
- ✅ Line length ≤ 100
- ✅ Method length ≤ 150 líneas
- ✅ Cyclomatic complexity ≤ 10
- ✅ No trailing whitespace

## SpotBugs

Análisis estático para detectar bugs potenciales:

- Null pointer dereferences
- Infinite loops
- Dead stores
- Resource leaks

## Pre-commit checklist

Antes de hacer commit:

```bash
# 1. Formato
mvn spotless:apply

# 2. Verificación completa
mvn clean verify

# 3. Si todo pasa, commit
git add .
git commit -m "tipo: descripción"
```

## Mensajes de commit

Formato: `tipo: descripción breve`

Tipos:
- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Documentación
- `test`: Tests
- `refactor`: Refactorización
- `style`: Cambios de formato
- `chore`: Tareas de mantenimiento

Ejemplos:
```
feat: agregar ejemplos de TreeMap
fix: corregir NullPointerException en HashSetSteps
docs: completar documentación de ArrayList
test: agregar 5 escenarios para PriorityQueue
```

## Violaciones comunes

### ❌ Múltiples strings literales
```java
// ❌ Mal
String result = a + ", " + b + ", " + c;

// ✅ Bien
private static final String SEPARATOR = ", ";
String result = a + SEPARATOR + b + SEPARATOR + c;
```

### ❌ Catching Exception genérico
```java
// ❌ Mal
try {
  // código
} catch (Exception e) {
  // ...
}

// ✅ Bien
try {
  // código
} catch (IllegalArgumentException e) {
  // ...
}
```

### ❌ Raw types
```java
// ❌ Mal
List lista = new ArrayList();

// ✅ Bien
List<String> lista = new ArrayList<>();
```

## Recursos

- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Checkstyle Configuration](src/test/resources/config/checkstyle/)
- [SpotBugs Configuration](src/test/resources/config/spotbugs/)

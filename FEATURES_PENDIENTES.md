# Features Pendientes - Roadmap de Mejoras

> Documentación de características propuestas para futuras versiones del proyecto.
> 
> **Estado:** Documentado (no implementado)  
> **Fecha:** 2026-04-10

---

## 1. Anti-Patrones y Errores Comunes

### Descripción
Documentar y ejemplificar los errores más frecuentes al usar colecciones Java, incluyendo:
- `ConcurrentModificationException` en contextos no obvios
- Memory leaks con colecciones `static`
- Uso de `==` vs `.equals()` en HashSet/HashMap
- Modificar objetos mutables usados como claves
- Uso incorrecto de streams (orden de operaciones)

### Escenarios BDD propuestos
```gherkin
Feature: Anti-patrones comunes en colecciones
  
  Scenario: Memory leak con colección estática
    Given una colección static declarada
    When se agregan elementos sin limite
    Then se produce un memory leak gradual
    
  Scenario: Modificar objeto usado como clave
    Given un HashMap con objetos mutables como claves
    When se modifica el objeto después de insertarlo
    Then la clave ya no es encontrable
    
  Scenario: Usar == en lugar de equals
    Given un HashSet de Strings
    When se comparan strings con == en lugar de equals
    Then se consideran diferentes objetos con mismo contenido
```

### Valor educativo
**Alta** - Completa el ciclo de aprendizaje mostrando qué NO hacer.

### Complejidad
**Media** - Requiere nuevos escenarios BDD y clases de ejemplo.

---

## 2. Patrones de Diseño con Colecciones

### Descripción
Implementar ejemplos de patrones de diseño que utilizan colecciones como componente central:

- **Flyweight Pattern:** Pool de objetos inmutables reutilizables
- **Observer Pattern:** Sistema de eventos con CopyOnWriteArrayList
- **Strategy Pattern:** Algoritmos de ordenamiento intercambiables
- **Factory Method:** Creación de colecciones según contexto de uso
- **Composite Pattern:** Estructuras jerárquicas con colecciones anidadas

### Escenarios BDD propuestos
```gherkin
Feature: Patrones de diseño con colecciones

  Scenario: Observer con CopyOnWriteArrayList
    Given un sistema de notificaciones con observers
    When se agrega un nuevo listener durante notificación
    Then no se produce ConcurrentModificationException
    
  Scenario: Flyweight pool de objetos
    Given un pool de objetos String reutilizables
    When se solicitan 1000 objetos iguales
    Then solo se crean 1 o 2 instancias reales
    
  Scenario: Strategy para ordenamiento
    Given una lista de productos
    When se cambia la estrategia de ordenamiento
    Then los productos se ordenan según el nuevo criterio
```

### Valor educativo
**Alta** - Conecta colecciones con arquitectura de software.

### Complejidad
**Alta** - Requiere implementar múltiples patrones con sus interfaces.

---

## 3. Java Moderno (Java 21+)

### Descripción
Demostrar características modernas de Java que mejoran el uso de colecciones:

- **Records** como claves inmutables en Map/Set
- **Pattern Matching** con switch sobre tipos de colección
- **Sealed Classes** para jerarquías de colecciones tipadas
- **Text Blocks** en especificaciones Gherkin para legibilidad
- **var** y type inference en declaraciones
- **Stream.toList()** vs Collectors.toList()
- **Optional** con colecciones (orElse, ifPresentOrElse)

### Escenarios BDD propuestos
```gherkin
Feature: Java 21 features con colecciones

  Scenario: Record como clave inmutable
    Given un record Person(String name, int age)
    When se usa como clave en HashMap
    Then es inmutable y thread-safe por diseño
    
  Scenario: Pattern matching con colecciones
    Given una colección de tipo desconocido
    When se usa switch con pattern matching
    Then se ejecuta el caso correcto según el tipo
    
  Scenario: Sealed class para tipos de colección
    Given una sealed class CollectionType
    When se implementan variantes permitidas
    Then el compilador verifica exhaustividad
```

### Valor educativo
**Media-Alta** - Mantiene el proyecto actualizado con Java moderno.

### Complejidad
**Media** - Requiere Java 21+ y cambios sintácticos menores.

---

## 4. Serialización y Persistencia

### Descripción
Ejemplos de cómo persistir colecciones en diferentes formatos y medios:

- **JSON:** Serialización con Jackson y Gson
- **XML:** JAXB para estructuras complejas
- **Java Serializable:** Pros, contras y alternativas modernas
- **Base de Datos:** JPA/Hibernate con colecciones (@ElementCollection)
- **NoSQL:** MongoDB, Redis con estructuras de colecciones
- **CSV:** Import/export para análisis de datos

### Escenarios BDD propuestos
```gherkin
Feature: Persistencia de colecciones

  Scenario: Serialización a JSON con Jackson
    Given una lista de objetos complejos
    When se serializa a JSON
    Then se preserva estructura y tipos
    
  Scenario: Persistencia en base de datos relacional
    Given un Map con @ElementCollection
    When se guarda con JPA
    Then se crean tablas de relación automáticamente
    
  Scenario: Redis como cache de colecciones
    Given un HashMap en memoria
    When se persiste en Redis
    Then está disponible entre reinicios de aplicación
```

### Valor educativo
**Media** - Conecta colecciones con persistencia real.

### Complejidad
**Alta** - Requiere dependencias adicionales (Jackson, JPA, Redis, etc.)

---

## 5. Guía de Debugging y Troubleshooting

### Descripción
Documentación y ejemplos prácticos para diagnosticar problemas:

- **Lectura de toString():** Interpretar salidas de colecciones anidadas
- **Memory Profiling:** VisualVM, JConsole para detectar fugas
- **ConcurrentModificationException:** Leer stack traces y causas
- **Performance Tuning:** Identificar cuellos de botella en colecciones
- **Debugging en IDE:** Breakpoints condicionales en streams
- **Análisis de heap dumps:** Encontrar colecciones que crecen sin control

### Escenarios BDD propuestos
```gherkin
Feature: Debugging y troubleshooting

  Scenario: Detectar ConcurrentModificationException
    Given un error en logs
    When se analiza el stack trace
    Then se identifica la colección y operación concurrente
    
  Scenario: Memory leak en colección estática
    Given un heap dump de aplicación
    When se analizan las referencias dominantes
    Then se identifica la colección que no libera memoria
    
  Scenario: Performance issue en LinkedList
    Given operaciones lentas en lista grande
    When se profila con JConsole
    Then se identifica que se usa LinkedList para acceso por índice
```

### Valor educativo
**Alta** - Habilidades prácticas para desarrollo profesional.

### Complejidad
**Media** - Requiere herramientas externas y documentación detallada.

---

## Resumen de Priorización

| Feature | Prioridad | Complejidad | Valor Educativo |
|---------|-----------|-------------|-----------------|
| Anti-Patrones | **Alta** | Media | ⭐⭐⭐⭐⭐ |
| Patrones de Diseño | Media | Alta | ⭐⭐⭐⭐⭐ |
| Java Moderno | Media | Media | ⭐⭐⭐⭐ |
| Serialización | Baja | Alta | ⭐⭐⭐ |
| Debugging | **Alta** | Media | ⭐⭐⭐⭐⭐ |

## Recomendación

Si se implementara **solo una**, la recomendación es:

> **#1 Anti-Patrones y Errores Comunes**
> 
> Porque complementa perfectamente el objetivo actual del repositorio: no solo enseñar "cómo hacerlo bien" sino también "qué errores evitar" y "por qué falla cuando se hace mal". Esta dualidad es esencial para un recurso educativo completo.

---

## Notas de Implementación

- Todas las features siguen el mismo enfoque **BDD/TDD** del proyecto actual
- Especificaciones en español con Gherkin
- Código fuente en inglés, comentarios en español
- Deben pasar los mismos quality gates: Checkstyle, SpotBugs, Spotless, JaCoCo
- Convención de commits: `docs:`, `feat:`, `test:` según corresponda

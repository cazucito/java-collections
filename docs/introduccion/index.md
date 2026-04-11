# Introducción

Bienvenido a **Java Collections Examples**. Esta sección te guiará desde la instalación hasta tu primer escenario BDD ejecutado exitosamente.

## ¿Qué es este proyecto?

Una colección exhaustiva de **ejemplos prácticos** que demuestran el uso del API Java Collections siguiendo las mejores prácticas de desarrollo de software.

### Objetivos principales

- **Aprender haciendo**: Cada concepto tiene escenarios BDD ejecutables
- **Referencia rápida**: Encuentra el ejemplo que necesitas cuando lo necesitas
- **Calidad garantizada**: Todo el código pasa Checkstyle, SpotBugs y tiene >80% de cobertura
- **Documentación viva**: Los tests sirven como documentación ejecutable

## ¿Para quién es este proyecto?

### 👶 Si eres principiante en Java
- Aprende las colecciones desde cero con ejemplos claros
- Entiende cuándo usar ArrayList vs LinkedList
- Domina HashMap, HashSet y sus diferencias

### 🧑‍💻 Si ya conoces Java pero quieres profundizar
- Descubre casos de uso reales que no ves en tutoriales básicos
- Aprende Streams API y programación funcional
- Entiende generics avanzados (wildcards, PECS)

### 🏗️ Si eres arquitecto o líder técnico
- Revisa anti-patrones comunes y cómo evitarlos
- Analiza decisiones de rendimiento con benchmarks reales
- Usa como material de capacitación para tu equipo

## Metodología BDD

Este proyecto usa **Behavior Driven Development**, una técnica donde:

1. **Especificamos comportamiento** en lenguaje natural
2. **Automatizamos** esas especificaciones como tests
3. **Implementamos** el código necesario
4. **Refactorizamos** manteniendo los tests verdes

### Ejemplo completo

```gherkin
# 1. Especificación (archivo .feature)
Escenario: Buscar elemento en ArrayList
  Dado un ArrayList con elementos "A, B, C, D"
  Cuando busco el índice del elemento "C"
  Entonces el índice encontrado es 2
```

```java
// 2. Step Definition
@Cuando("busco el índice del elemento {string}")
public void buscoElIndiceDelElemento(final String element) {
    foundIndex = arrayList.indexOf(element);
}

@Entonces("el índice encontrado es {int}")
public void elIndiceEncontradoEs(final int expected) {
    assertThat(foundIndex).isEqualTo(expected);
}
```

```java
// 3. Implementación
public int indexOf(String element) {
    return elements.indexOf(element);
}
```

## Estructura de navegación

La documentación está organizada en secciones que se complementan:

1. **[Empezar](instalacion.md)** - Setup y primeros pasos
2. **[Colecciones](../colecciones/index.md)** - Referencia de cada tipo
3. **[Casos de Uso](../casos-de-uso/index.md)** - Soluciones prácticas
4. **[Avanzado](../avanzado/index.md)** - Streams, Generics, Concurrencia
5. **[Anti-Patrones](../anti-patrones/index.md)** - Errores a evitar
6. **[Rendimiento](../rendimiento/index.md)** - Optimización y complejidad

## Próximos pasos

- ➡️ [Instalar y configurar](instalacion.md)
- ➡️ [Tu primer escenario BDD](primeros-pasos.md)

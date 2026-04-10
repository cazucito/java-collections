# Primeros Pasos

Guía paso a paso para ejecutar tu primer escenario BDD.

## Verificar instalación

```bash
cd java-collections
mvn clean test
```

Deberías ver:
```
[INFO] Tests run: 217, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Tu primer escenario BDD

Los escenarios BDD están en `src/test/resources/features/`. Cada archivo `.feature` contiene escenarios en lenguaje natural.

### Ejemplo: ArrayList

```gherkin
# Archivo: src/test/resources/features/list/arraylist_operations.feature
Escenario: Agregar elemento a ArrayList
  Dado un ArrayList vacío
  Cuando agrego el elemento "Java"
  Entonces el tamaño del ArrayList es 1
  Y el ArrayList contiene "Java"
```

### Ejecutar un escenario específico

```bash
mvn test -Dcucumber.filter.tags="@arraylist"
```

## Entender la estructura

1. **Feature** (`.feature`): Define el comportamiento en Gherkin
2. **Steps** (`.java`): Conecta Gherkin con código Java
3. **Implementation** (`.java`): La lógica de negocio

## Siguientes pasos

- Explora los [escenarios de List](../colecciones/list/arraylist.md)
- Revisa los [casos de uso prácticos](../casos-de-uso/index.md)
- Aprende sobre [anti-patrones comunes](../anti-patrones/index.md)

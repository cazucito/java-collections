# Generics Avanzados

Wildcards, bounds y type erasure en Java Collections.

## Wildcards

- `?`: Unbounded wildcard
- `? extends T`: Upper bounded (covarianza)
- `? super T`: Lower bounded (contravarianza)

## PECS Principle

- **P**roducer → **E**xtends
- **C**onsumer → **S**uper

## Type Erasure

Los generics solo existen en tiempo de compilación.

```java
// Compilación
List<String> y List<Integer> son diferentes

// Runtime
Ambos son List (raw type)
```

## Próximamente

Documentación completa con escenarios BDD.

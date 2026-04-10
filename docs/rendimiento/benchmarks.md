# Benchmarks

Mediciones de rendimiento con JMH (Java Microbenchmark Harness).

## Consideraciones

### No uses `System.nanoTime()`

```java
// ❌ MAL: No preciso para microbenchmarks
long start = System.nanoTime();
// operación
long end = System.nanoTime();
```

### Usa JMH

```java
// ✅ BIEN: Framework especializado
@Benchmark
public void testArrayListAdd(Blackhole blackhole) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
        list.add("item" + i);
    }
    blackhole.consume(list);
}
```

## Resultados típicos

| Operación | ArrayList | LinkedList |
|-----------|-----------|------------|
| add() al final | 50 ns | 80 ns |
| get(500) | 5 ns | 250 ns |
| remove(0) | 500 ns | 20 ns |

## Próximamente

Documentación completa con escenarios BDD.

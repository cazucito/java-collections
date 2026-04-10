# Diagramas

Diagramas de clases y relaciones del proyecto.

## Jerarquía de Colecciones

```
                    Iterable
                       │
                    Collection
                       │
        ┌──────────────┼──────────────┐
        │              │              │
       List           Set           Queue
        │              │              │
   ┌────┴────┐    ┌───┴───┐     ┌────┴────┐
   │         │    │       │     │         │
ArrayList LinkedList HashSet TreeSet PriorityQueue ArrayDeque
             │       │
             │   LinkedHashSet
             │
        CopyOnWriteArrayList
```

## Jerarquía de Map

```
               Map
                │
        ┌───────┼───────┐
        │       │       │
    HashMap TreeMap LinkedHashMap
                │
          WeakHashMap
```

## Arquitectura del proyecto

```
java-collections/
├── src/main/java/          # Implementaciones
│   └── io/github/cazucito/collections/
│       ├── list/
│       ├── set/
│       ├── map/
│       ├── queue/
│       ├── streams/
│       ├── algorithm/
│       ├── generics/
│       └── antipatterns/
├── src/test/java/          # Step definitions
│   └── .../steps/
├── src/test/resources/     # Features Gherkin
│   └── features/
└── docs/                   # Documentación
```

## Próximamente

Diagramas más detallados con PlantUML.

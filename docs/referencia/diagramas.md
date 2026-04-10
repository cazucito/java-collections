# Diagramas

Diagramas de clases y arquitectura del proyecto.

## Jerarquía de colecciones en Java

```
                    Iterable<T>
                        │
                   Collection<T>
                        │
        ┌───────────────┼───────────────┐
        │               │               │
      List<T>        Set<T>        Queue<T>
        │               │               │
   ┌────┴────┐    ┌────┴────┐    ┌────┴────┐
   │         │    │         │    │         │
ArrayList LinkedHashSet  TreeSet  PriorityQueue ArrayDeque
LinkedList      │                        │
           LinkedHashSet           LinkedList
```

## Jerarquía de Map

```
                    Map<K,V>
                       │
        ┌──────────────┼──────────────┐
        │              │              │
    HashMap       TreeMap      LinkedHashMap
        │              │              │
   WeakHashMap   NavigableMap    (orden inserción)
                     │
                 SortedMap
```

## Arquitectura del proyecto

```
java-collections/
│
├── src/main/java/io/github/cazucito/collections/
│   │
│   ├── list/
│   │   ├── ArrayListExample.java
│   │   └── LinkedListExample.java
│   │
│   ├── set/
│   │   ├── HashSetExample.java
│   │   ├── TreeSetExample.java
│   │   └── LinkedHashSetExample.java
│   │
│   ├── map/
│   │   ├── HashMapExample.java
│   │   ├── TreeMapExample.java
│   │   └── LinkedHashMapExample.java
│   │
│   ├── queue/
│   │   ├── PriorityQueueExample.java
│   │   └── ArrayDequeExample.java
│   │
│   ├── streams/
│   │   └── StreamExample.java
│   │
│   ├── algorithm/
│   │   ├── CollectionsUtilitiesExample.java
│   │   └── ArraysUtilitiesExample.java
│   │
│   ├── generics/
│   │   └── AdvancedGenericsExample.java
│   │
│   └── antipatterns/
│       └── AntiPatternsExample.java
│
├── src/test/java/
│   └── steps/           # Step definitions de Cucumber
│
└── src/test/resources/features/
    └── *.feature        # Escenarios Gherkin
```

## Flujo BDD

```
Feature File (.feature)
       │
       ▼
Step Definitions (.java) ──► Implementation (.java)
       │                           │
       │                           ▼
       │                    Business Logic
       │                           │
       └───────────────────────────┘
                   │
                   ▼
            JUnit Test Result
```

## Diagrama de clases - Ejemplo ArrayList

```
┌─────────────────────┐
│ ArrayListExample    │
├─────────────────────┤
│ - elements: List    │
├─────────────────────┤
│ + addElement()      │
│ + removeElement()   │
│ + getElement()      │
│ + size()            │
│ + sort()            │
│ + ...               │
└─────────────────────┘
           │
           ▼
┌─────────────────────┐
│  ArrayList<String>  │
│    (Java API)       │
└─────────────────────┘
```

## Dependencias del proyecto

```
java-collections
├── JUnit 5 (junit-jupiter)
├── Cucumber JVM (cucumber-java)
├── AssertJ (assertj-core)
├── SpotBugs (spotbugs-annotations)
└── Maven Plugins:
    ├── maven-surefire-plugin
    ├── maven-checkstyle-plugin
    ├── spotbugs-maven-plugin
    ├── spotless-maven-plugin
    └── jacoco-maven-plugin
```

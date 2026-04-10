# Arquitectura del Proyecto

Diseño y estructura interna del proyecto.

## Principios de diseño

1. **BDD First**: Especificación en Gherkin antes de implementación
2. **Calidad**: Cada cambio debe pasar todas las verificaciones
3. **Documentación viva**: Los tests son la documentación
4. **Simplicidad**: Código claro y mantenible

## Estructura de paquetes

```
io.github.cazucito.collections/
│
├── list/               # Implementaciones de List
│   ├── ArrayListExample.java
│   └── LinkedListExample.java
│
├── set/                # Implementaciones de Set
│   ├── HashSetExample.java
│   ├── TreeSetExample.java
│   └── LinkedHashSetExample.java
│
├── map/                # Implementaciones de Map
│   ├── HashMapExample.java
│   ├── TreeMapExample.java
│   └── LinkedHashMapExample.java
│
├── queue/              # Implementaciones de Queue/Deque
│   ├── PriorityQueueExample.java
│   └── ArrayDequeExample.java
│
├── streams/            # Streams API
│   └── StreamExample.java
│
├── algorithm/          # Utilidades
│   ├── CollectionsUtilitiesExample.java
│   └── ArraysUtilitiesExample.java
│
├── generics/           # Generics avanzados
│   └── AdvancedGenericsExample.java
│
└── antipatterns/       # Anti-patrones
    └── AntiPatternsExample.java
```

## Patrones utilizados

### BDD (Behavior Driven Development)

```
Feature (Gherkin) → Steps (Java) → Implementation (Java)
     │                    │                  │
     └────────────────────┴──────────────────┘
                    │
                    ▼
            Verification (Tests)
```

### Factory Pattern

Cada clase Example actúa como factory de la colección:

```java
public class ArrayListExample {
    private final List<String> elements = new ArrayList<>();
    
    public boolean addElement(String element) {
        return elements.add(element);
    }
}
```

### Strategy Pattern

Comparadores personalizados para ordenamiento:

```java
Set<Persona> porEdad = new TreeSet<>(
    Comparator.comparingInt(Persona::getEdad)
);
```

## Flujo de datos

```
1. Feature File (.feature)
   └─ Define comportamiento esperado en Gherkin
   
2. Step Definitions (Steps.java)
   └─ Mapea pasos Gherkin a código Java
   
3. Example Classes (Example.java)
   └─ Implementa la lógica de negocio
   
4. JUnit + Cucumber
   └─ Ejecuta y verifica el comportamiento
```

## Quality Gates

```
Código fuente
     │
     ├──► Checkstyle ──► Estilo de código
     │
     ├──► SpotBugs ────► Bugs potenciales
     │
     ├──► Spotless ────► Formato consistente
     │
     ├──► Tests ───────► 217+ escenarios
     │
     └──► JaCoCo ──────► >60% cobertura
```

## Dependencias principales

### Runtime
- **Java 21 LTS**: Plataforma base
- **Maven**: Build tool

### Testing
- **JUnit 5**: Framework de testing
- **Cucumber JVM**: BDD framework
- **AssertJ**: Assertions fluídas

### Quality
- **Checkstyle**: Análisis de estilo
- **SpotBugs**: Análisis estático
- **Spotless**: Formateo automático
- **JaCoCo**: Cobertura de código

## Ciclo de vida de un feature

```
1. Idea → Crear feature file con escenarios
2. Run → Tests fallan (rojo)
3. Implement → Escribir código mínimo
4. Run → Tests pasan (verde)
5. Refactor → Mejorar código
6. Verify → Todos los tests siguen pasando
```

## Convenciones de código

- **Paquetes**: `io.github.cazucito.collections.<categoria>`
- **Clases**: `PascalCaseExample`
- **Métodos**: `camelCaseDescriptivo`
- **Variables**: `camelCase`
- **Constantes**: `UPPER_SNAKE_CASE`

## Extensibilidad

Para agregar una nueva colección:

1. Crear paquete en `src/main/java/.../nueva/`
2. Implementar `NuevaColeccionExample`
3. Crear Steps en `src/test/java/.../nueva/`
4. Crear feature file en `src/test/resources/features/nueva/`
5. Agregar a `mkdocs.yml` nav
6. Verificar `mvn clean verify`

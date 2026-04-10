# Arquitectura del Proyecto

Estructura y diseño del proyecto.

## Principios

- **BDD/TDD**: Especificación primero, luego implementación
- **Calidad**: Checkstyle, SpotBugs, Spotless, JaCoCo
- **Documentación viva**: Los tests son documentación

## Estructura de paquetes

```
io.github.cazucito.collections/
├── list/           # List implementations
├── set/            # Set implementations
├── map/            # Map implementations
├── queue/          # Queue implementations
├── streams/        # Stream examples
├── algorithm/      # Collections/Arrays utilities
├── generics/       # Advanced generics
└── antipatterns/   # Common mistakes
```

## Patrones utilizados

- **BDD**: Gherkin + Cucumber
- **Factory**: Creación de colecciones
- **Strategy**: Comparadores personalizados

## Próximamente

Documentación arquitectónica detallada.

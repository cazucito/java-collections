# Project Roadmap

> Planificación y milestones del proyecto java-collections

---

## 🎯 Visión

Crear una colección completa de ejemplos del API Java Collections, demostrando
mejores prácticas de desarrollo con BDD/TDD y código de calidad.

---

## 📅 Milestones

### Milestone 1: Fundamentos ✅
**Estado:** Completado  
**Fecha:** 2024-04-08  

- [x] Configuración del proyecto (Maven, Java 21)
- [x] Herramientas de calidad (Checkstyle, SpotBugs, Spotless, JaCoCo)
- [x] Ejemplo ArrayList completo con BDD
- [x] Documentación inicial (AGENTS.md, README.md)
- [x] Estructura de paquetes definida

---

### Milestone 2: Interfaces List
**Estado:** En planificación  
**Fecha estimada:** 2024-04-15  
**Prioridad:** Alta

- [ ] **LinkedList**
  - [ ] Feature file con 4-6 scenarios
  - [ ] Step definitions
  - [ ] Implementación de ejemplo
  - [ ] Diferencias vs ArrayList documentadas

- [ ] **Vector** (opcional, legado)
  - [ ] Breve ejemplo de uso
  - [ ] Nota sobre sincronización

- [ ] **Stack** (opcional, legado)
  - [ ] Ejemplo básico
  - [ ] Referencia a Deque como preferido

---

### Milestone 3: Interfaces Set
**Estado:** Pendiente  
**Fecha estimada:** 2024-04-22  
**Prioridad:** Alta

- [ ] **HashSet**
  - [ ] Feature file
  - [ ] Step definitions
  - [ ] Implementación
  - [ ] Explicar unicidad y hashCode

- [ ] **LinkedHashSet**
  - [ ] Ejemplo de orden de inserción
  - [ ] Comparación con HashSet

- [ ] **TreeSet**
  - [ ] Ejemplo con orden natural
  - [ ] Ejemplo con Comparator
  - [ ] Explicar Comparable vs Comparator

---

### Milestone 4: Interfaces Map
**Estado:** Pendiente  
**Fecha estimada:** 2024-04-29  
**Prioridad:** Alta

- [ ] **HashMap**
  - [ ] Feature file completo
  - [ ] Manejo de colisiones
  - [ ] get/put/remove/clear
  - [ ] Iteración (entrySet, keySet, values)

- [ ] **LinkedHashMap**
  - [ ] Orden de inserción
  - [ ] Casos de uso

- [ ] **TreeMap**
  - [ ] Ordenamiento por clave
  - [ ] Comparator personalizado

- [ ] **EnumMap** (opcional)
  - [ ] Ejemplo con enums

---

### Milestone 5: Interfaces Queue y Deque
**Estado:** Pendiente  
**Fecha estimada:** 2024-05-06  
**Prioridad:** Media

- [ ] **PriorityQueue**
  - [ ] Ordenamiento natural
  - [ ] Comparator
  - [ ] poll/peek/offer

- [ ] **ArrayDeque**
  - [ ] Stack (push/pop)
  - [ ] Queue (add/remove)
  - [ ] Ventajas sobre Stack/LinkedList

- [ ] **LinkedList como Deque**
  - [ ] Doble cola

---

### Milestone 6: Algoritmos y Utilidades
**Estado:** Pendiente  
**Fecha estimada:** 2024-05-13  
**Prioridad:** Media

- [ ] **Collections Utility Class**
  - [ ] sort()
  - [ ] binarySearch()
  - [ ] reverse()
  - [ ] shuffle()
  - [ ] unmodifiableXxx()
  - [ ] synchronizedXxx()

- [ ] **Arrays Utility Class**
  - [ ] asList()
  - [ ] sort()
  - [ ] binarySearch()

---

### Milestone 7: Streams API
**Estado:** Pendiente  
**Fecha estimada:** 2024-05-20  
**Prioridad:** Media

- [ ] **Conceptos Básicos**
  - [ ] stream() vs parallelStream()
  - [ ] filter/map/reduce
  - [ ] collect() con Collectors

- [ ] **Operaciones Intermedias**
  - [ ] filter, map, flatMap
  - [ ] distinct, sorted
  - [ ] peek (debugging)

- [ ] **Operaciones Terminales**
  - [ ] forEach, collect
  - [ ] reduce, count
  - [ ] anyMatch, allMatch, noneMatch

---

### Milestone 8: Features Avanzadas
**Estado:** Pendiente  
**Fecha estimada:** 2024-05-27  
**Prioridad:** Baja

- [ ] **Genericos Avanzados**
  - [ ] Wildcards (? extends, ? super)
  - [ ] Type erasure
  - [ ] Bounded type parameters

- [ ] **Performance**
  - [ ] ArrayList vs LinkedList benchmarks
  - [ ] HashMap capacity y load factor
  - [ ] Iterators vs for-each

- [ ] **Concurrencia**
  - [ ] CopyOnWriteArrayList
  - [ ] ConcurrentHashMap
  - [ ] BlockingQueue

---

### Milestone 9: CI/CD y Automatización
**Estado:** Pendiente  
**Fecha estimada:** 2024-06-03  
**Prioridad:** Baja

- [ ] **GitHub Actions**
  - [ ] Workflow de build
  - [ ] Workflow de tests
  - [ ] Publicación de reportes (JaCoCo, Checkstyle)

- [ ] **SonarCloud** (opcional)
  - [ ] Análisis de código
  - [ ] Cobertura de código

- [ ] **Dependabot**
  - [ ] Configuración avanzada
  - [ ] Agrupación de updates

---

## 📊 Métricas de Éxito

| Métrica | Meta | Actual |
|---------|------|--------|
| Cobertura de código | 80% | 60% |
| Features Gherkin | 20+ | 1 (6 scenarios) |
| Tipos de Collection | 10+ | 1 (ArrayList) |
| Documentación | Completa | Inicial |
| CI/CD | Automatizado | Manual |

---

## 🎯 Criterios de Priorización

### Alta Prioridad
- Interfaces más usadas (List, Set, Map)
- Features críticas para el entendimiento
- Bloqueantes para otros milestones

### Media Prioridad
- Interfaces especializadas (Queue, Deque)
- Features de conveniencia
- Mejoras de documentación

### Baja Prioridad
- Features avanzadas
- Optimizaciones
- Integraciones externas

---

## 🔄 Metodología

1. **Cada Collection = 1 feature branch**
2. **Cada feature branch incluye:**
   - Feature file (Gherkin)
   - Step definitions
   - Implementación
   - Tests pasando
   - Documentación actualizada
3. **Merge a main solo después de:**
   - `mvn clean verify` exitoso
   - Code review (si aplica)
   - Documentación actualizada

---

## 📝 Notas

- Las fechas son estimaciones flexibles
- Prioridades pueden cambiar según necesidades
- Cada milestone debe ser demostrable
- Documentación debe mantenerse actualizada

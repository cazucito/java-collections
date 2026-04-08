# Project Context

> Contexto arquitectónico y decisiones técnicas del proyecto java-collections

---

## 🏗️ Arquitectura

### Tipo de Proyecto
- **Tipo:** Librería/Ejemplos educativos
- **Enfoque:** Specification First (BDD/TDD)
- **Empaquetado:** JAR estándar

### Stack Tecnológico

| Capa | Tecnología | Versión |
|------|------------|---------|
| Lenguaje | Java | 21 LTS |
| Build Tool | Maven | 3.9+ |
| Testing | JUnit 5 | 5.10.1 |
| BDD | Cucumber JVM | 7.14.0 |
| Assertions | AssertJ | 3.27.7 |

### Estructura de Paquetes

```
io.github.cazucito.collections
├── list          # List: ArrayList, LinkedList
├── set           # Set: HashSet, TreeSet, LinkedHashSet
├── map           # Map: HashMap, TreeMap, LinkedHashMap
├── queue         # Queue: PriorityQueue, Deque
└── utils         # Utilidades comunes
```

---

## 🎯 Decisiones Técnicas (ADRs)

### ADR-001: Enfoque BDD con Cucumber
**Estado:** Aceptado  
**Fecha:** 2024-04-08  

**Contexto:** Necesitamos ejemplos claros del API Collections que sirvan como documentación viva.

**Decisión:** Usar Cucumber JVM con Gherkin para especificar comportamiento antes de implementar.

**Consecuencias:**
- ✅ Documentación ejecutable
- ✅ Tests legibles para no-desarrolladores
- ✅ Especificaciones en español neutro
- ❌ Overhead de mantener feature files

---

### ADR-002: Convención de Idiomas
**Estado:** Aceptado  
**Fecha:** 2024-04-08  

**Contexto:** El código debe ser profesional pero accesible para hablantes de español.

**Decisión:**
- Código fuente (clases, métodos, variables): **Inglés**
- Documentación y comentarios: **Español neutro**
- Commits: **Español neutro** (Conventional Commits)

**Consecuencias:**
- ✅ Código universal y reusable
- ✅ Documentación comprensible para el equipo
- ✅ Commits claros en el idioma del equipo

---

### ADR-003: Ubicación de Configuraciones de Calidad
**Estado:** Aceptado  
**Fecha:** 2024-04-08  

**Contexto:** Checkstyle y SpotBugs son herramientas de validación, no de producción.

**Decisión:** Mover configuraciones de `config/` a `src/test/resources/config/`.

**Consecuencias:**
- ✅ Separación clara entre código y config de testing
- ✅ Root del proyecto más limpio
- ✅ Configuraciones en contexto de test

---

### ADR-004: Gestión de Dependencias
**Estado:** Aceptado  
**Fecha:** 2024-04-08  

**Contexto:** Vulnerabilidades en dependencias transitivas (commons-compress, commons-io).

**Decisión:** Usar `dependencyManagement` en pom.xml para forzar versiones seguras.

**Consecuencias:**
- ✅ Control explícito de versiones
- ✅ Corrección de CVEs conocidos
- ⚠️ Requiere mantenimiento manual

---

## 📊 Estado de Features

| Feature | Estado | Notas |
|---------|--------|-------|
| ArrayList | ✅ Completo | Ejemplo de referencia |
| LinkedList | ⏳ Pendiente | - |
| HashSet | ⏳ Pendiente | - |
| TreeSet | ⏳ Pendiente | - |
| HashMap | ⏳ Pendiente | - |
| TreeMap | ⏳ Pendiente | - |
| PriorityQueue | ⏳ Pendiente | - |
| Deque | ⏳ Pendiente | - |
| Streams | ⏳ Pendiente | - |

---

## 🔧 Calidad de Código

### Herramientas Configuradas
- **Checkstyle:** Validación de estilo (Google Java Style)
- **SpotBugs:** Detección de bugs estáticos
- **Spotless:** Formateo automático de código
- **JaCoCo:** Cobertura de código (mínimo 60%)

### Ejecución
```bash
# Verificar todo
mvn clean verify

# Solo calidad de código
mvn checkstyle:check spotbugs:check spotless:check

# Formatear código
mvn spotless:apply
```

---

## 📚 Referencias Externas

- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Cucumber JVM Documentation](https://cucumber.io/docs/installation/java/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

---

## 🔄 Changelog de Decisiones

| Fecha | Decisión | Motivo |
|-------|----------|--------|
| 2024-04-08 | Java 21 LTS | Versión estable con soporte extendido |
| 2024-04-08 | Maven vs Gradle | Mayor adopción en enterprise Java |
| 2024-04-08 | Cucumber + JUnit 5 | Estandar de la industria para BDD en Java |

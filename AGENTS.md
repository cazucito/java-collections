# AGENTS.md - Guide for AI Agents

> **Repository:** java-collections  
> **Purpose:** Demonstrate the use of the Java Collections API using a specification-first approach (BDD/TDD)

---

## ⚠️ IMPORTANT: Decisions Requiring User Confirmation

**The following changes MUST be confirmed with the user before implementation:**

- **Java Version changes** (currently Java 17 LTS)
- **Adding or removing dependencies** in `pom.xml`
- **Adding or removing features** from the project
- **Version upgrades** of any tool or library (Checkstyle, SpotBugs, Cucumber, etc.)
- **Structural changes** to the project architecture
- **Changes to quality gates** or code coverage thresholds

**Always ask the user before making these types of changes.**

---

## 📚 Agent Context Files

Este proyecto usa archivos de contexto extendidos ubicados en `.agents/` para mantener
información entre sesiones de trabajo.

### Archivos Disponibles

| Archivo | Propósito | Leer cuando... | Actualizar cuando... |
|---------|-----------|----------------|---------------------|
| [`.agents/README.md`](.agents/README.md) | Índice y guía de uso | Primera vez | Nuevo archivo agregado |
| [`.agents/HANDOFF.md`](.agents/HANDOFF.md) | Estado actual del trabajo | **Iniciar sesión** | **Terminar sesión** |
| [`.agents/CONTEXT.md`](.agents/CONTEXT.md) | Decisiones arquitectónicas | Planificar features | Cambiar arquitectura |
| [`.agents/MEMORY.md`](.agents/MEMORY.md) | Lecciones aprendidas | Antes de decisiones | Aprender algo nuevo |
| [`.agents/STATE.md`](.agents/STATE.md) | Estado técnico del entorno | Debugging | Cambiar configuración |
| [`.agents/SESSION.md`](.agents/SESSION.md) | Log de sesión actual | N/A | Durante la sesión |
| [`.agents/PLAN.md`](.agents/PLAN.md) | Roadmap y planificación | Priorizar trabajo | Completar milestones |

### Flujo de Trabajo Recomendado

**AL INICIAR CADA SESIÓN:**
1. Leer `.agents/HANDOFF.md` para entender el estado actual
2. Leer `.agents/CONTEXT.md` para recordar arquitectura
3. Leer `.agents/MEMORY.md` para evitar errores conocidos

**ANTES DE TERMINAR:**
1. Actualizar `.agents/HANDOFF.md` con el nuevo estado
2. Actualizar `.agents/SESSION.md` con log de la sesión
3. Limpiar `.agents/SESSION.md` si es necesario

---

## 📋 Project Conventions

### Languages
- **Source code:** English (class names, methods, variables, constants)
- **Documentation and comments:** Neutral Spanish
- **Commits:** Neutral Spanish, following Conventional Commits

### Java Version
- **Java 21** (LTS) - Source and target compatibility

### Naming Conventions

| Element | Convention | Example |
|---------|------------|---------|
| Classes | UpperCamelCase | `ListExamples`, `HashSetDemo` |
| Interfaces | UpperCamelCase (adjective/noun) | `Sortable`, `CollectionOperations` |
| Methods | lowerCamelCase (verb + action) | `addElement()`, `sortByName()` |
| Variables | lowerCamelCase | `studentList`, `elementCount` |
| Constants | UPPER_SNAKE_CASE | `MAX_CAPACITY`, `DEFAULT_SIZE` |
| Packages | lowercase, reversed domain | `io.github.cazucito.collections.list` |
| Tests | ClassName + Test | `ArrayListTest`, `HashMapFeatures` |
| Feature files | snake_case.feature | `set_operations.feature` |

### Package Structure

```
io.github.cazucito.collections
├── list          # List examples: ArrayList, LinkedList, etc.
├── set           # Set examples: HashSet, TreeSet, etc.
├── map           # Map examples: HashMap, TreeMap, etc.
├── queue         # Queue examples: PriorityQueue, Deque, etc.
└── utils         # Common utilities
```

---

## 🧪 Development Approach: Specification First

This project follows **BDD (Behavior Driven Development)** complemented by **TDD**.

### Workflow

1. **Specify:** Write `.feature` file with Gherkin (Given-When-Then)
2. **Define:** Create empty step definitions
3. **Implement:** Write minimal code to make tests pass
4. **Refactor:** Improve code while keeping tests green

### Test Location

```
src/
├── main/java/           # Source code
└── test/
    ├── java/            # Step definitions and unit tests
    └── resources/       # Cucumber .feature files
```

---

## 📝 Commit Conventions (Conventional Commits)

Format: `<type>(<scope>): <description>`

### Types

| Type | Use | Example |
|------|-----|---------|
| `feat` | New functionality | `feat(set): agregar ejemplo de HashSet único` |
| `fix` | Bug fix | `fix(list): corregir índice en ArrayListExample` |
| `docs` | Documentation | `docs(readme): actualizar instrucciones de ejecución` |
| `style` | Format changes (no logic change) | `style: aplicar formato con Spotless` |
| `refactor` | Code refactoring | `refactor(map): simplificar lógica de búsqueda` |
| `test` | Add or modify tests | `test(queue): agregar tests para PriorityQueue` |
| `chore` | Maintenance tasks | `chore(deps): actualizar versión de Cucumber` |

### Common Scopes
- `list` - Changes related to List
- `set` - Changes related to Set
- `map` - Changes related to Map
- `queue` - Changes related to Queue
- `deps` - Dependencies
- `config` - Project configuration
- `ci` - Continuous integration

### Examples

```bash
# New functionality
feat(list): agregar ejemplo de ordenamiento con Comparator

# Fix
fix(set): validar elemento nulo antes de agregar

# Tests
test(map): agregar escenario de colisión de hash

# Documentation
docs: explicar diferencias entre ArrayList y LinkedList
```

---

## 🏷️ Semantic Versioning (SemVer)

Format: `MAJOR.MINOR.PATCH`

| Version | When to increment | Example |
|---------|-------------------|---------|
| MAJOR (X.0.0) | Incompatible API changes | Removing examples or changing packages |
| MINOR (0.X.0) | Backward-compatible new features | Adding new Collections examples |
| PATCH (0.0.X) | Bug fixes | Fix in existing examples |

### Git Tags

```bash
# Create version tag
git tag -a v1.2.0 -m "feat: agregar ejemplos de Streams con Collections"

# Push tags
git push origin --tags
```

---

## 🔧 Code Quality Tools

### Checkstyle
- Verifies style conventions
- Configuration: `src/test/resources/config/checkstyle/checkstyle.xml`
- Execution: `mvn checkstyle:check`

### Spotless
- Automatic code formatting
- Based on Google Java Format
- Execution: `mvn spotless:apply` (format) / `mvn spotless:check` (verify)

### SpotBugs
- Detects potential bugs
- Execution: `mvn spotbugs:check`

### JaCoCo
- Code coverage
- Report: `target/site/jacoco/index.html`
- Execution: `mvn jacoco:report`

### Full Execution

```bash
# Verify everything (before commit)
mvn clean verify

# Verify only code quality
mvn checkstyle:check spotbugs:check spotless:check

# Automatically format code
mvn spotless:apply
```

---

## 🎯 Code Standards

### Important Rules

1. **All classes must have Javadoc** (in neutral Spanish)
   ```java
   /**
    * Ejemplifica el uso de ArrayList para almacenar elementos.
    * Demuestra operaciones básicas como agregar, eliminar y acceder.
    */
   public class ArrayListExample {
   ```

2. **All public methods must have Javadoc** (in neutral Spanish)
   ```java
   /**
    * Agrega un elemento a la lista si no está duplicado.
    *
    * @param element el elemento a agregar
    * @return true si se agregó, false si ya existía
    */
   public boolean addUniqueElement(String element) {
   ```

3. **Comments in neutral Spanish explaining complex logic**
   ```java
   // Se utiliza LinkedList en lugar de ArrayList porque
   // requerimos inserciones frecuentes al inicio de la colección
   ```

4. **Descriptive names, code in English**
   ```java
   // ❌ Incorrect
   List<String> l = new ArrayList<>();
   
   // ✅ Correct
   List<String> activeStudents = new ArrayList<>();
   ```

5. **Use `final` for immutable variables**
   ```java
   final List<String> immutableList = List.of("a", "b", "c");
   ```

6. **Avoid raw types**
   ```java
   // ❌ Incorrect
   List list = new ArrayList();
   
   // ✅ Correct
   List<String> names = new ArrayList<>();
   ```

---

## 🚀 Useful Commands

```bash
# Compile project
mvn clean compile

# Run all tests
mvn test

# Run Cucumber tests
mvn test -Dcucumber.plugin=pretty

# Full code quality verification
mvn clean verify

# Generate coverage report
mvn jacoco:report

# Format code
mvn spotless:apply

# Install to local repository
mvn clean install
```

---

## 📚 Additional Resources

- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Cucumber JVM Documentation](https://cucumber.io/docs/installation/java/)
- [Conventional Commits](https://www.conventionalcommits.org/)
- [Semantic Versioning](https://semver.org/lang/es/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

---

**Note for AI Agents:**
- Always verify that code passes `mvn spotless:check` before finishing
- Maintain consistency with existing examples
- Document design decisions in comments (neutral Spanish)
- Strictly follow the specified commit format

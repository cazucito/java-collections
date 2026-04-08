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

This project uses extended context files located in `.agents/` to maintain
information between work sessions.

### Available Files

| File | Purpose | Read when... | Update when... |
|------|---------|--------------|----------------|
| [`.agents/README.md`](.agents/README.md) | Index and usage guide | First time | New file added |
| [`.agents/HANDOFF.md`](.agents/HANDOFF.md) | Current work status | **Start session** | **End session** |
| [`.agents/CONTEXT.md`](.agents/CONTEXT.md) | Architectural decisions | Planning features | Architecture changes |
| [`.agents/MEMORY.md`](.agents/MEMORY.md) | Lessons learned | Before decisions | Learn something new |
| [`.agents/STATE.md`](.agents/STATE.md) | Technical environment state | Debugging | Configuration changes |
| [`.agents/SESSION.md`](.agents/SESSION.md) | Current session log | N/A | During session |
| [`.agents/PLAN.md`](.agents/PLAN.md) | Roadmap and planning | Prioritizing work | Milestones completed |

### Recommended Workflow

**WHEN STARTING A SESSION:**
1. Read `.agents/HANDOFF.md` to understand current status
2. Read `.agents/CONTEXT.md` to remember architecture
3. Read `.agents/MEMORY.md` to avoid known errors

**BEFORE ENDING:**
1. Update `.agents/HANDOFF.md` with new status
2. Update `.agents/SESSION.md` with session log
3. Clean up `.agents/SESSION.md` if needed

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
| `feat` | New functionality | `feat(set): add unique HashSet example` |
| `fix` | Bug fix | `fix(list): fix index in ArrayListExample` |
| `docs` | Documentation | `docs(readme): update execution instructions` |
| `style` | Format changes (no logic change) | `style: apply Spotless formatting` |
| `refactor` | Code refactoring | `refactor(map): simplify search logic` |
| `test` | Add or modify tests | `test(queue): add tests for PriorityQueue` |
| `chore` | Maintenance tasks | `chore(deps): update Cucumber version` |

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
feat(list): add sorting example with Comparator

# Fix
fix(set): validate null element before adding

# Tests
test(map): add hash collision scenario

# Documentation
docs: explain differences between ArrayList and LinkedList
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
git tag -a v1.2.0 -m "feat: add Streams with Collections examples"

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
    * Demonstrates the use of ArrayList to store elements.
    * Shows basic operations such as adding, removing, and accessing.
    */
   public class ArrayListExample {
   ```

2. **All public methods must have Javadoc** (in neutral Spanish)
   ```java
   /**
    * Adds an element to the list if it is not duplicated.
    *
    * @param element the element to add
    * @return true if added, false if it already existed
    */
   public boolean addUniqueElement(String element) {
   ```

3. **Comments in neutral Spanish explaining complex logic**
   ```java
   // LinkedList is used instead of ArrayList because
   // we require frequent insertions at the beginning of the collection
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
- [Semantic Versioning](https://semver.org/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

---

**Note for AI Agents:**
- Always verify that code passes `mvn spotless:check` before finishing
- Maintain consistency with existing examples
- Document design decisions in comments (neutral Spanish)
- Strictly follow the specified commit format

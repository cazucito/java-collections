# Project Context

> Architectural context and technical decisions for java-collections project

---

## 🏗️ Architecture

### Project Type
- **Type:** Library/Educational Examples
- **Approach:** Specification First (BDD/TDD)
- **Packaging:** Standard JAR

### Technology Stack

| Layer | Technology | Version |
|-------|------------|---------|
| Language | Java | 21 LTS |
| Build Tool | Maven | 3.9+ |
| Testing | JUnit 5 | 5.10.1 |
| BDD | Cucumber JVM | 7.14.0 |
| Assertions | AssertJ | 3.27.7 |

### Package Structure

```
io.github.cazucito.collections
├── list          # List: ArrayList, LinkedList
├── set           # Set: HashSet, TreeSet, LinkedHashSet
├── map           # Map: HashMap, TreeMap, LinkedHashMap
├── queue         # Queue: PriorityQueue, Deque
└── utils         # Common utilities
```

---

## 🎯 Technical Decisions (ADRs)

### ADR-001: BDD Approach with Cucumber
**Status:** Accepted  
**Date:** 2024-04-08  

**Context:** We need clear examples of the Collections API that serve as living documentation.

**Decision:** Use Cucumber JVM with Gherkin to specify behavior before implementing.

**Consequences:**
- ✅ Executable documentation
- ✅ Readable tests for non-developers
- ✅ Specifications in neutral Spanish
- ❌ Overhead of maintaining feature files

---

### ADR-002: Language Convention
**Status:** Accepted  
**Date:** 2024-04-08  

**Context:** Code must be professional but accessible to Spanish speakers.

**Decision:**
- Source code (classes, methods, variables): **English**
- Documentation and comments: **Neutral Spanish**
- Commits: **English** (Conventional Commits)
- Gherkin Features: **Neutral Spanish** (with `# language: es` header)

**Consequences:**
- ✅ Universal and reusable code
- ✅ Documentation and specifications understandable for the team
- ✅ Clear commits in English for broader compatibility
- ✅ Gherkin features readable by Spanish-speaking stakeholders

---

### ADR-003: Quality Configurations Location
**Status:** Accepted  
**Date:** 2024-04-08  

**Context:** Checkstyle and SpotBugs are validation tools, not production tools.

**Decision:** Move configurations from `config/` to `src/test/resources/config/`.

**Consequences:**
- ✅ Clear separation between code and test config
- ✅ Cleaner project root
- ✅ Configurations in test context

---

### ADR-004: Dependency Management
**Status:** Accepted  
**Date:** 2024-04-08  

**Context:** Vulnerabilities in transitive dependencies (commons-compress, commons-io).

**Decision:** Use `dependencyManagement` in pom.xml to force secure versions.

**Consequences:**
- ✅ Explicit version control
- ✅ Correction of known CVEs
- ⚠️ Requires manual maintenance

---

## 📊 Feature Status

| Feature | Status | Notes |
|---------|--------|-------|
| ArrayList | ✅ Complete | Reference example |
| LinkedList | ✅ Complete | 11 BDD scenarios implemented |
| HashSet | ✅ Complete | 10 BDD scenarios implemented |
| TreeSet | ⏳ Pending | - |
| HashMap | ⏳ Pending | - |
| TreeMap | ⏳ Pending | - |
| PriorityQueue | ⏳ Pending | - |
| Deque | ⏳ Pending | - |
| Streams | ⏳ Pending | - |

---

## 🔧 Code Quality

### Configured Tools
- **Checkstyle:** Style validation (Google Java Style)
- **SpotBugs:** Static bug detection
- **Spotless:** Automatic code formatting
- **JaCoCo:** Code coverage (minimum 60%)

### Execution
```bash
# Verify everything
mvn clean verify

# Code quality only
mvn checkstyle:check spotbugs:check spotless:check

# Format code
mvn spotless:apply
```

---

## 📚 External References

- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Cucumber JVM Documentation](https://cucumber.io/docs/installation/java/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

---

## 🔄 Decision Changelog

| Date | Decision | Reason |
|------|----------|--------|
| 2024-04-08 | Java 21 LTS | Stable version with extended support |
| 2024-04-08 | Maven vs Gradle | Greater adoption in enterprise Java |
| 2024-04-08 | Cucumber + JUnit 5 | Industry standard for BDD in Java |

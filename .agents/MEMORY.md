# Agent Memory

> Lessons learned, user preferences, and common errors to avoid

---

## 👤 User Preferences

### Changes that REQUIRE prior confirmation
- ❌ **Java Version changes** (current: 21 LTS)
- ❌ **Adding/removing dependencies** in pom.xml
- ❌ **Adding/removing features** from the project
- ❌ **Version upgrades** of tools (Checkstyle, SpotBugs, Cucumber, etc.)
- ❌ **Structural changes** to architecture
- ❌ **Changes to quality gates** or coverage thresholds

**Rule:** Always ask before these changes.

### Established Conventions
- **Source code:** English (classes, methods, variables)
- **Comments:** Neutral Spanish
- **Commits:** Neutral Spanish (Conventional Commits)
- **Documentation:** English (AGENTS.md, README.md)
- **Gherkin Features:** Neutral Spanish

### Language by File Type
| File Type | Language |
|-----------|----------|
| `.java` | Code: English, Comments: Neutral Spanish |
| `.feature` | Neutral Spanish |
| `.md` (root) | English |
| `.md` (.agents/) | English |
| Commits | Neutral Spanish |

---

## 📖 Lessons Learned

### Lesson 001: Checkstyle vs Spotless
**Problem:** Checkstyle required blank line between Javadoc and `package`, but Spotless (Google Java Format) removed it.

**Solution:** Remove `PACKAGE_DEF` from `EmptyLineSeparator` rule in checkstyle.xml.

**Reference:** Commit `c68ec31`

---

### Lesson 002: Java 21 vs Java 17
**Problem:** pom.xml configured for Java 21 but system had Java 17 installed.

**Solution:** Detect installed Java version before configuring or ask user.

**Note:** User installed Java 21 later, but better to verify first.

---

### Lesson 003: junit-platform-suite Dependency
**Problem:** Cucumber with JUnit 5 requires `junit-platform-suite` not in dependencies.

**Solution:** Add explicitly:
```xml
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-suite</artifactId>
    <version>1.10.1</version>
    <scope>test</scope>
</dependency>
```

---

### Lesson 004: Spotless Overwrites Format
**Problem:** When running `mvn spotless:apply`, manual format changes not matching Google Java Style are lost.

**Solution:** Always run `mvn spotless:apply` before commit to avoid surprises.

---

### Lesson 005: Dependabot vs Manual
**Problem:** Trying to resolve vulnerabilities manually by updating plugins.

**Solution:** GitHub Dependabot creates automatic PRs that are more reliable. Accepting them is preferred.

**Example:** AssertJ 3.24.2 → 3.27.7 resolved via Dependabot PR #1.

---

### Lesson 006: Quality Configurations in src/test/resources
**Problem:** Checkstyle/SpotBugs configurations in root (`config/`) didn't reflect they are for testing.

**Solution:** Move to `src/test/resources/config/` for semantic clarity.

---

## ⚠️ Common Errors and How to Avoid Them

### Error: Forgetting `junit-platform-suite`
**Symptom:** `package org.junit.platform.suite.api does not exist`  
**Prevention:** Always verify this dependency when setting up Cucumber + JUnit 5

### Error: Inconsistent Java Version
**Symptom:** `invalid target release: 21`  
**Prevention:** Verify `java -version` before configuring pom.xml

### Error: Checkstyle/Spotless Conflict
**Symptom:** Checkstyle fails after `spotless:apply`  
**Prevention:** Ensure checkstyle.xml is compatible with Google Java Format

### Error: Vulnerable Transitive Dependencies
**Symptom:** GitHub Dependabot alerts CVEs  
**Prevention:** Use `dependencyManagement` to force secure versions or wait for Dependabot PRs

---

## 💡 Tips and Tricks

### Useful Commands
```bash
# Verify everything before commit
mvn clean verify

# Tests only
mvn test

# Code quality only
mvn checkstyle:check spotbugs:check spotless:check

# Format everything
mvn spotless:apply

# Coverage report
mvn jacoco:report
# Open: target/site/jacoco/index.html
```

### BDD/TDD Flow
1. Write `.feature` with Gherkin scenarios
2. Create `*Steps.java` empty (Cucumber detects them)
3. Implement minimum code
4. Refactor keeping tests green

### Commit Convention
```
feat(list): add sorting example
fix(set): validate null element
test(map): add collision scenario
docs(readme): update instructions
style: apply Spotless formatting
refactor(queue): simplify logic
chore(deps): update Cucumber version
```

---

## 📚 Useful Resources

### Official Documentation
- [Java 21 API](https://docs.oracle.com/en/java/javase/21/docs/api/)
- [Cucumber JVM](https://cucumber.io/docs/installation/java/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ](https://assertj.github.io/doc/)

### Style Guides
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Conventional Commits](https://www.conventionalcommits.org/)

---

## 🔮 Predictions

### Likely Future Needs
1. **GitHub Actions** - Automated CI/CD
2. **SonarQube** - Deeper code analysis
3. **Streams Examples** - With lambdas and method references
4. **Performance Tests** - Compare ArrayList vs LinkedList
5. **Mutation Testing** - With PIT (optional)

---

## 📝 Notes for Future Agents

- This project is **educational**, code must be clear before optimized
- Examples should be **self-contained** and easy to understand
- **Always** run `mvn clean verify` before finishing
- **Never** assume permission to change versions or add dependencies
- If something is unclear, **ask the user**

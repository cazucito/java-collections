# System State

> Technical state of the development environment

**Last Updated:** 2024-04-08  
**System:** macOS (aarch64)

---

## ☕ Java Environment

### Installed Version
```
openjdk version "17.0.17" 2025-10-21
OpenJDK Runtime Environment Temurin-17.0.17+10
OpenJDK 64-Bit Server VM (build 17.0.17+10, mixed mode, sharing)
```

**Note:** Project configured for Java 21 LTS but system has Java 17 installed.

### Available SDKs (SDKMAN)
```
~/.sdkman/candidates/java/
├── 17.0.17-tem/
└── current -> 17.0.17-tem/
```

### Java 21 - Installation Instructions
To install Java 21 (required by project):

```bash
# List available versions
sdk list java | grep "21\."

# Install Temurin 21 (recommended)
sdk install java 21.0.2-tem

# Set as default
sdk default java 21.0.2-tem

# Verify
java -version
```

---

## 🔨 Maven

### Version
```
Apache Maven 3.9.14
Maven home: /opt/homebrew/Cellar/maven/3.9.14/libexec
Java version: 17.0.17, vendor: Eclipse Adoptium
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "26.3.1", arch: "aarch64"
```

### Installation
```bash
brew install maven
```

---

## 📁 Project Structure

```
java-collections/
├── AGENTS.md                          # Agent guide (root)
├── pom.xml                            # Maven build
├── README.md                          # User documentation
├── .agents/                           # Context files
├── .gitignore                         # Git exclusions
└── src/
    ├── main/java/io/github/cazucito/collections/
    │   ├── Main.java
    │   └── list/
    │       └── ArrayListExample.java
    └── test/
        ├── java/io/github/cazucito/collections/
        │   ├── RunCucumberTest.java
        │   └── list/
        │       └── ArrayListSteps.java
        └── resources/
            ├── config/
            │   ├── checkstyle/
            │   │   ├── checkstyle.xml
            │   │   └── suppressions.xml
            │   └── spotbugs/
            │       └── include-filter.xml
            └── features/
                └── list/
                    └── arraylist_operations.feature
```

---

## ✅ Build Status

### Last Verification
```bash
$ mvn clean verify

[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] Total time: 3.639 s
```

### Quality Gates
| Tool | Status | Thresholds |
|------|--------|------------|
| Checkstyle | ✅ PASS | 0 violations |
| SpotBugs | ✅ PASS | 0 bugs |
| Spotless | ✅ PASS | Format correct |
| JaCoCo | ✅ PASS | 60% instructions, 50% branches |
| Tests | ✅ PASS | 6/6 passing |

---

## 🔧 Active Configurations

### Maven Properties (pom.xml)
```properties
maven.compiler.source=21
maven.compiler.target=21
junit.version=5.10.1
cucumber.version=7.14.0
assertj.version=3.27.7
checkstyle.version=3.5.0
spotbugs.version=4.8.6.0
spotless.version=2.43.0
jacoco.version=0.8.12
```

### Forced Transitive Dependencies
```xml
<dependencyManagement>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-compress</artifactId>
        <version>1.26.2</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.16.1</version>
    </dependency>
</dependencyManagement>
```

---

## 🌐 GitHub Integration

### Remote Repository
```
git@github.com:cazucito/java-collections.git
```

### Dependabot
- ✅ Active and working
- ✅ PR #1 accepted (AssertJ 3.27.7)
- ✅ No known vulnerabilities currently

---

## ⚠️ Known Issues

### 1. Java Version Mismatch
**Status:** ⚠️ Warning  
**Description:** Project requires Java 21, system has Java 17  
**Impact:** Build will fail if Java 21 not installed  
**Solution:** Install Java 21 via SDKMAN or Homebrew

---

## 🚀 Verification Commands

```bash
# Verify Java version
java -version

# Verify Maven
mvn -version

# Verify structure
tree -L 3

# Full build
mvn clean verify

# Tests only
mvn test

# Code quality
mvn checkstyle:check spotbugs:check spotless:check

# Coverage report
mvn jacoco:report
open target/site/jacoco/index.html
```

---

## 📊 Current Metrics

| Metric | Value |
|--------|-------|
| Production classes | 2 |
| Test classes | 2 |
| Gherkin Features | 1 (6 scenarios) |
| Code coverage | >60% |
| Lines of code | ~500 |
| Direct dependencies | 4 (test scope) |
| Vulnerabilities | 0 |

---

## 📝 Notes

- Operating system: macOS (ARM64/aarch64)
- Package manager: Homebrew
- Java version manager: SDKMAN
- Recommended IDE: IntelliJ IDEA or VS Code
- Terminal: zsh

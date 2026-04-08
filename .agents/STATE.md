# System State

> Estado técnico del entorno de desarrollo

**Última actualización:** 2024-04-08  
**Sistema:** macOS (aarch64)

---

## ☕ Java Environment

### Versión Instalada
```
openjdk version "17.0.17" 2025-10-21
OpenJDK Runtime Environment Temurin-17.0.17+10
OpenJDK 64-Bit Server VM (build 17.0.17+10, mixed mode, sharing)
```

**Nota:** Proyecto configurado para Java 21 LTS pero sistema tiene Java 17 instalado.

### SDKs Disponibles (SDKMAN)
```
~/.sdkman/candidates/java/
├── 17.0.17-tem/
└── current -> 17.0.17-tem/
```

### Java 21 - Instrucciones de Instalación
Para instalar Java 21 (requerido por el proyecto):

```bash
# Listar versiones disponibles
sdk list java | grep "21\."

# Instalar Temurin 21 (recomendado)
sdk install java 21.0.2-tem

# Establecer como default
sdk default java 21.0.2-tem

# Verificar
java -version
```

---

## 🔨 Maven

### Versión
```
Apache Maven 3.9.14
Maven home: /opt/homebrew/Cellar/maven/3.9.14/libexec
Java version: 17.0.17, vendor: Eclipse Adoptium
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "26.3.1", arch: "aarch64"
```

### Instalación
```bash
brew install maven
```

---

## 📁 Estructura del Proyecto

```
java-collections/
├── AGENTS.md                          # Guía para agentes (root)
├── pom.xml                            # Maven build
├── README.md                          # Documentación usuario
├── .agents/                           # Archivos de contexto
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

## ✅ Estado del Build

### Última Verificación
```bash
$ mvn clean verify

[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] Total time: 3.639 s
```

### Quality Gates
| Herramienta | Estado | Umbrales |
|-------------|--------|----------|
| Checkstyle | ✅ PASS | 0 violaciones |
| SpotBugs | ✅ PASS | 0 bugs |
| Spotless | ✅ PASS | Formato correcto |
| JaCoCo | ✅ PASS | 60% instrucciones, 50% branches |
| Tests | ✅ PASS | 6/6 pasando |

---

## 🔧 Configuraciones Activas

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

### Dependencias Transitivas Forzadas
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

### Repositorio Remoto
```
git@github.com:cazucito/java-collections.git
```

### Dependabot
- ✅ Activo y funcionando
- ✅ PR #1 aceptada (AssertJ 3.27.7)
- ✅ Sin vulnerabilidades conocidas actualmente

---

## ⚠️ Problemas Conocidos

### 1. Java Version Mismatch
**Estado:** ⚠️ Warning  
**Descripción:** Proyecto requiere Java 21, sistema tiene Java 17  
**Impacto:** Build fallará si no se instala Java 21  
**Solución:** Instalar Java 21 via SDKMAN o Homebrew

---

## 🚀 Comandos de Verificación

```bash
# Verificar versión de Java
java -version

# Verificar Maven
mvn -version

# Verificar estructura
tree -L 3

# Build completo
mvn clean verify

# Solo tests
mvn test

# Calidad de código
mvn checkstyle:check spotbugs:check spotless:check

# Reporte de cobertura
mvn jacoco:report
open target/site/jacoco/index.html
```

---

## 📊 Métricas Actuales

| Métrica | Valor |
|---------|-------|
| Clases de producción | 2 |
| Clases de test | 2 |
| Features Gherkin | 1 (6 scenarios) |
| Cobertura de código | >60% |
| Líneas de código | ~500 |
| Dependencias directas | 4 (test scope) |
| Vulnerabilidades | 0 |

---

## 📝 Notas

- Sistema operativo: macOS (ARM64/aarch64)
- Package manager: Homebrew
- Java version manager: SDKMAN
- IDE recomendado: IntelliJ IDEA o VS Code
- Terminal: zsh

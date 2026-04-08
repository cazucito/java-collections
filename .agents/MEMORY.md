# Agent Memory

> Lecciones aprendidas, preferencias del usuario y errores comunes a evitar

---

## 👤 Preferencias del Usuario

### Decisiones que REQUIEREN confirmación previa
- ❌ **Cambios de versión de Java** (actual: 21 LTS)
- ❌ **Agregar/eliminar dependencias** en pom.xml
- ❌ **Agregar/eliminar features** del proyecto
- ❌ **Version upgrades** de herramientas (Checkstyle, SpotBugs, Cucumber, etc.)
- ❌ **Cambios estructurales** a la arquitectura
- ❌ **Cambios a quality gates** o umbrales de cobertura

**Regla:** Siempre preguntar antes de estos cambios.

### Convenciones Establecidas
- **Código fuente:** Inglés (clases, métodos, variables)
- **Comentarios:** Español neutro
- **Commits:** Español neutro (Conventional Commits)
- **Documentación:** Inglés (AGENTS.md, README.md)
- **Features Gherkin:** Español neutro

### Idiomas por Tipo de Archivo
| Tipo de Archivo | Idioma |
|-----------------|--------|
| `.java` | Código: Inglés, Comentarios: Español neutro |
| `.feature` | Español neutro |
| `.md` (root) | Inglés |
| `.md` (.agents/) | Inglés |
| Commits | Español neutro |

---

## 📖 Lecciones Aprendidas

### Lección 001: Checkstyle y Spotless
**Problema:** Checkstyle requería línea en blanco entre Javadoc y `package`, pero Spotless (Google Java Format) la eliminaba.

**Solución:** Quitar `PACKAGE_DEF` de la regla `EmptyLineSeparator` en checkstyle.xml.

**Referencia:** Commit `c68ec31`

---

### Lección 002: Java 21 vs Java 17
**Problema:** pom.xml configurado para Java 21 pero sistema tenía Java 17 instalado.

**Solución:** Detectar versión de Java instalada antes de configurar o preguntar al usuario.

**Nota:** El usuario instaló Java 21 después, pero es mejor verificar primero.

---

### Lección 003: Dependencia junit-platform-suite
**Problema:** Cucumber con JUnit 5 requiere `junit-platform-suite` que no estaba en dependencias.

**Solución:** Agregar explícitamente:
```xml
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-suite</artifactId>
    <version>1.10.1</version>
    <scope>test</scope>
</dependency>
```

---

### Lección 004: Spotless sobreescribe formato
**Problema:** Al aplicar `mvn spotless:apply`, se pierden cambios manuales de formato que no cumplen Google Java Style.

**Solución:** Siempre ejecutar `mvn spotless:apply` antes de commit para evitar sorpresas.

---

### Lección 005: Dependabot vs Manual
**Problema:** Intentar resolver vulnerabilidades manualmente actualizando plugins.

**Solución:** Dependabot de GitHub crea PRs automáticas que son más confiables. Aceptarlas es preferible.

**Ejemplo:** AssertJ 3.24.2 → 3.27.7 resuelto via Dependabot PR #1.

---

### Lección 006: Configuraciones de Calidad en src/test/resources
**Problema:** Configuraciones de Checkstyle/SpotBugs en root (`config/`) no reflejan que son de testing.

**Solución:** Mover a `src/test/resources/config/` para claridad semántica.

---

## ⚠️ Errores Comunes y Cómo Evitarlos

### Error: Olvidar `junit-platform-suite`
**Síntoma:** `package org.junit.platform.suite.api does not exist`  
**Prevención:** Siempre verificar esta dependencia cuando se configura Cucumber + JUnit 5

### Error: Versión de Java inconsistente
**Síntoma:** `invalid target release: 21`  
**Prevención:** Verificar `java -version` antes de configurar pom.xml

### Error: Conflicto Checkstyle/Spotless
**Síntoma:** Checkstyle falla después de `spotless:apply`  
**Prevención:** Asegurar que checkstyle.xml sea compatible con Google Java Format

### Error: Dependencias transitivas vulnerables
**Síntoma:** GitHub Dependabot alerta de CVEs  
**Prevención:** Usar `dependencyManagement` para forzar versiones seguras o esperar PRs de Dependabot

---

## 💡 Tips y Trucos

### Comandos Útiles
```bash
# Verificar todo antes de commit
mvn clean verify

# Solo tests
mvn test

# Solo calidad de código
mvn checkstyle:check spotbugs:check spotless:check

# Formatear todo
mvn spotless:apply

# Reporte de cobertura
mvn jacoco:report
# Abrir: target/site/jacoco/index.html
```

### Flujo BDD/TDD
1. Escribir `.feature` con scenarios Gherkin
2. Crear `*Steps.java` vacíos (Cucumber los detecta)
3. Implementar código mínimo
4. Refactorizar manteniendo tests verdes

### Convención de Commits
```
feat(list): agregar ejemplo de ordenamiento
fix(set): validar elemento nulo
test(map): agregar escenario de colisión
docs(readme): actualizar instrucciones
style: aplicar formato con Spotless
refactor(queue): simplificar lógica
chore(deps): actualizar versión de Cucumber
```

---

## 📚 Recursos Útiles

### Documentación Oficial
- [Java 21 API](https://docs.oracle.com/en/java/javase/21/docs/api/)
- [Cucumber JVM](https://cucumber.io/docs/installation/java/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ](https://assertj.github.io/doc/)

### Guías de Estilo
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Conventional Commits](https://www.conventionalcommits.org/)

---

## 🔮 Predicciones

### Próximas Necesidades Probables
1. **GitHub Actions** - CI/CD automatizado
2. **SonarQube** - Análisis de código más profundo
3. **Ejemplos de Streams** - Con lambdas y method references
4. **Performance Tests** - Comparar ArrayList vs LinkedList
5. **Mutación Testing** - Con PIT (opcional)

---

## 📝 Notas para Futuros Agentes

- Este proyecto es **educativo**, el código debe ser claro antes que optimizado
- Los ejemplos deben ser **autocontenidos** y fáciles de entender
- **Siempre** ejecutar `mvn clean verify` antes de terminar
- **Nunca** asumir permiso para cambiar versiones o agregar dependencias
- Si algo no está claro, **preguntar al usuario**

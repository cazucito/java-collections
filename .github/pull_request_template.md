# Pull Request

## 📋 Tipo de Cambio

<!-- Marque con una x las opciones que apliquen -->

- [ ] ✨ Nueva funcionalidad (`feat`)
- [ ] 🐛 Corrección de bug (`fix`)
- [ ] 📝 Documentación (`docs`)
- [ ] 💄 Estilo de código (`style`)
- [ ] ♻️ Refactorización (`refactor`)
- [ ] 🧪 Tests (`test`)
- [ ] 🔧 Tareas de mantenimiento (`chore`)

## 📝 Descripción

<!-- Describa brevemente qué cambios introduce este PR -->

## 🎯 Motivación y Contexto

<!-- Explique por qué es necesario este cambio y qué problema resuelve -->

## 🔍 Cambios Realizados

<!-- Liste los cambios principales -->
- 
- 
- 

## ✅ Checklist

### Antes de enviar:
- [ ] He ejecutado `mvn clean verify` localmente y todos los tests pasan
- [ ] El código sigue las convenciones del proyecto (ver `AGENTS.md`)
- [ ] He agregado/actualizado la documentación necesaria
- [ ] Los commits siguen el formato de Conventional Commits
- [ ] No hay archivos sin formato (`mvn spotless:check` pasa)

### Calidad de código:
- [ ] Checkstyle pasa sin violaciones
- [ ] SpotBugs no reporta bugs
- [ ] JaCoCo reporta cobertura >= 60%
- [ ] Todos los tests nuevos pasan

### Para features de Collections:
- [ ] He agregado el archivo `.feature` en español (`# language: es`)
- [ ] He creado los step definitions correspondientes
- [ ] La implementación tiene Javadoc en español neutro
- [ ] He incluido ejemplos claros y autocontenidos

## 🧪 Tests

<!-- Describa cómo ha probado estos cambios -->

```bash
# Comandos ejecutados
mvn clean verify

# Resultado
[INFO] Tests run: X, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 📸 Screenshots / Evidencia

<!-- Si aplica, agregue screenshots o ejemplos de salida -->

## 🔗 Issues Relacionados

<!-- Referencie issues relacionados (ej: Closes #123, Fixes #456) -->

Closes #

## 📝 Notas para el Reviewer

<!-- Información adicional que el revisor debería saber -->

---

## 📚 Referencias

<!-- Documentación, ADRs o recursos relevantes -->

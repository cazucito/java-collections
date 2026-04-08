# Agent Context Files

> Índice de archivos de contexto para agentes de IA trabajando en java-collections

## 📚 Archivos Disponibles

| Archivo | Propósito | Leer cuando... | Actualizar cuando... |
|---------|-----------|----------------|---------------------|
| [`HANDOFF.md`](HANDOFF.md) | Estado actual del trabajo | Iniciar una sesión | Terminar una sesión |
| [`CONTEXT.md`](CONTEXT.md) | Decisiones arquitectónicas y contexto | Planificar features | Cambiar arquitectura |
| [`MEMORY.md`](MEMORY.md) | Lecciones aprendidas y preferencias | Antes de decisiones | Aprender algo nuevo |
| [`STATE.md`](STATE.md) | Estado técnico del entorno | Debugging | Cambiar configuración |
| [`SESSION.md`](SESSION.md) | Log de sesión actual | N/A | Durante la sesión |
| [`PLAN.md`](PLAN.md) | Roadmap y planificación | Priorizar trabajo | Completar milestones |

---

## 🚀 Flujo de Trabajo Recomendado

### Al iniciar una sesión:
1. Leer `HANDOFF.md` para entender el estado actual
2. Leer `CONTEXT.md` para recordar arquitectura
3. Leer `MEMORY.md` para evitar errores conocidos

### Durante la sesión:
4. Documentar en `SESSION.md` las acciones realizadas
5. Consultar `PLAN.md` para mantener foco

### Al terminar una sesión:
6. Actualizar `HANDOFF.md` con el nuevo estado
7. Actualizar `MEMORY.md` si se aprendió algo nuevo
8. Limpiar `SESSION.md` o archivarlo

---

## 📝 Notas

- Estos archivos están en **inglés** para consistencia con el código
- Los comentarios en código fuente deben seguir en **español neutro**
- Siempre verificar `AGENTS.md` en root para convenciones del proyecto

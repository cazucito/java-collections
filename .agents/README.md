# Agent Context Files

> Extended context files for AI agents working on java-collections

## 📚 Available Files

| File | Purpose | Read when... | Update when... |
|------|---------|--------------|----------------|
| [`README.md`](README.md) | Index and usage guide | First time | New file added |
| [`HANDOFF.md`](HANDOFF.md) | Current work status | **Start session** | **End session** |
| [`CONTEXT.md`](CONTEXT.md) | Architectural decisions | Planning features | Architecture changes |
| [`MEMORY.md`](MEMORY.md) | Lessons learned | Before decisions | Learn something new |
| [`STATE.md`](STATE.md) | Technical environment state | Debugging | Configuration changes |
| [`SESSION.md`](SESSION.md) | Current session log | N/A | During session |
| [`PLAN.md`](PLAN.md) | Roadmap and planning | Prioritizing work | Milestones completed |

---

## 🚀 Recommended Workflow

### When starting a session:
1. Read `HANDOFF.md` to understand current status
2. Read `CONTEXT.md` to remember architecture
3. Read `MEMORY.md` to avoid known errors

### During the session:
4. Document in `SESSION.md` actions performed
5. Check `PLAN.md` to maintain focus

### When ending a session:
6. Update `HANDOFF.md` with new status
7. Update `MEMORY.md` if something new was learned
8. Clean up `SESSION.md` if needed

---

## 📝 Notes

- These files are in **English** for consistency with code
- Source code comments must remain in **neutral Spanish**
- Always verify `AGENTS.md` in root for project conventions

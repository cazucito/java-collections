# Project Roadmap

> Planning and milestones for java-collections project

---

## 🎯 Vision

Create a complete collection of Java Collections API examples, demonstrating
best development practices with BDD/TDD and quality code.

---

## 📅 Milestones

### Milestone 1: Foundations ✅
**Status:** Completed  
**Date:** 2024-04-08  

- [x] Project configuration (Maven, Java 21)
- [x] Quality tools (Checkstyle, SpotBugs, Spotless, JaCoCo)
- [x] Complete ArrayList example with BDD
- [x] Initial documentation (AGENTS.md, README.md)
- [x] Defined package structure

---

### Milestone 2: List Interfaces
**Status:** In planning  
**Estimated Date:** 2024-04-15  
**Priority:** High

- [ ] **LinkedList**
  - [ ] Feature file with 4-6 scenarios
  - [ ] Step definitions
  - [ ] Example implementation
  - [ ] Documented differences vs ArrayList

- [ ] **Vector** (optional, legacy)
  - [ ] Brief usage example
  - [ ] Note about synchronization

- [ ] **Stack** (optional, legacy)
  - [ ] Basic example
  - [ ] Reference to Deque as preferred

---

### Milestone 3: Set Interfaces
**Status:** Pending  
**Estimated Date:** 2024-04-22  
**Priority:** High

- [ ] **HashSet**
  - [ ] Feature file
  - [ ] Step definitions
  - [ ] Implementation
  - [ ] Explain uniqueness and hashCode

- [ ] **LinkedHashSet**
  - [ ] Insertion order example
  - [ ] Comparison with HashSet

- [ ] **TreeSet**
  - [ ] Natural order example
  - [ ] Comparator example
  - [ ] Explain Comparable vs Comparator

---

### Milestone 4: Map Interfaces
**Status:** Pending  
**Estimated Date:** 2024-04-29  
**Priority:** High

- [ ] **HashMap**
  - [ ] Complete feature file
  - [ ] Collision handling
  - [ ] get/put/remove/clear
  - [ ] Iteration (entrySet, keySet, values)

- [ ] **LinkedHashMap**
  - [ ] Insertion order
  - [ ] Use cases

- [ ] **TreeMap**
  - [ ] Key ordering
  - [ ] Custom Comparator

- [ ] **EnumMap** (optional)
  - [ ] Example with enums

---

### Milestone 5: Queue and Deque Interfaces
**Status:** Pending  
**Estimated Date:** 2024-05-06  
**Priority:** Medium

- [ ] **PriorityQueue**
  - [ ] Natural ordering
  - [ ] Comparator
  - [ ] poll/peek/offer

- [ ] **ArrayDeque**
  - [ ] Stack (push/pop)
  - [ ] Queue (add/remove)
  - [ ] Advantages over Stack/LinkedList

- [ ] **LinkedList as Deque**
  - [ ] Double-ended queue

---

### Milestone 6: Algorithms and Utilities
**Status:** Pending  
**Estimated Date:** 2024-05-13  
**Priority:** Medium

- [ ] **Collections Utility Class**
  - [ ] sort()
  - [ ] binarySearch()
  - [ ] reverse()
  - [ ] shuffle()
  - [ ] unmodifiableXxx()
  - [ ] synchronizedXxx()

- [ ] **Arrays Utility Class**
  - [ ] asList()
  - [ ] sort()
  - [ ] binarySearch()

---

### Milestone 7: Streams API
**Status:** Pending  
**Estimated Date:** 2024-05-20  
**Priority:** Medium

- [ ] **Basic Concepts**
  - [ ] stream() vs parallelStream()
  - [ ] filter/map/reduce
  - [ ] collect() with Collectors

- [ ] **Intermediate Operations**
  - [ ] filter, map, flatMap
  - [ ] distinct, sorted
  - [ ] peek (debugging)

- [ ] **Terminal Operations**
  - [ ] forEach, collect
  - [ ] reduce, count
  - [ ] anyMatch, allMatch, noneMatch

---

### Milestone 8: Advanced Features
**Status:** Pending  
**Estimated Date:** 2024-05-27  
**Priority:** Low

- [ ] **Advanced Generics**
  - [ ] Wildcards (? extends, ? super)
  - [ ] Type erasure
  - [ ] Bounded type parameters

- [ ] **Performance**
  - [ ] ArrayList vs LinkedList benchmarks
  - [ ] HashMap capacity and load factor
  - [ ] Iterators vs for-each

- [ ] **Concurrency**
  - [ ] CopyOnWriteArrayList
  - [ ] ConcurrentHashMap
  - [ ] BlockingQueue

---

### Milestone 9: CI/CD and Automation
**Status:** Pending  
**Estimated Date:** 2024-06-03  
**Priority:** Low

- [ ] **GitHub Actions**
  - [ ] Build workflow
  - [ ] Test workflow
  - [ ] Report publishing (JaCoCo, Checkstyle)

- [ ] **SonarCloud** (optional)
  - [ ] Code analysis
  - [ ] Code coverage

- [ ] **Dependabot**
  - [ ] Advanced configuration
  - [ ] Update grouping

---

## 📊 Success Metrics

| Metric | Target | Current |
|--------|--------|---------|
| Code Coverage | 80% | 60% |
| Gherkin Features | 20+ | 1 (6 scenarios) |
| Collection Types | 10+ | 1 (ArrayList) |
| Documentation | Complete | Initial |
| CI/CD | Automated | Manual |

---

## 🎯 Prioritization Criteria

### High Priority
- Most used interfaces (List, Set, Map)
- Critical features for understanding
- Blockers for other milestones

### Medium Priority
- Specialized interfaces (Queue, Deque)
- Convenience features
- Documentation improvements

### Low Priority
- Advanced features
- Optimizations
- External integrations

---

## 🔄 Methodology

1. **Each Collection = 1 feature branch**
2. **Each feature branch includes:**
   - Feature file (Gherkin)
   - Step definitions
   - Implementation
   - Passing tests
   - Updated documentation
3. **Merge to main only after:**
   - Successful `mvn clean verify`
   - Code review (if applicable)
   - Updated documentation

---

## 📝 Notes

- Dates are flexible estimates
- Priorities may change according to needs
- Each milestone must be demonstrable
- Documentation must be kept up to date

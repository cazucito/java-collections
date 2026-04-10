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
**Actual:** 2026-04-10

- [x] Project configuration (Maven, Java 21)
- [x] Quality tools (Checkstyle, SpotBugs, Spotless, JaCoCo)
- [x] Complete ArrayList example with BDD
- [x] Initial documentation (AGENTS.md, README.md)
- [x] Defined package structure

---

### Milestone 2: List Interfaces ✅
**Status:** Completed  
**Estimated Date:** 2024-04-15  
**Actual:** 2026-04-10

- [x] **ArrayList** (16 scenarios)
  - [x] Feature file with comprehensive scenarios
  - [x] Step definitions
  - [x] Example implementation
  - [x] CRUD operations, sorting, capacity management

- [x] **LinkedList** (11 scenarios)
  - [x] Feature file with scenarios
  - [x] Step definitions
  - [x] Example implementation
  - [x] Documented differences vs ArrayList
  - [x] Stack and Queue operations

- [ ] **Vector** (optional, legacy)
  - [ ] Brief usage example
  - [ ] Note about synchronization

- [ ] **Stack** (optional, legacy)
  - [ ] Basic example
  - [ ] Reference to Deque as preferred

---

### Milestone 3: Set Interfaces ✅
**Status:** Completed  
**Estimated Date:** 2024-04-22  
**Actual:** 2026-04-10

- [x] **HashSet** (10 scenarios)
  - [x] Feature file
  - [x] Step definitions
  - [x] Implementation
  - [x] Explain uniqueness and hashCode

- [x] **LinkedHashSet** (10 scenarios)
  - [x] Insertion order example
  - [x] Comparison with HashSet

- [x] **TreeSet** (12 scenarios)
  - [x] Natural order example
  - [x] Comparator example
  - [x] Explain Comparable vs Comparator
  - [x] headSet/tailSet/subSet operations

---

### Milestone 4: Map Interfaces ✅
**Status:** Completed  
**Estimated Date:** 2024-04-29  
**Actual:** 2026-04-10

- [x] **HashMap** (14 scenarios)
  - [x] Complete feature file
  - [x] Collision handling concepts
  - [x] get/put/remove/clear/containsKey
  - [x] Iteration (entrySet, keySet, values)

- [x] **LinkedHashMap** (10 scenarios)
  - [x] Insertion order preservation
  - [x] Use cases documentation

- [x] **TreeMap** (13 scenarios)
  - [x] Key ordering
  - [x] Custom Comparator
  - [x] subMap operations

- [ ] **EnumMap** (optional)
  - [ ] Example with enums
  - [ ] Performance benefits

---

### Milestone 5: Queue and Deque Interfaces ✅
**Status:** Completed  
**Estimated Date:** 2024-05-06  
**Actual:** 2026-04-10

- [x] **PriorityQueue** (11 scenarios)
  - [x] Natural ordering
  - [x] Comparator
  - [x] poll/peek/offer operations

- [x] **ArrayDeque** (10 scenarios)
  - [x] Stack (push/pop/peek)
  - [x] Queue (add/remove/poll)
  - [x] Advantages over Stack/LinkedList

- [x] **LinkedList as Deque** (implicit in LinkedList scenarios)
  - [x] Double-ended queue operations

---

### Milestone 6: Algorithms and Utilities ✅
**Status:** Completed  
**Estimated Date:** 2024-05-13  
**Actual:** 2026-04-10  
**Priority:** High

- [x] **Collections Utility Class** (16 scenarios)
  - [x] sort() - Sort lists with natural order or Comparator
  - [x] binarySearch() - Efficient search in sorted lists
  - [x] reverse() - Reverse order of elements
  - [x] shuffle() - Randomize element order
  - [x] unmodifiableXxx() - Create read-only views
  - [x] synchronizedXxx() - Thread-safe wrappers
  - [x] max()/min() - Find extremes with Comparator
  - [x] fill() - Fill list with value
  - [x] rotate() - Rotate elements in list
  - [x] copy() - Copy elements between lists

- [x] **Arrays Utility Class** (12 scenarios)
  - [x] asList() - Fixed-size list view of array
  - [x] sort() - Sort arrays
  - [x] parallelSort() - Parallel sorting for large arrays
  - [x] binarySearch() - Search in sorted arrays
  - [x] fill() - Fill array with value
  - [x] copyOf() - Copy with resizing

---

### Milestone 7: Streams API ✅
**Status:** Completed  
**Estimated Date:** 2024-05-20  
**Actual:** 2026-04-10

- [x] **Basic Concepts** (22 scenarios)
  - [x] stream() vs parallelStream()
  - [x] filter/map/reduce pipeline
  - [x] collect() with Collectors

- [x] **Intermediate Operations**
  - [x] filter, map, flatMap
  - [x] distinct, sorted
  - [x] limit, skip

- [x] **Terminal Operations**
  - [x] forEach, collect
  - [x] reduce, count
  - [x] anyMatch, allMatch, noneMatch
  - [x] findFirst, findAny

- [x] **Collectors**
  - [x] toList(), toSet()
  - [x] groupingBy()
  - [x] partitioningBy()

---

### Milestone 8: Advanced Features ✅
**Status:** Completed  
**Estimated Date:** 2024-05-27  
**Actual:** 2026-04-10

#### Completed:
- [x] **Performance** (7 scenarios)
  - [x] ArrayList vs LinkedList benchmarks
  - [x] HashSet vs TreeSet complexity
  - [x] HashMap vs TreeMap complexity

- [x] **Concurrency** (10 scenarios)
  - [x] CopyOnWriteArrayList
  - [x] ConcurrentHashMap
  - [x] Collections.synchronizedXxx
  - [x] ConcurrentModificationException
  - [x] Race conditions demonstration

- [x] **Custom Comparators** (10 scenarios)
  - [x] Natural vs custom ordering
  - [x] Comparator.comparing()
  - [x] Multiple field sorting
  - [x] TreeMap with custom Comparator

- [x] **Advanced Generics** (12 scenarios)
  - [x] Wildcards (? extends, ? super, ? unbounded)
  - [x] PECS principle (Producer Extends, Consumer Super)
  - [x] Type erasure - same class at runtime for all generic types
  - [x] Bounded type parameters (<T extends Number>)
  - [x] Multiple bounds (<T extends Comparable<T>>)

---

### Milestone 9: CI/CD and Automation ⏳
**Status:** Pending  
**Estimated Date:** 2024-06-03  
**Priority:** Low

- [ ] **GitHub Actions**
  - [ ] Build workflow on push/PR
  - [ ] Test workflow with Maven
  - [ ] Report publishing (JaCoCo, Checkstyle)
  - [ ] Status badges in README

- [ ] **SonarCloud** (optional)
  - [ ] Code analysis integration
  - [ ] Code coverage tracking
  - [ ] Quality gate configuration

- [ ] **Dependabot**
  - [ ] Advanced configuration
  - [ ] Update grouping strategies

---

## 🆕 Milestone 10: Documentation and Best Practices ✅
**Status:** Completed  
**Date:** 2026-04-10  
**Priority:** High

- [x] **CASOS_DE_USO.md** - Practical use cases for each collection
  - [x] Real-world application examples
  - [x] Selection guide by use case
  - [x] Complexity comparison table

- [x] **FEATURES_PENDIENTES.md** - Future roadmap documentation
  - [x] 5 proposed features with BDD scenarios
  - [x] Priority and complexity assessment
  - [x] Anti-patterns, Design Patterns, Modern Java, Serialization, Debugging

---

## 🆕 Milestone 11: Anti-Patterns and Common Errors ✅
**Status:** Completed  
**Estimated Date:** TBD  
**Actual:** 2026-04-10  
**Priority:** High

- [x] **Common Mistakes** (11 scenarios)
  - [x] Memory leaks with static collections - grow without limit, never garbage collected
  - [x] ConcurrentModificationException - removing during for-each iteration
  - [x] Using == instead of equals() - reference vs value equality
  - [x] Modifying mutable objects used as keys - breaks HashMap contract
  - [x] HashSet with reference equality issues

- [x] **Solutions Demonstrated**
  - [x] Clear static collections to prevent memory leaks
  - [x] Use Iterator.remove() for safe removal during iteration
  - [x] Use removeIf() for functional removal
  - [x] Always use equals() for value comparison
  - [x] Use immutable objects as keys

---

## 📊 Success Metrics

| Metric | Target | Current (2026-04-10) | Status |
|--------|--------|---------------------|--------|
| Code Coverage | 80% | Passing (JaCoCo) | ✅ |
| Gherkin Features | 20+ | 9 features (166 scenarios) | ✅ |
| Collection Types | 10+ | 10+ types implemented | ✅ |
| Documentation | Complete | Complete (README, AGENTS, CASOS_DE_USO, FEATURES_PENDIENTES) | ✅ |
| CI/CD | Automated | Manual | ⏳ |

---

## 🎯 Current Priorities

### High Priority
1. **Milestone 6: Algorithms and Utilities** - Currently in progress
2. **Milestone 11: Anti-Patterns** - Educational value high

### Medium Priority
3. **Milestone 8: Advanced Generics** - Complete the generics section

### Low Priority
4. **Milestone 9: CI/CD** - Nice to have, not critical
5. **Milestone 2-5 optional items** - Vector, Stack, EnumMap (legacy/rarely used)

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
- **Last major update:** 2026-04-10 - Completed M2-M5, M7-M8 partial, added M10-M11

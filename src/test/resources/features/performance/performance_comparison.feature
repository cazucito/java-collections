# language: es

Característica: Comparación de rendimiento entre colecciones
  Como desarrollador Java
  Quiero comparar el rendimiento de diferentes colecciones
  Para elegir la más adecuada según el caso de uso

  # ============================================
  # ARRAYLIST VS LINKEDLIST - INSERCIÓN
  # ============================================
  Escenario: Inserción al final - ArrayList vs LinkedList O(1) vs O(1)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de inserción al final en ArrayList
    Y mido el tiempo de inserción al final en LinkedList
    Entonces el tiempo de ejecución debe ser menor a 1000 ms

  Escenario: Inserción al inicio - LinkedList O(1) vs ArrayList O(n)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de inserción al inicio en ArrayList
    Y mido el tiempo de inserción al inicio en LinkedList
    Entonces la inserción al inicio en LinkedList debe ser más rápida que en ArrayList

  # ============================================
  # ARRAYLIST VS LINKEDLIST - ACCESO
  # ============================================
  Escenario: Acceso por índice - ArrayList O(1) vs LinkedList O(n)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de acceso por índice en ArrayList
    Y mido el tiempo de acceso por índice en LinkedList
    Entonces el acceso por índice en ArrayList debe ser más rápido que en LinkedList

  # ============================================
  # HASHSET VS TREESET
  # ============================================
  Escenario: Inserción - HashSet O(1) vs TreeSet O(log n)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de inserción en HashSet
    Y mido el tiempo de inserción en TreeSet
    Entonces las operaciones en HashSet deben ser más rápidas que en TreeSet

  Escenario: Búsqueda - HashSet O(1) vs TreeSet O(log n)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de búsqueda en HashSet
    Y mido el tiempo de búsqueda en TreeSet
    Entonces las operaciones en HashSet deben ser más rápidas que en TreeSet

  # ============================================
  # HASHMAP VS TREEMAP
  # ============================================
  Escenario: Inserción - HashMap O(1) vs TreeMap O(log n)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de inserción en HashMap
    Y mido el tiempo de inserción en TreeMap
    Entonces las operaciones en HashMap deben ser más rápidas que en TreeMap

  Escenario: Búsqueda - HashMap O(1) vs TreeMap O(log n)
    Dado un ejemplo de comparación de rendimiento
    Y una colección de 10000 elementos
    Cuando mido el tiempo de búsqueda en HashMap
    Y mido el tiempo de búsqueda en TreeMap
    Entonces las operaciones en HashMap deben ser más rápidas que en TreeMap

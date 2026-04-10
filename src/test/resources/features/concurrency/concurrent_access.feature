# language: es

Característica: Acceso concurrente a colecciones
  Como desarrollador Java
  Quiero entender los problemas de concurrencia en colecciones
  Para usar alternativas thread-safe cuando sea necesario

  # ============================================
  # PROBLEMAS DE CONCURRENCIA EN LIST
  # ============================================
  Escenario: ArrayList no es thread-safe - riesgo de pérdida de elementos
    Dado un ejemplo de acceso concurrente a List
    Y que utilizo 10 threads con 100 elementos cada uno
    Y el tamaño esperado es 1000
    Cuando agrego elementos al ArrayList desde múltiples threads
    Y obtengo el tamaño del ArrayList
    Entonces el tamaño puede ser menor o igual a 1000

  Escenario: Collections.synchronizedList es thread-safe
    Dado un ejemplo de acceso concurrente a List
    Y que utilizo 10 threads con 100 elementos cada uno
    Y el tamaño esperado es 1000
    Cuando agrego elementos a la lista sincronizada desde múltiples threads
    Y obtengo el tamaño de la lista sincronizada
    Entonces el tamaño debe ser 1000

  Escenario: CopyOnWriteArrayList es thread-safe
    Dado un ejemplo de acceso concurrente a List
    Y que utilizo 10 threads con 100 elementos cada uno
    Y el tamaño esperado es 1000
    Cuando agrego elementos al CopyOnWriteArrayList desde múltiples threads
    Y obtengo el tamaño del CopyOnWriteArrayList
    Entonces el tamaño debe ser 1000

  # ============================================
  # CONCURRENT MODIFICATION EXCEPTION
  # ============================================
  Escenario: ConcurrentModificationException al iterar y modificar ArrayList
    Dado un ejemplo de acceso concurrente a List
    Cuando intento modificar la lista mientras itero sobre ella
    Entonces debe lanzarse ConcurrentModificationException

  Escenario: CopyOnWriteArrayList permite modificación durante iteración
    Dado un ejemplo de acceso concurrente a List
    Cuando modifico el CopyOnWriteArrayList mientras itero
    Entonces el tamaño debe ser 2

  # ============================================
  # PROBLEMAS DE CONCURRENCIA EN MAP
  # ============================================
  Escenario: HashMap no es thread-safe - riesgo de pérdida de entradas
    Dado un ejemplo de acceso concurrente a Map
    Y que utilizo 10 threads con 100 elementos cada uno
    Y el tamaño esperado es 1000
    Cuando agrego elementos al HashMap desde múltiples threads
    Y obtengo el tamaño del HashMap
    Entonces el tamaño del map puede ser menor o igual a 1000

  Escenario: Collections.synchronizedMap es thread-safe
    Dado un ejemplo de acceso concurrente a Map
    Y que utilizo 10 threads con 100 elementos cada uno
    Y el tamaño esperado es 1000
    Cuando agrego elementos al map sincronizado desde múltiples threads
    Y obtengo el tamaño del map sincronizado
    Entonces el tamaño del map concurrente debe ser 1000

  Escenario: ConcurrentHashMap es thread-safe
    Dado un ejemplo de acceso concurrente a Map
    Y que utilizo 10 threads con 100 elementos cada uno
    Y el tamaño esperado es 1000
    Cuando agrego elementos al ConcurrentHashMap desde múltiples threads
    Y obtengo el tamaño del ConcurrentHashMap
    Entonces el tamaño del map concurrente debe ser 1000

  # ============================================
  # RACE CONDITIONS
  # ============================================
  Escenario: Race condition en incremento de contador con HashMap
    Dado un ejemplo de acceso concurrente a Map
    Y que utilizo 10 threads con 100 incrementos cada uno
    Cuando incremento un contador concurrentemente sin sincronización
    Entonces el valor del contador puede ser menor o igual a 1000

  Escenario: Incremento atómico con ConcurrentHashMap
    Dado un ejemplo de acceso concurrente a Map
    Y que utilizo 10 threads con 100 incrementos cada uno
    Cuando incremento el contador con ConcurrentHashMap
    Entonces el valor del contador debe ser 1000

# language: es

Característica: Anti-patrones comunes en colecciones
  Como desarrollador Java
  Quiero entender los errores comunes al usar colecciones
  Para evitar problemas en mi código

  # ============================================
  # MEMORY LEAK CON COLECCIONES ESTÁTICAS
  # ============================================
  Escenario: Memory leak gradual con colección estática
    Dado una colección estática declarada
    Cuando se agregan elementos sin límite "A, B, C, D, E, F, G, H"
    Entonces el tamaño de la colección estática es 8
    Y la colección no es elegible para garbage collection

  Escenario: Solución - limpiar colección estática
    Dado una colección estática con elementos "A, B, C"
    Cuando se limpia la colección estática
    Entonces el tamaño de la colección estática es 0
    Y la memoria puede ser liberada

  # ============================================
  # MODIFICAR OBJETO USADO COMO CLAVE
  # ============================================
  Escenario: Modificar objeto mutable usado como clave en HashMap
    Dado un HashMap con claves mutables
    Cuando se inserta una entrada con clave mutable 100
    Y se modifica la clave a 200 después de insertarla
    Entonces la entrada no es encontrable con la clave original
    Y la entrada no es encontrable con la clave modificada
    Y se produce una fuga de memoria en el mapa

  # ============================================
  # USAR == EN LUGAR DE EQUALS
  # ============================================
  Escenario: Comparar strings con == en lugar de equals
    Dado dos strings con mismo contenido "Hello"
    Cuando se comparan con operador ==
    Entonces el resultado de comparación por referencia es falso

  Escenario: Comparar strings correctamente con equals
    Dado dos strings con mismo contenido "Hello"
    Cuando se comparan con método equals
    Entonces el resultado de comparación por valor es verdadero

  # ============================================
  # CONCURRENT MODIFICATION EXCEPTION
  # ============================================
  Escenario: Modificar lista durante iteración simple
    Dado una lista con elementos "A, B, C, D, E"
    Cuando se intenta remover elemento "C" durante iteración for-each
    Entonces se lanza ConcurrentModificationException

  Escenario: Solución - usar Iterator para remover elementos
    Dado una lista con elementos "A, B, C, D, E"
    Cuando se remueve elemento "C" usando Iterator
    Entonces la lista resultante es "A, B, D, E"
    Y no se lanza ninguna excepción

  Escenario: Solución - usar removeIf para remover elementos
    Dado una lista con elementos "A, B, C, D, E"
    Cuando se remueve elemento "C" usando removeIf
    Entonces la lista resultante es "A, B, D, E"
    Y no se lanza ninguna excepción

  # ============================================
  # HASHSET CON REFERENCE EQUALITY
  # ============================================
  Escenario: HashSet funciona correctamente con strings
    Dado strings con contenido duplicado creados con new String
    Cuando se agregan a un HashSet
    Entonces el HashSet contiene solo elementos únicos lógicos
    Y el tamaño del HashSet es menor que la cantidad de strings creados

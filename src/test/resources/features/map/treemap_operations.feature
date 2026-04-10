# language: es

Característica: Gestión de pares clave-valor ordenados con TreeMap
  Como desarrollador Java
  Quiero utilizar TreeMap para almacenar pares ordenados por clave
  Para comprender su comportamiento de ordenamiento y operaciones de rango

  Escenario: Agregar entradas desordenadas y verificar orden por clave
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "Charlie" -> "Valor C"
    Y agrego la entrada al treemap "Alice" -> "Valor A"
    Y agrego la entrada al treemap "Bob" -> "Valor B"
    Entonces el tamaño del treemap debe ser 3
    Y la primera clave del treemap es "Alice"
    Y el primer valor del treemap es "Valor A"
    Y la última clave del treemap es "Charlie"
    Y el último valor del treemap es "Valor C"

  Escenario: Sobrescribir valor con clave existente mantiene orden
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "Z" -> "Inicial"
    Y agrego la entrada al treemap "A" -> "Primero"
    Y agrego la entrada al treemap "Z" -> "Actualizado"
    Entonces el tamaño del treemap debe ser 2
    Y la primera clave del treemap es "A"
    Y la última clave del treemap es "Z"
    Y el valor en treemap para la clave "Z" es "Actualizado"

  Escenario: Verificar ordenamiento alfabético de claves
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "Zebra" -> "Animal Z"
    Y agrego la entrada al treemap "Apple" -> "Fruta A"
    Y agrego la entrada al treemap "Mango" -> "Fruta M"
    Y agrego la entrada al treemap "Banana" -> "Fruta B"
    Entonces las claves ordenadas del treemap son "Apple, Banana, Mango, Zebra"
    Y la primera clave del treemap es "Apple"
    Y la última clave del treemap es "Zebra"

  Escenario: Eliminar entrada por clave existente
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "Primero" -> "1"
    Y agrego la entrada al treemap "Segundo" -> "2"
    Y agrego la entrada al treemap "Tercero" -> "3"
    Y elimino la entrada del treemap con clave "Segundo"
    Entonces el tamaño del treemap debe ser 2
    Y el treemap no contiene la clave "Segundo"
    Y la primera clave del treemap es "Primero"
    Y la última clave del treemap es "Tercero"

  Escenario: Verificar treemap vacío
    Dado un TreeMap vacío
    Entonces el treemap debe estar vacío
    Y el tamaño del treemap debe ser 0

  Escenario: Limpiar treemap con entradas
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "A" -> "Valor A"
    Y agrego la entrada al treemap "B" -> "Valor B"
    Y limpio el treemap
    Entonces el treemap debe estar vacío
    Y el tamaño del treemap debe ser 0

  Escenario: Verificar pertenencia de claves y valores
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "Java" -> "Lenguaje"
    Y agrego la entrada al treemap "Python" -> "Lenguaje"
    Y agrego la entrada al treemap "Go" -> "Lenguaje"
    Entonces el treemap contiene la clave "Java"
    Y el treemap contiene la clave "Python"
    Y el treemap contiene la clave "Go"
    Y el treemap contiene el valor "Lenguaje"
    Y el treemap no contiene la clave "Rust"

  Escenario: Obtener entradas con claves menores a un valor (headMap)
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "A" -> "1"
    Y agrego la entrada al treemap "B" -> "2"
    Y agrego la entrada al treemap "C" -> "3"
    Y agrego la entrada al treemap "D" -> "4"
    Y agrego la entrada al treemap "E" -> "5"
    Entonces las claves del treemap menores a "C" son "A, B"

  Escenario: Obtener entradas con claves mayores o iguales (tailMap)
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "10" -> "Diez"
    Y agrego la entrada al treemap "20" -> "Veinte"
    Y agrego la entrada al treemap "30" -> "Treinta"
    Y agrego la entrada al treemap "40" -> "Cuarenta"
    Entonces las claves del treemap mayores o iguales a "30" son "30, 40"

  Escenario: Obtener submap entre dos claves (subMap)
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "Lunes" -> "1"
    Y agrego la entrada al treemap "Martes" -> "2"
    Y agrego la entrada al treemap "Miércoles" -> "3"
    Y agrego la entrada al treemap "Jueves" -> "4"
    Y agrego la entrada al treemap "Viernes" -> "5"
    Entonces las claves del treemap entre "Lunes" y "Miércoles" son "Lunes, Martes"

  Escenario: Verificar orden después de eliminar entradas
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "C" -> "3"
    Y agrego la entrada al treemap "A" -> "1"
    Y agrego la entrada al treemap "B" -> "2"
    Y agrego la entrada al treemap "D" -> "4"
    Y elimino la entrada del treemap con clave "B"
    Entonces las claves ordenadas del treemap son "A, C, D"
    Y la primera clave del treemap es "A"
    Y la última clave del treemap es "D"

  Escenario: Intentar agregar entrada con clave null (no permitido)
    Dado un TreeMap vacío
    Cuando intento agregar la entrada con clave null
    Entonces debe lanzarse NullPointerException en el treemap
    Y el treemap debe estar vacío

  Escenario: Acceder a clave inexistente retorna null
    Dado un TreeMap vacío
    Cuando agrego la entrada al treemap "existente" -> "valor"
    Entonces el valor en treemap para la clave "inexistente" es null

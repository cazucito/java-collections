# language: es

Característica: Gestión de pares clave-valor con orden de inserción usando LinkedHashMap
  Como desarrollador Java
  Quiero utilizar LinkedHashMap para mantener el orden de inserción de entradas
  Para comprender su comportamiento híbrido entre HashMap y orden predecible

  Escenario: Agregar entradas y verificar orden de inserción
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "primero" -> "1"
    Y agrego la entrada al linkedhashmap "segundo" -> "2"
    Y agrego la entrada al linkedhashmap "tercero" -> "3"
    Entonces el tamaño del linkedhashmap debe ser 3
    Y el orden de inserción de claves debe ser "primero, segundo, tercero"

  Escenario: Sobrescribir valor no cambia el orden de inserción
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "A" -> "valor A"
    Y agrego la entrada al linkedhashmap "B" -> "valor B"
    Y agrego la entrada al linkedhashmap "A" -> "valor A actualizado"
    Entonces el tamaño del linkedhashmap debe ser 2
    Y el orden de inserción de claves debe ser "A, B"
    Y el valor en linkedhashmap para la clave "A" es "valor A actualizado"

  Escenario: Eliminar y reinsertar cambia el orden
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "X" -> "10"
    Y agrego la entrada al linkedhashmap "Y" -> "20"
    Y agrego la entrada al linkedhashmap "Z" -> "30"
    Y elimino la entrada del linkedhashmap con clave "Y"
    Y agrego la entrada al linkedhashmap "Y" -> "20"
    Entonces el orden de inserción de claves debe ser "X, Z, Y"

  Escenario: Acceso a valores por clave
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "Java" -> "Lenguaje"
    Y agrego la entrada al linkedhashmap "Python" -> "Lenguaje"
    Entonces el valor en linkedhashmap para la clave "Java" es "Lenguaje"
    Y el valor en linkedhashmap para la clave "Python" es "Lenguaje"

  Escenario: Verificar linkedhashmap vacío
    Dado un LinkedHashMap vacío
    Entonces el linkedhashmap debe estar vacío
    Y el tamaño del linkedhashmap debe ser 0

  Escenario: Limpiar linkedhashmap con entradas
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "key1" -> "value1"
    Y agrego la entrada al linkedhashmap "key2" -> "value2"
    Y limpio el linkedhashmap
    Entonces el linkedhashmap debe estar vacío
    Y el tamaño del linkedhashmap debe ser 0

  Escenario: Verificar pertenencia de claves y valores
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "uno" -> "1"
    Y agrego la entrada al linkedhashmap "dos" -> "2"
    Entonces el linkedhashmap contiene la clave "uno"
    Y el linkedhashmap contiene la clave "dos"
    Y el linkedhashmap contiene el valor "1"
    Y el linkedhashmap no contiene la clave "tres"

  Escenario: Iterar entradas mantiene orden de inserción
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "third" -> "3"
    Y agrego la entrada al linkedhashmap "first" -> "1"
    Y agrego la entrada al linkedhashmap "second" -> "2"
    Entonces el orden de inserción de valores debe ser "3, 1, 2"

  Escenario: LinkedHashMap permite null key y null values
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap null -> "null key"
    Y agrego la entrada al linkedhashmap "null value" -> null
    Entonces el tamaño del linkedhashmap debe ser 2
    Y el linkedhashmap contiene la clave null
    Y el valor en linkedhashmap para la clave null es "null key"
    Y el linkedhashmap contiene el valor null

  Escenario: Verificar orden después de eliminar entradas
    Dado un LinkedHashMap vacío
    Cuando agrego la entrada al linkedhashmap "A" -> "1"
    Y agrego la entrada al linkedhashmap "B" -> "2"
    Y agrego la entrada al linkedhashmap "C" -> "3"
    Y agrego la entrada al linkedhashmap "D" -> "4"
    Y elimino la entrada del linkedhashmap con clave "B"
    Entonces el orden de inserción de claves debe ser "A, C, D"
    Y el tamaño del linkedhashmap debe ser 3

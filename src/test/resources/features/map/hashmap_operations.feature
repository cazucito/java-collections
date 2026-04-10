# language: es

Característica: Gestión de pares clave-valor con HashMap
  Como desarrollador Java
  Quiero utilizar HashMap para almacenar pares clave-valor
  Para comprender su comportamiento de acceso rápido por clave y manejo de duplicados

  Escenario: Agregar pares clave-valor a un HashMap vacío
    Dado un HashMap vacío
    Cuando agrego la entrada "nombre" -> "Juan"
    Y agrego la entrada "edad" -> "30"
    Y agrego la entrada "ciudad" -> "Madrid"
    Entonces el tamaño del map debe ser 3
    Y el map debe contener la clave "nombre"
    Y el map debe contener la clave "edad"
    Y el map debe contener la clave "ciudad"

  Escenario: Recuperar valor por clave existente
    Dado un HashMap vacío
    Cuando agrego la entrada "nombre" -> "María"
    Y agrego la entrada "edad" -> "25"
    Entonces el valor para la clave "nombre" debe ser "María"
    Y el valor para la clave "edad" debe ser "25"

  Escenario: Intentar agregar clave duplicada (sobrescribe valor)
    Dado un HashMap vacío
    Cuando agrego la entrada "nombre" -> "Pedro"
    Y agrego la entrada "nombre" -> "Luis"
    Entonces el tamaño del map debe ser 1
    Y el valor para la clave "nombre" debe ser "Luis"

  Escenario: Verificar que valores pueden duplicarse
    Dado un HashMap vacío
    Cuando agrego la entrada "persona1" -> "Activo"
    Y agrego la entrada "persona2" -> "Activo"
    Y agrego la entrada "persona3" -> "Inactivo"
    Entonces el tamaño del map debe ser 3
    Y el valor para la clave "persona1" debe ser "Activo"
    Y el valor para la clave "persona2" debe ser "Activo"
    Y el valor para la clave "persona3" debe ser "Inactivo"

  Escenario: Eliminar entrada por clave existente
    Dado un HashMap vacío
    Cuando agrego la entrada "A" -> "Valor A"
    Y agrego la entrada "B" -> "Valor B"
    Y agrego la entrada "C" -> "Valor C"
    Y elimino la entrada con clave "B"
    Entonces el tamaño del map debe ser 2
    Y el map no debe contener la clave "B"
    Y el map debe contener la clave "A"
    Y el map debe contener la clave "C"

  Escenario: Intentar eliminar clave inexistente
    Dado un HashMap vacío
    Cuando agrego la entrada "A" -> "Valor A"
    Y elimino la entrada con clave "Z"
    Entonces el tamaño del map debe ser 1
    Y el map debe contener la clave "A"

  Escenario: Verificar si clave existe en el map
    Dado un HashMap vacío
    Cuando agrego la entrada "producto" -> "Laptop"
    Y agrego la entrada "precio" -> "999.99"
    Entonces el map debe contener la clave "producto"
    Y el map debe contener la clave "precio"
    Y el map no debe contener la clave "cantidad"
    Y el map no debe contener la clave "descripcion"

  Escenario: Verificar si valor existe en el map
    Dado un HashMap vacío
    Cuando agrego la entrada "lang1" -> "Java"
    Y agrego la entrada "lang2" -> "Python"
    Y agrego la entrada "lang3" -> "Go"
    Entonces el map debe contener el valor "Java"
    Y el map debe contener el valor "Python"
    Y el map debe contener el valor "Go"
    Y el map no debe contener el valor "Rust"

  Escenario: Verificar map vacío
    Dado un HashMap vacío
    Entonces el map debe estar vacío
    Y el tamaño del map debe ser 0

  Escenario: Limpiar map con entradas
    Dado un HashMap vacío
    Cuando agrego la entrada "key1" -> "value1"
    Y agrego la entrada "key2" -> "value2"
    Y limpio el map
    Entonces el map debe estar vacío
    Y el tamaño del map debe ser 0

  Escenario: Acceder a clave inexistente retorna null
    Dado un HashMap vacío
    Cuando agrego la entrada "existente" -> "valor"
    Entonces el valor para la clave "inexistente" debe ser null

  Escenario: Actualizar valor de clave existente y verificar valor anterior
    Dado un HashMap vacío
    Cuando agrego la entrada "estado" -> "PENDIENTE"
    Y actualizo la entrada "estado" -> "COMPLETADO"
    Entonces el tamaño del map debe ser 1
    Y el valor para la clave "estado" debe ser "COMPLETADO"

  Escenario: Agregar entrada con clave null
    Dado un HashMap vacío
    Cuando agrego la entrada null -> "valor-null"
    Entonces el tamaño del map debe ser 1
    Y el valor para la clave null debe ser "valor-null"

  Escenario: Agregar entrada con valor null
    Dado un HashMap vacío
    Cuando agrego la entrada "clave" -> null
    Entonces el tamaño del map debe ser 1
    Y el map debe contener la clave "clave"
    Y el valor para la clave "clave" debe ser null

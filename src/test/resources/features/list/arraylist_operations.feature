# language: es

Característica: Gestión de elementos con ArrayList
  Como desarrollador Java
  Quiero utilizar ArrayList para almacenar elementos
  Para comprender sus operaciones básicas y comportamiento

  Escenario: Agregar elementos a un ArrayList vacío
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Entonces el tamaño de la lista debe ser 2
    Y la lista debe contener "Java"
    Y la lista debe contener "Python"

  Escenario: Agregar elemento duplicado con addUniqueElement
    Dado un ArrayList vacío
    Cuando agrego el elemento único "Java"
    Y agrego el elemento único "Java"
    Entonces el tamaño de la lista debe ser 1
    Y la operación de segundo agregado debe retornar false

  Escenario: Obtener elemento por índice
    Dado un ArrayList vacío
    Cuando agrego el elemento "Primero"
    Y agrego el elemento "Segundo"
    Y agrego el elemento "Tercero"
    Entonces el elemento en índice 0 debe ser "Primero"
    Y el elemento en índice 1 debe ser "Segundo"
    Y el elemento en índice 2 debe ser "Tercero"

  Escenario: Eliminar elemento existente
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y elimino el elemento "Java"
    Entonces el tamaño de la lista debe ser 1
    Y la lista no debe contener "Java"
    Y la lista debe contener "Python"

  Escenario: Verificar lista vacía
    Dado un ArrayList vacío
    Entonces la lista debe estar vacía
    Y el tamaño de la lista debe ser 0

  Escenario: Limpiar lista con elementos
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y limpio la lista
    Entonces la lista debe estar vacía
    Y el tamaño de la lista debe ser 0

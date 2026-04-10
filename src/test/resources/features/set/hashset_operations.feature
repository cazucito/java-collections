# language: es

Característica: Gestión de elementos únicos con HashSet
  Como desarrollador Java
  Quiero utilizar HashSet para almacenar elementos únicos
  Para comprender su comportamiento de no-duplicados y operaciones básicas

  Escenario: Agregar elementos únicos a un HashSet vacío
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y agrego el elemento "Python" al set
    Y agrego el elemento "Go" al set
    Entonces el tamaño del set debe ser 3
    Y el set debe contener "Java"
    Y el set debe contener "Python"
    Y el set debe contener "Go"

  Escenario: Intentar agregar elementos duplicados
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y agrego el elemento "Python" al set
    Y agrego el elemento "Java" al set
    Entonces el tamaño del set debe ser 2
    Y el set debe contener "Java"
    Y el set debe contener "Python"

  Escenario: Verificar que no existen duplicados en el set
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y agrego el elemento "Java" al set
    Y agrego el elemento "Java" al set
    Entonces el tamaño del set debe ser 1
    Y solo existe una ocurrencia de "Java"

  Escenario: Eliminar elemento existente del set
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y agrego el elemento "Python" al set
    Y agrego el elemento "Go" al set
    Y elimino el elemento "Python" del set
    Entonces el tamaño del set debe ser 2
    Y el set no debe contener "Python"
    Y el set debe contener "Java"
    Y el set debe contener "Go"

  Escenario: Intentar eliminar elemento inexistente
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y elimino el elemento "Python" del set
    Entonces el tamaño del set debe ser 1
    Y el set debe contener "Java"

  Escenario: Verificar set vacío
    Dado un HashSet vacío
    Entonces el set debe estar vacío
    Y el tamaño del set debe ser 0

  Escenario: Limpiar set con elementos
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y agrego el elemento "Python" al set
    Y limpio el set
    Entonces el set debe estar vacío
    Y el tamaño del set debe ser 0

  Escenario: Verificar pertenencia de elementos
    Dado un HashSet vacío
    Cuando agrego el elemento "Java" al set
    Y agrego el elemento "Python" al set
    Entonces el set debe contener "Java"
    Y el set debe contener "Python"
    Y el set no debe contener "Go"
    Y el set no debe contener "Rust"

  Escenario: Agregar elemento null
    Dado un HashSet vacío
    Cuando agrego el elemento null al set
    Entonces el tamaño del set debe ser 1
    Y el set debe contener null

  Escenario: Intentar agregar null duplicado
    Dado un HashSet vacío
    Cuando agrego el elemento null al set
    Y agrego el elemento null al set
    Entonces el tamaño del set debe ser 1
    Y el set debe contener null

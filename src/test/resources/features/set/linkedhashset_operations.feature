# language: es

Característica: Gestión de elementos únicos con orden de inserción usando LinkedHashSet
  Como desarrollador Java
  Quiero utilizar LinkedHashSet para mantener elementos únicos en orden de inserción
  Para comprender su comportamiento híbrido entre HashSet y orden predecible

  Escenario: Agregar elementos y verificar orden de inserción
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "primero" al linkedhashset
    Y agrego el elemento "segundo" al linkedhashset
    Y agrego el elemento "tercero" al linkedhashset
    Entonces el tamaño del linkedhashset debe ser 3
    Y el orden de inserción debe ser "primero, segundo, tercero"

  Escenario: Intentar agregar elementos duplicados (ignorados sin cambiar orden)
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "A" al linkedhashset
    Y agrego el elemento "B" al linkedhashset
    Y agrego el elemento "A" al linkedhashset
    Entonces el tamaño del linkedhashset debe ser 2
    Y el orden de inserción debe ser "A, B"
    Y el linkedhashset contiene el elemento "A"
    Y el linkedhashset contiene el elemento "B"

  Escenario: Eliminar y reinsertar cambia el orden
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "X" al linkedhashset
    Y agrego el elemento "Y" al linkedhashset
    Y agrego el elemento "Z" al linkedhashset
    Y elimino el elemento "Y" del linkedhashset
    Y agrego el elemento "Y" al linkedhashset
    Entonces el orden de inserción debe ser "X, Z, Y"
    Y el tamaño del linkedhashset debe ser 3

  Escenario: Verificar linkedhashset vacío
    Dado un LinkedHashSet vacío
    Entonces el linkedhashset debe estar vacío
    Y el tamaño del linkedhashset debe ser 0

  Escenario: Limpiar linkedhashset con elementos
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "elemento1" al linkedhashset
    Y agrego el elemento "elemento2" al linkedhashset
    Y limpio el linkedhashset
    Entonces el linkedhashset debe estar vacío
    Y el tamaño del linkedhashset debe ser 0

  Escenario: Verificar pertenencia de elementos
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "Java" al linkedhashset
    Y agrego el elemento "Python" al linkedhashset
    Entonces el linkedhashset contiene el elemento "Java"
    Y el linkedhashset contiene el elemento "Python"
    Y el linkedhashset no contiene el elemento "Go"

  Escenario: LinkedHashSet permite null
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento null al linkedhashset
    Entonces el tamaño del linkedhashset debe ser 1
    Y el linkedhashset contiene el elemento null

  Escenario: Verificar orden después de múltiples operaciones
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "C" al linkedhashset
    Y agrego el elemento "A" al linkedhashset
    Y agrego el elemento "B" al linkedhashset
    Y elimino el elemento "A" del linkedhashset
    Y agrego el elemento "D" al linkedhashset
    Y agrego el elemento "A" al linkedhashset
    Entonces el orden de inserción debe ser "C, B, D, A"
    Y el tamaño del linkedhashset debe ser 4

  Escenario: Iterar elementos mantiene orden de inserción
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento "third" al linkedhashset
    Y agrego el elemento "first" al linkedhashset
    Y agrego el elemento "second" al linkedhashset
    Entonces el orden de inserción debe ser "third, first, second"

  Escenario: Intentar agregar null duplicado
    Dado un LinkedHashSet vacío
    Cuando agrego el elemento null al linkedhashset
    Y agrego el elemento null al linkedhashset
    Entonces el tamaño del linkedhashset debe ser 1
    Y el linkedhashset contiene el elemento null

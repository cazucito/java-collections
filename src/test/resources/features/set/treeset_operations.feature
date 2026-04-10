# language: es

Característica: Gestión de elementos ordenados con TreeSet
  Como desarrollador Java
  Quiero utilizar TreeSet para almacenar elementos ordenados
  Para comprender su comportamiento de ordenamiento natural y operaciones de rango

  Escenario: Agregar elementos desordenados y verificar orden automático
    Dado un TreeSet vacío
    Cuando agrego el elemento "Charlie" al treeset
    Y agrego el elemento "Alice" al treeset
    Y agrego el elemento "Bob" al treeset
    Entonces el tamaño del treeset debe ser 3
    Y el primer elemento debe ser "Alice"
    Y el último elemento debe ser "Charlie"
    Y el treeset ordenado debe ser "Alice, Bob, Charlie"

  Escenario: Intentar agregar elementos duplicados (ignorados)
    Dado un TreeSet vacío
    Cuando agrego el elemento "Java" al treeset
    Y agrego el elemento "Python" al treeset
    Y agrego el elemento "Java" al treeset
    Entonces el tamaño del treeset debe ser 2
    Y el treeset debe contener "Java"
    Y el treeset debe contener "Python"

  Escenario: Verificar ordenamiento alfabético con strings
    Dado un TreeSet vacío
    Cuando agrego el elemento "Zebra" al treeset
    Y agrego el elemento "Apple" al treeset
    Y agrego el elemento "Mango" al treeset
    Y agrego el elemento "Banana" al treeset
    Entonces el treeset ordenado debe ser "Apple, Banana, Mango, Zebra"
    Y el primer elemento debe ser "Apple"
    Y el último elemento debe ser "Zebra"

  Escenario: Eliminar elemento existente del treeset
    Dado un TreeSet vacío
    Cuando agrego el elemento "Primero" al treeset
    Y agrego el elemento "Segundo" al treeset
    Y agrego el elemento "Tercero" al treeset
    Y elimino el elemento "Segundo" del treeset
    Entonces el tamaño del treeset debe ser 2
    Y el treeset no debe contener "Segundo"
    Y el treeset ordenado debe ser "Primero, Tercero"

  Escenario: Verificar treeset vacío
    Dado un TreeSet vacío
    Entonces el treeset debe estar vacío
    Y el tamaño del treeset debe ser 0

  Escenario: Limpiar treeset con elementos
    Dado un TreeSet vacío
    Cuando agrego el elemento "A" al treeset
    Y agrego el elemento "B" al treeset
    Y limpio el treeset
    Entonces el treeset debe estar vacío
    Y el tamaño del treeset debe ser 0

  Escenario: Verificar pertenencia de elementos
    Dado un TreeSet vacío
    Cuando agrego el elemento "Java" al treeset
    Y agrego el elemento "Python" al treeset
    Y agrego el elemento "Go" al treeset
    Entonces el treeset debe contener "Java"
    Y el treeset debe contener "Python"
    Y el treeset debe contener "Go"
    Y el treeset no debe contener "Rust"
    Y el treeset no debe contener "C++"

  Escenario: Obtener elementos menores a un valor (headSet)
    Dado un TreeSet vacío
    Cuando agrego el elemento "A" al treeset
    Y agrego el elemento "B" al treeset
    Y agrego el elemento "C" al treeset
    Y agrego el elemento "D" al treeset
    Y agrego el elemento "E" al treeset
    Entonces los elementos menores a "C" deben ser "A, B"

  Escenario: Obtener elementos mayores o iguales a un valor (tailSet)
    Dado un TreeSet vacío
    Cuando agrego el elemento "A" al treeset
    Y agrego el elemento "B" al treeset
    Y agrego el elemento "C" al treeset
    Y agrego el elemento "D" al treeset
    Y agrego el elemento "E" al treeset
    Entonces los elementos mayores o iguales a "D" deben ser "D, E"

  Escenario: Obtener subconjunto entre dos valores (subSet)
    Dado un TreeSet vacío
    Cuando agrego el elemento "10" al treeset
    Y agrego el elemento "20" al treeset
    Y agrego el elemento "30" al treeset
    Y agrego el elemento "40" al treeset
    Y agrego el elemento "50" al treeset
    Entonces los elementos entre "20" y "40" deben ser "20, 30"

  Escenario: Verificar orden después de eliminar elementos
    Dado un TreeSet vacío
    Cuando agrego el elemento "C" al treeset
    Y agrego el elemento "A" al treeset
    Y agrego el elemento "B" al treeset
    Y agrego el elemento "D" al treeset
    Y elimino el elemento "B" del treeset
    Entonces el treeset ordenado debe ser "A, C, D"
    Y el primer elemento debe ser "A"
    Y el último elemento debe ser "D"

  Escenario: Intentar agregar null (no permitido en TreeSet)
    Dado un TreeSet vacío
    Cuando intento agregar null al treeset
    Entonces debe lanzarse NullPointerException
    Y el treeset debe estar vacío

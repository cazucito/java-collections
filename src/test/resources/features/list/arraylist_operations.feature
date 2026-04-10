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

  # ============================================
  # ORDENAMIENTO
  # ============================================
  Escenario: Ordenar lista alfabéticamente
    Dado un ArrayList vacío
    Cuando agrego el elemento "Banana"
    Y agrego el elemento "Apple"
    Y agrego el elemento "Cherry"
    Y ordeno la lista alfabéticamente
    Entonces el elemento en índice 0 debe ser "Apple"
    Y el elemento en índice 1 debe ser "Banana"
    Y el elemento en índice 2 debe ser "Cherry"

  Escenario: Ordenar lista descendentemente
    Dado un ArrayList vacío
    Cuando agrego el elemento "Apple"
    Y agrego el elemento "Cherry"
    Y agrego el elemento "Banana"
    Y ordeno la lista descendentemente
    Entonces el elemento en índice 0 debe ser "Cherry"
    Y el elemento en índice 1 debe ser "Banana"
    Y el elemento en índice 2 debe ser "Apple"

  # ============================================
  # BÚSQUEDA POR ÍNDICE
  # ============================================
  Escenario: Buscar índice de elemento existente
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y agrego el elemento "Go"
    Y busco el índice del elemento "Python"
    Entonces el índice encontrado debe ser 1

  Escenario: Buscar índice de elemento inexistente
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y busco el índice del elemento "Ruby"
    Entonces el índice debe ser -1 indicando que no existe

  Escenario: Buscar último índice con elementos duplicados
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y agrego el elemento "Java"
    Y agrego el elemento "Go"
    Y busco el último índice del elemento "Java"
    Entonces el índice encontrado debe ser 2

  # ============================================
  # REEMPLAZO Y ACCESO POR ÍNDICE
  # ============================================
  Escenario: Reemplazar elemento en índice específico
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y reemplazo el elemento en índice 1 con "Kotlin"
    Entonces el elemento obtenido debe ser "Python"
    Y el tamaño de la lista debe ser 2
    Y el elemento en índice 1 debe ser "Kotlin"

  Escenario: Agregar elemento en índice específico
    Dado un ArrayList vacío
    Cuando agrego el elemento "Primero"
    Y agrego el elemento "Último"
    Y agrego el elemento "Medio" en el índice 1
    Entonces el tamaño de la lista debe ser 3
    Y el elemento en índice 0 debe ser "Primero"
    Y el elemento en índice 1 debe ser "Medio"
    Y el elemento en índice 2 debe ser "Último"

  Escenario: Eliminar elemento por índice
    Dado un ArrayList vacío
    Cuando agrego el elemento "Java"
    Y agrego el elemento "Python"
    Y agrego el elemento "Go"
    Y elimino el elemento en el índice 1
    Entonces el elemento obtenido debe ser "Python"
    Y el tamaño de la lista debe ser 2
    Y la lista debe contener "Java"
    Y la lista no debe contener "Python"

  # ============================================
  # SUBLISTAS
  # ============================================
  Escenario: Obtener sublista de un rango
    Dado un ArrayList vacío
    Cuando agrego el elemento "A"
    Y agrego el elemento "B"
    Y agrego el elemento "C"
    Y agrego el elemento "D"
    Y agrego el elemento "E"
    Y obtengo la sublista desde el índice 1 hasta el 4
    Entonces el tamaño de la sublista debe ser 3
    Y la sublista debe contener "B"
    Y la sublista debe contener "C"
    Y la sublista debe contener "D"

  # ============================================
  # CONVERSIÓN A ARRAY
  # ============================================
  Escenario: Convertir lista a array
    Dado un ArrayList vacío
    Cuando agrego el elemento "Uno"
    Y agrego el elemento "Dos"
    Y agrego el elemento "Tres"
    Y convierto la lista a array
    Entonces el tamaño del array debe ser 3
    Y el array en posición 0 debe ser "Uno"
    Y el array en posición 1 debe ser "Dos"
    Y el array en posición 2 debe ser "Tres"

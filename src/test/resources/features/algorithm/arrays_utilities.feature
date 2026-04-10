# language: es

Característica: Utilidades de la clase Arrays
  Como desarrollador Java
  Quiero utilizar metodos utilitarios de Arrays
  Para manipular arrays de forma eficiente

  # ============================================
  # CONVERSION ARRAY A LISTA
  # ============================================
  Escenario: Convertir array a lista con Arrays asList
    Dado un array de strings para utilidad "Java, Python, Go, Rust"
    Cuando convierto el array a lista con Arrays asList
    Entonces la lista convertida desde array debe ser "Java, Python, Go, Rust"

  Escenario: Lista de Arrays asList tiene tamaño fijo
    Dado un array de strings para utilidad "A, B, C"
    Cuando convierto el array a lista con Arrays asList
    Entonces intentar agregar elemento a la lista fija lanza UnsupportedOperationException

  Escenario: Modificaciones en la lista afectan al array original
    Dado un array de strings para utilidad "A, B, C"
    Cuando convierto el array a lista con Arrays asList
    Y modifico el primer elemento de la lista a "Modificado"
    Entonces el array original refleja la modificación de la lista con valor "Modificado"

  # ============================================
  # ORDENAMIENTO DE ARRAYS
  # ============================================
  Escenario: Ordenar array con orden natural
    Dado un array de enteros para utilidad "45, 12, 89, 3, 67"
    Cuando ordeno el array de enteros con Arrays sort
    Entonces el array de enteros ordenado debe ser "3, 12, 45, 67, 89"

  Escenario: Ordenar array paralelo para grandes volumenes
    Dado un array de 10000 enteros aleatorios para utilidad
    Cuando ordeno el array de enteros con Arrays parallelSort
    Entonces el array de enteros esta ordenado correctamente

  # ============================================
  # BUSQUEDA EN ARRAYS
  # ============================================
  Escenario: Busqueda binaria en array ordenado - elemento encontrado
    Dado un array ordenado de enteros para utilidad "10, 20, 30, 40, 50, 60, 70"
    Cuando busco en el array ordenado el elemento 40 con binarySearch
    Entonces el indice encontrado en array debe ser 3

  Escenario: Busqueda binaria en array ordenado - elemento no encontrado
    Dado un array ordenado de enteros para utilidad "10, 20, 30, 40, 50, 60, 70"
    Cuando busco en el array ordenado el elemento 35 con binarySearch
    Entonces el resultado de busqueda es negativo indicando posicion de insercion

  # ============================================
  # RELLENO DE ARRAYS
  # ============================================
  Escenario: Rellenar array completo
    Dado un array de strings para utilidad "A, B, C, D, E"
    Cuando relleno el array de strings con el valor "X"
    Entonces todos los elementos del array de strings deben ser "X"

  # ============================================
  # COPIA DE ARRAYS
  # ============================================
  Escenario: Copiar array con nuevo tamaño mayor
    Dado un array de enteros para utilidad "1, 2, 3"
    Cuando copio el array a nuevo array de tamaño 5 con Arrays copyOf
    Entonces el nuevo array de enteros debe ser "1, 2, 3, 0, 0"
    Y el tamaño del array de enteros es 5

  Escenario: Copiar array con truncamiento
    Dado un array de enteros para utilidad "1, 2, 3, 4, 5"
    Cuando copio el array a nuevo array de tamaño 3 con Arrays copyOf
    Entonces el nuevo array de enteros debe ser "1, 2, 3"
    Y el tamaño del array de enteros es 3

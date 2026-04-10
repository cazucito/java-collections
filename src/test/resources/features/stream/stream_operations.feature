# language: es

Característica: Operaciones funcionales con Streams API
  Como desarrollador Java
  Quiero utilizar Streams para procesar colecciones de forma funcional
  Para comprender operaciones intermedias y terminales de forma declarativa

  # ============================================
  # OPERACIONES DE FILTRADO
  # ============================================
  Escenario: Filtrar elementos con filter
    Dado una lista de números "1, 2, 3, 4, 5, 6, 7, 8, 9, 10"
    Cuando filtro los números mayores a 5
    Entonces el resultado del stream debe ser "6, 7, 8, 9, 10"

  Escenario: Filtrar strings que comienzan con una letra
    Dado una lista de nombres "Ana, Pedro, Antonio, María, Andrés"
    Cuando filtro los nombres que comienzan con "A"
    Entonces el resultado del stream debe ser "Ana, Antonio, Andrés"

  # ============================================
  # OPERACIONES DE TRANSFORMACIÓN
  # ============================================
  Escenario: Transformar elementos con map
    Dado una lista de números "1, 2, 3, 4, 5"
    Cuando multiplico cada número por 2
    Entonces el resultado del stream debe ser "2, 4, 6, 8, 10"

  Escenario: Transformar strings a mayúsculas
    Dado una lista de nombres "java, python, go"
    Cuando convierto todos a mayúsculas
    Entonces el resultado del stream debe ser "JAVA, PYTHON, GO"

  Escenario: Obtener longitudes de strings
    Dado una lista de palabras "hola, mundo, java"
    Cuando obtengo la longitud de cada palabra
    Entonces el resultado numérico debe ser "4, 5, 4"

  # ============================================
  # OPERACIONES DE AGREGACIÓN
  # ============================================
  Escenario: Sumar todos los elementos con reduce
    Dado una lista de números "1, 2, 3, 4, 5"
    Cuando sumo todos los elementos
    Entonces el resultado reducido debe ser 15

  Escenario: Encontrar el máximo
    Dado una lista de números "23, 45, 12, 67, 34, 89, 5"
    Cuando busco el valor máximo
    Entonces el resultado reducido debe ser 89

  Escenario: Encontrar el mínimo
    Dado una lista de números "23, 45, 12, 67, 34, 89, 5"
    Cuando busco el valor mínimo
    Entonces el resultado reducido debe ser 5

  # ============================================
  # OPERACIONES DE COLECCIÓN
  # ============================================
  Escenario: Convertir a lista con collect
    Dado una lista de números "1, 2, 3, 4, 5"
    Cuando filtro los números pares y convierto a lista
    Entonces la lista resultante debe ser "2, 4"

  Escenario: Convertir a set con collect (elimina duplicados)
    Dado una lista con duplicados "1, 2, 2, 3, 3, 3, 4"
    Cuando convierto a set
    Entonces el set resultante debe contener "1, 2, 3, 4"

  # ============================================
  # OPERACIONES DE ORDENAMIENTO Y UNIFICACIÓN
  # ============================================
  Escenario: Ordenar elementos naturalmente
    Dado una lista desordenada "banana, apple, cherry, date"
    Cuando ordeno alfabéticamente
    Entonces el resultado del stream debe ser "apple, banana, cherry, date"

  Escenario: Ordenar números descendente
    Dado una lista de números "5, 2, 8, 1, 9, 3"
    Cuando ordeno descendente
    Entonces el resultado del stream debe ser "9, 8, 5, 3, 2, 1"

  Escenario: Eliminar duplicados con distinct
    Dado una lista con duplicados "A, B, A, C, B, D, A"
    Cuando elimino duplicados
    Entonces el resultado del stream debe ser "A, B, C, D"

  # ============================================
  # OPERACIONES DE LIMITACIÓN
  # ============================================
  Escenario: Limitar cantidad de elementos
    Dado una lista de números "1, 2, 3, 4, 5, 6, 7, 8, 9, 10"
    Cuando limito a los primeros 5 elementos
    Entonces el resultado del stream debe ser "1, 2, 3, 4, 5"

  Escenario: Saltar elementos con skip
    Dado una lista de números "1, 2, 3, 4, 5, 6, 7, 8, 9, 10"
    Cuando salto los primeros 7 elementos
    Entonces el resultado del stream debe ser "8, 9, 10"

  # ============================================
  # OPERACIONES DE MATCHING
  # ============================================
  Escenario: Verificar si todos cumplen condición (allMatch)
    Dado una lista de números "2, 4, 6, 8, 10"
    Cuando verifico si todos son pares
    Entonces el resultado booleano debe ser "true"

  Escenario: Verificar si alguno cumple condición (anyMatch)
    Dado una lista de números "1, 3, 5, 7, 8, 9"
    Cuando verifico si alguno es par
    Entonces el resultado booleano debe ser "true"

  Escenario: Verificar si ninguno cumple condición (noneMatch)
    Dado una lista de números "1, 3, 5, 7, 9"
    Cuando verifico si ninguno es par
    Entonces el resultado booleano debe ser "true"

  # ============================================
  # OPERACIONES DE BÚSQUEDA
  # ============================================
  Escenario: Encontrar primer elemento con findFirst
    Dado una lista de números "5, 2, 8, 1, 9, 3"
    Cuando busco el primer número par
    Entonces el resultado opcional debe ser "2"

  Escenario: Contar elementos
    Dado una lista de números "1, 2, 3, 4, 5, 6, 7, 8, 9, 10"
    Cuando cuento los elementos mayores a 5
    Entonces el conteo debe ser 5

  # ============================================
  # OPERACIONES COMPUESTAS
  # ============================================
  Escenario: Pipeline completo: filtrar, transformar y ordenar
    Dado una lista de números "5, 12, 3, 8, 15, 2, 9, 20, 1, 7"
    Cuando filtro mayores a 5, multiplico por 2 y ordeno descendente
    Entonces el resultado del stream debe ser "40, 30, 24, 18, 16, 14"

  Escenario: Agrupar por longitud de palabra
    Dado una lista de palabras "a, bb, ccc, dd, eeeee, fff, gg"
    Cuando agrupo por longitud
    Entonces el grupo de longitud 1 debe ser "a"
    Y el grupo de longitud 2 debe ser "bb, dd, gg"
    Y el grupo de longitud 3 debe ser "ccc, fff"
    Y el grupo de longitud 5 debe ser "eeeee"

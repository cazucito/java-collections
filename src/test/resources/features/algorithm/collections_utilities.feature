# language: es

Característica: Utilidades de la clase Collections
  Como desarrollador Java
  Quiero utilizar métodos utilitarios de Collections
  Para manipular colecciones de forma eficiente

  # ============================================
  # ORDENAMIENTO
  # ============================================
  Escenario: Ordenar lista con orden natural
    Dado una lista desordenada para algoritmo "Banana, Apple, Cherry, Date"
    Cuando ordeno la lista con Collections sort algoritmo
    Entonces la lista ordenada algoritmo debe ser "Apple, Banana, Cherry, Date"

  Escenario: Ordenar lista con Comparator personalizado
    Dado una lista de numeros para algoritmo "45, 12, 89, 3, 67"
    Cuando ordeno la lista en orden descendente algoritmo
    Entonces el maximo algoritmo debe ser 89

  Escenario: Invertir el orden de una lista
    Dado una lista para algoritmo "Primero, Segundo, Tercero, Cuarto"
    Cuando invierto el orden con Collections reverse algoritmo
    Entonces la lista algoritmo debe ser "Cuarto, Tercero, Segundo, Primero"

  Escenario: Mezclar elementos aleatoriamente
    Dado una lista para algoritmo "A, B, C, D, E"
    Cuando mezclo la lista con Collections shuffle algoritmo
    Entonces la lista debe tener los mismos elementos en diferente orden algoritmo

  # ============================================
  # BÚSQUEDA
  # ============================================
  Escenario: Búsqueda binaria en lista ordenada - elemento encontrado
    Dado una lista ordenada para algoritmo "10, 20, 30, 40, 50"
    Cuando busco el elemento 30 con binarySearch algoritmo
    Entonces el indice encontrado algoritmo debe ser 2

  Escenario: Búsqueda binaria en lista ordenada - elemento no encontrado
    Dado una lista ordenada para algoritmo "10, 20, 30, 40, 50"
    Cuando busco el elemento 25 con binarySearch algoritmo
    Entonces el resultado algoritmo debe ser negativo indicando posicion de insercion

  # ============================================
  # MÁXIMO Y MÍNIMO
  # ============================================
  Escenario: Encontrar el elemento máximo
    Dado una lista de numeros para algoritmo "23, 56, 12, 89, 34"
    Cuando busco el elemento maximo algoritmo
    Entonces el maximo algoritmo debe ser 89

  Escenario: Encontrar el elemento mínimo
    Dado una lista de numeros para algoritmo "23, 56, 12, 89, 34"
    Cuando busco el elemento minimo algoritmo
    Entonces el minimo algoritmo debe ser 12

  # ============================================
  # FRECUENCIA Y DISJOINT
  # ============================================
  Escenario: Contar frecuencia de un elemento
    Dado una lista para algoritmo "A, B, A, C, A, B, A"
    Cuando cuento la frecuencia del elemento "A" algoritmo
    Entonces la frecuencia algoritmo debe ser 4

  # Escenario omitido - requiere implementación adicional
  # Escenario: Verificar colecciones disjuntas - sin elementos comunes
  #   Dado una lista A para algoritmo "1, 2, 3, 4"
  #   Y una lista B para algoritmo "5, 6, 7, 8"
  #   Cuando verifico si son disjuntas algoritmo
  #   Entonces el resultado disjuntas algoritmo debe ser true

  # ============================================
  # COLECCIONES INMODIFICABLES
  # ============================================
  Escenario: Crear lista inmodificable
    Dado una lista para algoritmo "X, Y, Z"
    Cuando creo una vista inmodificable algoritmo
    Entonces intentar agregar un elemento algoritmo debe lanzar UnsupportedOperationException

  Escenario: Crear set inmodificable
    Dado un set con elementos para algoritmo "A, B, C"
    Cuando creo una vista inmodificable del set algoritmo
    Entonces intentar eliminar un elemento algoritmo debe lanzar UnsupportedOperationException

  Escenario: Crear map inmodificable
    Dado un map con entradas para algoritmo "1=Uno, 2=Dos"
    Cuando creo una vista inmodificable del map algoritmo
    Entonces intentar modificar el map algoritmo debe lanzar UnsupportedOperationException

  # ============================================
  # COLECCIONES SINCRONIZADAS
  # ============================================
  Escenario: Crear lista sincronizada
    Dado una lista ArrayList para algoritmo
    Cuando creo una version sincronizada con Collections synchronizedList algoritmo
    Entonces la lista es thread-safe para operaciones simples algoritmo

  Escenario: Crear map sincronizado
    Dado un HashMap vacio para algoritmo
    Cuando creo una version sincronizada con Collections synchronizedMap algoritmo
    Entonces el map es thread-safe para operaciones simples algoritmo

  Escenario: Crear set sincronizado
    Dado un HashSet vacio para algoritmo
    Cuando creo una version sincronizada con Collections synchronizedSet algoritmo
    Entonces el set es thread-safe para operaciones simples algoritmo

  # ============================================
  # COPIAS Y RELLENO
  # ============================================
  Escenario: Copiar elementos entre listas
    Dado una lista origen para algoritmo "A, B, C"
    Y una lista destino para algoritmo "X, Y, Z"
    Cuando copio elementos de origen a destino algoritmo
    Entonces la lista destino algoritmo debe ser "A, B, C"

  Escenario: Rellenar lista con un valor
    Dado una lista para algoritmo "A, B, C, D, E"
    Cuando relleno con el valor "X" algoritmo
    Entonces todos los elementos algoritmo deben ser "X"

  # ============================================
  # ROTACIÓN
  # ============================================
  Escenario: Rotar lista hacia la derecha
    Dado una lista para algoritmo "1, 2, 3, 4, 5"
    Cuando roto la lista 2 posiciones algoritmo
    Entonces la lista algoritmo debe ser "4, 5, 1, 2, 3"

  Escenario: Rotar lista hacia la izquierda
    Dado una lista para algoritmo "1, 2, 3, 4, 5"
    Cuando roto la lista -1 posiciones algoritmo
    Entonces la lista algoritmo debe ser "2, 3, 4, 5, 1"

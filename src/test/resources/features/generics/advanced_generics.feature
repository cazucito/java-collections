# language: es

Característica: Generics avanzados en colecciones
  Como desarrollador Java
  Quiero entender wildcards, PECS y type erasure
  Para usar colecciones de forma mas flexible y type-safe

  Escenario: PECS - Producer Extends Consumer Super
    Dado una lista fuente de enteros para generics "1, 2, 3"
    Y una lista destino vacia para generics
    Cuando copio elementos usando PECS
    Entonces la lista destino contiene "1, 2, 3"

  Escenario: Producer Extends - solo lectura permitida
    Dado una lista de Dog con elementos "Fido, Max"
    Cuando intento demostrar que extends es solo lectura
    Entonces el resultado es modo solo-lectura

  Escenario: Consumer Super - escritura permitida
    Dado una lista de animales vacia
    Y un perro llamado "Buddy"
    Cuando agrego el perro usando super wildcard
    Entonces el resultado es escritura-permitida
    Y la lista contiene el perro

  Escenario: Upper bounded wildcard - sumar numeros
    Dado una lista de numeros para generics "1.5, 2.5, 3.0"
    Cuando calculo la suma usando bounded wildcard
    Entonces la suma total es "7.0"

  Escenario: Upper bounded wildcard con enteros
    Dado una lista de enteros para generics "10, 20, 30"
    Cuando calculo la suma usando bounded wildcard
    Entonces la suma total es "60.0"

  Escenario: Lower bounded wildcard - agregar enteros
    Dado una lista de numeros vacia
    Cuando agrego enteros 42 usando lower bounded wildcard
    Y agrego enteros 99 usando lower bounded wildcard
    Entonces la lista de numeros contiene 2 elementos

  Escenario: Unbounded wildcard - obtener tamano
    Dado una lista de strings para generics "A, B, C, D"
    Cuando obtengo el tamano usando unbounded wildcard
    Entonces el tamano obtenido es 4

  Escenario: Unbounded wildcard - verificar contencion
    Dado una lista de strings para generics "Apple, Banana, Cherry"
    Cuando verifico si contiene "Banana" usando unbounded wildcard
    Entonces el resultado de contencion es verdadero

  Escenario: Bounded type parameter - crear lista de numeros
    Cuando creo una lista de numeros usando bounded type parameter
    Entonces la lista creada esta vacia
    Y puedo agregar numeros enteros a la lista

  Escenario: Multiple bounds - encontrar maximo de comparables
    Dado una lista de strings para generics "Zebra, Apple, Mango"
    Cuando encuentro el maximo usando comparable bound
    Entonces el maximo encontrado es "Zebra"

  Escenario: Multiple bounds con enteros
    Dado una lista de enteros para generics "45, 12, 89, 3"
    Cuando encuentro el maximo usando comparable bound
    Entonces el maximo encontrado es "89"

  Escenario: Type erasure - misma clase en runtime
    Dado una lista de strings para generics "A, B"
    Y una lista de enteros para generics "1, 2"
    Cuando comparo las clases en runtime
    Entonces ambas listas tienen la misma clase
    Y el nombre de la clase es "ArrayList"

  Escenario: Type erasure - informacion de tipo no disponible
    Dado una lista de strings para generics "Hello"
    Cuando obtengo el nombre de la clase en runtime
    Entonces el nombre es "ArrayList" sin informacion de tipo generico

# language: es

Característica: Gestión de elementos con LinkedList
  Como desarrollador Java
  Quiero utilizar LinkedList para almacenar elementos
  Para comprender sus operaciones de lista doblemente enlazada y comportamiento específico

  Escenario: Agregar elementos a una LinkedList vacía
    Dado una LinkedList vacía
    Cuando agrego el elemento "Primero" a la linked list
    Y agrego el elemento "Segundo" a la linked list
    Y agrego el elemento "Tercero" a la linked list
    Entonces el tamaño de la linked list debe ser 3
    Y la linked list debe contener "Primero"
    Y la linked list debe contener "Segundo"
    Y la linked list debe contener "Tercero"

  Escenario: Agregar elementos al inicio de la lista
    Dado una LinkedList vacía
    Cuando agrego al inicio el elemento "Último"
    Y agrego al inicio el elemento "Medio"
    Y agrego al inicio el elemento "Primero"
    Entonces el elemento en índice 0 de la linked list debe ser "Primero"
    Y el elemento en índice 1 de la linked list debe ser "Medio"
    Y el elemento en índice 2 de la linked list debe ser "Último"

  Escenario: Agregar elementos al final de la lista
    Dado una LinkedList vacía
    Cuando agrego al final el elemento "Primero"
    Y agrego al final el elemento "Segundo"
    Y agrego al final el elemento "Tercero"
    Entonces el elemento en índice 0 de la linked list debe ser "Primero"
    Y el elemento en índice 1 de la linked list debe ser "Segundo"
    Y el elemento en índice 2 de la linked list debe ser "Tercero"

  Escenario: Eliminar primer elemento de la lista
    Dado una LinkedList vacía
    Cuando agrego el elemento "A" a la linked list
    Y agrego el elemento "B" a la linked list
    Y agrego el elemento "C" a la linked list
    Y elimino el primer elemento de la linked list
    Entonces el tamaño de la linked list debe ser 2
    Y el elemento en índice 0 de la linked list debe ser "B"
    Y la linked list no debe contener "A"

  Escenario: Eliminar último elemento de la lista
    Dado una LinkedList vacía
    Cuando agrego el elemento "A" a la linked list
    Y agrego el elemento "B" a la linked list
    Y agrego el elemento "C" a la linked list
    Y elimino el último elemento de la linked list
    Entonces el tamaño de la linked list debe ser 2
    Y el elemento en índice 1 de la linked list debe ser "B"
    Y la linked list no debe contener "C"

  Escenario: Obtener primer elemento sin eliminarlo
    Dado una LinkedList vacía
    Cuando agrego el elemento "Primero" a la linked list
    Y agrego el elemento "Segundo" a la linked list
    Y obtengo el primer elemento de la linked list
    Entonces el primer elemento obtenido debe ser "Primero"
    Y el tamaño de la linked list debe ser 2

  Escenario: Obtener último elemento sin eliminarlo
    Dado una LinkedList vacía
    Cuando agrego el elemento "Primero" a la linked list
    Y agrego el elemento "Último" a la linked list
    Y obtengo el último elemento de la linked list
    Entonces el último elemento obtenido debe ser "Último"
    Y el tamaño de la linked list debe ser 2

  Escenario: Verificar lista vacía
    Dado una LinkedList vacía
    Entonces la linked list debe estar vacía
    Y el tamaño de la linked list debe ser 0

  Escenario: Limpiar lista con elementos
    Dado una LinkedList vacía
    Cuando agrego el elemento "Java" a la linked list
    Y agrego el elemento "Python" a la linked list
    Y limpio la linked list
    Entonces la linked list debe estar vacía
    Y el tamaño de la linked list debe ser 0

  Escenario: Acceso por índice en LinkedList
    Dado una LinkedList vacía
    Cuando agrego el elemento "Posición 0" a la linked list
    Y agrego el elemento "Posición 1" a la linked list
    Y agrego el elemento "Posición 2" a la linked list
    Entonces el elemento en índice 0 de la linked list debe ser "Posición 0"
    Y el elemento en índice 1 de la linked list debe ser "Posición 1"
    Y el elemento en índice 2 de la linked list debe ser "Posición 2"

  Escenario: Eliminar elemento por valor en LinkedList
    Dado una LinkedList vacía
    Cuando agrego el elemento "Java" a la linked list
    Y agrego el elemento "Python" a la linked list
    Y agrego el elemento "Go" a la linked list
    Y elimino el elemento "Python" de la linked list
    Entonces el tamaño de la linked list debe ser 2
    Y la linked list no debe contener "Python"
    Y la linked list debe contener "Java"
    Y la linked list debe contener "Go"

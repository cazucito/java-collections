# language: es

Característica: Gestión de elementos de doble extremo con ArrayDeque
  Como desarrollador Java
  Quiero utilizar ArrayDeque como pila (stack) y cola (queue)
  Para comprender sus operaciones O(1) en ambos extremos

  Escenario: Agregar elementos al inicio y al final
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "A" al inicio del deque
    Y agrego el elemento "B" al final del deque
    Y agrego el elemento "C" al inicio del deque
    Entonces el tamaño del deque debe ser 3
    Y el primer elemento del deque debe ser "C"
    Y el último elemento del deque debe ser "B"

  Escenario: Usar ArrayDeque como pila (LIFO - Last In First Out)
    Dado un ArrayDeque vacío
    Cuando hago push del elemento "primero"
    Y hago push del elemento "segundo"
    Y hago push del elemento "tercero"
    Entonces el elemento en el tope debe ser "tercero"
    Cuando hago pop
    Entonces el resultado debe ser "tercero"
    Y el elemento en el tope debe ser "segundo"
    Cuando hago pop
    Entonces el resultado debe ser "segundo"
    Y el tamaño del deque debe ser 1

  Escenario: Usar ArrayDeque como cola (FIFO - First In First Out)
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "cliente1" al final
    Y agrego el elemento "cliente2" al final
    Y agrego el elemento "cliente3" al final
    Entonces el primer elemento del deque debe ser "cliente1"
    Cuando proceso el primer elemento
    Entonces el resultado debe ser "cliente1"
    Y el primer elemento del deque debe ser "cliente2"
    Cuando proceso el primer elemento
    Entonces el resultado debe ser "cliente2"
    Y el tamaño del deque debe ser 1

  Escenario: Eliminar del inicio y del final
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "X" al final
    Y agrego el elemento "Y" al final
    Y agrego el elemento "Z" al final
    Y elimino el primer elemento
    Y elimino el último elemento
    Entonces el tamaño del deque debe ser 1
    Y el primer elemento del deque debe ser "Y"
    Y el último elemento del deque debe ser "Y"

  Escenario: Verificar deque vacío
    Dado un ArrayDeque vacío
    Entonces el deque debe estar vacío
    Y el tamaño del deque debe ser 0
    Y el primer elemento del deque debe ser null
    Y el último elemento del deque debe ser null

  Escenario: Limpiar deque con elementos
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "item1" al final
    Y agrego el elemento "item2" al final
    Y limpio el deque
    Entonces el deque debe estar vacío
    Y el tamaño del deque debe ser 0

  Escenario: Verificar pertenencia de elementos
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "Java" al final
    Y agrego el elemento "Python" al inicio
    Entonces el deque debe contener "Java"
    Y el deque debe contener "Python"
    Y el deque no debe contener "Go"

  Escenario: ArrayDeque no permite null
    Dado un ArrayDeque vacío
    Cuando intento agregar null al inicio
    Entonces debe lanzarse NullPointerException en el deque
    Y el deque debe estar vacío

  Escenario: Combinar operaciones de pila y cola
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "1" al final
    Y agrego el elemento "2" al inicio
    Y agrego el elemento "3" al final
    Y hago push del elemento "0"
    Entonces el orden del deque debe ser "0, 2, 1, 3"
    Cuando proceso el primer elemento
    Entonces el resultado debe ser "0"
    Cuando hago pop
    Entonces el resultado debe ser "2"
    Y el tamaño del deque debe ser 2

  Escenario: Convertir a array mantiene orden
    Dado un ArrayDeque vacío
    Cuando agrego el elemento "A" al final
    Y agrego el elemento "B" al final
    Y agrego el elemento "C" al inicio
    Entonces el array resultante debe ser "[C, A, B]"

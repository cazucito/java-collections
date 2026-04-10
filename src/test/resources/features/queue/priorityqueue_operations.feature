# language: es

Característica: Gestión de elementos por prioridad con PriorityQueue
  Como desarrollador Java
  Quiero utilizar PriorityQueue para procesar elementos por orden de prioridad
  Para comprender su comportamiento de ordenamiento y eficiencia en heaps

  Escenario: Agregar elementos desordenados y verificar orden por prioridad
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 50 a la cola
    Y agrego el elemento con prioridad 10 a la cola
    Y agrego el elemento con prioridad 30 a la cola
    Entonces el tamaño de la cola debe ser 3
    Y el elemento de mayor prioridad debe ser 10
    Y el orden de prioridad debe ser "10, 30, 50"

  Escenario: Procesar elementos en orden de prioridad (poll)
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 5 a la cola
    Y agrego el elemento con prioridad 1 a la cola
    Y agrego el elemento con prioridad 3 a la cola
    Entonces el elemento con mayor prioridad procesado debe ser 1
    Y el siguiente elemento procesado debe ser 3
    Y el último elemento procesado debe ser 5
    Y la cola debe estar vacía

  Escenario: Verificar peek no elimina el elemento
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 20 a la cola
    Y agrego el elemento con prioridad 5 a la cola
    Y observo el elemento de mayor prioridad
    Entonces el tamaño de la cola debe ser 2
    Y el elemento de mayor prioridad debe ser 5

  Escenario: Agregar elementos duplicados (permitidos)
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 10 a la cola
    Y agrego el elemento con prioridad 10 a la cola
    Y agrego el elemento con prioridad 5 a la cola
    Entonces el tamaño de la cola debe ser 3
    Y el elemento de mayor prioridad debe ser 5

  Escenario: Verificar cola vacía
    Dado una PriorityQueue vacía
    Entonces la cola debe estar vacía
    Y el tamaño de la cola debe ser 0
    Y el elemento de mayor prioridad debe ser null

  Escenario: Limpiar cola con elementos
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 100 a la cola
    Y agrego el elemento con prioridad 200 a la cola
    Y limpio la cola
    Entonces la cola debe estar vacía
    Y el tamaño de la cola debe ser 0

  Escenario: Verificar pertenencia de elementos
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 15 a la cola
    Y agrego el elemento con prioridad 25 a la cola
    Entonces la cola debe contener el elemento 15
    Y la cola debe contener el elemento 25
    Y la cola no debe contener el elemento 10

  Escenario: Eliminar elemento específico
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 30 a la cola
    Y agrego el elemento con prioridad 20 a la cola
    Y agrego el elemento con prioridad 40 a la cola
    Y elimino el elemento con prioridad 20 de la cola
    Entonces el tamaño de la cola debe ser 2
    Y la cola no debe contener el elemento 20
    Y el elemento de mayor prioridad debe ser 30

  Escenario: PriorityQueue con Strings (orden alfabético)
    Dado una PriorityQueue de Strings vacía
    Cuando agrego el string "Banana" a la cola
    Y agrego el string "Apple" a la cola
    Y agrego el string "Cherry" a la cola
    Entonces el elemento de mayor prioridad debe ser "Apple"
    Y el orden de prioridad de strings debe ser "Apple, Banana, Cherry"

  Escenario: Intentar agregar null (no permitido)
    Dado una PriorityQueue vacía
    Cuando intento agregar null a la cola
    Entonces debe lanzarse NullPointerException en la cola
    Y la cola debe estar vacía

  Escenario: Verificar orden después de múltiples operaciones
    Dado una PriorityQueue vacía
    Cuando agrego el elemento con prioridad 5 a la cola
    Y agrego el elemento con prioridad 1 a la cola
    Y agrego el elemento con prioridad 3 a la cola
    Y agrego el elemento con prioridad 2 a la cola
    Y proceso un elemento de la cola
    Y proceso un elemento de la cola
    Y agrego el elemento con prioridad 4 a la cola
    Entonces el elemento de mayor prioridad debe ser 3
    Y el tamaño de la cola debe ser 3

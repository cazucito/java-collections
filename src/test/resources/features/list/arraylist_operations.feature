Feature: Gestión de elementos con ArrayList
  Como desarrollador Java
  Quiero utilizar ArrayList para almacenar elementos
  Para comprender sus operaciones básicas y comportamiento

  Scenario: Agregar elementos a un ArrayList vacío
    Given un ArrayList vacío
    When agrego el elemento "Java"
    And agrego el elemento "Python"
    Then el tamaño de la lista debe ser 2
    And la lista debe contener "Java"
    And la lista debe contener "Python"

  Scenario: Agregar elemento duplicado con addUniqueElement
    Given un ArrayList vacío
    When agrego el elemento único "Java"
    And agrego el elemento único "Java"
    Then el tamaño de la lista debe ser 1
    And la operación de segundo agregado debe retornar false

  Scenario: Obtener elemento por índice
    Given un ArrayList vacío
    When agrego el elemento "Primero"
    And agrego el elemento "Segundo"
    And agrego el elemento "Tercero"
    Then el elemento en índice 0 debe ser "Primero"
    And el elemento en índice 1 debe ser "Segundo"
    And el elemento en índice 2 debe ser "Tercero"

  Scenario: Eliminar elemento existente
    Given un ArrayList vacío
    When agrego el elemento "Java"
    And agrego el elemento "Python"
    And elimino el elemento "Java"
    Then el tamaño de la lista debe ser 1
    And la lista no debe contener "Java"
    And la lista debe contener "Python"

  Scenario: Verificar lista vacía
    Given un ArrayList vacío
    Then la lista debe estar vacía
    And el tamaño de la lista debe ser 0

  Scenario: Limpiar lista con elementos
    Given un ArrayList vacío
    When agrego el elemento "Java"
    And agrego el elemento "Python"
    And limpio la lista
    Then la lista debe estar vacía
    And el tamaño de la lista debe ser 0

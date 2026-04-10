# language: es

Característica: Comparadores personalizados para ordenamiento
  Como desarrollador Java
  Quiero utilizar comparadores personalizados
  Para ordenar colecciones según criterios específicos

  # ============================================
  # ORDENAMIENTO NATURAL VS INVERSO
  # ============================================
  Escenario: Ordenamiento natural de strings en TreeSet
    Dado un ejemplo de comparadores personalizados
    Y los elementos "Banana, Apple, Cherry, Date"
    Cuando agrego los elementos al TreeSet con ordenamiento natural
    Y obtengo el orden natural del TreeSet
    Entonces el resultado comparator debe ser "Apple, Banana, Cherry, Date"

  Escenario: Ordenamiento inverso de strings en TreeSet
    Dado un ejemplo de comparadores personalizados
    Y los elementos "Banana, Apple, Cherry, Date"
    Cuando agrego los elementos al TreeSet con ordenamiento inverso
    Y obtengo el orden inverso del TreeSet
    Entonces el resultado comparator debe ser "Date, Cherry, Banana, Apple"

  # ============================================
  # ORDENAMIENTO POR LONGITUD
  # ============================================
  Escenario: Ordenamiento por longitud de strings
    Dado un ejemplo de comparadores personalizados
    Y los elementos "Hi, Hello, Hey, Welcome"
    Cuando agrego los elementos al TreeSet ordenado por longitud
    Y obtengo el orden por longitud del TreeSet
    Entonces el resultado comparator debe ser "Hi, Hey, Hello, Welcome"

  Escenario: Strings de igual longitud son considerados duplicados
    Dado un ejemplo de comparadores personalizados
    Y los elementos "Cat, Dog, Ant"
    Cuando agrego los elementos al TreeSet ordenado por longitud
    Y obtengo el orden por longitud del TreeSet
    Entonces el resultado comparator debe ser "Cat"

  # ============================================
  # ORDENAMIENTO CASE-INSENSITIVE
  # ============================================
  Escenario: Ordenamiento case-insensitive
    Dado un ejemplo de comparadores personalizados
    Y los elementos "banana, Apple, CHERRY, date"
    Cuando agrego los elementos al TreeSet con ordenamiento case-insensitive
    Y obtengo el orden case-insensitive del TreeSet
    Entonces el resultado comparator debe ser "Apple, banana, CHERRY, date"

  Escenario: Duplicados con diferente case son ignorados
    Dado un ejemplo de comparadores personalizados
    Y los elementos "Java, java, JAVA, Python"
    Cuando agrego los elementos al TreeSet con ordenamiento case-insensitive
    Y obtengo el orden case-insensitive del TreeSet
    Entonces el resultado comparator debe ser "Java, Python"

  # ============================================
  # ORDENAMIENTO EN TREEMAP
  # ============================================
  Escenario: TreeMap con ordenamiento inverso de claves
    Dado un ejemplo de comparadores personalizados
    Y las claves "C, A, B, D" con valores "3, 1, 2, 4"
    Cuando agrego las entradas al TreeMap con ordenamiento inverso de claves
    Y obtengo las claves del TreeMap
    Entonces el resultado comparator debe ser "D, C, B, A"

  Escenario: Valores en TreeMap siguen orden inverso de claves
    Dado un ejemplo de comparadores personalizados
    Y las claves "C, A, B, D" con valores "30, 10, 20, 40"
    Cuando agrego las entradas al TreeMap con ordenamiento inverso de claves
    Y obtengo los valores del TreeMap
    Entonces el resultado comparator debe ser "40, 30, 20, 10"

  # ============================================
  # ORDENAMIENTO DE OBJETOS PERSONALIZADOS
  # ============================================
  Escenario: Ordenar objetos Person por edad
    Dado un ejemplo de comparadores personalizados
    Y personas con nombres "Carlos, Ana, Bruno" y edades "30, 25, 28"
    Cuando agrego las personas ordenadas por edad
    Y obtengo las personas ordenadas por edad
    Entonces el resultado comparator debe ser "Ana(25), Bruno(28), Carlos(30)"

  Escenario: Ordenar objetos Person por nombre
    Dado un ejemplo de comparadores personalizados
    Y personas con nombres "Carlos, Ana, Bruno" y edades "30, 25, 28"
    Cuando agrego las personas ordenadas por nombre
    Y obtengo las personas ordenadas por nombre
    Entonces el resultado comparator debe ser "Ana, Bruno, Carlos"

# Casos de Uso Prácticos - Java Collections

> Guía de aplicación práctica de cada colección con ejemplos del mundo real

---

## 📋 List (Listas)

### ArrayList
**Cuándo usar:** Acceso aleatorio frecuente, recorrido secuencial, pocos inserts/eliminados en medio.

**Casos prácticos:**
- 📚 **Catálogo de productos** - Listado de items en una tienda online donde se necesita acceso rápido por índice
- 📊 **Datos de sensores** - Almacenar lecturas temporales donde se agregan al final y se recorren secuencialmente
- 🎵 **Playlist de música** - Lista de canciones donde el usuario salta a cualquier posición
- 📝 **Log de eventos** - Registro de actividades donde los nuevos eventos se agregan al final

```java
// Ejemplo: Lista de tareas pendientes
ArrayList<String> tareas = new ArrayList<>();
tareas.add("Revisar correos");
tareas.add("Reunión con equipo");
tareas.add("Code review");
// Acceso rápido a la tercera tarea
String tareaActual = tareas.get(2); // O(1)
```

### LinkedList
**Cuándo usar:** Inserciones/eliminaciones frecuentes al inicio o medio, implementación de colas/deques.

**Casos prácticos:**
- 🔄 **Historial de navegación** - Botones "atrás" y "adelante" del navegador (doble linked list)
- 🎮 **Undo/Redo** - Sistema de deshacer/rehacer en editores de texto o gráficos
- 🏦 **Cola de transacciones bancarias** - Procesamiento FIFO de operaciones con prioridad
- 📱 **Buffer de mensajes** - Lista de mensajes en chat donde se insertan nuevos al inicio

```java
// Ejemplo: Historial de páginas visitadas
LinkedList<String> historial = new LinkedList<>();
historial.addLast("google.com");
historial.addLast("github.com");
historial.addLast("stackoverflow.com");
// Ir atrás
String paginaAnterior = historial.removeLast(); // O(1)
```

---

## 🔗 Set (Conjuntos)

### HashSet
**Cuándo usar:** Verificación rápida de unicidad, operaciones de conjuntos (unión, intersección), no importa el orden.

**Casos prácticos:**
- 🔐 **IPs bloqueadas** - Verificar si una IP está en lista negra de forma rápida O(1)
- 🏷️ **Etiquetas únicas** - Sistema de tags donde no pueden repetirse (blog, fotos)
- 🎟️ **Códigos de cupones usados** - Validar que un cupón no se canjee dos veces
- 👥 **Amigos en común** - Encontrar intersección entre dos grupos de usuarios
- 🔍 **Palabras únicas** - Contar vocabulario único en un documento

```java
// Ejemplo: Sistema de votación (un voto por persona)
HashSet<String> votantes = new HashSet<>();
votantes.add("user123");
votantes.add("user456");
// Intentar votar de nuevo
boolean yaVoto = !votantes.add("user123"); // true = ya existía
```

### TreeSet
**Cuándo usar:** Necesitas elementos ordenados, rangos de búsqueda, orden específico.

**Casos prácticos:**
- 📅 **Eventos ordenados por fecha** - Calendario donde los eventos se mantienen ordenados
- 📊 **Top N elementos** - Mantener los 10 mejores puntajes ordenados automáticamente
- 🌡️ **Registros de temperatura** - Análisis de rangos: "temperaturas entre 20° y 30°"
- 📖 **Índice de palabras** - Diccionario ordenado alfabéticamente
- 🎯 **Sistema de rangos** - Clasificación de jugadores por niveles (Bronce, Plata, Oro)

```java
// Ejemplo: Top 5 puntuaciones
TreeSet<Integer> puntuaciones = new TreeSet<>();
puntuaciones.add(1500);
puntuaciones.add(2300);
puntuaciones.add(1800);
// Obtener las 3 mejores
SortedSet<Integer> top3 = puntuaciones.descendingSet().headSet(2000);
```

### LinkedHashSet
**Cuándo usar:** Unicidad + preservar orden de inserción, cache LRU simple.

**Casos prácticos:**
- 📝 **Orden de llegada** - Lista de participantes en orden de registro sin duplicados
- 🔄 **Cache de resultados** - Guardar últimas búsquedas únicas manteniendo orden
- 📧 **Destinatarios de email** - Lista de emails sin duplicados, manteniendo orden de entrada
- 🎨 **Paleta de colores usados** - Colores únicos en orden de aparición en una imagen

```java
// Ejemplo: Últimas búsquedas únicas
LinkedHashSet<String> busquedasRecientes = new LinkedHashSet<>();
busquedasRecientes.add("java collections");
busquedasRecientes.add("spring boot");
busquedasRecientes.add("java collections"); // Ignorado, ya existe
// Mantiene: [java collections, spring boot]
```

---

## 🗺️ Map (Mapas)

### HashMap
**Cuándo usar:** Búsqueda rápida por clave, caché, contadores, índices.

**Casos prácticos:**
- 💾 **Cache de objetos** - Almacenar usuarios por ID para acceso rápido O(1)
- 📊 **Contador de frecuencias** - Contar ocurrencias de palabras en un texto
- 🛒 **Carrito de compras** - Producto → Cantidad
- 🌐 **Diccionario de traducción** - Palabra en español → Palabra en inglés
- 🔑 **Sesiones de usuario** - SessionID → Datos de sesión
- 📈 **Índice invertido** - Palabra → Lista de documentos (motores de búsqueda)

```java
// Ejemplo: Contador de visitas por página
HashMap<String, Integer> visitas = new HashMap<>();
visitas.put("/home", visitas.getOrDefault("/home", 0) + 1);
visitas.put("/products", visitas.getOrDefault("/products", 0) + 1);
// Acceso instantáneo
int visitasHome = visitas.get("/home"); // O(1)
```

### TreeMap
**Cuándo usar:** Claves ordenadas, rangos de búsqueda, orden cronológico.

**Casos prácticos:**
- 📅 **Agenda ordenada por hora** - 09:00 → Reunión, 10:30 → Demo, 14:00 → Almuerzo
- 📊 **Histórico de precios** - Encontrar precio en una fecha específica o el más cercano
- 🌍 **Zonas horarias** - Offset UTC → Nombre de zona (ordenado)
- 📈 **Versionado de documentos** - Timestamp → Versión del documento
- 🎮 **Leaderboard por niveles** - Nivel → Lista de jugadores (ordenado por nivel)

```java
// Ejemplo: Registro de temperaturas por fecha
TreeMap<LocalDate, Double> temperaturas = new TreeMap<>();
temperaturas.put(LocalDate.of(2024, 1, 15), 22.5);
temperaturas.put(LocalDate.of(2024, 1, 10), 18.3);
// Obtener temperaturas entre dos fechas automáticamente ordenadas
SortedMap<LocalDate, Double> enero = temperaturas.subMap(
    LocalDate.of(2024, 1, 1),
    LocalDate.of(2024, 2, 1)
);
```

### LinkedHashMap
**Cuándo usar:** Preservar orden de inserción, implementar cache LRU.

**Casos prácticos:**
- 💾 **Cache LRU** (Least Recently Used) - Eliminar elementos menos usados cuando está lleno
- 📝 **Configuración en orden** - Propiedades de aplicación donde el orden importa
- 📋 **Formulario paso a paso** - Mantener campos en orden de llenado
- 📊 **Reporte en orden de generación** - Datos procesados manteniendo secuencia
- 🔗 **URL router** - Mapeo de rutas en orden de especificación

```java
// Ejemplo: Cache LRU de 100 elementos
LinkedHashMap<String, Object> cache = new LinkedHashMap<String, Object>(100, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return size() > 100; // Elimina el menos usado
    }
};
```

---

## 🚦 Queue (Colas)

### PriorityQueue
**Cuándo usar:** Procesamiento por prioridad, algoritmos greedy, scheduling.

**Casos prácticos:**
- 🏥 **Triage hospitalario** - Pacientes atendidos por gravedad, no por orden de llegada
- 🖨️ **Cola de impresión** - Documentos urgentes se imprimen primero
- 🎮 **Sistema de turnos con prioridad** - Jugadores VIP entran primero
- 🧵 **Thread pool** - Tareas con diferente prioridad de ejecución
- 🔍 **Algoritmo A* / Dijkstra** - Encontrar camino más corto en grafos
- 📧 **Cola de emails** - Emails importantes se envían primero

```java
// Ejemplo: Cola de tareas con prioridad
PriorityQueue<Tarea> cola = new PriorityQueue<>(
    Comparator.comparingInt(Tarea::getPrioridad)
);
cola.add(new Tarea("Bug crítico", 1));
cola.add(new Tarea("Feature nueva", 3));
cola.add(new Tarea("Refactor", 5));
// La primera en salir es "Bug crítico"
Tarea siguiente = cola.poll(); // Prioridad 1
```

### ArrayDeque
**Cuándo usar:** Stack (LIFO) o Queue (FIFO) eficiente, sin limitaciones de LinkedList.

**Casos prácticos:**
- 🌐 **Navegación web** - Stack de páginas visitadas (más eficiente que LinkedList)
- 🧮 **Evaluación de expresiones** - Calculadora con notación polaca inversa
- 🔄 **BFS en grafos** - Recorrido por niveles (queue)
- 🎯 **DFS en grafos** - Recorrido en profundidad (stack)
- 📊 **Sliding window algorithm** - Ventanas deslizantes en arrays
- 🎮 **Sistema de mensajes** - Cola de eventos de input en juegos

```java
// Ejemplo: Stack de operaciones (Undo)
ArrayDeque<String> undoStack = new ArrayDeque<>();
undoStack.push("Escribir 'Hola'");
undoStack.push("Escribir ' Mundo'");
// Deshacer última acción
String ultimaAccion = undoStack.pop(); // "Escribir ' Mundo'"
```

---

## 🌊 Streams API

**Cuándo usar:** Procesamiento funcional, pipelines de datos, operaciones encadenadas.

**Casos prácticos:**
- 📊 **ETL de datos** - Filtrar, transformar y cargar datos de forma declarativa
- 📧 **Procesamiento de logs** - Filtrar errores, extraer campos, generar reportes
- 🛒 **Análisis de ventas** - Calcular totales, agrupar por categoría, ordenar
- 🔍 **Búsqueda y filtrado** - Encontrar productos que cumplan múltiples criterios
- 📈 **Generación de reportes** - Transformar datos crudos en información procesada

```java
// Ejemplo: Análisis de ventas
List<Venta> ventas = ...;
Map<String, Double> ventasPorCategoria = ventas.stream()
    .filter(v -> v.getFecha().getYear() == 2024)
    .collect(Collectors.groupingBy(
        Venta::getCategoria,
        Collectors.summingDouble(Venta::getMonto)
    ));
```

---

## 🧵 Concurrencia

### Colecciones Thread-Safe

**CopyOnWriteArrayList:**
- 📰 **Listado de suscriptores** - Event listeners donde hay muchas lecturas y pocas escrituras
- 📡 **Configuración en runtime** - Parámetros que cambian raramente pero se leen frecuentemente

**ConcurrentHashMap:**
- 💾 **Cache concurrente** - Múltiples threads leyendo/escribiendo sin bloqueo total
- 🌍 **Contadores de métricas** - Request rates, contadores de eventos en sistemas high-traffic
- 🔑 **Gestión de sesiones** - Múltiples usuarios concurrentes

```java
// Ejemplo: Contador de visitas concurrente
ConcurrentHashMap<String, LongAdder> visitas = new ConcurrentHashMap<>();
visitas.computeIfAbsent("/home", k -> new LongAdder()).increment();
```

---

## 🎯 Guía de Selección Rápida

| Necesitas... | Usa... |
|--------------|--------|
| Acceso rápido por índice | `ArrayList` |
| Inserciones/eliminaciones frecuentes | `LinkedList` |
| Elementos únicos, sin orden | `HashSet` |
| Elementos únicos, ordenados | `TreeSet` |
| Elementos únicos, orden de llegada | `LinkedHashSet` |
| Búsqueda rápida por clave | `HashMap` |
| Claves ordenadas | `TreeMap` |
| Orden de inserción en mapa | `LinkedHashMap` |
| Procesamiento por prioridad | `PriorityQueue` |
| Stack o Queue eficiente | `ArrayDeque` |
| Procesamiento funcional | `Streams` |
| Concurrencia | `ConcurrentHashMap`, `CopyOnWriteArrayList` |

---

## 📚 Matriz de Complejidad

| Colección | get | add | remove | contains |
|-----------|-----|-----|--------|----------|
| ArrayList | O(1) | O(1)* | O(n) | O(n) |
| LinkedList | O(n) | O(1) | O(1) | O(n) |
| HashSet | - | O(1) | O(1) | O(1) |
| TreeSet | - | O(log n) | O(log n) | O(log n) |
| HashMap | O(1) | O(1) | O(1) | - |
| TreeMap | O(log n) | O(log n) | O(log n) | - |

*Amortizado - puede ser O(n) cuando requiere resize

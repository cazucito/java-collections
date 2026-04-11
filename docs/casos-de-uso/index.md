# Casos de Uso

Colección de casos de uso reales para cada tipo de colección, con ejemplos prácticos del mundo real.

---

## List - Listas Ordenadas

### ArrayList - Catálogo de Productos

```java
public class CatalogoProductos {
    private final List<Producto> productos = new ArrayList<>();
    
    // Búsqueda rápida por índice
    public Producto getProducto(int indice) {
        return productos.get(indice); // O(1)
    }
    
    // Listado paginado
    public List<Producto> getPagina(int pagina, int tamaño) {
        int desde = pagina * tamaño;
        int hasta = Math.min(desde + tamaño, productos.size());
        return productos.subList(desde, hasta);
    }
}
```

**Casos:** Catálogos de e-commerce, listas de reproducción, datos de sensores.

### LinkedList - Historial de Navegación

```java
public class HistorialNavegacion {
    private final LinkedList<String> historial = new LinkedList<>();
    private int posicionActual = 0;
    
    public void visitarPagina(String url) {
        // Eliminar páginas adelante si navegamos a una nueva
        while (historial.size() > posicionActual + 1) {
            historial.removeLast();
        }
        historial.addLast(url);
        posicionActual++;
    }
    
    public String retroceder() {
        if (posicionActual > 0) {
            posicionActual--;
            return historial.get(posicionActual);
        }
        return null;
    }
    
    public String avanzar() {
        if (posicionActual < historial.size() - 1) {
            posicionActual++;
            return historial.get(posicionActual);
        }
        return null;
    }
}
```

**Casos:** Navegadores web, undo/redo, colas de transacciones.

---

## Set - Conjuntos Únicos

### HashSet - Control de IPs Bloqueadas

```java
public class Firewall {
    private final Set<String> ipsBloqueadas = new HashSet<>();
    
    public void bloquearIP(String ip) {
        ipsBloqueadas.add(ip); // O(1)
    }
    
    public boolean estaBloqueada(String ip) {
        return ipsBloqueadas.contains(ip); // O(1)
    }
}
```

**Casos:** Sistemas de seguridad, tags únicos, cupones usados, detección de duplicados.

### TreeSet - Ranking de Puntuaciones

```java
public class Ranking {
    private final TreeSet<Puntuacion> puntuaciones = new TreeSet<>();
    
    public void agregarPuntuacion(String jugador, int puntos) {
        puntuaciones.add(new Puntuacion(jugador, puntos));
    }
    
    public List<Puntuacion> getTop10() {
        return puntuaciones.descendingSet()
            .stream()
            .limit(10)
            .collect(Collectors.toList());
    }
}

class Puntuacion implements Comparable<Puntuacion> {
    String jugador;
    int puntos;
    
    @Override
    public int compareTo(Puntuacion o) {
        return Integer.compare(this.puntos, o.puntos);
    }
}
```

**Casos:** Leaderboards, eventos ordenados por tiempo, top N elementos.

### LinkedHashSet - Mantener Orden de Inserción

```java
public class GestorDeTags {
    private final Set<String> tags = new LinkedHashSet<>();
    
    public void agregarTag(String tag) {
        tags.add(tag.toLowerCase());
    }
    
    public String getTagsComoString() {
        return String.join(", ", tags);
        // Mantiene orden de primera aparición
    }
}
```

**Casos:** Tags únicos ordenados, historial de búsquedas únicas.

---

## Map - Pares Clave-Valor

### HashMap - Caché de Usuarios

```java
public class CacheUsuarios {
    private final Map<String, Usuario> cache = new HashMap<>();
    private static final int MAX_SIZE = 1000;
    
    public Usuario getUsuario(String id) {
        Usuario usuario = cache.get(id);
        if (usuario == null) {
            usuario = baseDeDatos.cargarUsuario(id);
            if (cache.size() >= MAX_SIZE) {
                // Estrategia simple: limpiar cuando está lleno
                cache.clear();
            }
            cache.put(id, usuario);
        }
        return usuario;
    }
}
```

**Casos:** Cachés en memoria, carritos de compra, sesiones de usuario.

### TreeMap - Historial de Precios

```java
public class HistorialPrecios {
    private final TreeMap<LocalDateTime, BigDecimal> precios = new TreeMap<>();
    
    public void registrarPrecio(BigDecimal precio) {
        precios.put(LocalDateTime.now(), precio);
    }
    
    public BigDecimal getPrecioEnFecha(LocalDateTime fecha) {
        // Floor entry: precio más cercano anterior o igual
        Map.Entry<LocalDateTime, BigDecimal> entry = 
            precios.floorEntry(fecha);
        return entry != null ? entry.getValue() : null;
    }
    
    public Map<LocalDateTime, BigDecimal> getPreciosEntre(
            LocalDateTime inicio, LocalDateTime fin) {
        return precios.subMap(inicio, true, fin, true);
    }
}
```

**Casos:** Series temporales, versionado, rangos de fechas.

### LinkedHashMap - Caché LRU

```java
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacidad;
    
    public LRUCache(int capacidad) {
        super(capacidad, 0.75f, true); // accessOrder = true
        this.capacidad = capacidad;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacidad;
    }
}

// Uso
LRUCache<String, Datos> cache = new LRUCache<>(100);
cache.put("A", datosA); // Acceso reciente
cache.get("A");         // Marca como reciente
cache.put("B", datosB); // Si está lleno, elimina el menos usado
```

**Casos:** Cachés con política LRU, configuración ordenada.

---

## Queue - Colas

### PriorityQueue - Triage Hospitalario

```java
public class SistemaTriage {
    private final PriorityQueue<Paciente> cola = 
        new PriorityQueue<>(Comparator.comparingInt(p -> p.getPrioridad().ordinal()));
    
    public void registrarPaciente(String nombre, Prioridad prioridad) {
        cola.offer(new Paciente(nombre, prioridad));
    }
    
    public Paciente atenderSiguiente() {
        return cola.poll(); // Retorna el de mayor prioridad
    }
}

enum Prioridad { CRITICO, GRAVE, MODERADO, LEVE }
```

**Casos:** Sistemas de emergencias, colas de impresión, planificación de tareas.

### ArrayDeque - Navegación de Directorios

```java
public class NavegadorDirectorios {
    private final Deque<String> historial = new ArrayDeque<>();
    private final Deque<String> adelante = new ArrayDeque<>();
    private String actual = "/";
    
    public void cd(String directorio) {
        historial.push(actual);
        actual = directorio;
        adelante.clear();
    }
    
    public String back() {
        if (!historial.isEmpty()) {
            adelante.push(actual);
            actual = historial.pop();
        }
        return actual;
    }
    
    public String forward() {
        if (!adelante.isEmpty()) {
            historial.push(actual);
            actual = adelante.pop();
        }
        return actual;
    }
}
```

**Casos:** Navegadores de archivos, undo/redo, algoritmos BFS/DFS.

---

## Comparativa de Casos de Uso

| Caso | Colección | Razón |
|------|-----------|-------|
| Catálogo de productos | ArrayList | Acceso rápido por índice |
| Historial navegación | LinkedList | Operaciones en extremos O(1) |
| IPs bloqueadas | HashSet | Búsqueda O(1) |
| Leaderboard | TreeSet | Ordenamiento automático |
| Caché simple | HashMap | Lookup O(1) |
| Caché LRU | LinkedHashMap | Orden de acceso |
| Cola de emergencias | PriorityQueue | Por prioridad |
| Undo/Redo | ArrayDeque | Stack eficiente |

---

## Patrones Comunes

### 1. Filtrado y Transformación

```java
List<Producto> productos = catalogo.getProductos();

List<String> nombresEnOferta = productos.stream()
    .filter(p -> p.getDescuento() > 0)
    .map(Producto::getNombre)
    .collect(Collectors.toList());
```

### 2. Agrupación

```java
Map<Categoria, List<Producto>> porCategoria = productos.stream()
    .collect(Collectors.groupingBy(Producto::getCategoria));
```

### 3. Particionamiento

```java
Map<Boolean, List<Usuario>> usuariosActivos = usuarios.stream()
    .collect(Collectors.partitioningBy(Usuario::isActivo));
```

---

Para más detalles, consulta la documentación de cada colección en la sección [Colecciones](../colecciones/index.md).

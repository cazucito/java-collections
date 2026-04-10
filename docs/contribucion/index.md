# Contribuir

Guía para contribuir al proyecto Java Collections Examples.

## Requisitos previos

- Java 21 o superior
- Maven 3.9+
- Git
- Cuenta de GitHub

## Configuración del entorno

```bash
# 1. Fork el repositorio en GitHub
# 2. Clonar tu fork
git clone https://github.com/TU_USUARIO/java-collections.git
cd java-collections

# 3. Verificar instalación
java -version  # Debe mostrar Java 21
mvn -version   # Debe mostrar Maven 3.9+

# 4. Compilar y testear
mvn clean verify
```

## Flujo de trabajo

### 1. Crear rama

```bash
git checkout -b feature/nueva-coleccion
# o
git checkout -b fix/bug-en-arraylist
```

### 2. Desarrollar

Estructura para agregar una nueva colección:

```
src/main/java/io/github/cazucito/collections/
└── nueva/
    └── NuevaColeccionExample.java

src/test/java/io/github/cazucito/collections/nueva/
└── NuevaColeccionSteps.java

src/test/resources/features/nueva/
└── nueva_coleccion.feature
```

### 3. Verificar calidad

Antes de commit, ejecuta:

```bash
mvn clean verify
```

Debe pasar:
- ✅ Compilación exitosa
- ✅ Todos los tests (217+)
- ✅ Checkstyle sin violaciones
- ✅ SpotBugs sin bugs
- ✅ Spotless formato correcto
- ✅ JaCoCo cobertura >60%

### 4. Commit

```bash
git add .
git commit -m "feat: agregar ejemplos de NuevaColeccion

- Implementar NuevaColeccionExample
- Agregar step definitions
- Crear feature file con 10 escenarios
- Cobertura 85%"
```

### 5. Push y Pull Request

```bash
git push origin feature/nueva-coleccion
```

Luego crea un Pull Request en GitHub desde tu fork al repositorio original.

## Reportar bugs

Si encuentras un bug:

1. Verifica que no exista ya un issue similar
2. Crea un issue con:
   - Descripción clara del problema
   - Pasos para reproducir
   - Comportamiento esperado vs actual
   - Versión de Java y Maven

## Sugerir mejoras

Las sugerencias son bienvenidas. Crea un issue con etiqueta `enhancement` describiendo:
- Qué quieres agregar
- Por qué sería útil
- Posible implementación

## Código de conducta

- Sé respetuoso en todas las interacciones
- Acepta feedback constructivo
- Enfócate en lo mejor para la comunidad
- Respeta diferentes opiniones y experiencias

## Contacto

- GitHub Issues: [github.com/cazucito/java-collections/issues](https://github.com/cazucito/java-collections/issues)
- Email: (ver perfil de GitHub)

¡Gracias por contribuir!

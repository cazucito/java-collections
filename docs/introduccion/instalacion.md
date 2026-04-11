# Instalación

Configura tu entorno de desarrollo en minutos y ejecuta tu primer test.

## Requisitos previos

| Herramienta | Versión mínima | Descargar |
|-------------|----------------|-----------|
| Java | 21 LTS | [OpenJDK](https://openjdk.org/projects/jdk/21/) |
| Maven | 3.9+ | [Maven](https://maven.apache.org/download.cgi) |
| Git | 2.x | [Git](https://git-scm.com/) |

Verifica tus instalaciones:

```bash
java -version
# openjdk version "21.0.x" 2024-XX-XX

mvn -version
# Apache Maven 3.9.x

git --version
# git version 2.x.x
```

## Clonar el repositorio

```bash
git clone https://github.com/cazucito/java-collections.git
cd java-collections
```

## Compilar el proyecto

```bash
# Compilar sin tests (rápido)
mvn clean compile

# Compilar con tests (recomendado)
mvn clean test

# Verificación completa (calidad de código incluida)
mvn clean verify
```

!!! success "Éxito"
    Si ves `BUILD SUCCESS`, ¡todo está configurado correctamente!

## Ejecutar tests específicos

```bash
# Todos los tests
mvn test

# Solo tests de ArrayList
mvn test -Dcucumber.filter.tags="@arraylist"

# Solo tests de un archivo feature específico
mvn test -Dcucumber.features="src/test/resources/features/list/arraylist_operations.feature"
```

## Ver reportes

Después de ejecutar `mvn verify`, encuentra los reportes en:

```
target/
├── cucumber-report.html      # Reporte BDD con Cucumber
├── site/jacoco/index.html    # Cobertura de código
├── checkstyle-result.xml     # Análisis de estilo
└── spotbugsXml.xml           # Bugs encontrados
```

Abre `target/cucumber-report.html` en tu navegador para ver los resultados.

## Comandos útiles

### Formatear código
```bash
mvn spotless:apply
```

### Solo verificar calidad (sin tests)
```bash
mvn clean verify -DskipTests
```

### Ver ayuda de Maven
```bash
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin
```

## Configuración IDE (VS Code)

1. Instala extensiones:
   - Extension Pack for Java
   - Cucumber (Gherkin) Full Support
   - Maven for Java

2. Abre el proyecto:
   ```bash
   code .
   ```

3. Configura Java 21 en `.vscode/settings.json`:
   ```json
   {
     "java.configuration.runtimes": [
       {
         "name": "JavaSE-21",
         "path": "/path/to/jdk-21",
         "default": true
       }
     ]
   }
   ```

## Solución de problemas

<details>
<summary>❌ "java.lang.UnsupportedClassVersionError"</summary>

Tu Java es anterior a la versión 21. Actualiza o configura JAVA_HOME correctamente.

```bash
export JAVA_HOME=/path/to/jdk-21
export PATH=$JAVA_HOME/bin:$PATH
```
</details>

<details>
<summary>❌ "Could not find artifact"</summary>

Limpia el caché de Maven:

```bash
rm -rf ~/.m2/repository
mvn clean install
```
</details>

<details>
<summary>❌ Tests fallan por codificación</summary>

Configura UTF-8 en tu terminal:

```bash
export MAVEN_OPTS="-Dfile.encoding=UTF-8"
```
</details>

## Próximos pasos

➡️ [Tu primer escenario BDD](primeros-pasos.md)

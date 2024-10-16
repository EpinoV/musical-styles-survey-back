# API REST: Musical Styles Survey
Esta API REST proporciona servicios relacionados con estilos musicales y permite a los usuarios guardar sus preferencias. Está desarrollada en **Java 17** utilizando **Spring Boot 3.3.4** con una base de datos en memoria **H2**.

## Requisitos Previos
1. **Java 17**: Asegúrate de tener Java 17 instalado. Verifica con:
   ```bash
   java -version
   ```
2. **Maven**: Herramienta de construcción para Java. Verifica con:
   ```bash
   mvn -version
   ```
3. **Git** (opcional, si clonas el proyecto):
   ```bash
   git --version
   ```
## Clonar el Proyecto
Si deseas clonar el proyecto desde GitHub, ejecuta:

   ```bash
   git clone git@github.com:EpinoV/musical-styles-survey-back.git
   cd musical-styles-survey-back
   ```

## Compilación y Ejecución
1. **Compilar el Proyecto** con Maven:
   ```bash
   mvn clean install
   ```
2. **Ejecutar** la Aplicación:
   ```bash
   mvn spring-boot:run
   ```
3. **Verificar la Ejecución**: La API estará disponible en:
    > <http://localhost:8085/musical-styles-survey>

## Base de Datos H2
La aplicación utiliza una base de datos en memoria H2. Puedes acceder a la consola de H2 desde:
- URL: http://localhost:8085/h2-console
- Driver: org.h2.Driver
- JDBC URL: jdbc:h2:mem:musicalstylessurvey
- Usuario: sa
- Contraseña: password

## Servicios REST y Comandos cURL
### 1. Obtener Todos los Estilos Musicales
### Endpoint:
    GET /api/v1/allMusicStyles

**Descripción**: Devuelve una lista de todos los estilos musicales disponibles.

**Comando cURL:**
   ```bash
   curl -X GET http://localhost:8085/musical-styles-survey/api/v1/allMusicStyles -H "Content-Type: application/json"
   ```

**Respuesta Exitosa:**

   ```json
[
    {
        "id": 1,
        "name": "Rock"
    },
    {
        "id": 2,
        "name": "Pop"
    }
]
   ```

### 2. Agregar Preferencia de Usuario
### Endpoint:
    POST /api/v1/userMusicPreference

**Descripción: Guarda la preferencia musical de un usuario.**

**Comando cURL:**
   ```bash
curl -X POST http://localhost:8085/musical-styles-survey/api/v1/userMusicPreference \
-H "Content-Type: application/json" \
-d '{
  "styleId": "1",
  "email": "user@example.com"
}'
   ```

**Respuesta Exitosa:**

   ```json
{
  "message": "User preference saved successfully."
}
   ```

### 3. Obtener Resumen de Estilos Musicales
### Endpoint:
    GET /api/v1/musicStyleSummary

**Descripción: Devuelve un resumen con la cantidad de votos por cada estilo musical.**

**Comando cURL:**
   ```
curl -X GET http://localhost:8085/musical-styles-survey/api/v1/musicStyleSummary -H "Content-Type: application/json"
   ```

**Respuesta Exitosa:**

   ```json
[
    {
        "musicStyleName": "Rock",
        "summaryOfVotes": 10
    },
    {
        "musicStyleName": "Pop",
        "summaryOfVotes": 20
    }
]
   ```

## Ejecución de Pruebas
Para ejecutar las pruebas unitarias, utiliza el siguiente comando:

   ```bash
   mvn test
   ```

## Despliegue en Producción

1. **Crear el Archivo JAR**:

   ```bash
   mvn clean package
   ```
Esto generará un archivo JAR en la carpeta `target/`.



2. **Ejecutar el JAR**:

   ```bash
   java -jar target/musical-styles-survey-0.0.1-SNAPSHOT.jar
   ```

3. **Verificar el Despliegue**: La API estará disponible en:
   > <http://localhost:8085/musical-styles-survey>

## Posibles Problemas

- **CORS Bloqueado**: Si usas esta API desde un frontend local (como Angular), asegúrate de habilitar CORS en la configuración de Spring Boot.
- **H2 Console No Disponible**: Asegúrate de que la consola H2 esté habilitada en `application.properties`:

   ```properties
  spring.h2.console.enabled=true
  spring.h2.console.path=/h2-console
   ```
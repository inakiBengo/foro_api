# foro_api
An api for a forum. Where you can create topics and users write in them.

## Iniciar el proyecto
Para iniciar el proyecto debe configurar la conexión a base de datos, esto lo puede hacer desde el archivo 
application.properties. 

**Debe inicializar las variables de entorno para DB_NAME, DB_USER y DB_PASSWORD con los datos para su base de datos.**
````properties
spring.application.name=foros
spring.datasource.url=jdbc:mysql://localhost/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
````

## Funcionamiento
La API cuenta con los siguientes endpoints:

- **/topicos**: 
    - POST: Crear un nuevo tópico
    ````JSON
    {
	  "titulo": "title example",
	  "mensaje": "message example",
	  "autorId": 1,
	  "cursoId": 1
    }
    ````
    - GET: Obtener una lista de todos los tópicos con formato Pageable.


- **/topicos/{id}**
    - GET: Obtener un tópico según id.
    - PUT: Actualizar tópico según id.
    ````JSON
    {
	  "titulo": "title example",
	  "mensaje": "message example",
	  "autorId": 1,
	  "cursoId": 1
    }
    ````
    - DELETE: Eliminar tópico según id.

# foro_api
An api for a forum. Where you can create topics and users write in them.

![Static Badge](https://img.shields.io/badge/Alura-Challengue-blue)
![Static Badge](https://img.shields.io/badge/Spring_Boot-green)
![Static Badge](https://img.shields.io/badge/Spring_Security_🔒-050)
![Static Badge](https://img.shields.io/badge/JWT-919)
![Static Badge](https://img.shields.io/badge/MYSQL-red)
![Static Badge](https://img.shields.io/badge/FlyWay-059)
![Static Badge](https://img.shields.io/badge/STATUS-FINISHED-orange)

## 👨‍💻 Iniciar el proyecto
Para iniciar el proyecto debe configurar la conexión a base de datos, además de crear una llave secreta y un usuario generador. 
Esto lo puede hacer desde el archivo application.properties. 

**Debe inicializar las variables de entorno para DB_NAME, DB_USER y DB_PASSWORD con los datos de su base de datos.**

**Debe inicializar las variables de entorno para SECRET_KE y USER_GENERATOR para poder crear los tokens de autenticación**
````properties
spring.application.name=foros
spring.datasource.url=jdbc:mysql://localhost/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

api.jwt.key.secret=${SECRET_KEY}
api.jwt.user.generator=${USER_GENERATOR}
````

No debe preocuparse de crear las tablas en la base de datos, flyway se encargará de eso al ejecutar el 
programa.

![img.png](img.png)

Además, en el archivo V7 de flyway se ingresarán datos de prueba en la base de datos para que no tengas que hacerlo.

![img_1.png](img_1.png)

## 🔗 Endpoints
La API cuenta con los siguientes endpoints:

- <b style="color:green">/topicos:</b> 
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


- <b style="color:green">/topicos/{id}</b>
    - GET: Obtener un tópico según id.
    - PUT: Actualizar tópico según id.
  
      Perfiles con acceso: "ADMIN","USER","DEVELOPER".

    ````JSON
    {
	  "titulo": "title example",
	  "mensaje": "message example",
	  "autorId": 1,
	  "cursoId": 1
    }
    ````
    - DELETE: Eliminar tópico según id.
      Perfiles con acceso: "ADMIN","USER".

- <b style="color:green">/cursos</b>
    - POST: Crear un nuevo curso. 

      Categoria: es un enum que acepta las siguientes categorías: PROGRAMACION, DISENO, SOFT_SKILLS

      Perfiles con acceso: "ADMIN".
    ````JSON
    {
	  "nombre": "example curso title",
	  "categoria": "PROGRAMACION"
    }
    ````
    - GET: Obtener una lista de todos los cursos con formato Pageable.

- <b style="color:green">/cursos/{id}</b>
    - GET: Obtener un solo curso según id.
    - PUT: Actualizar nombre o categoría de un curso.

      Perfiles con acceso: "ADMIN".
  
    - DELETE: Eliminar un curso según id. (Al eliminar un curso todos los tópicos enlazados a este también serán eliminados)
      
    - Perfiles con acceso: "ADMIN".
    - 
- <b style="color:green">/usuario/login</b>
    - POST: al loguearse obtendrás un token.
    REQUEST:
    ````JSON
    {
	  "nombre": "Santiago",
	  "correoElectronico": "santiago@gmail.com",
	  "contrasena": "123456"
    }
     ````
    RESPONSE:
    ````JSON
    {
	  "nombre": "Santiago",
	  "correoElectronico": "santiago@gmail.com",
	  "jwt": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBVVRIMEpXVC1CQUNLRU5EIiwic3ViIjoiU2FudGlhZ28iLCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE3MTkxODMwOTAsImV4cCI6MTcxOTE4NDg5MCwianRpIjoiMGE0NzQ3YjctNjNlYS00ZTU2LWI0MTAtM2QzZTFiNzFmOWYwIiwibmJmIjoxNzE5MTgzMDkwfQ.c2c8hCRki5DZMGBEEbmTVv4sD01UOWSM-_jYPvKinIc",
	  "status": true
    }
     ````

- <b style="color:green">/usuario/sign-up</b>
    - POST: al registrarte obtendrás un token.
      REQUEST:
    ````JSON
    {
	  "nombre": "joaquin",
	  "correoElectronico": "joaquin@gmail.com",
	  "contrasena": "123456",
	  "perfilId": {
		  "perfil": ["ADMIN"]
      }
    }
     ````
  RESPONSE:
    ````JSON
    {
	  "nombre": "joaquin",
	  "correoElectronico": "joaquin@gmail.com",
	  "jwt": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBVVRIMEpXVC1CQUNLRU5EIiwic3ViIjoiam9hcXVpbiIsImF1dGhvcml0aWVzIjoiUk9MRV9BRE1JTiIsImlhdCI6MTcxOTE4NjI1NywiZXhwIjoxNzE5MTg4MDU3LCJqdGkiOiIwNmYxNGYyOS03NzIwLTQ5MGQtOTZlNC04MjFmNDE4NjhmYjEiLCJuYmYiOjE3MTkxODYyNTd9.WDQNMV-Xp4Vos-CWFJ21h39o7ycnykl1e_Cy9H2QXMM",
	  "status": true
    }
     ````
  
## 🔑 Token de autenticación
El token guarda los siguientes valores:

El token es válido durante 30 minutos.

![img_2.png](img_2.png)


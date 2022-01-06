#case study.

## Description
Esta API contiene las siguientes funcionalidades:

* Obtener todos los usuarios
* Crear usuarios nuevos.
* Obtener todos los productos
* Crear nuevos productos.
* Crear ordenes
* Crear reportes.

### Versioning
1.0.0

#### Last modification date:
07/01/2022 by Rodolfo Miranda

#### 1. Obtiene recursos actuales.
### Endpoint
    > /api/public/v1/parrot/case/study/users GET
    > /api/public/v1/parrot/case/study/users POST
    > /api/public/v1/parrot/case/study/products GET
    > /api/public/v1/parrot/case/study/products POST
    > /api/public/v1/parrot/case/study/orders POST
    > /api/public/v1/parrot/case/study/reports GET
    
### Url Swagger
    
    > http://localhost:8080/swagger-ui.html

## instrucciones de consumo
URL :

- getAllUsers
http://localhost:8080/api/public/v1/parrot/case/study/users?page=0&size=2  GET

```

 Se envian dos parametros, la pagina actual y los elementos por pagina
 
 Ejemplo de respuesta:
 	
 	{
	  "users": [
	    {
	      "id": 1,
	      "email": "user1@parrot.com.mx",
	      "name": "User ventas"
	    },
	    {
	      "id": 2,
	      "email": "user2@parrot.com.mx",
	      "name": "User ventas2"
	    }
	  ],
	  "totalPages": 1,
	  "currentPage": 0,
	  "totalItems": 2
	}

```

- createUser
http://localhost:8080/api/public/v1/parrot/case/study/users   POST

```
 
 Ejemplo de solicitud:
 	
 	{
    	"email" : "rodo3@gmail.com",
    	"name" : "Herna3n"
	}
	
 Ejemplo de respuesta:
 
 	201 Created

```

- getAllProducts
http://localhost:8080/api/public/v1/parrot/case/study/products?page=2&size=2  GET

```

 Se envian dos parametros, la pagina actual y los elementos por pagina
 
 Ejemplo de respuesta:
 	
 	{
	    "products": [
	        {
	            "id": 5,
	            "name": "sacapuntas",
	            "price": 5.00,
	            "stock": 245
	        },
	        {
	            "id": 6,
	            "name": "Pegamento",
	            "price": 10.50,
	            "stock": 50
	        }
	    ],
	    "totalPages": 3,
	    "currentPage": 2,
	    "totalItems": 6
	}

```

- createProduct
http://localhost:8080/api/public/v1/parrot/case/study/products   POST

```
 
 Ejemplo de solicitud:
 	
 	{
	    "name" : "Pegamento",
	    "price" : "10.5",
	    "stock" : "50"
	}
	
 Ejemplo de respuesta:
 
 	201 Created

```

- createOrder
http://localhost:8080/api/public/v1/parrot/case/study/orders   POST

```
 
 Ejemplo de solicitud:
 	
 	{
	    "clientId" : 1,
	    "total" : "135.90",
	    "products": [
	        {
	            "id" : 1,
	            "quantity" : 43
	        },
	        {
	            "id" : 2,
	            "quantity" : 3
	        }
	    ]
	}
	
 Ejemplo de respuesta:
 
 	201 Created

```

- generateReport
http://localhost:8080/api/public/v1/parrot/case/study/reports?size=5&page=0&startDate=2022-01-03&endDate=2022-01-04   get

```
 
 Se envian cuatro parametros, la pagina actual, los elementos por pagina, fecha de inicio y fin para consultar.
 
 Ejemplo de respuesta:
 	
 	{
	    "startDate": "2022-01-03",
	    "endDate": "2022-01-04",
	    "products": [
	        {
	            "name": "lapiz",
	            "quantity": 10,
	            "total": 60.00
	        },
	        {
	            "name": "pluma",
	            "quantity": 8,
	            "total": 40.00
	        },
	        {
	            "name": "sacapuntas",
	            "quantity": 6,
	            "total": 30.00
	        },
	        {
	            "name": "regla",
	            "quantity": 4,
	            "total": 16.00
	        },
	        {
	            "name": "goma",
	            "quantity": 3,
	            "total": 15.00
	        }
	    ],
	    "totalPages": 1,
	    "currentPage": 0,
	    "totalItems": 5
	}

```

## Built With
* Maven
* Spring
* SpringBoot
* Spring Tools Suite
* Lombok


Se necesita tener instalado:
		
 - Java 1.8  		
 - Maven 		
 - Spring Tools Suite
 - lombok


## Deployment
    mvn spring boot:run  en Local 
O desde Spring Tools Suite click derecho sobre el proyecto -> Run As -> Spring Boot App

El profile activo es dev y esta configurado dentro el archivo application.properties.

Las configuraciones del sistema se encuentran dentro del archivo application-dev.properties en la carpeta config.

### Running JUnit tests
 - Desde pring Tools Suite click derecho sobre el proyecto  > Run As >
   JUnit Test.  

#### Base de datos

El archivo testdb.mv contiene la base de datos.

Para entrar a la consola de H2 es con la siguiente url: http://localhost:8080/h2-console

user: sa
password: pass

#### Colección Postman

La carpeta postman contiene una colección con los endpoints y poder probar las APIs.



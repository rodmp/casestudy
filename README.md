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

## instrucciones de consumo
URL :

http://localhost:8080/swagger-ui.html#!/tripplan-resources-controller/getDifferencesResourcesUsingGET

```

 - El servicio es invocable desde el paquete  **com.meep.tripplan.router.api** en el metodo:
```java
  public ResponseEntity<TripplanResourceDiffResponse> getDifferencesResources(){
    
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


### Running JUnit tests
 - Desde pring Tools Suite click derecho sobre el proyecto  > Run As >
   JUnit Test.  

### Reporting
Genera el reporte de check-style html y lo guarda en el site.

#### site
Se divide en dos partes:


 1. Informacion del proyecto.

	- Proporciona una descripción general de los diversos documentos y enlaces que forman parte de la información general de este proyecto.
	
2. Reportes de proyecto
	
	- Brindan un panoramageneral de varios reportes que son generados automaticamente por Maven.
	
EL site es generado  dentro de la ca: target > site > index.html
	

	$ mvn clean install site


Sonar es una plataforma de código abierto utilizada por los equipos de desarrollo para gestionar la calidad del código fuente.

mvn clean package site sonar:sonar -Pdevelopment_reporting

En las últimas líneas de la salida de consola hay un enlace, cópielo y péguelo en cualquier navegador web para ver el informe.

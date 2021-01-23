# fibonacci-service
Servicio para el procesamiento de la serie de Fibonacci. 

## Funcionamiento
El servicio permite la obtención de la serie completa, de la serie comprendida entre 0 y un número indicado, y el número que ocupa la posición n dentro de la serie.

## Tecnologías
El servicio está desarrollado sobre Spring Boot, utilizando un RestController que define tres endpoints para las tres operaciones indicadas anteriormente.

Los diferentes endpoints utilizan un FibonacciService para realizar las operaciones.

Se ha añadido Spring Doc Open API para documentar el servicio.

Las versiones utilizadas son:
- Java 11
- Spring Boot 2.4.2
- Spring Doc 1.5.2 

## Ejecución del servicio
Para poder ejecutarlo hay dos opciones:

- Clonar este repositorio en local y desde la raíz del proyecto (/fibonacci-service), ejecutar 
     > $ ./mvnw spring-boot:run.
      
- Se puede ejecutar la imagen de Docker del proyecto. Para ello basta ejecutar:
     > $ docker run  -d -p 8585:8585 --name fibonacci-service jorgedutton/fibonacci-service

## Prueba del servicio     
   Para probar el servicio, se puede acceder desde un navegador a la documentación de la API y ejecutar los ejemplos:
      http://localhost:8585/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/fibonacci-service

Otra opción es el uso de Postman o Curl para estas pruebas.

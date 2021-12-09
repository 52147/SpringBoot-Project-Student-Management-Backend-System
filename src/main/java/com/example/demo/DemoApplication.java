package com.example.demo;
/**
 * 
 * Three-tier architecture:
 * 
 *  database (data access layer) <-> service layer <-> Api layer(get, post, put, delete)
 *  
 *   - Spring boot is framework to build the full stack or back end application.
 *   - We have the log tomcats started on 48080, which means we have a web server up and running(http 8080)
 * 
 *   
 * Properties of Spring:
 *   
 *   - 1. Serialization: is the process of converting an object into a a stream of bytes 
 *                    to store the object or transmit it to memory, a database, or a file.
 *                    
 *     - Spring Boot project use the JSON to serialize and deserialize objects.
 *     
 *       - JSON automatically serializes object from REST APIs and deserializes parameter 
 *         like @RequestBody. 
 *       
 *                 Object -> Serializer -(stream of Bytes)-> File       -> Deserializer -> Object
 *                                                        -> Database
 *                                                        -> Memory
 *         
 *   - 2. Dependency Injection:
 *   
 *     - is a fundamental aspect of the Spring framework, 
 *     - through ‎which the Spring container “injects” objects into other objects or “dependencies”.‎                                             
 *     - Use the annotation to tell the class to inject the data, which means we can can split things into the service layer and API layer.           
 *     
 *    
 *  
 *     - Use notation can split things into the service layer and API layer.
 *     - The API layer talking successfully to the service layer 
 *       and the service layer is giving some data back to the API layer.                                        
 *                                             
 *                                                        
 */




//Run the application , spring boot will try to connect with the database
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

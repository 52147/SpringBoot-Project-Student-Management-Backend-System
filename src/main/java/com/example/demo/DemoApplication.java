package com.example.demo;
/**
 * Full stack:
 * 
 *  database <-> data access layer <-> service layer <-> Api layer(get, post, put, delete)
 *  
 *   - Spring boot is framework to build the full stack or back end application.
 *   - We have the log tomcats started on 48080, which means we have a web server up and running(http 8080)‎
 * 
 * 
 */



// Spring boot is framework to build the full stack or back end application.
// We have the log tomcats started on 48080 right here which means we have a web server up and running(http 8080)‎

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Run the application , spring boot will try to connect with the database
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

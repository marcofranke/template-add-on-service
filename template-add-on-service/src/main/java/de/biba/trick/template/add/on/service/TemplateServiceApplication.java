package de.biba.trick.template.add.on.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * This is the main class of the template. It is the entry point for the Spring
 * application.
 * 
 * @author fma
 *
 */

@SpringBootApplication
@RestController
@EnableFeignClients(basePackages = "de.biba.trick.template.add.on.service")
@EnableCircuitBreaker
@ComponentScan(basePackages = "de.biba.trick.template.add.on.service")

public class TemplateServiceApplication {


	@CrossOrigin
	@RequestMapping("/")
	public String home() {
		return "Hello,  I am the de.biba.trick.template.add.on.service for TRICK. You can just add an RESTController to get in toach with all  TRICK functions";
	}

	public static void main(String[] args) {
		SpringApplication.run(TemplateServiceApplication.class, args);
	}
}
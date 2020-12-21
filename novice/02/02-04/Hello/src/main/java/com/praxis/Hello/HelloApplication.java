package com.praxis.Hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	@GetMapping("/hello") // ini nanti yg dipanggil di localhost, jadi localhost:8080/hello
	public String hello() {
		return String.format("hello world");
	}

}

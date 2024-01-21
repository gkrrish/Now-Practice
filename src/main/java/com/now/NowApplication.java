package com.now;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NowApplication {

	public static void main(String[] args) {
		SpringApplication.run(NowApplication.class, args);
		System.out.println("Hello-World! welcome to news on whatsApp...");
	}

}

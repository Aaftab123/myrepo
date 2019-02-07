package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example"})
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		
		String str = "abcdef";
		System.out.println(str.substring(1, 3));
		
		SpringApplication.run(DemoApplication.class, args);
	}

}


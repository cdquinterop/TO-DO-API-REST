package com.todo_ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class ToDoApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApiRestApplication.class, args);
	}

}

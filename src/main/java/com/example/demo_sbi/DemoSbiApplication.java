package com.example.demo_sbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DemoSbiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSbiApplication.class, args);
	}

}

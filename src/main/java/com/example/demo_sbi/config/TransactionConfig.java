package com.example.demo_sbi.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		return new JpaTransactionManager(entityManagerFactory);
	}
}

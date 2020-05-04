package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.controller.WalletController;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
@EntityScan(basePackages = "com.example.demo.entities")
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
@SpringBootApplication
public class WalletApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	 private static final Logger logger = LoggerFactory.getLogger(WalletApplication.class);
	
	public static void main(String[] args) {
		logger.info("this is a info message");
	    logger.warn("this is a warn message");
	    logger.error("this is a error message");
		SpringApplication.run(WalletApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		 
		 
		
	}

}

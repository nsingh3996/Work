package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class CustomerRepositoryTests {

	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void testRepositorySave()
	{
		Customer customer=new Customer();
		customer.setAccountNumber("123456789");
		customer.setCustomerName("Nikhil Singh");
		customer.setPanNumber("QWERTY123");
		customer.setAadharNumber("232345456767");
		customer.setPhoneNo("7358724781");
		customer.setAmount(56000.0f);
		customer.setUsername("rayansh39");
		customer.setPassword("nikhil");
		
		customerRepository.save(customer);
		
		Assert.assertNotNull(customer.getUserId());
		
	}
	
	@Test
	public void testRepositoryGetById()
	{
		Customer customer=new Customer();
		customer.setAccountNumber("123456789");
		customer.setCustomerName("Nikhil Singh");
		customer.setPanNumber("QWERTY123");
		customer.setAadharNumber("232345456767");
		customer.setPhoneNo("7358724781");
		customer.setAmount(56000.0f);
		customer.setUsername("rayansh39");
		customer.setPassword("nikhil");
		
		customerRepository.save(customer);
		Optional<Customer> found=customerRepository.findById(customer.getUserId());
		assertThat(found.get()).isEqualTo(customer);
	}
	
	@Test
	public void testRepositoryDelete()
	{
		Customer customer=new Customer();
		customer.setAccountNumber("123456789");
		customer.setCustomerName("Nikhil Singh");
		customer.setPanNumber("QWERTY123");
		customer.setAadharNumber("232345456767");
		customer.setPhoneNo("7358724781");
		customer.setAmount(56000.0f);
		customer.setUsername("rayansh39");
		customer.setPassword("nikhil");
		
		customerRepository.save(customer);
		customerRepository.delete(customer);
		assertThat(customerRepository.findById(customer.getUserId())).isNotEqualTo(customer);
	}

}

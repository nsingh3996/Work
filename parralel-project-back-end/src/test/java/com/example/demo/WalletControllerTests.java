package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.WalletController;
import com.example.demo.entities.Customer;
import com.example.demo.entities.ResourceNotFoundException;
import com.example.demo.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class WalletControllerTests {

	
	@Autowired
	WalletController walletController;
	
	@Test
	public void testControllerAddCustomer()
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
		
		walletController.addCustomer(customer);
		
		Assert.assertNotNull(customer.getUserId());
		
	}
	
	@Test
	public void testControllerGetCustomerById()
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
		
		walletController.addCustomer(customer);
		Customer found=null;
		try {
			found = walletController.getCustomerById(customer.getUserId());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(found).isEqualTo(customer);
	}
	
	@Test
	public void testControllerDeleteCustomerById()
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
		
		walletController.addCustomer(customer);
		try {
			walletController.deleteCustomer(customer.getUserId());
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		try {
			assertThat(walletController.getCustomerById(customer.getUserId())).isNotEqualTo(customer);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
	}

}

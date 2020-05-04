package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.ResourceNotFoundException;
import com.example.demo.entities.Transactions;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class WalletController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		//return customerRepository.findAll();
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable Long id) throws ResourceNotFoundException {
//		Optional<Customer> customer= customerRepository.findById(id);
//		if(customer.isPresent()) {
//            return customer.get();
//        } else {
//            throw new ResourceNotFoundException("No customer record exist for given id");
//        }
		return customerService.getCustomerById(id);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public boolean deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
//		Optional<Customer> customer= customerRepository.findById(id);
//		if(customer.isPresent()) {
//			customerRepository.delete(customer.get());
//        } else {
//            throw new ResourceNotFoundException("No customer record exist for given id");
//        }
		customerService.deleteCustomerById(id);
		return true;
		
	}
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer c) {
		
//		Customer c1 = customerRepository.save(c);
//		transactionRepository.deleteZero();
//		System.out.println("Customer added to database");
//		return c1;
		return customerService.addCustomer(c);
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer c) {
//		System.out.println("Customer updated in database");
//		return customerRepository.save(c);
		return customerService.updateCustomer(c);
	}
	
	@PutMapping("/makeTransaction")
	public Customer makeTransaction(@RequestBody Customer c) {
//		Customer c1 = customerRepository.save(c);
//		return c1;
		return customerService.makeTransaction(c);
	}
	

	
	
}

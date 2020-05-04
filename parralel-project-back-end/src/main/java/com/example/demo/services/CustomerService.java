package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Customer;
import com.example.demo.entities.ResourceNotFoundException;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public void deleteCustomerById(Long id) throws ResourceNotFoundException;
	public Customer getCustomerById(Long id) throws ResourceNotFoundException;
	public List<Customer> getAllCustomers();
	public Customer updateCustomer(Customer customer);
	public Customer makeTransaction(Customer customer);

}

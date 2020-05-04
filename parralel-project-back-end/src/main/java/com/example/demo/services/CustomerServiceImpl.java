package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.ResourceNotFoundException;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.TransactionRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer c1 = customerRepository.save(customer);
		transactionRepository.deleteZero();
		System.out.println("Customer added to database");
		return c1;

	}

	@Override
	public void deleteCustomerById(Long id)throws ResourceNotFoundException {
		Optional<Customer> customer= customerRepository.findById(id);
		if(customer.isPresent()) {
			customerRepository.delete(customer.get());
        } else {
            throw new ResourceNotFoundException("No customer record exist for given id");
        }

	}

	@Override
	public Customer getCustomerById(Long id) throws ResourceNotFoundException{
		Optional<Customer> customer= customerRepository.findById(id);
		if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new ResourceNotFoundException("No customer record exist for given id");
        }
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		System.out.println("Customer updated in database");
		return customerRepository.save(customer);
	}

	@Override
	public Customer makeTransaction(Customer customer) {
		Customer c1 = customerRepository.save(customer);
		return c1;
	}

}

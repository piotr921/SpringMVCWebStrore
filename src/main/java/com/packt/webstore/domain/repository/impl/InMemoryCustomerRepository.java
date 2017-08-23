package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> customers = new ArrayList<>();
	
	public InMemoryCustomerRepository() {
		
		Customer customer1 = new Customer();
		customer1.setName("John Smith");
		customer1.setCustomerId("C001");
		customer1.setAddress("Washington st. 123, Boston");
		customer1.setNoOfOrdersMade(5);
		
		Customer customer2 = new Customer();
		customer2.setName("Johann Muller");
		customer2.setCustomerId("C009");
		customer2.setAddress("AlexanderPlatz 6, Berlin");
		customer1.setNoOfOrdersMade(80);
		
		Customer customer3 = new Customer();
		customer3.setName("Robert Roy");
		customer3.setCustomerId("C162");
		customer3.setAddress("Maple Leaf st. 72, Toronto");
		customer3.setNoOfOrdersMade(96);
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customers.stream()
				.filter(customer -> customer.getCustomerId().equals(customerId))
				.findFirst().orElseThrow(() -> 
				new IllegalArgumentException("Customer with id: " + customerId + " doesn't exist in our store"));
	}
}

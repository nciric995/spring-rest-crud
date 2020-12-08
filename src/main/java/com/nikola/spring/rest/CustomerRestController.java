package com.nikola.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikola.spring.entity.Customer;
import com.nikola.spring.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	//add mapping for GET/customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	
	//add mapping for GET/customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer==null) {
			throw new CustomerNotFoundException("Customer id not found - " +customerId);
		}
		
		return theCustomer;
	}
	
	//add mapping for POST/customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0); // if id is 0, then DAO will insert new customer
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	//add mapping for PUT/customers
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
		
	}
	
	//add mapping for DELETE/customers/{customerId}
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		//throw exception if is null
		if(tempCustomer==null) {
			throw new CustomerNotFoundException("Customer id not found - " +customerId);
		}
		
		
		customerService.deleteCustomer(customerId);
		return "Deleted customer id - " +customerId;
	}
	
}

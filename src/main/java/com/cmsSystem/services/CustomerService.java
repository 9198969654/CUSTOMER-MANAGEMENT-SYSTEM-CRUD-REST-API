package com.cmsSystem.services;

import com.cmsSystem.entities.Customer;
import com.cmsSystem.exception.CustomerNotFoundException;
import com.cmsSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();

    }

    public Customer getCustomer(Long theId) {
        return customerRepository.findById(theId).orElseThrow(() ->
                new CustomerNotFoundException("The Required customer could not be found"));
    }

    public Customer addCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    public void deleteCustomer(Long theId) {
        customerRepository.deleteById(theId);
    }
}

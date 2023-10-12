package com.cmsSystem.controllers;


import com.cmsSystem.entities.Customer;
import com.cmsSystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //get All Customer
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> allCustomers = customerService.getCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    //get All Customer
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long theId){

       Customer theCustomer =  customerService.getCustomer(theId);
       return new ResponseEntity<>(theCustomer, HttpStatus.OK);

    }
    //Post Customer
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer theCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }

    //Put Customer
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer theCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }

    //Delete Customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long theId){
        customerService.deleteCustomer(theId);
    }

}

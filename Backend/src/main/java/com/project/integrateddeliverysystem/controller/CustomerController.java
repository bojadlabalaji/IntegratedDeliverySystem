package com.project.integrateddeliverysystem.controller;

import com.project.integrateddeliverysystem.entity.Customer;
import com.project.integrateddeliverysystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    private Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/getCustomerByKey")
    private Optional<Customer> getCustomerByKey(@RequestParam(name = "phone") String phone){

        System.out.println("Phone number is: "+phone);
        return customerService.getCustomerByKey(phone);
    }
}

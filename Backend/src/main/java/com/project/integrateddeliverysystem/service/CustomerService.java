package com.project.integrateddeliverysystem.service;

import com.project.integrateddeliverysystem.entity.Customer;
import com.project.integrateddeliverysystem.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomer(Customer customer){
        System.out.println(customer.getName());
        return customerRepo.save(customer);
    }

    public Optional<Customer> getCustomerByKey(String phone) {
        return customerRepo.findById(phone);
    }
}

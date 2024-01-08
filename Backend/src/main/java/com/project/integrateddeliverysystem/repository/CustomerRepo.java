package com.project.integrateddeliverysystem.repository;

import com.project.integrateddeliverysystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer, String> {


}

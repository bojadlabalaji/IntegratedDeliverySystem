package com.project.integrateddeliverysystem.repository;

import com.project.integrateddeliverysystem.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store, String> {
}

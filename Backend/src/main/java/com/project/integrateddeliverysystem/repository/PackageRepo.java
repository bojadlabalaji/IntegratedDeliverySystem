package com.project.integrateddeliverysystem.repository;

import com.project.integrateddeliverysystem.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepo  extends JpaRepository<Package, String> {

}

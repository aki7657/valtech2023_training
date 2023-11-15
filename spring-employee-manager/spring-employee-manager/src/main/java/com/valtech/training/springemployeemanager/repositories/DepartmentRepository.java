package com.valtech.training.springemployeemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.springemployeemanager.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

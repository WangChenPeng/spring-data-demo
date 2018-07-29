package com.demo.repository;

import com.demo.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCRUDRepository extends CrudRepository<Employee,Integer> {

}

package com.demo.repository;

import com.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeJPARepository extends JpaRepository<Employee,Integer> {


}

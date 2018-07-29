package com.demo.repository;

import com.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaSpecificationExecutorRepository extends JpaSpecificationExecutor<Employee> {
}

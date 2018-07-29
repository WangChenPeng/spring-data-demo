package com.demo.service;

import com.demo.domain.Employee;
import com.demo.repository.EmployeeCRUDRepository;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCRUDRepository crudRepository;

    @Transactional
    public void update(Integer id, Integer age){

        employeeRepository.update(id, age);
    }

    @Transactional
    public void Save(List<Employee> employeeList){
        crudRepository.save(employeeList);
    }
}

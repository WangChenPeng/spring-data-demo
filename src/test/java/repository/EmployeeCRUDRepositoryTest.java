package repository;

import com.demo.domain.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class EmployeeCRUDRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeService employeeService =null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void TestEmployeeRepository1(){
        ArrayList<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setName("123");
        employee1.setAge(123);
        Employee employee2 = new Employee();
        employee2.setName("111");
        employee2.setAge(11);
        Employee employee3 = new Employee();
        employee3.setName("222");
        employee3.setAge(22);
        Employee employee4 = new Employee();
        employee4.setName("333");
        employee4.setAge(33);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        employeeService.Save(employees);
    }
}

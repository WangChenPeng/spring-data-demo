package repository;

import com.demo.domain.Employee;
import com.demo.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository =null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void TestEmployeeRepository1(){
        Employee employee = employeeRepository.findByName("张三");
        System.out.println(employee);

    }

    @Test
    public void TestEmployeeRepository2(){
        List<Employee> all = employeeRepository.findAll();
        System.out.println(all);

    }

    @Test
    public void TestEmployeeRepository3(){
        /*
        插入不会返回id 但是如果插入成功可以返回插入的实体 并从中可以获取id
         */
        Employee employee = new Employee();
        employee.setAge(16);
        employee.setName("马六");
        Employee save = employeeRepository.save(employee);
        System.out.println(save);

    }

    @Test
    public void TestEmployeeRepository4(){
        Long count = employeeRepository.count();
        System.out.println(count);

    }

    @Test
    public void TestEmployeeRepository5(){
        Boolean exists = employeeRepository.exists(4);
        System.out.println(exists);
    }

    @Test
    public void TestEmployeeRepository6(){
        try {
            /*
            没有返回值 如果删除失败会有异常
             */
            employeeRepository.delete(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestEmployeeRepository7(){
        try {
            /*
            传入实体的删除一样只能根据id删除 传入其他参数目测无效
             */
            Employee employee = new Employee();
            employee.setId(7);
            employeeRepository.delete(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestEmployeeRepository8(){
        List<Employee> te = employeeRepository.findByNameStartingWithAndAgeLessThan("te", 23);
        for (Employee employee : te) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository9(){
        List<Employee> te = employeeRepository.findByNameEndingWithAndAgeLessThan("11", 33);
        for (Employee employee : te) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository10(){
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(list, 55);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository11(){
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(list, 14);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository12(){
        Employee employeeById = employeeRepository.getEmployeeByMaxId();
        System.out.println(employeeById);
    }

    @Test
    public void TestEmployeeRepository13(){
        List<Employee> list = employeeRepository.queryParams1( 16,"马六");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository14(){
        List<Employee> list = employeeRepository.queryParams2( 16,"马六");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository15(){
        List<Employee> list = employeeRepository.querylike1("六");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository16(){
        List<Employee> list = employeeRepository.querylike1("1");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestEmployeeRepository17(){
        Long count = employeeRepository.getCount();
        System.out.println(count);
    }


}

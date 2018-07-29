package repository;

import com.demo.repository.EmployeeJpaSpecificationExecutorRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.JpaSpecificationExecutorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {


    private ApplicationContext ctx = null;

    private JpaSpecificationExecutorRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(JpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void Test(){

    }

}

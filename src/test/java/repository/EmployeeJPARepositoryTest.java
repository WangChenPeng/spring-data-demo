package repository;

import com.demo.domain.Employee;
import com.demo.repository.EmployeeJPARepository;
import com.demo.repository.EmployeePagingAndSortingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class EmployeeJPARepositoryTest {
    private ApplicationContext ctx = null;

    private EmployeeJPARepository jpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        jpaRepository = ctx.getBean(EmployeeJPARepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void TestFind() {
        Employee one = jpaRepository.findOne(21);
        System.out.println(one);

        System.out.println("Employee[21]是否存在"+jpaRepository.exists(21));

    }
}

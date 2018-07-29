package repository;

import com.demo.domain.Employee;
import com.demo.repository.EmployeePagingAndSortingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext ctx = null;

    private EmployeePagingAndSortingRepository employeeService = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void TestPage() {
        //从第0条记录开始显示 每页显示5条
        PageRequest pageRequest = new PageRequest(0, 5);
        Page<Employee> all = employeeService.findAll(pageRequest);

        System.out.println("查询的总页数" + all.getTotalPages());
        System.out.println("查询的总记录" + all.getTotalElements());
        //页数从0开始
        System.out.println("查询当前是第几页" + (all.getNumber() + 1));
        System.out.println("查询的当前页面的集合" + all.getContent());
        System.out.println("查询当前页面的记录数" + all.getNumberOfElements());

        for (Employee employee : all) {
            System.out.println(employee);
        }
    }

    @Test
    public void TestPageAndSort() {
        //创建一个order 此处第二个参数为 要根据哪个字段排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "age");
        //创建一个排序规则
        Sort orders = new Sort(order);

        //从第0条记录开始显示 每页显示5条
        PageRequest pageRequest = new PageRequest(0, 5,orders);
        Page<Employee> all = employeeService.findAll(pageRequest);

        System.out.println("查询的总页数" + all.getTotalPages());
        System.out.println("查询的总记录" + all.getTotalElements());
        //页数从0开始
        System.out.println("查询当前是第几页" + (all.getNumber() + 1));
        System.out.println("查询的当前页面的集合" + all.getContent());
        System.out.println("查询当前页面的记录数" + all.getNumberOfElements());

        for (Employee employee : all) {
            System.out.println(employee);
        }
    }
}

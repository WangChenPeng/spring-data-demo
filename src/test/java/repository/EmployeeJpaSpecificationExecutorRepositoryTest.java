package repository;

import com.demo.domain.Employee;

import com.demo.repository.EmployeeJpaSpecificationExecutorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeJpaSpecificationExecutorRepository jpaSpecificationExecutorRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        jpaSpecificationExecutorRepository = (EmployeeJpaSpecificationExecutorRepository) ctx.getBean("employeeJpaSpecificationExecutorRepository");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    /**
     * 1 分页 根据id
     * 2 排序 降序
     * 3 查询条件 age>50
     */
    @Test
    public void TestQuery() {

        System.out.println("执行");
        //创建一个order 此处第二个参数为 要根据哪个字段排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        //创建一个排序规则
        Sort orders = new Sort(order);

        /**
         * root 就是我们的查询的类型(employee)
         * query 添加查询条件
         * cb 构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //root 里面有一个 employee employee里面有一个age
                Path path = root.get("age");

                return cb.gt(path, 50);
            }
        };

        //根据id倒序分页 从第0条记录开始显示 每页显示5条
        PageRequest pageRequest = new PageRequest(0, 5,orders);
        //根据查询条件 age 大于 50 并且根据结果的id倒序分页  根据条件分页来查询
        Page<Employee> all = jpaSpecificationExecutorRepository.findAll(specification,pageRequest);

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

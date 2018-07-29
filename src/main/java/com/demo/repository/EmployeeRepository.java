package com.demo.repository;

import com.demo.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * extends Repository<Employee,Integer>
 * 此接口是标记接口 如果继承了此接口会被spring所管理 第一个泛型为要操作的实体类 第二个为主键的类型
 * 如果不继承接口的话也可以用注解标识
 * 注解RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
 */
//@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee, Integer> {

    public Employee findByName(String name);

    List<Employee> findAll();

    Employee save(Employee employee);

    Boolean exists(Integer id);

    Long count();

    void delete(Integer id);

    void delete(Employee employee);

    /**
     * where name like ?% and age <?
     *
     * @param name
     * @param age
     * @return
     */
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    /**
     * where name in(?,?...) or age <?
     *
     * @param name
     * @param age
     * @return
     */
    List<Employee> findByNameInAndAgeLessThan(List<String> name, Integer age);

    List<Employee> findByNameInOrAgeLessThan(List<String> name, Integer age);

    /**
     * 此处Employee是类名不是表明
     *
     * @return
     */
    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    /**
     * 此处 query中的1 2 代表着传入参数的顺序
     *
     * @param age
     * @param name
     * @return
     */
    @Query("select o from Employee o where o.name=?2 and o.age=?1")
    List<Employee> queryParams1(Integer age, String name);

    /**
     * 此处 query中的:name :age代表着传入参数的前声明的参数名
     *
     * @param age
     * @param name
     * @return
     */
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    List<Employee> queryParams2(@Param("age") Integer age, @Param("name") String name);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> querylike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> querylike2(@Param("name") String name);

    /**
     * 开启原生sql查询 默认不开启原生sql
     * 此时from 后为表名
     *
     * @return
     */
    @Query(nativeQuery = true, value = "select count(*) from employee")
    Long getCount();

    @Modifying
    @Query("update Employee o set o.age=:age where o.id=:id")
    void update(@Param("id") Integer id,@Param("age") Integer age);
}

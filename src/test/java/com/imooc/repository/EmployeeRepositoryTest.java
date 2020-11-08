package com.imooc.repository;

import com.imooc.domain.Employee;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/8
 */
public class EmployeeRepositoryTest extends TestCase {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    public void testFindByName() {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee);
    }
}
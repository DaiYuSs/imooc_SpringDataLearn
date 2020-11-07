package com.imooc.dao;

import com.imooc.domain.Student;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/7
 */
public class StudentDAOSpringJdbcImplTest extends TestCase {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery() {
        List<Student> query = studentDAO.query();
        for (Student student : query) {
            System.out.println(student);
        }
    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("Test-Spring-jdbc");
        student.setAge(40);
        studentDAO.save(student);
    }
}
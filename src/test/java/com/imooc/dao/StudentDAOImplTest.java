package com.imooc.dao;

import com.imooc.domain.Student;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/7
 */
public class StudentDAOImplTest extends TestCase {

    @Test
    public void testQuery() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> query = studentDAO.query();
        for (Student student : query) {
            System.out.println(student);
        }
    }

    @Test
    public void testSave() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("Test");
        student.setAge(30);
        studentDAO.save(student);
    }
}
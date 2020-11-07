package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类：通过最原始的JDBC的方式操作
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/7
 */
public class StudentDAOImpl implements StudentDAO {

    /**
     * 查询所有学生
     *
     * @return 返回所有学生
     */
    @Override
    public List<Student> query() {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select id, name ,age from student";

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            Student student;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.relsease(resultSet, statement, connection);
        }

        return students;
    }

    /**
     * 添加一个学生
     *
     * @param student 待添加的学生
     */
    @Override
    public void save(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "insert into student(name ,age) values(?,?)";

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.relsease(resultSet, statement, connection);
        }
    }
}

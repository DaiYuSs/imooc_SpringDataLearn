package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/7
 */
public interface StudentDAO {

    /**
     * 查询所有学生
     *
     * @return 返回所有学生
     */
    List<Student> query();


    /**
     * 添加一个学生
     *
     * @param student 待添加的学生
     */
    void save(Student student);
}

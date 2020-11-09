package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/8
 */
public interface EmployeeRepository extends Repository<Employee, Integer> {

    Employee findByName(String name);

    /**
     * where name like ?% and age <?
     *
     * @param name 名字开头
     * @param age  小于该年龄
     * @return Employee的列表
     */
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    /**
     * where name like ?% and age <?
     *
     * @param name 名字结尾
     * @param age  小于该年龄
     * @return Employee的列表
     */
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    /**
     * where name in (?,?...) or age <?
     *
     * @param name 包含名列表
     * @param age  小于该年龄
     * @return Employee的列表
     */
    List<Employee> findByNameInOrAgeLessThan(List<String> name, Integer age);
}
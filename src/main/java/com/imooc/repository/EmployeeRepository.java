package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.Repository;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/8
 */
public interface EmployeeRepository extends Repository<Employee, Integer> {

    Employee findByName(String name);
}
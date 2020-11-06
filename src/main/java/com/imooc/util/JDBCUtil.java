package com.imooc.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * JDBC工具类
 * 1) 获取Connection
 * 2) 释放资源
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/6
 */
public class JDBCUtil {

    /**
     * 获取Connection
     *
     * @return 所获的到的JDBC的Connection
     */
    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql:///spring_data";
        String user = "root";
        String password = "root";
        String driverClass = "com.mysql.jdbc.Driver";
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}

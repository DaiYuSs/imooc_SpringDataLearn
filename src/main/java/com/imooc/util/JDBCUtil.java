package com.imooc.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

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

//        String url = "jdbc:mysql:///spring_data";
//        String user = "root";
//        String password = "root";
//        String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        // 加载inputStream的数据
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 释放DB相关的资源
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void relsease(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.imooc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/7
 */
public class DataSourceTest {
    private ApplicationContext ctx = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource() {
        System.out.println("testDataSource");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testJdbcDataSource() {
        System.out.println("testJdbcTemplate");
        JdbcTemplate dataSource = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(dataSource);
    }
}

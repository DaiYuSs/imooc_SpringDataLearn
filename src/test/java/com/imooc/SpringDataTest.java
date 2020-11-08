package com.imooc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/8
 */
public class SpringDataTest {
    private ApplicationContext ctx = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEntityMangerFactory() {

    }
}

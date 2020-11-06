package com.imooc.util;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/6
 */

public class JDBCUtilTest extends TestCase {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
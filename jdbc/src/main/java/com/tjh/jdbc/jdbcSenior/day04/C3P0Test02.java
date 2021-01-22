package com.tjh.jdbc.jdbcSenior.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-20
 *
 * 方式二：使用配置文件
 *
 */
public class C3P0Test02 {

    @Test
    public void testGetConnection1() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");//hellc3p0：c3p0-config.xml 中的 <named-config name="hellc3p0">
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

}

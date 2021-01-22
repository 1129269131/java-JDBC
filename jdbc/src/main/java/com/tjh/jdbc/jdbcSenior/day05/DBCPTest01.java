package com.tjh.jdbc.jdbcSenior.day05;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-21
 *
 * 方式一：不推荐：硬编码的方式
 *
 */
public class DBCPTest01 {

    @Test
    public void testGetConnection() throws SQLException{
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///test");
        source.setUsername("root");
        source.setPassword("root");

        //还可以设置其他涉及数据库连接池管理的相关属性：
        source.setInitialSize(10);
        source.setMaxActive(10);
        //。。。

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

}

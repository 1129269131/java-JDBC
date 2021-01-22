package com.tjh.jdbc.jdbcSenior.day05;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Create by koala on 2021-01-21
 *
 * 方式二：推荐：使用配置文件
 *
 */
public class DBCPTest02 {

    @Test
    public void testGetConnection1() throws Exception{
        Properties pros = new Properties();

		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");

        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

}

package com.tjh.jdbc.jdbcSenior.day05;

import org.junit.Test;

import java.sql.Connection;

/**
 * Create by koala on 2021-01-21
 */
public class DBCPUtilsTest03 {

    @Test
    public void testGetConnection() throws Exception {
        Connection conn = DBCPUtils03.getConnection();
        System.out.println(conn);
    }

}

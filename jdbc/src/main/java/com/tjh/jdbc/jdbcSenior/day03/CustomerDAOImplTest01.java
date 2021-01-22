package com.tjh.jdbc.jdbcSenior.day03;

import com.tjh.jdbc.jdbcSenior.JDBCUtils;
import com.tjh.jdbc.jdbcSenior.day02.Customer02;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Create by koala on 2021-01-20
 */
public class CustomerDAOImplTest01 {

    private CustomerDAOImpl01 dao = new CustomerDAOImpl01();

    @Test
    public void testGetCustomerById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            Customer02 cust = dao.getCustomerById(conn, 19);

            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testGetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            List<Customer02> list = dao.getAll(conn);

            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, null);
        }
    }

}

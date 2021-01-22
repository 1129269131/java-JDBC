package com.tjh.jdbc.jdbcSenior.day07;

import com.tjh.jdbc.jdbcSenior.day02.Customer02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-21
 *
 * 自定义ResultSetHandler的实现类
 *
 */
public class QueryRunnerTest04 {

    @Test
    public void testQuery(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidUtils01.getConnection();

            String sql = "select id,name,email,birth from customers where id = ?";
            ResultSetHandler<Customer02> handler = new ResultSetHandler<Customer02>(){

                @Override
                public Customer02 handle(ResultSet rs) throws SQLException {
					/*System.out.println("handle");
					return null;*/

					//return new Customer02(12, "成龙", "Jacky@126.com", new Date(234324234324L));

                    if(rs.next()){
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        Date birth = rs.getDate("birth");
                        Customer02 customer = new Customer02(id, name, email, birth);
                        return customer;
                    }

                    return null;
                }

            };
            Customer02 customer = runner.query(conn, sql, handler,1);
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DruidUtils01.closeResource(conn, null);
        }

    }

}

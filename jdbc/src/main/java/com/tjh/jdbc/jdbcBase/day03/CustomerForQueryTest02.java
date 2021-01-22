package com.tjh.jdbc.jdbcBase.day03;

import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Create by koala on 2021-01-18
 *
 * 针对于customers表的通用的查询操作
 *
 */
public class CustomerForQueryTest02 {

    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";
        Customer01 customer = queryForCustomers(sql, 13);
        System.out.println(customer);

        sql = "select name,email from customers where name = ?";
        Customer01 customer1 = queryForCustomers(sql,"周杰伦");
        System.out.println(customer1);
    }

    public Customer01 queryForCustomers(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils01.getConnection();

            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据: ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                Customer01 cust = new Customer01();
                //处理结果集一行数据中的每一个列
                for(int i = 0;i < columnCount;i++){
                    //获取列值
                    Object columValue = rs.getObject(i + 1);

                    //获取每个列的列名
					String columnName = rsmd.getColumnName(i + 1);

                    //给cust对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = Customer01.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cust, columValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils01.closeResource(conn, ps, rs);
        }

        return null;
    }

}

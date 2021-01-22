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
 * 针对于Order表的通用的查询操作
 *
 * 针对于表的字段名与类的属性名不相同的情况：
 * 1. 必须声明sql时，使用类的属性名来命名字段的别名
 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
 *    获取列的别名。
 *  说明：如果sql中没有给字段起别名，getColumnLabel()获取的就是列名
 *
 */
public class OrderForQueryTest03 {

    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order03 order = orderForQuery(sql,1);
        System.out.println(order);
    }

    public Order03 orderForQuery(String sql, Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils01.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            //执行，获取结果集
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                Order03 order = new Order03();
                for(int i = 0;i < columnCount;i++){
                    //获取每个列的列值:通过ResultSet
                    Object columnValue = rs.getObject(i + 1);
                    //通过ResultSetMetaData
                    //获取列的列名：getColumnName() --不推荐使用
                    //String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名：getColumnLabel()
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //通过反射，将对象指定名columnName的属性赋值为指定的值columnValue
                    Field field = Order03.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }

                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils01.closeResource(conn, ps, rs);
        }

        return null;
    }

}

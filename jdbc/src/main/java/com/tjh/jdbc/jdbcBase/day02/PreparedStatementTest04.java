package com.tjh.jdbc.jdbcBase.day02;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Create by koala on 2021-01-18
 */
public class PreparedStatementTest04 {

    @Test
    public void testCommonUpdate(){
		/*String sql = "delete from customers where id = ?";
		update(sql,3);*/

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql,"DD","2");
    }

    //通用的增删改操作
    public void update(String sql,Object ...args){//sql中占位符的个数与可变形参的长度相同！
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils02.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);//小心参数声明错误！！
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.资源的关闭
            JDBCUtils02.closeResource(conn, ps);
        }

    }

}

package com.tjh.jdbc.jdbcBase.day05;

import com.tjh.jdbc.jdbcBase.day03.JDBCUtils01;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Create by koala on 2021-01-19
 *
 * 测试使用PreparedStatement操作Blob类型的数据
 *
 */
public class BlobTest01 {

    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() throws Exception{
        Connection conn = JDBCUtils01.getConnection();
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,"张三");
        ps.setObject(2, "zhang@qq.com");
        ps.setObject(3,"1992-09-08");
        FileInputStream is = new FileInputStream(new File("playgirl.jpg"));
        ps.setBlob(4, is);

        ps.execute();

        JDBCUtils01.closeResource(conn, ps);
    }

}

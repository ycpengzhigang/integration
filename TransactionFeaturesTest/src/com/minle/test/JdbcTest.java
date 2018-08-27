package com.minle.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.minle.util.JDBCUtils;
/**
 * 测试类
 */
public class JdbcTest {
	    /**
	     * 测试链接的数据的正确性
	     */
	    @Test
	    public void add() {
	        Connection conn = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        
	        try {
	            // 获取连接
	            conn = JDBCUtils.getConnection();
	            
	            // 编写sql
	            String sql = "insert into account(name,money) values (?,?)";
	            
	            // 创建语句执行者
	            st= conn.prepareStatement(sql);
	            
	            //设置参数
	            st.setString(1, "ddd");
	            st.setFloat(2, 2000);
	            
	            // 执行sql
	            int i = st.executeUpdate();
	            
	            if(i==1) {
	                System.out.println("数据添加成功！");
	            }else {
	                System.out.println("数据添加失败！");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JDBCUtils.colseResource(conn, st, rs);
	        }
	    }
	    
	    
}

package dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import 连接数据库.JDBCUtils;

public class ChaXunTeShuZhi {
	//查询一共有多少条记录
	@Test
	public void testQuery5() throws Exception{
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			
			String sql = "select count(*) from customers";
			
			ScalarHandler handler = new ScalarHandler();
			
			Long count = (Long) runner.query(conn, sql, handler);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResources(conn, null);
			
		}
		
	}
	
	//查询最大的日期值
	@Test
	public void testQuery6() throws Exception{
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			
			String sql = "select max(birth) from customers";
			
			ScalarHandler handler = new ScalarHandler();
			Date maxBirth = (Date) runner.query(conn, sql, handler);
			System.out.println(maxBirth);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResources(conn, null);
			
		}
		
	}
}

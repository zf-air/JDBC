package dbutils;

import java.sql.Connection;

import org.junit.Test;


public class TestDemo {
	@Test
	public void test() throws Exception {
		Connection conn =null;
		conn=JDBCUtils.getConnection();
		System.out.println(conn);
	}
}

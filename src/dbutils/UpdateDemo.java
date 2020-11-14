package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import 连接数据库.JDBCUtils;

public class UpdateDemo {
	// 更改数据
	@Test
	public void testInsert() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "update customers set email=? where name=?";

			
			int insertCount = runner.update(conn, sql,  "cai@126.com", "蔡徐坤");
			System.out.println("更改了" + insertCount + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResources(conn, null);
		}

	}
}

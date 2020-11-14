package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import 连接数据库.JDBCUtils;

public class DeleteDemo {
	@Test
	public void delete() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "delete from customers where name=?";

			int insertCount = runner.update(conn, sql,"蔡徐坤");
			System.out.println("删除了" + insertCount + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResources(conn, null);
		}
	}
}

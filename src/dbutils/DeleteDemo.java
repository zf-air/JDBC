package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import �������ݿ�.JDBCUtils;

public class DeleteDemo {
	@Test
	public void delete() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "delete from customers where name=?";

			int insertCount = runner.update(conn, sql,"������");
			System.out.println("ɾ����" + insertCount + "����¼");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResources(conn, null);
		}
	}
}

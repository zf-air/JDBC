package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import �������ݿ�.JDBCUtils;

public class UpdateDemo {
	// ��������
	@Test
	public void testInsert() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "update customers set email=? where name=?";

			
			int insertCount = runner.update(conn, sql,  "cai@126.com", "������");
			System.out.println("������" + insertCount + "����¼");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResources(conn, null);
		}

	}
}

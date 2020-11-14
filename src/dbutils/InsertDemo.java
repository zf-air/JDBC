package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class InsertDemo {
	// ��������
	@Test
	public void testInsert() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";

			//��¼��һ��һ����
			int insertCount = runner.update(conn, sql, 
					"������", "caixukun@126.com", "1997-09-08");				
			System.out.println("�����" + insertCount + "����¼");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}

	}
}

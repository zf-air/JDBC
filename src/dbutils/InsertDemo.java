package dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class InsertDemo {
	// 增加数据
	@Test
	public void testInsert() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";

			//记录得一条一条加
			int insertCount = runner.update(conn, sql, 
					"蔡徐坤", "caixukun@126.com", "1997-09-08");				
			System.out.println("添加了" + insertCount + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}

	}
}

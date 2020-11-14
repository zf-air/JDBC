package dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSource;

public class JDBCUtils {
	public static Connection getConnection() throws Exception {
		// 1. DataSource��ʵ����
		@SuppressWarnings("resource")
		DruidDataSource dataSource = new DruidDataSource();

		// 2.���û�ȡ���ӵĻ�������
		dataSource.setUsername("root");
		dataSource.setPassword("zhangfan789..");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		// 3. ���������Ĳ���
		// һ��ʼ�����ӳ��з���8������
		dataSource.setInitialSize(8);

		// �������ӵ��������Ϊ10
		dataSource.setMaxActive(10);

		// 4.��ȡ����
		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
		return connection;
	}

	public void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(rs);
	}
	public static void closeResource(Connection conn, PreparedStatement ps) {
		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(ps);
	}
}

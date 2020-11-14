package dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSource;

public class JDBCUtils {
	public static Connection getConnection() throws Exception {
		// 1. DataSource的实例化
		@SuppressWarnings("resource")
		DruidDataSource dataSource = new DruidDataSource();

		// 2.设置获取连接的基本参数
		dataSource.setUsername("root");
		dataSource.setPassword("zhangfan789..");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		// 3. 配置其他的参数
		// 一开始在连接池中放入8个连接
		dataSource.setInitialSize(8);

		// 设置连接的最大数量为10
		dataSource.setMaxActive(10);

		// 4.获取连接
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

package 连接数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class statement {
	public static void main(String[] args) throws Exception {
		// 1.基本信息
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";

		// 2.加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);

		// 4.进行操作
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		
		//5.关闭资源
		conn.close();
	}
}

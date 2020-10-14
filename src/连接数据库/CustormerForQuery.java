package 连接数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustormerForQuery {
	public static void main(String[] args) throws Exception{
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
		String sql = "insert into customers(name,email,birth)" + "values(?,?,?)"; // 问号是占位符
		PreparedStatement ps = conn.prepareStatement(sql);

		// 5.填充占位符
		ps.setString(1, "哪吒");
		ps.setString(2, "nezha@gmail.com");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("1000-01-01");

		ps.setDate(3, new java.sql.Date(date.getTime()));

		// 6.执行操作
		ps.execute();

		// 7.资源的关闭
		conn.close();
		ps.close();
	}
}

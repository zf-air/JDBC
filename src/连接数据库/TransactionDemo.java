package 连接数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDemo {
	public static void main(String[] args) throws Exception {
		// 1.基本信息
		String url = "jdbc:mysql://localhost:3306/xinwen?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";

		// 2.加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);

		// 4.进行操作 执行两个操作
		String sql1 = "UPDATE t_account SET money=money-100 WHERE sf = \"A\";"; // 问号是占位符
		String sql2 = "UPDATE t_account SET money=money+100 WHERE sf = \"B\";";
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);

		// 6.执行操作
		ps1.execute();
		ps2.execute();
		// 7.资源的关闭
		conn.close();
		ps1.close();
		ps2.close();

	}
}

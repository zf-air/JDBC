package 连接数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";
		
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取连接
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println(conn);
				
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}		
	}
}

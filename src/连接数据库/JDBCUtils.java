package 连接数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {
	//获取连接
	public static Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		//基本信息
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";
		
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		conn = DriverManager.getConnection(url,user,password);
		
		return conn;
	}
	
	public static void closeResources(Connection conn,PreparedStatement ps) {
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

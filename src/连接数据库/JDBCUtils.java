package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {
	//��ȡ����
	public static Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		//������Ϣ
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";
		
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����
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

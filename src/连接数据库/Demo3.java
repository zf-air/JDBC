package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";
		
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		
		//��ȡ����
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println(conn);
				
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}		
	}
}

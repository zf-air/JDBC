package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class statement {
	public static void main(String[] args) throws Exception {
		// 1.������Ϣ
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";

		// 2.��������
		Class.forName("com.mysql.jdbc.Driver");

		// 3.��ȡ����
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);

		// 4.���в���
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		
		//5.�ر���Դ
		conn.close();
	}
}

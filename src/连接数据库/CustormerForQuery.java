package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustormerForQuery {
	public static void main(String[] args) throws Exception{
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
		String sql = "insert into customers(name,email,birth)" + "values(?,?,?)"; // �ʺ���ռλ��
		PreparedStatement ps = conn.prepareStatement(sql);

		// 5.���ռλ��
		ps.setString(1, "��߸");
		ps.setString(2, "nezha@gmail.com");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("1000-01-01");

		ps.setDate(3, new java.sql.Date(date.getTime()));

		// 6.ִ�в���
		ps.execute();

		// 7.��Դ�Ĺر�
		conn.close();
		ps.close();
	}
}

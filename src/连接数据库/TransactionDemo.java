package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDemo {
	public static void main(String[] args) throws Exception {
		// 1.������Ϣ
		String url = "jdbc:mysql://localhost:3306/xinwen?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "zhangfan789..";

		// 2.��������
		Class.forName("com.mysql.jdbc.Driver");

		// 3.��ȡ����
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);

		// 4.���в��� ִ����������
		String sql1 = "UPDATE t_account SET money=money-100 WHERE sf = \"A\";"; // �ʺ���ռλ��
		String sql2 = "UPDATE t_account SET money=money+100 WHERE sf = \"B\";";
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);

		// 6.ִ�в���
		ps1.execute();
		ps2.execute();
		// 7.��Դ�Ĺر�
		conn.close();
		ps1.close();
		ps2.close();

	}
}

package �������ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShouDongKongZhiTiJiao {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		
		try {
			// 1.������Ϣ
			String url = "jdbc:mysql://localhost:3306/xinwen?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "zhangfan789..";
			
			// 2.��������
			Class.forName("com.mysql.jdbc.Driver");

			// 3.��ȡ����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);

			//�ֶ��ύ
			conn.setAutoCommit(false);
			
			// 4.���в��� ִ����������
			String sql1 = "UPDATE t_account SET money=money-100 WHERE sf = \"A\";"; // �ʺ���ռλ��
			String sql2 = "UPDATE t_account SET money=money+100 WHERE sf = \"B\";";
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);

			// 6.ִ�в���
			ps1.execute();
			ps2.execute();
			
			//�ύ
			conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//���ִ���ͻع�
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 7.��Դ�Ĺر�
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ps1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

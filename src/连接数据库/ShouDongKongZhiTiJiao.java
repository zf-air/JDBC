package 连接数据库;

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
			// 1.基本信息
			String url = "jdbc:mysql://localhost:3306/xinwen?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "zhangfan789..";
			
			// 2.加载驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 3.获取连接
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);

			//手动提交
			conn.setAutoCommit(false);
			
			// 4.进行操作 执行两个操作
			String sql1 = "UPDATE t_account SET money=money-100 WHERE sf = \"A\";"; // 问号是占位符
			String sql2 = "UPDATE t_account SET money=money+100 WHERE sf = \"B\";";
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);

			// 6.执行操作
			ps1.execute();
			ps2.execute();
			
			//提交
			conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//出现错误就回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 7.资源的关闭
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

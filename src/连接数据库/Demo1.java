package �������ݿ�;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;


public class Demo1 {
	@Test
	public void testConnection1() throws SQLException {
		//��ȡ����
		Driver driver = new com.mysql.jdbc.Driver();
		
		//url:http://localhost:8080/test ���ݿ�
		//jdbc:mysql :Э��
		//localhost :ip��ַ
		//3306 Ĭ��mysql�˿ں�
		//test :test���ݿ�
		
		String url = "jdbc:mysql://localhost:3306/test";
		
		//�û���������
		Properties info = new Properties();
		info.setProperty("user","root");
		info.setProperty("password", "zhangfan789..");
		
		Connection conn = driver.connect(url,info);
		
		System.out.println(conn);
	}
}

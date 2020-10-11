package 连接数据库;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;


public class Demo1 {
	@Test
	public void testConnection1() throws SQLException {
		//获取驱动
		Driver driver = new com.mysql.jdbc.Driver();
		
		//url:http://localhost:8080/test 数据库
		//jdbc:mysql :协议
		//localhost :ip地址
		//3306 默认mysql端口号
		//test :test数据库
		
		String url = "jdbc:mysql://localhost:3306/test";
		
		//用户名和密码
		Properties info = new Properties();
		info.setProperty("user","root");
		info.setProperty("password", "zhangfan789..");
		
		Connection conn = driver.connect(url,info);
		
		System.out.println(conn);
	}
}

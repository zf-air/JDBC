package 连接数据库;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class update_sql {
	
	//增删改模板
	public static void update(String sql,Object... args) throws Exception {
		
		//1.获取连接
		Connection conn = JDBCUtils.getConnection();
		
		//2.预编译sql
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//3.填充占位符
		for(int i=0;i<args.length;i++) {
			ps.setObject(i+1, args[i]);
		}
		
		//4.执行sql语句
		ps.execute();
		
		//5.关闭资源
		JDBCUtils.closeResources(conn, ps);
		
	}
	
	public static void main(String[] args) throws Exception {
		String sql = "update `order` set order_name = ? where order_id = ?";
		update(sql,"DD",2);
	}
}

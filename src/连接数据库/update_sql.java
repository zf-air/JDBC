package �������ݿ�;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class update_sql {
	
	//��ɾ��ģ��
	public static void update(String sql,Object... args) throws Exception {
		
		//1.��ȡ����
		Connection conn = JDBCUtils.getConnection();
		
		//2.Ԥ����sql
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//3.���ռλ��
		for(int i=0;i<args.length;i++) {
			ps.setObject(i+1, args[i]);
		}
		
		//4.ִ��sql���
		ps.execute();
		
		//5.�ر���Դ
		JDBCUtils.closeResources(conn, ps);
		
	}
	
	public static void main(String[] args) throws Exception {
		String sql = "update `order` set order_name = ? where order_id = ?";
		update(sql,"DD",2);
	}
}

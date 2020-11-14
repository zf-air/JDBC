package dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import bean.Customer;

import 连接数据库.JDBCUtils;

public class ChaXunDemo {

	// 查询
	// BeanHander 封装表中的一条记录
	@Test
	public void testQuery1() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "select id,name,email,birth from customers where id = ?";
			BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
			Customer customer = runner.query(conn, sql, handler, 16);
			System.out.println(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResources(conn, null);

		}

	}

	// 封装表中多条记录
	@Test
	public void testQuery2() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "select id,name,email,birth from customers where id < ?";

			BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);

			List<Customer> list = runner.query(conn, sql, handler, 15);
			list.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JDBCUtils.closeResources(conn, null);
		}

	}

	// 查询
	// MapHander 封装表中的一条记录
	// 将字段中的值作为键值对返回
	@Test
	public void testQuery3() throws Exception {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "select id,name,email,birth from customers where id = ?";
			MapHandler handler = new MapHandler();
			Map<String, Object> map = runner.query(conn, sql, handler, 23);
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResources(conn, null);

		}

	}
	
	// MapListHandler
	@Test
	public void testQuery4() throws Exception{
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection();
			String sql = "select id,name,email,birth from customers where id < ?";
		
			MapListHandler handler = new MapListHandler();
			List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);
			list.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResources(conn, null);
			
		}
		
	}
}

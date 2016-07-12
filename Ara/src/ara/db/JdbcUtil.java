package ara.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	Connection con;

	/*static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ��� ����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public static Connection getConnect() {
		Connection con = null;
		try {
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "java", "java");
			// java/java ���̵� ����
			
			// Ʈ����� ó��
			// �ϳ��� ��ó�� ����
			// �����Ͻ� ��û �� �������� ������ ���� �۾��� �ؾ� �ϴ� ��û�� �ִ�.
			// �̷��� �������� ������ ���� �۾��� �ϳ��� ��ó�� ������ �����ִ� ���� Ʈ����� ó���̴�.
			// Connection �� autoCommit �� true��... ����, �⺻������ Ʈ������� ������ �ȵ�.
			
			Context initCtx = new InitialContext();
			// ���� ��ü�� ���ؽ�Ʈ�� ����(������).
			
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			// ���ǵ� Resource�� ������ �� �ִ� ���ؽ�Ʈ�� ����(������).
			
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest"); // ������ �ҽ� ����
			// Ŀ�ؼ��� �����ͼҽ��� ���ؼ� Ŀ�ؼ�Ǯ���� ���´�.
			con = ds.getConnection();
			
			con.setAutoCommit(false); // �ٲ���� Ʈ������� �ɸ���.
			
			System.out.println("Connect Success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) { // ���� close�ϴ� �޼ҵ� ����
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Ʈ����� �κ�
	public static void commit(Connection con) { // commit �޼ҵ� ����
		try {
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Ʈ����� �� �۾��� ���
	public static void rollback(Connection con) { // rollback �޼ҵ� ����
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package site.yl1204.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ʵ���������ݿ���ͷ���Դ�ķ���
public class jdbcUtils {
	//�������ݿ�ķ���
	public static Connection getCon() {
		Connection con = null;
		String Url = "jdbc:mysql://localhost:3306/All";
		String user = "root";
		String psw = "root";
		String jdbcName="com.mysql.jdbc.Driver";
		try {
			Class.forName(jdbcName);
			System.out.println("���������ɹ�");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
		try {
			con = DriverManager.getConnection(Url, user, psw);
			System.out.println("��ȡ���ݿ����ӳɹ�");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//�ͷ���Դ
	public static void release(Connection con,Statement stmt,ResultSet rs) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=null;
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=null;
		}
	}
	 //release����������
	public static void release(Connection con,Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=null;
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=null;
		}
	}
}

package site.yl1204.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//实现连接数据库和释放资源的方法
public class jdbcUtils {
	//连接数据库的方法
	public static Connection getCon() {
		Connection con = null;
		String Url = "jdbc:mysql://localhost:3306/All";
		String user = "root";
		String psw = "root";
		String jdbcName="com.mysql.jdbc.Driver";
		try {
			Class.forName(jdbcName);
			System.out.println("加载驱动成功");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}
		try {
			con = DriverManager.getConnection(Url, user, psw);
			System.out.println("获取数据库连接成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//释放资源
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
	 //release方法的重载
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

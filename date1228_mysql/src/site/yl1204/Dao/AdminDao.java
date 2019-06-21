package site.yl1204.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import site.yl1204.domain.Admin;
import site.yl1204.domain.User;
import site.yl1204.utils.jdbcUtils;

//���ж����ݿ�����ķ���
public class AdminDao {
	//�鿴�����û�
	//1.��User���е�ÿһ����¼����װ��һ��user����
	//2.��User������ӵ�ArrayList��������
	//3.���ظ�List������
	public List<User> findAll() {
		Connection con = null;
		Statement stmt =null;
		ResultSet rs = null;
		List<User> list =new ArrayList<User>();
		//step1 ���÷��� �������ݿ�
		con = jdbcUtils.getCon();
		//step2 ����Statement����ִ��SQL���
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from User ";
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				//��õ�ǰ�е�����
				int id = rs.getInt("id");
				String name = rs.getString("uname");
				String pwd = rs.getString("upassword");
				String claan = rs.getString("sclass");
				//����User����Ϊ����User������ֵ
				User user = new User();
				user.setId(id);
				user.setUname(name);
				user.setUpassword(pwd);
				user.setSclass(claan);
				list.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtils.release(con, stmt, rs);
		}
		
		return list;
	}
	//�û�ע��
	public int addUser(User user) {
		Connection con = null;
		int result  = 0;
		PreparedStatement pst = null;
		
		con = jdbcUtils.getCon();
		String sql = "insert into user(uname,upassword) values(?,?)";
		try {
			pst = con.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, user.getUname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(2, user.getUpassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtils.release(con, pst);
		}
		return result;
	}
	//�û���¼
	public User login(User user){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = jdbcUtils.getCon();
		String sql = "select uname,upassword from user where uname=? and upassword = ?";
		
		try {
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, user.getUname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(2, user.getUpassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User resultuser =null;
			try{
				rs=pst.executeQuery();
				if(rs.next()){
					String name=rs.getString("uname");
					String password=rs.getString("upassword");
					resultuser = new User();
					resultuser.setUname(name);
					resultuser.setUpassword(password);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				jdbcUtils.release(con, pst, rs);
			}
			return  resultuser;
	}
	//�û���¼ --�ж��û�
	public Admin  checkUser(Admin admin) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = jdbcUtils.getCon();
		String sql = "select adminName,adminPassword from admin where adminName=? and adminPassword = ?";
		try {
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, admin.getAdminname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(2, admin.getAdminpassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin resultuser =null;
		try{
			rs=pst.executeQuery();
			if(rs.next()){
				String name=rs.getString("adminName");
				String password=rs.getString("adminPassword");
				resultuser = new Admin();
				resultuser.setAdminpassword(name);
				resultuser.setAdminpassword(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtils.release(con, pst, rs);
		}
		return resultuser;
	}
	//�޸��û�����
	public int updatePsd(User user) {
		Connection con = null;
		PreparedStatement pst =null;
		int result = 0;
		con = jdbcUtils.getCon();
		String sql = "update user set user.upassword=? where uname=?";
		try {
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, user.getUpassword());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pst.setString(2, user.getUname());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 result = pst.executeUpdate();
			if(result==1) {
				System.out.println("�޸��û���Ϊdakai������ɹ�");
			}else {
				System.out.println("�޸�����ʧ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtils.release(con, pst);
		}
		return result;
	}
	//ע���û�
	public int deleteByName(User user) {
		Connection con=null;
		con = jdbcUtils.getCon();
		String sql = "delete from user where id=?";
		PreparedStatement pst =null;
		int result = 0;
		try {
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setInt(1, user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtils.release(con, pst);
		}
		return result;
	}
	
}

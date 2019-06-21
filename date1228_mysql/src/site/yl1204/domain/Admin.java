package site.yl1204.domain;

public class Admin {
	private int id;
	private String adminname;
	private String adminpassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
	public Admin(int id, String adminname, String adminpassword) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

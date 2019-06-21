package site.yl1204.domain;
//实体类
public class User {
	//属性，表的字段
	private int id;
	private String uname;
	private String upassword;
	private String sclass;
	
	//成员方法，构造方法，set/get方法。toString方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String uname, String upassword,String sclass) {
		super();
		this.sclass=sclass;
		this.id = id;
		this.uname = uname;
		this.upassword = upassword;
	}
	
	public User(int id, String uname ,String sclass) {
		super();
		this.sclass=sclass;
		this.uname = uname;
		this.id=id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upassword=" + upassword + "]";
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	
	
	
	
}

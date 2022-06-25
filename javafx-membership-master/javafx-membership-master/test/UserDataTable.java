package test;

public class UserDataTable {
	
	private String idx= null;
	private String username = null;
	private String usergender = null;
	private String classname = null;
	private String classnum = null;
	private String city = null;
	private String jungbo = null;
	
	public UserDataTable( String idx, String username, String usergender, String classname, String classnum, String city, String jungbo) {
		this.idx = idx;
		this.username = username;
		this.usergender = usergender;
		this.classname = classname;
		this.classnum = classnum;
		this.city = city;
		this.jungbo = jungbo;
	}
	
	public String getidx() {
		return idx;
	}
	public String getusername() {
		return username;
	}
	public String getusergender() {
		return usergender;
	}
	public String getclassname() {
		return classname;
	}
	public String getclassnum() {
		return classnum;
	}
	public String getcity() {
		return city;
	}
	public String getjungbo() {
		return jungbo;
	}
	public void setidx(String idx) {
		this.idx = idx;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public void setusergender(String usergender) {
		this.usergender = usergender;
	}
	public void setclassname(String classname) {
		this.classname = classname;
	}
	public void setclassnum(String classnum) {
		this.classnum = classnum;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public void setjungbo(String jungbo) {
		this.jungbo = jungbo;
	}
	
	
}

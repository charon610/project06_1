package application;

public class Member {
	String userName = null;
	String usergender = null;
	String classname = null;
	String classnum = null;
	String city = null;
	String jungbo = null;
	public Member() {
		this("", "", "", "", "", "");
	}
	public Member(String userName, String usergender, String classname, String classnum, String city, String jungbo) {
		super();
		this.userName = userName;
		this.usergender = usergender;
		this.classname = classname;
		this.classnum = classnum;
		this.city = city;
		this.jungbo = jungbo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getusergender() {
		return usergender;
	}
	public void setusergender(String usergender) {
		this.usergender = usergender;
	}
	public String getclassname() {
		return classname;
	}
	public void setclassname(String classname) {
		this.classname = classname;
	}
	public String getclassnum() {
		return classnum;
	}
	public void setclassnum(String classnum) {
		this.classnum = classnum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getjungbo() {
		return jungbo;
	}
	public void setjungbo(String jungbo) {
		this.jungbo = jungbo;
	}
}

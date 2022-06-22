package application;

public class Member {
	String userName = null;
	String userId = null;
	String userPassword = null;
	String classnum = null;
	String city = null;
	String jungbo = null;
	public Member() {
		this("", "", "", "", "", "");
	}
	public Member(String userName, String userId, String userPassword, String classnum, String city, String jungbo) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

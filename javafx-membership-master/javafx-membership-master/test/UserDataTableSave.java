package test;

public class UserDataTableSave {
	
	private int idx= 0;
	private String username = null;
	private String usergender = null;
	private String class_name = null;
	private int class_num = 0;
	private String city = null;
	private String jungbo = null;
	
	public UserDataTableSave( int idx, String username, String usergender, String class_name, int class_num, String city, String jungbo) {
		this.idx = idx;
		this.username = username;
		this.usergender = usergender;
		this.class_name = class_name;
		this.class_num = class_num;
		this.city = city;
		this.jungbo = jungbo;
	}
	
	public int getidx() {
		return idx;
	}
	public String getusername() {
		return username;
	}
	public String getusergender() {
		return usergender;
	}
	public String getclass_name() {
		return class_name;
	}
	public int getclass_num() {
		return class_num;
	}
	public String getcity() {
		return city;
	}
	public String getjungbo() {
		return jungbo;
	}
	public void setidx(int idx) {
		this.idx = idx;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public void setusergender(String usergender) {
		this.usergender = usergender;
	}
	public void setclass_name(String class_name) {
		this.class_name = class_name;
	}
	public void setclass_num(int class_num) {
		this.class_num = class_num;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public void setjungbo(String jungbo) {
		this.jungbo = jungbo;
	}
	
	
}

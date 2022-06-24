package test;

public class UserDataTable {
	
	private int 번호;
	private String 이름;
	private String 성별;
	private String 과목명;
	private int 강의실;
	private String 주거지;
	private String 자격증;
	
	public UserDataTable(int 번호, String 이름, String 성별, String 과목명, int 강의실, String 주거지, String 자격증) {
		this.번호 = 번호;
		this.이름 = 이름;
		this.성별 = 성별;
		this.과목명 = 과목명;
		this.강의실 = 강의실;
		this.주거지 = 주거지;
		this.자격증 = 자격증;
	}
	
	public int get번호() {
		return 번호;
	}
	public String get이름() {
		return 이름;
	}
	public String get성별() {
		return 성별;
	}
	public String get과목명() {
		return 과목명;
	}
	public int get강의실() {
		return 강의실;
	}
	public String get주거지() {
		return 주거지;
	}
	public String get자격증() {
		return 자격증;
	}
	public void set번호(int 번호) {
		this.번호 = 번호;
	}
	public void set이름(String 이름) {
		this.이름 = 이름;
	}
	public void set성별(String 성별) {
		this.성별 = 성별;
	}
	public void set과목명(String 과목명) {
		this.과목명 = 과목명;
	}
	public void set강의실(int 강의실) {
		this.강의실 = 강의실;
	}
	public void set주거지(String 주거지) {
		this.주거지 = 주거지;
	}
	public void set자격증(String 자격증) {
		this.자격증 = 자격증;
	}
	
	
}

package test;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class 회원정보테이블 {
	
	private final IntegerProperty 번호;
	private final StringProperty 이름;
	private final StringProperty 성별;
	private final StringProperty 과목명;
	private final IntegerProperty 강의실;
	private final StringProperty 주거지;
	private final StringProperty 자격증;
	
	
	public int get번호() {
		return 번호.get();
	}
	public String get이름() {
		return 이름.get();
	}
	public String get성별() {
		return 성별.get();
	}
	public String get과목명() {
		return 과목명.get();
		
	}
	public IntegerProperty get강의실() {
		return 강의실;
	}
	public StringProperty get주거지() {
		return 주거지;
	}
	public StringProperty get자격증() {
		return 자격증;
	}
	
	public IntegerProperty 번호Property() {
		return 번호;
	}
	public StringProperty 이름Property() {
		return 이름;
	}
	public StringProperty 성별Property() {
		return 성별;
	}
	public StringProperty 과목명Property() {
		return 과목명;
	}
	
	public 회원정보테이블(int 번호,String 이름,String 성별, String 과목명, int 강의실, String 주거지, String 자격증) {
		this.번호 = new SimpleIntegerProperty(번호);
		this.이름 = new SimpleStringProperty(이름);
		this.성별 = new SimpleStringProperty(이름);
		this.과목명 = new SimpleStringProperty(이름);
		this.강의실 = new SimpleIntegerProperty(강의실);
		this.주거지 = new SimpleStringProperty(주거지);
		this.자격증 = new SimpleStringProperty(자격증);
	}
	
}

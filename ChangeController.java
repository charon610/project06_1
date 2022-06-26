package p890;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeController {
	
	/*이름 = userid
	강의명 = classname
	강의실 번호 = classnum
	거주지명 = city
	성별 = gender
	자격증 여부 = certificate
	수정 버튼 = changebutton
	취소 버튼 = resetbutton
	메뉴 버튼 = menubutton */
	
	@FXML private TextField userid;
	@FXML private TextField classname;
	@FXML private TextField classnum;
	@FXML private TextField city;
	@FXML private TextField gender;
	@FXML private TextField certificate;
	@FXML private Button changebutton;
	@FXML private Button resetbutton;
	@FXML private Button menubutton;
	@FXML private Label changeMessage;
	
	
	// 수정 버튼 클릭 이벤트
	@FXML
	void changebuttonOnAction( ) {
		
		changeMessage.setText("수정 완료!");
/*		boolean checkuserid
		boolean checkclassname
		boolean classnum
		boolean city
		boolean gender
		boolean certificate
		boolean confirmbutton
		boolean resetbutton
		boolean menubutton
				
*/		
		
		// 수정 버튼 클릭 이벤트
		//registrationMessage.setText("등록 완료!");
	}
	
	
	
	// 초기화 버튼 클릭 이벤트
	@FXML
	public void resetbuttonOnAction() {
		
		changeMessage.setText(" ");
		userid.setText("");
		classname.setText("");
		classnum.setText("");
		city.setText("");
		gender.setText("");
		certificate.setText("");
		
		
	}
	
	// 메뉴화면 버튼 클릭 이벤트
	@FXML
	void menubuttonOnAction() {
		
		 Stage stage = (Stage) menubutton.getScene().getWindow();
		 stage.close();
	}	
}	
	
	
	


package p892;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeController2 implements Initializable{
	
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
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}	
	
	// 수정 버튼 클릭 이벤트
	@FXML
	void changebuttonOnAction( ) {
		
		DBConnection connNow = new DBConnection();
		Connection conn = connNow.getConnection();
		
		String sql = "UPDATE member_accounts "
				+ "SET "
				+ "class_name=?, "
				+ "class_num=?, "
				+ "city=?, "
				+ "user_gender=? "
				+ "jungbo=? "				
				+ "WHERE user_id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid.getText());
			pstmt.setString(2, classname.getText());
			pstmt.setString(3, classnum.getText());
			pstmt.setString(4, city.getText());
			pstmt.setString(5, gender.getText());
			pstmt.setString(6, certificate.getText());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			changeMessage.setText("회원 정보 수정을 완료했습니다!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
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



	


////	void readMemberData() {
////		if(Main.global_user_id.length(>0))
//	}
	
}	
	
	
	


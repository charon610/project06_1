package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class memberController {
//	이름 = userid
//	강의명 = classname
//	강의실 번호 = classnum
//	거주지명 = city
//	성별 = gender
//	자격증 여부 = certificate
//	등록 버튼 = confirmbutton
//	취소 버튼 = resetbutton
//	메뉴 버튼 = menubutton
	
	@FXML private TextField userid;
	@FXML private TextField classname;
	@FXML private TextField classnum;
	@FXML private TextField city;
	@FXML private TextField gender;
	@FXML private TextField certificate;
	@FXML private Button confirmbutton;
	@FXML private Button resetbutton;
	@FXML private Button menubutton;
	@FXML private Label registrationMessage;
	
	
	
	@FXML
	void confirmbuttonOnAction() {
		DBConnection connNow = new DBConnection();
		Connection conn = connNow.getConnection();
		
		String sql = "insert into member_accounts"
				+ "(idx, user_name, user_gender, class_name, class_num, city, jungbo)"
				+ "values"
				+ "(member_idx_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			// 데이터베이스에 값을 저장하는 SQL문 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid.getText());
			pstmt.setString(2, gender.getText());
			pstmt.setString(3, classname.getText());
			pstmt.setString(4, classnum.getText());
			pstmt.setString(5, city.getText());
			pstmt.setString(6, certificate.getText());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			
			userid.setText("");
			classname.setText("");
			classnum.setText("");
			city.setText("");
			gender.setText("");
			certificate.setText("");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		registrationMessage.setText("등록 완료!");
	}


	@FXML
	public void resetbuttonOnAction() {
		userid.setText("");
		classname.setText("");
		classnum.setText("");
		city.setText("");
		gender.setText("");
		certificate.setText("");
		
		
	}
	@FXML
	void menubuttonOnAction() {
		 Stage stage = (Stage) menubutton.getScene().getWindow();
		 stage.close();
	}	
}	
	
	
	


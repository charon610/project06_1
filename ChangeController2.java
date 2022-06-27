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
	
	/*�̸� = userid
	���Ǹ� = classname
	���ǽ� ��ȣ = classnum
	�������� = city
	���� = gender
	�ڰ��� ���� = certificate
	���� ��ư = changebutton
	��� ��ư = resetbutton
	�޴� ��ư = menubutton */
	
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
	
	// ���� ��ư Ŭ�� �̺�Ʈ
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
			
			changeMessage.setText("ȸ�� ���� ������ �Ϸ��߽��ϴ�!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		changeMessage.setText("���� �Ϸ�!");
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
		
		// ���� ��ư Ŭ�� �̺�Ʈ
		//registrationMessage.setText("��� �Ϸ�!");
	}
	
	
	
	// �ʱ�ȭ ��ư Ŭ�� �̺�Ʈ
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
	
	// �޴�ȭ�� ��ư Ŭ�� �̺�Ʈ
	@FXML
	void menubuttonOnAction() {
		
		 Stage stage = (Stage) menubutton.getScene().getWindow();
		 stage.close();
	}



	


////	void readMemberData() {
////		if(Main.global_user_id.length(>0))
//	}
	
}	
	
	
	


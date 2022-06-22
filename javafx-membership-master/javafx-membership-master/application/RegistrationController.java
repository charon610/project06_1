package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegistrationController {
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField usergenderTextField;
	@FXML
	private TextField classnumTextField;
	@FXML
	private TextField cityTextField;
	@FXML
	private TextField jungboTextField;
	@FXML
	private PasswordField password1PasswordField;
	@FXML
	private PasswordField password2PasswordField;
	@FXML
	private Label registerMessageLabel;
	@FXML
	private Button submitButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button closeButton;
	
	@FXML
	void submitButtonOnAction() {
		// 입력한 값을 체크합니다
		boolean checkEmpty = isCheckEmpty();
		boolean checkDuplicatedId = isCheckDuplicatedId();
		boolean checkPasswordSame = isCheckPasswordSame();
		boolean checkNumbers = isCheckNumbers();
		
		if(
				checkEmpty == true
				&& checkDuplicatedId == true
				&& checkPasswordSame == true
				&& checkNumbers == true
				) { // 모든 체크를 통과했을 경우 데이터베이스에 저장한다
			registerMessageLabel.setText("회원 정보를 데이터베이스에 저장합니다...");
			
			DBConnection connNow = new DBConnection();
			Connection conn = connNow.getConnection();
			
			String sql = "INSERT INTO member_accounts "
					+ "(idx, user_name, user_gender, class_name, class_num, city, jungbo) "
					+ "VALUES "
					+ "(member_idx_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			try {
				// 데이터베이스에 값을 저장하는 SQL문 실행
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, usernameTextField.getText());
				pstmt.setString(2, usergenderTextField.getText());
				pstmt.setString(3, password1PasswordField.getText());
				pstmt.setString(4, classnumTextField.getText());
				pstmt.setString(5, cityTextField.getText());
				pstmt.setString(6, jungboTextField.getText());
				pstmt.executeUpdate();
				
				pstmt.close();
				conn.close();
				
				registerMessageLabel.setText("데이터베이스에 회원정보 입력 완료!");
				usernameTextField.setText("");
				usergenderTextField.setText("");
				password1PasswordField.setText("");
				password2PasswordField.setText("");
				classnumTextField.setText("");
				cityTextField.setText("");
				jungboTextField.setText("");
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			if(checkEmpty == false) {
				registerMessageLabel.setText("모든 정보를 입력해주세요!");
			} else if(checkDuplicatedId == false) {
				registerMessageLabel.setText("아이디가 중복됩니다. 다른 아이디를 입력해주세요!");
			} else if(checkPasswordSame == false) {
				registerMessageLabel.setText("입력한 암호가 동일하지 않습니다. 다시 확인해주세요!");
			} else if(checkNumbers == false) {
				registerMessageLabel.setText("학년, 반, 번호를 잘못 입력했습니다!");
			}
		}
	}
	
	@FXML
	void cancelButtonOnAction(ActionEvent e) {
		usernameTextField.setText("");
		usergenderTextField.setText("");
		classnumTextField.setText("");
		cityTextField.setText("");
		jungboTextField.setText("");
		password1PasswordField.setText("");
		password2PasswordField.setText("");
	}
	
	@FXML
	void closeButtonOnAction(ActionEvent e) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	boolean isCheckEmpty() { // 공백이 없는지 체크한다
		boolean result = false;
		if(
			usernameTextField.getText().isBlank() == false
			&& usergenderTextField.getText().isBlank() == false
			&& password1PasswordField.getText().isBlank() == false
			&& password2PasswordField.getText().isBlank() == false
			&& classnumTextField.getText().isBlank() == false
			&& cityTextField.getText().isBlank() == false
			&& jungboTextField.getText().isBlank() == false
		) { // 공백이 없다면..
			result = true;
		}
		return result;
	}
	
	boolean isCheckDuplicatedId() { // 데이터베이스에서 아이디 중복을 체크한다
		boolean result = true;
		DBConnection connNow = new DBConnection();
		Connection conn = connNow.getConnection();
		
		String sql = "SELECT COUNT(1) FROM member_accounts "
				+ " WHERE user_gender='" + usergenderTextField.getText() + "'";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getInt(1) == 1) {
					result = false;
				}
			}
			
			stmt.close();
			conn.close();
		} catch(Exception e) {
		}
		
		return result;
	}
	
	boolean isCheckPasswordSame() {
		boolean result = false;
		if(
			(password1PasswordField.getText().isBlank() == false
			  && password2PasswordField.getText().isBlank() == false)
			&&
			(password1PasswordField.getText().equals(password2PasswordField.getText()))
		) {
			result = true;
		}
		return result;
	}
	
	boolean isCheckNumbers() {
		boolean result = false;
		int classnum = 0;
		int city = 0;
		String jungbo = null;
		
		try {
			classnum = Integer.parseInt(classnumTextField.getText());
			city = Integer.parseInt(cityTextField.getText());
			jungbo = jungboTextField.getText();
			
			if(
				(classnum >= 501 && classnum <= 505)
				&& (jungbo == "O" || jungbo == "X")
				) { // 클래스 번호가 501~505호 사이, 자격증 O 또는 X
				result = true;
			}
			
			return result;
		} catch(NumberFormatException e) {
			result = false;
			return result;
		}
	}
}

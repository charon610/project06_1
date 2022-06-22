package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificationController implements Initializable {
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField useridTextField;
	@FXML
	private PasswordField password1PasswordField;
	@FXML
	private PasswordField password2PasswordField;
	@FXML
	private TextField classnumTextField;
	@FXML
	private TextField cityTextField;
	@FXML
	private TextField jungboTextField;
	@FXML
	private Label modifyMessageLabel;
	@FXML
	private Button modifyButton;
	@FXML
	private Button resetButton;
	@FXML
	private Button closeButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		readMemberData();	
	}	
	
	@FXML
	void modifyButtonOnAction() {
		// 입력한 값을 체크합니다
		boolean checkEmpty = isCheckEmpty();
		boolean checkPasswordSame = isCheckPasswordSame();
		boolean checkNumbers = isCheckNumbers();
		
		if(
				checkEmpty == true
				&& checkPasswordSame == true
				&& checkNumbers == true
				) { // 모든 체크를 통과했을 경우 데이터베이스에 저장한다
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("회원정보 수정 모듈");
			alert.setHeaderText("회원정보 수정");
			alert.setContentText(useridTextField.getText() + " 님의 회원정보를 수정하시겠습니까?");
			Optional<ButtonType> alertResult = alert.showAndWait();
			
			if(alertResult.get() == ButtonType.OK) {
				modifyMessageLabel.setText("회원 정보를 수정합니다...");
				
				DBConnection connNow = new DBConnection();
				Connection conn = connNow.getConnection();
				
				String sql = "UPDATE member_accounts "
						+ "SET "
						+ "user_name=?, "
						+ "class_name=?, "
						+ "class_num=?, "
						+ "city=?, "
						+ "jungbo=? "
						+ "WHERE user_id=?";
				
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, usernameTextField.getText());
					pstmt.setString(2, password1PasswordField.getText());
					pstmt.setString(3, classnumTextField.getText());
					pstmt.setString(4, cityTextField.getText());
					pstmt.setString(5, jungboTextField.getText());
					pstmt.setString(6, useridTextField.getText());
					pstmt.executeUpdate();
					
					pstmt.close();
					conn.close();
					
					modifyMessageLabel.setText("회원 정보 수정을 완료했습니다!");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			if(checkEmpty == false) {
				modifyMessageLabel.setText("모든 정보를 입력해주세요!");
			} else if(checkPasswordSame == false) {
				modifyMessageLabel.setText("입력한 암호가 동일하지 않습니다. 다시 확인해주세요!");
			} else if(checkNumbers == false) {
				modifyMessageLabel.setText("학년, 반, 번호를 잘못 입력했습니다!");
			}
		}
	}
	
	@FXML
	void resetButtonOnAction() {
		readMemberData();
	}
	
	@FXML
	void closeButtonOnAction() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	boolean isCheckEmpty() { // 공백이 없는지 체크한다
		boolean result = false;
		if(
			usernameTextField.getText().isBlank() == false
			&& useridTextField.getText().isBlank() == false
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
	
	void readMemberData() {
		if(
			Main.global_user_id.isEmpty() == false
			&&
			Main.global_user_id.length() > 0
		) {
			DBConnection connNow = new DBConnection();
			Connection conn = connNow.getConnection();
			
			String sql = "SELECT * FROM member_accounts "
					+ "WHERE user_id='" + Main.global_user_id + "'";
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next() ) {
					usernameTextField.setText(rs.getString("user_name"));
					useridTextField.setText(rs.getString("user_id"));
					password1PasswordField.setText(rs.getString("user_password"));
					password2PasswordField.setText(rs.getString("user_password"));
					classnumTextField.setText(rs.getString("class_num"));
					cityTextField.setText(rs.getString("city"));
					jungboTextField.setText(rs.getString("jungbo"));
				}
				
				stmt.close();
				rs.close();
				conn.close();
			} catch(Exception e) {}
		}
	}
}

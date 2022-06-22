package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MembershipController implements Initializable {
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
	private Label membershipMessageLabel;
	@FXML
	private Button updateButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button readlistButton;
	@FXML
	private Button closeButton;
	
	// TableView
	@FXML
	private TableView<Member> membershipTableView;
	@FXML
	private TableColumn<Member, String> userNameTableColumn;
	@FXML
	private TableColumn<Member, String> userIdTableColumn;
	@FXML
	private TableColumn<Member, String> userPasswordTableColumn;
	@FXML
	private TableColumn<Member, String> classnumTableColumn;
	@FXML
	private TableColumn<Member, String> cityTableColumn;
	@FXML
	private TableColumn<Member, String> jungboTableColumn;

	@FXML
	void updateButtonOnAction() {
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
					alert.setTitle("관리자 모듈 : 회원정보 수정");
					alert.setHeaderText("회원정보 수정");
					alert.setContentText(useridTextField.getText() + " 님의 회원정보를 수정하시겠습니까?");
					Optional<ButtonType> alertResult = alert.showAndWait();
					
					if(alertResult.get() == ButtonType.OK) {
						membershipMessageLabel.setText("회원 정보를 수정합니다...");
						
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
							
							membershipMessageLabel.setText("회원 정보 수정을 완료했습니다!");
							
							readlistButtonOnAction();
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					if(checkEmpty == false) {
						membershipMessageLabel.setText("모든 정보를 입력해주세요!");
					} else if(checkPasswordSame == false) {
						membershipMessageLabel.setText("입력한 암호가 동일하지 않습니다. 다시 확인해주세요!");
					} else if(checkNumbers == false) {
						membershipMessageLabel.setText("학년, 반, 번호를 잘못 입력했습니다!");
					}
				}
	}
	
	@FXML
	void deleteButtonOnAction() {
		if(isCheckEmpty()  == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("관리자 모듈 : 회원정보 삭제");
			alert.setHeaderText("회원정보 삭제");
			alert.setContentText(useridTextField.getText() + " 님의 회원정보를 삭제하시겠습니까?");
			Optional<ButtonType> alertResult = alert.showAndWait();
			if(alertResult.get() == ButtonType.OK) {
				DBConnection connNow = new DBConnection();
				Connection conn = connNow.getConnection();
				
				String sql = "DELETE FROM member_accounts "
						+ "WHERE user_id=?";
				
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, useridTextField.getText());
					pstmt.executeUpdate();
					
					pstmt.close();
					conn.close();
					
					membershipMessageLabel.setText("회원 정보 수정을 완료했습니다!");
					
					userIdTableColumn.setText("");
					userPasswordTableColumn.setText("");
					classnumTableColumn.setText("");
					cityTableColumn.setText("");
					jungboTableColumn.setText("");
					
					readlistButtonOnAction();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@FXML
	void readlistButtonOnAction() {
		DBConnection connNow = new DBConnection();
		Connection conn = connNow.getConnection();
		
		String sql = "SELECT * FROM member_accounts "
				+ "ORDER BY idx";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ObservableList<Member> dataList = FXCollections.observableArrayList(); // 자바 제네릭(Generic)
			
			while(rs.next()) {
				dataList.add(
					new Member(
							rs.getString("user_name"),
							rs.getString("user_id"),
							rs.getString("user_password"),
							rs.getString("classnum"),
							rs.getString("city"),
							rs.getString("jungbo")
					)
				);
			}
			
			membershipTableView.setItems(dataList);
		} catch(Exception e) {}
	}
	
	@FXML
	void closeButtonOnAction() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	void membershipTableViewOnAction() {
		if(membershipTableView.getSelectionModel().getSelectedItem() != null) {
			usernameTextField.setText(membershipTableView.getSelectionModel().getSelectedItem().getUserName());
			useridTextField.setText(membershipTableView.getSelectionModel().getSelectedItem().getUserId());
			password1PasswordField.setText(membershipTableView.getSelectionModel().getSelectedItem().getUserPassword());
			password2PasswordField.setText(membershipTableView.getSelectionModel().getSelectedItem().getUserPassword());
			classnumTextField.setText(membershipTableView.getSelectionModel().getSelectedItem().getclassnum());
			cityTextField.setText(membershipTableView.getSelectionModel().getSelectedItem().getCity());
			jungboTextField.setText(membershipTableView.getSelectionModel().getSelectedItem().getjungbo());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("멤버쉽 모듈 창이 열려서 초기화 함수(initialize)를 실행했습니다.");
		userNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
		userIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
		userPasswordTableColumn.setCellValueFactory(new PropertyValueFactory<>("userPassword"));
		classnumTableColumn.setCellValueFactory(new PropertyValueFactory<>("classnum"));
		cityTableColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
		jungboTableColumn.setCellValueFactory(new PropertyValueFactory<>("jungbo"));
		
		readlistButtonOnAction();
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
		String jungbo = null;
		
		try {
			classnum = Integer.parseInt(classnumTextField.getText());
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

package test;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserrefController implements Initializable {
	@FXML private TableView<UserDataTable> tableView;
	@FXML private TableColumn<UserDataTable, String> idxTableC;
	@FXML private TableColumn<UserDataTable, String> usernameTableC;
	@FXML private TableColumn<UserDataTable, String> userGenderTableC;
	@FXML private TableColumn<UserDataTable, String> classnameTableC;
	@FXML private TableColumn<UserDataTable, String> classnumTableC;
	@FXML private TableColumn<UserDataTable, String> cityTableC;
	@FXML private TableColumn<UserDataTable, String> jungboTableC;
	
	@FXML private Button 회원정보수정버튼;
	@FXML private Button closeButton;
	@FXML private Button 회원찾기버튼;
	@FXML private TextField 회원이름입력창;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		idxTableC.setCellValueFactory(new PropertyValueFactory<>("idx"));
		usernameTableC.setCellValueFactory(new PropertyValueFactory<>("user_name"));
		userGenderTableC.setCellValueFactory(new PropertyValueFactory<>("user_gender"));
		classnameTableC.setCellValueFactory(new PropertyValueFactory<>("class_name"));
		classnumTableC.setCellValueFactory(new PropertyValueFactory<>("class_num"));
		cityTableC.setCellValueFactory(new PropertyValueFactory<>("city"));
		jungboTableC.setCellValueFactory(new PropertyValueFactory<>("jungbo"));
		
		readlistButtonOnAction();
	}
	// 종료 버튼
	@FXML
	void closeButtonOnAction() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
	// 데이터베이스 불러오기
	@FXML
	void readlistButtonOnAction() {
		DBConnection connNow = new DBConnection();
		Connection conn = connNow.getConnection();
		
		String sql = "SELECT * FROM member_accounts "
				+ "ORDER BY idx";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ObservableList<UserDataTable> dataList = FXCollections.observableArrayList(); // 자바 제네릭(Generic)
			
			while(rs.next()) {
				dataList.add(
					new UserDataTable(
							rs.getString("idx"),
							rs.getString("user_name"),
							rs.getString("user_gender"),
							rs.getString("class_name"),
							rs.getString("class_num"),
							rs.getString("city"),
							rs.getString("jungbo")
					)
				);
			}
			
			tableView.setItems(dataList);
		} catch(Exception e) { System.out.println("DB 출력 실패");}
		
	}
}

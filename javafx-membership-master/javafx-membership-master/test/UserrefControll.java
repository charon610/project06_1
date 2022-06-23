package test;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import test.ComponentDAO;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UserrefControll implements Initializable {
	@FXML private TableView<UserDataTable> tableView;
	@FXML private TableColumn<UserDataTable, Integer> 번호;
	@FXML private TableColumn<UserDataTable, String> 회원명;
	@FXML private TableColumn<UserDataTable, String> 성별;
	@FXML private TableColumn<UserDataTable, String> 과목명;
	@FXML private TableColumn<UserDataTable, Integer> 강의실;
	@FXML private TableColumn<UserDataTable, String> 주거지;
	@FXML private TableColumn<UserDataTable, String> 자격증;
	
	@FXML private Button 회원정보수정버튼;
	@FXML private Button 돌아가기버튼;
	@FXML private Button 회원찾기버튼;
	@FXML private TextField 회원이름입력창;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		번호.setCellValueFactory(new PropertyValueFactory<UserDataTable,Integer>("idx"));
		회원명.setCellValueFactory(new PropertyValueFactory<UserDataTable,String>("user_name"));
		성별.setCellValueFactory(new PropertyValueFactory<UserDataTable,String>("user_gender"));
		과목명.setCellValueFactory(new PropertyValueFactory<UserDataTable,String>("class_name"));
		강의실.setCellValueFactory(new PropertyValueFactory<UserDataTable,Integer>("class_num"));
		주거지.setCellValueFactory(new PropertyValueFactory<UserDataTable,String>("city"));
		자격증.setCellValueFactory(new PropertyValueFactory<UserDataTable,String>("jungbo"));
		
		setTableView();
	}
	
	public void setTableView() {
		 
	}
}

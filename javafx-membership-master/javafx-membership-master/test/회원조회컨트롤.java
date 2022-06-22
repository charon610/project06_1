package test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class 회원조회컨트롤 implements Initializable {
	@FXML private TableView<회원정보테이블> tableView;
	@FXML private TableColumn<회원정보테이블, Integer> 번호;
	@FXML private TableColumn<회원정보테이블, String> 회원명;
	@FXML private TableColumn<회원정보테이블, String> 성별;
	@FXML private TableColumn<회원정보테이블, String> 과목명;
	@FXML private TableColumn<회원정보테이블, Integer> 강의실;
	@FXML private TableColumn<회원정보테이블, String> 주거지;
	@FXML private TableColumn<회원정보테이블, String> 자격증;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		번호.setCellValueFactory(new PropertyValueFactory<회원정보테이블,Integer>("idx"));
		회원명.setCellValueFactory(new PropertyValueFactory<회원정보테이블,String>("user_name"));
		성별.setCellValueFactory(new PropertyValueFactory<회원정보테이블,String>("user_gender"));
		과목명.setCellValueFactory(new PropertyValueFactory<회원정보테이블,String>("class_name"));
		강의실.setCellValueFactory(new PropertyValueFactory<회원정보테이블,Integer>("class_num"));
		주거지.setCellValueFactory(new PropertyValueFactory<회원정보테이블,String>("city"));
		자격증.setCellValueFactory(new PropertyValueFactory<회원정보테이블,String>("jungbo"));
		TableColumn tableColumn1 = 번호.getColumns().get(0);
		TableColumn tableColumn2 = 회원명.getColumns().get(1);
		TableColumn tableColumn3 = 성별.getColumns().get(2);
		TableColumn tableColumn4 = 과목명.getColumns().get(3);
		TableColumn tableColumn5 = 강의실.getColumns().get(4);
		TableColumn tableColumn6 = 주거지.getColumns().get(5);
		TableColumn tableColumn7 = 자격증.getColumns().get(6);
		
	}
	
	void 테이블뷰1(MouseEvent event) {
		
	}
}

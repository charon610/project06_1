package application;

		
import javafx.event.ActionEvent;	
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController  {
	

  /*로그아웃 버튼 = logoutbutton
  	회원등록 버튼 = memberbutton
  	회원조회 버튼 = userrefbutton
  */
	
	@FXML
	private Button logoutbutton;
	
	@FXML
	private Button userrefbutton;
	
	@FXML
	private Button memberbutton;
	

	//회원 추가 버튼 클릭 이벤트 
	@FXML
	void memberbuttonOnAction(ActionEvent e) {
	
		try {
	   		FXMLLoader loader = new FXMLLoader(getClass().getResource("member.fxml"));
			Parent root1 = (Parent) loader.load();
	   		Stage memberStage = new Stage();
	   		memberStage.setTitle("회원등록");
	   		memberStage.setScene(new Scene(root1));
	   		memberStage.show();
		}catch(Exception ex) {
		
	}
	}
	
	//회원 조회 버튼 클릭 이벤트 
	@FXML
	void userrefbuttonOnAction(ActionEvent e) {
	

		try {
	   		FXMLLoader loader = new FXMLLoader(getClass().getResource("userref.fxml"));
			Parent root2 = (Parent) loader.load();
	   		Stage userrefStage = new Stage();
	   		userrefStage.setTitle("회원조회");
	   		userrefStage.setScene(new Scene(root2));
	   		userrefStage.show();
		}catch(Exception ex) {
		
	}
	}
	//로그아웃 버튼 클릭 이벤트 
	@FXML
	void logoutbuttonOnAction() {
		
		Stage logoutstage = (Stage) logoutbutton.getScene().getWindow();
		logoutstage.close();
		 
		try {
	   		FXMLLoader loader = new FXMLLoader(getClass().getResource("login2.fxml"));
			Parent root3 = (Parent) loader.load();
	   		Stage userrefStage = new Stage();
	   		userrefStage.setTitle("로그인");
	   		userrefStage.setScene(new Scene(root3));
	   		userrefStage.show();
		}catch(Exception ex) {
		
	}
	}
}

package test;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController  {

	@FXML 
	
	public void closeButtonOnAction(ActionEvent e) {
		Platform.exit();
	}
	
	public void loginButtonOnAction(ActionEvent e) {
		try {
			Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml")); // getResource (" 열 fxml 파일 이름")
			Stage membershipStage = new Stage();
			membershipStage.setTitle("메인 메뉴 창");
			membershipStage.setScene(new Scene(root1, 600, 400));
			membershipStage.show();
		} catch (Exception e2) {
			
		}
		
	}
}

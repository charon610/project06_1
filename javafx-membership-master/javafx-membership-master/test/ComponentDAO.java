package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import test.Main;
import test.UserDataTable;

public class ComponentDAO {

	private static Connection conn;
	private static ResultSet rs;

	
	public void setMain(Main main) {
	}
	// 데이터베이스 연결
	public ComponentDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbtest","1234");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ObservableList<UserDataTable> getComponentList(){
		
		String SQL = "SELECT * FROM component_stock";
		ObservableList<UserDataTable> componentList = FXCollections.observableArrayList();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				UserDataTable component = new UserDataTable(rs.getInt("idx"),rs.getString("user_name"), rs.getString("user_gender"),
						rs.getString("class_name"),rs.getInt("class_num"),rs.getString("city"),rs.getString("jungbo"));
				componentList.add(component);
			}
			
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return componentList;
	}
	
	public int saveComponentList(ObservableList<UserDataTable> componentList) {
		if(deleteComponentList() == -1) {
			return -1;
		}
		if (insertComponentList(componentList) == -1) {
			return -1;
		}
		return 1;
	}
	
	int deleteComponentList() {

		try {
			
			String SQL = "DELETE FROM component_stock";
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.executeQuery();
			pstmt.close();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	// 데이터베이스 입력
	int insertComponentList(ObservableList<UserDataTable> componentList) {
		
		try {
			
			System.out.println(componentList.size());
			String SQL = "INSERT INTO component_stock";
			SQL += "(idx,user_name,user_gender,class_name,class_num,city,jungbo)";
			SQL += " VALUES(?,?,?,?,?,?,?)";
				
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			for (UserDataTable component : componentList) {
			int 번호 = component.get번호();
			String 이름 = component.get이름();
			String 성별 = component.get성별();
			String 과목명 = component.get과목명();
			int 강의실 = component.get강의실();
			String 주거지 = component.get주거지();
			String 자격증 = component.get자격증();
			
			pstmt.setInt(1, 번호);
			pstmt.setString(2, 이름);
			pstmt.setString(3, 성별);
			pstmt.setString(4, 과목명);
			pstmt.setInt(5, 강의실);
			pstmt.setString(6, 주거지);
			pstmt.setString(7, 자격증);
			pstmt.executeUpdate();
			
			}
			pstmt.close();

			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
	
}

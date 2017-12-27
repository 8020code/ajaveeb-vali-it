package ee.bcs.koolitus.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ee.bcs.koolitus.bean.Login;


public class LoginService {
	static HashMap<Integer, Login> loginMap = getLoginMap();
	Login searchQuery =new Login();

	public LoginService() {

	}
	
	public List<Login> getAllLogins(String usernamePassword) {
		List<Login> listOfLoginObj = new ArrayList<>();

		
		Connection connection = DBConnectionHandling.createConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM ajaveeb.login WHERE username_password LIKE '" + usernamePassword + "';");
			while (resultSet.next()) {
				Login loginObj = new Login(resultSet.getInt("user_id"),
						resultSet.getString("username_password"));
				listOfLoginObj.add(loginObj);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		return listOfLoginObj;
	}

	public Login getLogin(int userId) {
		Login Login = null;
		return Login;
	}
	
	public static HashMap<Integer, Login> getLoginMap() {
		return loginMap;
	}
	
	
	
	

}
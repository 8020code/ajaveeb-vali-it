package ee.bcs.koolitus.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHandling {
	public static Connection connection = null;

	public static Connection createConnection() {
		loadDriver();
		try {
			connection =
				       DriverManager.getConnection("jdbc:mysql://localhost/ajaveeb?" +
				                                   "user=root&password=valiit500");
		} catch (SQLException e) {
			System.out.println("Creating database connection has failed");
			e.printStackTrace();
		}
		return connection;
	}

	private static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("Loading MySql driver has failed");
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Closing database connection has failed");
			e.printStackTrace();
		}
	}
	
}
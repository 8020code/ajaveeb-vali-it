package ee.bcs.koolitus.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ee.bcs.koolitus.bean.PostState;

public class PostStateService {
	public List<PostState> getAllPostStates() {
		List<PostState> listOfPostStatesObj = new ArrayList<>();
		Connection connection = DBConnectionHandling.createConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM ajaveeb.states;");
			while (resultSet.next()) {
				listOfPostStatesObj.add(new PostState(resultSet.getInt("state_id"),
						resultSet.getString("state_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		return listOfPostStatesObj;
	}

	public PostState getPostState(int postStateId) {
		PostState PostState = null;
		return PostState;
	}

}
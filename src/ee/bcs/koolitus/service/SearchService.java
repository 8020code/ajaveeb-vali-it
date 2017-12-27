package ee.bcs.koolitus.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ee.bcs.koolitus.bean.Blog;
import ee.bcs.koolitus.bean.PostState;
import ee.bcs.koolitus.bean.SearchPost;
import ee.bcs.koolitus.bean.Tag;

public class SearchService {
	static HashMap<Integer, SearchPost> searchMap = getSearchMap();
	SearchPost searchQuery =new SearchPost();

	public SearchService() {

	}
	
	public List<SearchPost> getAllSearches(String searchKeyword) {
		List<SearchPost> listOfSearchObj = new ArrayList<>();

		
		Connection connection = DBConnectionHandling.createConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM ajaveeb.blog WHERE blog_content LIKE '%" + searchKeyword + "%';");
			while (resultSet.next()) {
				SearchPost searchObj = new SearchPost(resultSet.getInt("blog_entry_id"),
						resultSet.getString("blog_content"));
				listOfSearchObj.add(searchObj);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		return listOfSearchObj;
	}

	public SearchPost getSearchPost(int blogId) {
		SearchPost SearchPost = null;
		return SearchPost;
	}
	
	public static HashMap<Integer, SearchPost> getSearchMap() {
		return searchMap;
	}
	
	
	
	

}
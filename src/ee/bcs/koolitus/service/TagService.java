package ee.bcs.koolitus.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import ee.bcs.koolitus.bean.Tag;
import ee.bcs.koolitus.bean.PostState;

public class TagService {
	static HashMap<Integer, Tag> tagIdMap = getTagIdMap();

	public TagService() {

	}

	public List<Tag> getAllTags() {
		List<Tag> listOfTags = new ArrayList<>();
		

		
		Connection connection = DBConnectionHandling.createConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM ajaveeb.blog;");) {
			while (resultSet.next()) {
				Tag tag = new Tag(resultSet.getInt("blog_entry_id"), resultSet.getString("tags_from_post"));

				listOfTags.add(tag);
						
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		return listOfTags;
	}

	public Tag getTag(int tagId) {
		Tag tag = tagIdMap.get(tagId);
		return tag;
	}

	public Tag addTag(Tag tag) {
		
			Connection connection = DBConnectionHandling.createConnection(); //
			for(Integer key : tag.getTestMap().keySet()){
				
				for (int i=0; i<tag.getTestMap().get(key).length; i++){
					try (Statement statement = connection.createStatement();) {
						statement.executeUpdate(
							"INSERT INTO ajaveeb.tags_split (blog_entry_id, single_tag_name) VALUES ("+ key + ", '"+ tag.getTestMap().get(key)[i] + "');");
	
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
			
			DBConnectionHandling.closeConnection(connection);
			return tag;	
	}
	
	public void deleteTag(int tagId) {
		tagIdMap.remove(tagId);
	}

	public static HashMap<Integer, Tag> getTagIdMap() {
		return tagIdMap;
	}
	
}

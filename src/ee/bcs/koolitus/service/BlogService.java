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
import ee.bcs.koolitus.bean.Tag;


public class BlogService {
	static HashMap<Integer, Blog> blogIdMap = getBlogIdMap();

	public BlogService() {

	}

	public List<Blog> getAllBlogs() {
		List<Blog> listOfBlogs = new ArrayList<>();
		
		PostStateService postStateService = new PostStateService();
		List<PostState> postStates = postStateService.getAllPostStates();
		
		Connection connection = DBConnectionHandling.createConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM ajaveeb.blog;");) {
			while (resultSet.next()) {
				Blog blog = new Blog(resultSet.getInt("blog_entry_id"), resultSet.getString("blog_heading"),
						resultSet.getString("blog_content"), resultSet.getString("tags_from_post"));// oli getLong; Added resultSet.getString("tags_from_post")
				for (PostState postState: postStates){
					if(postState.getPostStateId() == resultSet.getInt("state_id")){
						blog.setPostState(postState);
					}
				}
				listOfBlogs.add(blog);
						
			}
			//adding here from main, this part activates 3 times per page refresh
			Map<Integer, String> mapObj4 = new HashMap<>();
			Tag testObj = new Tag(mapObj4);
			TagService testObj2 = new TagService();
			testObj2.addTag(testObj);
			//ends here
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		return listOfBlogs;
	}

	public Blog getBlog(int blogId) {
		Blog blog = blogIdMap.get(blogId);
		return blog;
	}

	public Blog addBlog(Blog blog) {
		Connection connection = DBConnectionHandling.createConnection();
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(
				"INSERT INTO ajaveeb.blog (blog_heading, blog_content, state_id, tags_from_post) VALUES ('"+ blog.getBlogName() + "', '"+ blog.getBlogContent() + "', " + blog.getPostState().getPostStateId() + ", '"+ blog.getTagsFromPost() + "');");// added tags_from_post and  '"+ blog.getTagsFromPost() + "') to last place
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		return blog;
	}

	public Blog updateBlog(Blog blog) {
		if (blog.getBlogId() <= 0)
			return null;
		Connection connection = DBConnectionHandling.createConnection();
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"UPDATE ajaveeb.blog SET blog_heading='" + blog.getBlogName() +"', blog_content='" + blog.getBlogContent() + "', state_id='" + blog.getPostState().getPostStateId() + "', tags_from_post='" + blog.getTagsFromPost() + "' WHERE blog_entry_id='" + blog.getBlogId()+ "';");
				//"INSERT INTO ajaveeb.blog (blog_heading, blog_content, state_id, tags_from_post) VALUES ('"+ blog.getBlogName() + "', '"+ blog.getBlogContent() + "', " + blog.getPostState().getPostStateId() + ", '"+ blog.getTagsFromPost() + "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		blogIdMap.put(blog.getBlogId(), blog);
		return blog;
	}

	public void deleteBlog(int blogId) {
		Connection connection = DBConnectionHandling.createConnection();
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(
				//"DELETE FROM ajaveeb.blog (blog_heading, blog_content, state_id, tags_from_post) VALUES ('"+ blog.getBlogName() + "', '"+ blog.getBlogContent() + "', " + blog.getPostState().getPostStateId() + ", '"+ blog.getTagsFromPost() + "');");
				"DELETE FROM ajaveeb.blog WHERE blog_entry_id = ("+ blogId + ");");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnectionHandling.closeConnection(connection);
		
		//blogIdMap.remove(blogId);
	}

	public static HashMap<Integer, Blog> getBlogIdMap() {
		return blogIdMap;
	}
}
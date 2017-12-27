package ee.bcs.koolitus.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ee.bcs.koolitus.bean.Blog;
import ee.bcs.koolitus.service.BlogService;

@Path("/blogs")
public class BlogController {

	BlogService blogService = new BlogService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Blog> getBlogs() {

		List<Blog> listOfBlogs = blogService.getAllBlogs();
		return listOfBlogs;
	}

	@GET
	@Path("/{blogId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Blog getBlogById(@PathParam("blogId") int blogId) {
		return blogService.getBlog(blogId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Blog addBlog(Blog blog) {
		return blogService.addBlog(blog);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Blog updateBlog(Blog blog) {
		return blogService.updateBlog(blog);

	}

	@DELETE
	@Path("/{blogId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBlog(@PathParam("blogId") int blogId) {
		blogService.deleteBlog(blogId);

	}

}
package ee.bcs.koolitus.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ee.bcs.koolitus.bean.Blog;
import ee.bcs.koolitus.bean.SearchPost;
import ee.bcs.koolitus.service.SearchService;

//Not finished class
@Path("/search")
public class SearchController {
	SearchService searchServiceObj = new SearchService();
	SearchPost searchQuery =new SearchPost();

	@GET
	@Path("/{searchKeyword}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SearchPost> getSearchPost(@PathParam("searchKeyword") String searchKeyword) {

		List<SearchPost> listOfSearches = searchServiceObj.getAllSearches(searchKeyword);
		return listOfSearches;
	}
	


}
	
	//listOfSearchObj



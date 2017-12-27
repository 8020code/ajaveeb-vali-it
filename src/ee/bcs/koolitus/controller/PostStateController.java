package ee.bcs.koolitus.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ee.bcs.koolitus.bean.PostState;
import ee.bcs.koolitus.service.PostStateService;

@Path("/states")
public class PostStateController {
	PostStateService postStateServiceObj = new PostStateService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PostState> getPostStates() {

		List<PostState> listOfPostStates = postStateServiceObj.getAllPostStates();
		return listOfPostStates;
	}

	@GET
	@Path("/{postStateId}")
	@Produces(MediaType.APPLICATION_JSON)
	public PostState getBlogById(@PathParam("postStateId") int postStateId) {
		return postStateServiceObj.getPostState(postStateId);
	
	}

}

package ee.bcs.koolitus.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ee.bcs.koolitus.bean.Login;
import ee.bcs.koolitus.service.LoginService;
import ee.bcs.koolitus.service.SearchService;


@Path("/login")
public class LoginController {
	LoginService loginServiceObj = new LoginService();
	Login searchQuery =new Login();

	@GET
	@Path("/{usernamePassword}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Login> getSearchPost(@PathParam("usernamePassword") String usernamePassword) {

		List<Login> listOfCombinations = loginServiceObj.getAllLogins(usernamePassword);
		return listOfCombinations;
	}
	


}
	
	
	//listOfSearchObj



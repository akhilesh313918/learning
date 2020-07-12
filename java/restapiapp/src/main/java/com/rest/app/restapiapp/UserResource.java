package com.rest.app.restapiapp;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserResource {

	
	UserRepo ur = new UserRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		
		
		return ur.getAllUser();
		
	}
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User u1){
		System.out.println(u1);
		ur.createUser(u1);
		
		return u1;
		
	}
	
	@DELETE
	@Path("id")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(User u1){
		ur.deleteUser(u1);
	}
	
	@PUT
	@Path("user/id")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User u1){
		ur.updateUser(u1);
	}
}

package com.springboot.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.dao.UserDaoService;
import com.springboot.execption.UserNotFoundException;
import com.springboot.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDaoService userService;

	@GetMapping("/users")
	public List<User> retrievedAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public   EntityModel<User> retrieveUsers(@PathVariable int id){
		User  user = userService.findOne(id);
		if(user == null ) {
			throw new UserNotFoundException("ID::"+id);
		}
		//Creating object for EntityModel
		EntityModel<User> model = EntityModel.of(user);
		//Build the link
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrievedAllUsers());
		
		//Adding linkToUsers to model
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	// input - details for user
	//output - Created and return the created URI
	@PostMapping("/createUsers")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		userService.save(user);
		//ResponseEntity<T>.created(location)
		
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(user.getName()).toUri();
		return ResponseEntity.created(location).build();
	}
	 
	
	// if the user deleted success full then it will return response status 200 else it will throw UserNotFoundExcpetion
	@DeleteMapping("/delete/{id}")
	public void deleteUserByID(@PathVariable int id){
		User  user = userService.deleteByID(id);
		if(user == null ) {
			throw new UserNotFoundException("ID::"+id);
		}
	}
	
	
	
	
	/*
	 @RequestBody : Annotation indicating a method parameter should be bound to the body of the HTTP request. 
	 
	 @ResponseBody annotation can be put on a method and indicates that the return type should be written straight to the HTTP response body.
	 
	 How to set the return the status of created user into the Response ?
	 How to set the URI of created resource into the Response ?
	 
	 URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("{id").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	
	After running check the response at the header of the response - will get the location
	 
	 location : http://localhost:2019/createUsers/kumar
	*/	
}

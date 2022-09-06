package com.springboot.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.model.User;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	public static int userCount =4;
	static {
		users.add(new User(1, "Amit", new Date()));
		users.add(new User(2, "Niraj", new Date()));
		users.add(new User(3, "Sandeep", new Date()));
		users.add(new User(4, "Rakesh", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteByID(int id) {
		 Iterator<User> iterator = users.iterator();
		 while(iterator.hasNext()) {
			 User user = iterator.next();
			 if(user.getId() == id) {
				 iterator.remove();
				 return user;
			 }
		 }
		 return null;
	}
}

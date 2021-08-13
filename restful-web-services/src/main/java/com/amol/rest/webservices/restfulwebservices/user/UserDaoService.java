package com.amol.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int usersCount = 4;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Lucifer", new Date()));
		users.add(new User(4, "God", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public static User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(Integer id) {
		User result = null;
		for(User user : users) {
			if(user.getId().equals(id)) {
				result =  user;
			}
		}
		return result;
	}
	
	public User deleteUserById(int id) {
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			User toDelete = it.next();
			if(id == toDelete.getId()) {
				it.remove();
				return toDelete;
			}
		}
		return null;
	}


}

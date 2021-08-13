package com.amol.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.amol.rest.webservices.restfulwebservices.post.Post;

public class User {

	private Integer id;
	
	@Size(min = 2, message = "Name should be atleast 2 characters.")
	private String name;
	
	@Past
	private Date birthDate;
	
	private Map<Integer, Post> posts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Post getPosts(int id) {
		return this.posts.get(id);
	}

	public void setPosts(String content) {
		Post post = new Post(content);
		this.posts.put(post.getId(), post);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = new HashMap<>();
	}

	public User() {
		super();
	}

}

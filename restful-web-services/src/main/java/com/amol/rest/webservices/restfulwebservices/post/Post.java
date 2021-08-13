package com.amol.rest.webservices.restfulwebservices.post;

public class Post {
	
	private static int postID = 0;
	private String content;
	private int id;
	
	public Post(String content) {
		super();
		this.id = ++postID;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

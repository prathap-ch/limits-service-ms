package com.skillUp.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillUp.user.User;
@Entity(name="POSTS")
public class Posts {
	@Id
	@GeneratedValue
	private int id;
	private String description;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Posts() {
		super();
	}

	public Posts(int id, String message) {
		super();
		this.id = id;
		this.description = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", message=" + description + "]";
	}
	
}

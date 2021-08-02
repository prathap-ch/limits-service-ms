package com.skillUp.user;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillUp.beans.Posts;
@Entity(name="USERS")
public class User {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="ID")
@Id
private int id;
@Column(name="NAME")
private String name;
@Column(name="DOB")
private Date dateOfBirth;
@JsonIgnore
@OneToMany(mappedBy = "user")
private List<Posts> posts;

public User() {
	super();
}

public User(int id, String name, Date dateOfBirth) {
	super();
	this.id = id;
	this.name = name;
	this.dateOfBirth = dateOfBirth;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public List<Posts> getPosts() {
	return posts;
}

public void setPosts(List<Posts> posts) {
	this.posts = posts;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", posts=" + posts + "]";
}

}

package com.couchdb.couchdb2.service;

import java.util.List;

import com.couchdb.couchdb2.model.User;

public interface UserServiceInter {
	
	public User createUser(User user);
	//public User updateUser(User user);
	public List<User> viewAllUser();
	//public void deleteUser(User user);
	public String findById(String id);

}

package com.couchdb.couchdb2.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchdb.couchdb2.model.User;
import com.couchdb.couchdb2.repository.UserDao;

@Service
public class UserServiceImpl implements UserServiceInter {
	@Autowired
	UserDao userDao;

	@Override
	public User createUser(User user) {
		int j = 0;

		long start = System.currentTimeMillis();

		for (j = 0; j < 100000; j++) {
			user.setId(String.valueOf(new Random()));

			User users = userDao.save(user);
		}
		long end = System.currentTimeMillis();
		long result = (end - start);
		String time = String.valueOf(result);
		System.out.println("This is write of " + j + "record time   :" + time);
		return null;

	}

	/*
	 * @Override public User updateUser(User user) {
	 * 
	 * User user3 = userDao.findById(user.getId()).get();
	 * user3.setAge(user.getAge()); user3.setEmail(user.getEmail());
	 * user3.setName(user.getName()); user3.setId(user.getId()); return
	 * userDao.save(user3); }
	 */
	@Override
	public List<User> viewAllUser() {
		long start = System.currentTimeMillis();
		userDao.findAll();
		long end = System.currentTimeMillis();
		long result = (end - start);
		String time = String.valueOf(result);
		System.out.println("This is findall time   :" + time);
		return null;
	}

	/*
	 * @Override public void deleteUser(User user) { userDao.delete(user);
	 * 
	 * }
	 */

	@Override
	public String findById(String id) {
		long start = System.currentTimeMillis();
		User user = (User) userDao.findById(id).get();
		long end = System.currentTimeMillis();
		long result = (end - start);
		String time = String.valueOf(result);
		System.out.println("This is findById time   :" + time);
		return "userfound";
	}

}
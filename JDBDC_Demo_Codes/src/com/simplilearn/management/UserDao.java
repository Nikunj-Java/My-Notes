package com.simplilearn.management;

import java.util.List;

public interface UserDao {

	public int createUser(User user);
	public List<User> getAllUsers();
	public User updateUser(User user, int id);
	public boolean deleteUser(int id);
	public User getUserById(int id);
}


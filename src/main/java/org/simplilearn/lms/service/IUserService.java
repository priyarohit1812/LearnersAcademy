package org.simplilearn.lms.service;

import org.simplilearn.lms.entities.User;

public interface IUserService {
	void insert(User user);

	User get(String username, String password);
	
	void updatePassword(String username, String password, String newPassword);
}

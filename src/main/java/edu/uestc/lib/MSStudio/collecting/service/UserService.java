package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.User;

public interface UserService {
	int UserInfoCheck(String name, String password);
	
	String getUserLevel(Integer id);
	
	List<User> getUserList();
	
	boolean createUser(User record);
	
	boolean deleteUser(String id);
	
	User findUser(String id);
	
	boolean updateUser(User record);
}

package edu.uestc.lib.MSStudio.collecting.service;

public interface UserService {
	String UserInfoCheck(String name, String password);
	
	String getUserLevel(Integer id);
}

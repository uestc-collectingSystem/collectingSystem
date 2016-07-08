package edu.uestc.lib.MSStudio.collecting.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.UserMapper;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper dao;
	
	@Override
	public boolean UserInfoCheck(String name,String password) {
		// TODO Auto-generated method stub
		if (dao.countMembers(name, password)==1){
			return true;
		}
		
		return false;
	}

}

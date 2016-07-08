package edu.uestc.lib.MSStudio.collecting.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.UserMapper;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper dao;
	
	@Override
	public boolean UserInfoCheck() {
		// TODO Auto-generated method stub
		dao.selectByPrimaryKey(1);	
		return false;
	}

}

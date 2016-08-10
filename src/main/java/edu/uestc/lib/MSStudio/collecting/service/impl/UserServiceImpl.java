package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.UserMapper;
import edu.uestc.lib.MSStudio.collecting.model.User;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper dao;
	
	@Override
	public int UserInfoCheck(String name,String password) {
		// TODO Auto-generated method stub
		if (dao.countMembers(name, password)==1){
			return dao.findMember(name, password).getId();
		}
		return 0;
	}
	
	@Override
	public String getUserLevel(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id).getLevel();
	}

	@Override
	public List<User> getUserList() {
		// 如果有数据需要隐藏可以在这里做统一处理
		return dao.getAllUsers();
	}

	@Override
	public boolean createUser(User record) {
		// 创建一个用户，返回创建结果
		if (dao.countMembers(record.getUsercode(), record.getPassword())>0){
			return false;
		}
		int result = dao.insert(record);
		if (result !=0 ) return true;
		return false;
	}

	@Override
	public boolean deleteUser(String id) {
		// 删除一个用户，返回删除结果
		if (dao.deleteByPrimaryKey(Integer.valueOf(id))!=0) return true;
		return false;
	}

	@Override
	public User findUser(String id) {
		// 查找指定用户
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean updateUser(User record) {
		// 根据当前内容更新用户
		if (dao.updateByPrimaryKeySelective(record)==0) return false;
		else return true;
	}
	
}

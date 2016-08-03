package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.TeachersMapper;
import edu.uestc.lib.MSStudio.collecting.model.Teachers;
import edu.uestc.lib.MSStudio.collecting.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Resource
	private TeachersMapper dao;
	
	@Override
	public boolean deleteObjectByID(String id) {
		// TODO Auto-generated method stub
		if (dao.deleteByPrimaryKey(Integer.valueOf(id))!=0) return true;
		return false;
	}

	@Override
	public boolean checkObjectByID(String id) {
		// TODO Auto-generated method stub
		if (dao.checkByID(1,Integer.valueOf(id))!=0) return true;
		else return false;
	}

	@Override
	public Teachers getTeacher(String id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(Teachers record) {
		// TODO Auto-generated method stub
		if (dao.insert(record)!=0) return true;
		return true;
	}

	@Override
	public List<Teachers> listAllTeacher(String num, String size) {
		// TODO Auto-generated method stub
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}

	@Override
	public boolean update(Teachers record) {
		if (dao.updateByPrimaryKeySelective(record)!=0) return true;
		return false;
	}

		
}

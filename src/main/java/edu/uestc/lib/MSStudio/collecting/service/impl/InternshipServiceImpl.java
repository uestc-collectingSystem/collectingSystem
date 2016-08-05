package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.InternshipMapper;
import edu.uestc.lib.MSStudio.collecting.model.Internship;
import edu.uestc.lib.MSStudio.collecting.service.InternshipService;

@Service("internshipService")
public class InternshipServiceImpl implements InternshipService{

	@Resource
	private InternshipMapper dao;
	
	@Override
	public boolean deleteObjectByID(String id) {
		// TODO Auto-generated method stub
		if (dao.deleteByPrimaryKey(Integer.valueOf(id))!=0) return true;
		return false;
	}

	@Override
	public boolean checkObjectByID(String id) {
		if (dao.checkByID(1,Integer.valueOf(id))!=0) return true;
		else return false;
	}

	@Override
	public Internship getInternship(String id) {
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(Internship record) {
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<Internship> listAllInternship(String num, String size) {
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}

	@Override
	public boolean update(Internship record) {
		if (dao.updateByPrimaryKeySelective(record)!=0) return true;
		return false;
	}

}

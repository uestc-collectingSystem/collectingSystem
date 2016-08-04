package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.MajorNumMapper;
import edu.uestc.lib.MSStudio.collecting.model.MajorNum;
import edu.uestc.lib.MSStudio.collecting.service.MajorNumService;

@Service("majorNumService")
public class MajorNumServiceImpl implements MajorNumService{

	@Resource
	private MajorNumMapper dao;

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
	public MajorNum getMajorNum(String id) {
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(MajorNum record) {
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<MajorNum> listAllMajorNum(String num, String size) {
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);

	}

	@Override
	public boolean update(MajorNum record) {
		if (dao.updateByPrimaryKeySelective(record)!=0) return true;
		return false;
	}
	
	
	
}

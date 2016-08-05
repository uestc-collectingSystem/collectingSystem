package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.SchoolEnterpriseMapper;
import edu.uestc.lib.MSStudio.collecting.model.SchoolEnterprise;
import edu.uestc.lib.MSStudio.collecting.service.SchoolEnterService;

@Service("schoolEnterService")
public class SchoolEnterServiceImpl implements SchoolEnterService{

	@Resource
	private SchoolEnterpriseMapper dao;
	
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
	public SchoolEnterprise getSchoolEnterprise(String id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(SchoolEnterprise record) {
		// TODO Auto-generated method stub
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<SchoolEnterprise> listAllSchoolEnterprise(String num, String size) {
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}

	@Override
	public boolean update(SchoolEnterprise record) {
		if (dao.updateByPrimaryKeySelective(record)!=0) return true;
		return false;
	}
	
}

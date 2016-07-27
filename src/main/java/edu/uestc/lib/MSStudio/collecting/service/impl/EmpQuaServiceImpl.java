package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.EmployQualityMapper;
import edu.uestc.lib.MSStudio.collecting.model.EmployQuality;
import edu.uestc.lib.MSStudio.collecting.service.EmpQuaServicee;

@Service("empQuaService")
public class EmpQuaServiceImpl implements EmpQuaServicee {
	
	@Resource
	private EmployQualityMapper dao;

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
	public EmployQuality getEmployquality(String id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(EmployQuality record) {
		// TODO Auto-generated method stub
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<EmployQuality> listAllEmployQuality(String num, String size) {
		// TODO Auto-generated method stub
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}
	
	
}

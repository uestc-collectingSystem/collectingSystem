package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.QualityAssureMapper;
import edu.uestc.lib.MSStudio.collecting.model.QualityAssure;
import edu.uestc.lib.MSStudio.collecting.service.QualityAssureService;

@Service("qualityAssureService")
public class QualityAssureServiceImpl implements QualityAssureService {
	@Resource
	private QualityAssureMapper dao;

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
	public QualityAssure getQualityAssure(String id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(QualityAssure record) {
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<QualityAssure> listAllQualityAssure(String num, String size) {
		// TODO Auto-generated method stub
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}
}

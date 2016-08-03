package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.FundsMapper;
import edu.uestc.lib.MSStudio.collecting.model.Funds;
import edu.uestc.lib.MSStudio.collecting.service.FundsService;

@Service("fundsService")
public class FundsServiceImpl implements FundsService{

	@Resource
	private FundsMapper dao;
	
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
	public Funds getFunds(String id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(Funds record) {
		// TODO Auto-generated method stub
		if (dao.insert(record)!=0) return true;
		return true;
	}

	@Override
	public List<Funds> listAllFunds(String num, String size) {
		// TODO Auto-generated method stub
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}

	@Override
	public boolean update(Funds record) {
		// TODO Auto-generated method stub
		if (dao.updateByPrimaryKeySelective(record)!=0) return true;
		return false;
	}

}

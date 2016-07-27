package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.PartyBuildMapper;
import edu.uestc.lib.MSStudio.collecting.model.PartyBuild;
import edu.uestc.lib.MSStudio.collecting.service.PartyBuildService;

@Service("partyBuildService")
public class PartyBuildServiceImpl implements PartyBuildService{

	@Resource
	private PartyBuildMapper dao;
	
	@Override
	public boolean deleteObjectByID(String id) {
		if (dao.deleteByPrimaryKey(Integer.valueOf(id))!=0) return true;
		return false;
	}

	@Override
	public boolean checkObjectByID(String id) {
		if (dao.checkByID(1,Integer.valueOf(id))!=0) return true;
		else return false;
	}

	@Override
	public PartyBuild getPartyBuild(String id) {
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(PartyBuild record) {
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<PartyBuild> listAllPartyBuild(String num, String size) {
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}

}

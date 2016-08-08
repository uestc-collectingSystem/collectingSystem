package edu.uestc.lib.MSStudio.collecting.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.InformantMapper;
import edu.uestc.lib.MSStudio.collecting.service.InformantService;

@Service("informantService")
public class InformantServiceImpl implements InformantService{
	
	@Resource
	private InformantMapper dao;

	@Override
	public boolean deleteObjectByID(String id) {
		if (dao.deleteByPrimaryKey(Integer.valueOf(id))!=0) return true;
		else return false;
	}

	
	
}

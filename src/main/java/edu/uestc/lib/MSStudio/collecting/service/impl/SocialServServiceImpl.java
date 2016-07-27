package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.SocialServiceMapper;
import edu.uestc.lib.MSStudio.collecting.model.SocialService;
import edu.uestc.lib.MSStudio.collecting.service.SocialServService;

@Service("socialServService")
public class SocialServServiceImpl implements SocialServService {

	@Resource
	private SocialServiceMapper dao;

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
	public SocialService getSocialService(String id) {
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(SocialService record) {
		if (dao.insert(record)!=0) return true;
		return false;
	}

	@Override
	public List<SocialService> listAllSocialService(String num, String size) {
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		//System.out.println((pageNum-1)*pageSize+" "+pageNum*pageSize);
		return dao.getAllObject((pageNum-1)*pageSize,pageSize);
	}
	
}

package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.FileInfoMapper;
import edu.uestc.lib.MSStudio.collecting.model.FileInfo;
import edu.uestc.lib.MSStudio.collecting.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {

	@Resource
	private FileInfoMapper dao;
	
	@Override
	public List<FileInfo> listFilePage(String num,String size) {
		// 列举所有的 School 类
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		return dao.getAllObject((pageNum-1)*pageSize,pageNum*pageSize);
	}

	@Override
	public boolean deleteFileById(String id) {
		// TODO Auto-generated method stub
		if (dao.deleteByPrimaryKey(Integer.valueOf(id))!=0) return true;
		return false;
	}
	
	@Override
	public boolean checkFileInfo(String id){
		if (dao.checkByID(1,Integer.valueOf(id))!=0) return true;
		else return false;
	}

	@Override
	public FileInfo findById(String id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(FileInfo record) {
		if (record.getUrl().equals("")){
			return false;
		}
		else {
			dao.insert(record);
			return true;
		}
	}

	@Override
	public List<FileInfo> listFilePage() {
		// TODO Auto-generated method stub
		return this.listFilePage("0","20");
	}
	
}

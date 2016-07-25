package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.FileInfo;

public interface FileService {
	List<FileInfo> listFilePage(String num,String size);
	
	List<FileInfo> listFilePage();
	
	boolean deleteFileById(String id);

	boolean checkFileInfo(String id);
	
	FileInfo findById(String id);
	
	boolean save(FileInfo record);
	
}

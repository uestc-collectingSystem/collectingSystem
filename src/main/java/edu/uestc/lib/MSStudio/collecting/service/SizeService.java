package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;

public interface SizeService {
	public SchoolSize getSchoolSize(String id);
	
	public boolean save(SchoolSize record);
	
//	public List<SchoolSize> listAllSize();

	public List<SchoolSize> listAllSize(String num, String size);

	boolean deleteSizeByID(String id);

	boolean checkSchoolSize(String id);
	
}

package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;

public interface SizeService extends OriginService {
	
	public SchoolSize getSchoolSize(String id);

	public boolean save(SchoolSize record);

	List<SchoolSize> listAllSchoolSize(String num, String size);
	
	public boolean update(SchoolSize record);
}

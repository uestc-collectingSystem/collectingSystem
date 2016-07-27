package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SchoolEnterprise;

public interface SchoolEnterService extends OriginService{
	public SchoolEnterprise getSchoolEnterprise(String id);

	public boolean save(SchoolEnterprise record);

	List<SchoolEnterprise> listAllSchoolEnterprise(String num, String size);
}

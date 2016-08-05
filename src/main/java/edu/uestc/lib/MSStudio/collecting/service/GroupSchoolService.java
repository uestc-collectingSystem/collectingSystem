package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.GroupSchool;

public interface GroupSchoolService extends OriginService {
	public GroupSchool getGroupSchool(String id);

	public boolean save(GroupSchool record);

	List<GroupSchool> listAllGroupSchool(String num, String size);

	public boolean update(GroupSchool record);
}

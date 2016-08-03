package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Teachers;

public interface TeacherService extends OriginService {
	public Teachers getTeacher(String id);

	public boolean save(Teachers record);

	List<Teachers> listAllTeacher(String num, String size);

	public boolean update(Teachers record);
}

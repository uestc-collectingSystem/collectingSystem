package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.StudentQuality;

public interface StuQuaService extends OriginService{
	public StudentQuality getStudentQuality(String id);

	public boolean save(StudentQuality record);

	List<StudentQuality> listAllStudentQuality(String num, String size);
}

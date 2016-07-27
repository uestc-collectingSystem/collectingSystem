package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Project;

public interface ProjectService extends OriginService{
	public Project getProject(String id);

	public boolean save(Project record);

	List<Project> listAllProject(String num, String size);

}

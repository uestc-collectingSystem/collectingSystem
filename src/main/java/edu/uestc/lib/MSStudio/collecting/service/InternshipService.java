package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Internship;

public interface InternshipService extends OriginService{
	public Internship getInternship(String id);

	public boolean save(Internship record);

	List<Internship> listAllInternship(String num, String size);
}

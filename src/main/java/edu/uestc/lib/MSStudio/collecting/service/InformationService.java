package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Information;
import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;

public interface InformationService extends OriginService {
	public Information getInformation(String id);

	public boolean save(Information record);

	List<Information> listAllInformation(String num, String size);

	public boolean update(Information record);
}

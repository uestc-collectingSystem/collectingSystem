package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.EmployQuality;

public interface EmpQuaServicee extends OriginService {
	public EmployQuality getEmployquality(String id);

	public boolean save(EmployQuality record);

	List<EmployQuality> listAllEmployQuality(String num, String size);
}

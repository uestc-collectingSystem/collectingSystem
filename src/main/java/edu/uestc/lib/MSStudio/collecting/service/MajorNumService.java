package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.MajorNum;

public interface MajorNumService extends OriginService {
	
	public MajorNum getMajorNum(String id);

	public boolean save(MajorNum record);

	List<MajorNum> listAllMajorNum(String num, String size);

	public boolean update(MajorNum record);

}

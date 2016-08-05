package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.CounpaSupply;

public interface CounpaSuppService extends OriginService{
	public CounpaSupply getCounpaSupply(String id);

	public boolean save(CounpaSupply record);

	List<CounpaSupply> listAllCounpaSupply(String num, String size);

	public boolean update(CounpaSupply record);
}

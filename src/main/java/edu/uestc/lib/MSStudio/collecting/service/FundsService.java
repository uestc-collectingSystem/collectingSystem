package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Funds;

public interface FundsService extends OriginService{
	public Funds getFunds(String id);

	public boolean save(Funds record);

	List<Funds> listAllFunds(String num, String size);

	public boolean update(Funds record);
}

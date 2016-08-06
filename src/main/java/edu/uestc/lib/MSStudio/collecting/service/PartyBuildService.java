package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.PartyBuild;

public interface PartyBuildService extends OriginService{
	public PartyBuild getPartyBuild(String id);

	public boolean save(PartyBuild record);

	List<PartyBuild> listAllPartyBuild(String num, String size);

	public boolean update(PartyBuild record);
}

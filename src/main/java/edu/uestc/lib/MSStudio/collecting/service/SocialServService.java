package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SocialService;

public interface SocialServService extends OriginService{
	public SocialService getSocialService(String id);

	public boolean save(SocialService record);

	List<SocialService> listAllSocialService(String num, String size);

	public boolean update(SocialService record);

}

package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SkillTrain;

public interface SkillTrainService extends OriginService{
	public SkillTrain getSkillTrain(String id);

	public boolean save(SkillTrain record);

	List<SkillTrain> listAllSkillTrain(String num, String size);

	public boolean update(SkillTrain record);

}

package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.EducationTrain;

public interface EducationTrainService extends OriginService{

	public EducationTrain getEducationTrain(String id);

	public boolean save(EducationTrain record);

	List<EducationTrain> listAllEducationTrain(String num, String size);

}

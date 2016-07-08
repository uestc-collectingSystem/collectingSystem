package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.EducationTrain;

public interface EducationTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EducationTrain record);

    int insertSelective(EducationTrain record);

    EducationTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EducationTrain record);

    int updateByPrimaryKey(EducationTrain record);
}
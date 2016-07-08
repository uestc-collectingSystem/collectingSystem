package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.SkillTrain;

public interface SkillTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkillTrain record);

    int insertSelective(SkillTrain record);

    SkillTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkillTrain record);

    int updateByPrimaryKey(SkillTrain record);
}
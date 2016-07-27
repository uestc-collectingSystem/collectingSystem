package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SkillTrain;

public interface SkillTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkillTrain record);

    int insertSelective(SkillTrain record);

    SkillTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkillTrain record);

    int updateByPrimaryKey(SkillTrain record);
    
    int checkByID(int i, Integer id);

	List<SkillTrain> getAllObject(int begin, int size);
}
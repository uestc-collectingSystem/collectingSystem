package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.EducationTrain;

public interface EducationTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EducationTrain record);

    int insertSelective(EducationTrain record);

    EducationTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EducationTrain record);

    int updateByPrimaryKey(EducationTrain record);
    
    int checkByID(int i, Integer id);

	List<EducationTrain> getAllObject(int begin, int size);
}
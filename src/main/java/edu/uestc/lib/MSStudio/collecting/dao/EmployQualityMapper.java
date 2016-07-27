package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.EmployQuality;

public interface EmployQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployQuality record);

    int insertSelective(EmployQuality record);

    EmployQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployQuality record);

    int updateByPrimaryKey(EmployQuality record);
    
    int checkByID(int i, Integer id);

	List<EmployQuality> getAllObject(int begin, int size);
}
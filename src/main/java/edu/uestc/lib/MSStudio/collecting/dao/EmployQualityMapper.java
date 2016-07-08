package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.EmployQuality;

public interface EmployQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployQuality record);

    int insertSelective(EmployQuality record);

    EmployQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployQuality record);

    int updateByPrimaryKey(EmployQuality record);
}
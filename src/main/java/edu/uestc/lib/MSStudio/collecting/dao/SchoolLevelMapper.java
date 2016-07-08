package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.SchoolLevel;

public interface SchoolLevelMapper {
    int deleteByPrimaryKey(String code);

    int insert(SchoolLevel record);

    int insertSelective(SchoolLevel record);

    SchoolLevel selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SchoolLevel record);

    int updateByPrimaryKey(SchoolLevel record);
}
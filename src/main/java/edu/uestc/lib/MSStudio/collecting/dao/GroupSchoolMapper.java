package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.GroupSchool;

public interface GroupSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupSchool record);

    int insertSelective(GroupSchool record);

    GroupSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupSchool record);

    int updateByPrimaryKey(GroupSchool record);
}
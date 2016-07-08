package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.MajorSchool;

public interface MajorSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorSchool record);

    int insertSelective(MajorSchool record);

    MajorSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorSchool record);

    int updateByPrimaryKey(MajorSchool record);
}
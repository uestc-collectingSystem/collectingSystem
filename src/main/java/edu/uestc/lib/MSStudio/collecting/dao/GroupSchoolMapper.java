package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.GroupSchool;

public interface GroupSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupSchool record);

    int insertSelective(GroupSchool record);

    GroupSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupSchool record);

    int updateByPrimaryKey(GroupSchool record);
    
    int checkByID(int i, Integer id);

	List<GroupSchool> getAllObject(int begin, int size);
}
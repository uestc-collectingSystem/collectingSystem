package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Teachers;

public interface TeachersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);

	int checkByID(int i, Integer id);

	List<Teachers> getAllObject(int begin, int size);
}
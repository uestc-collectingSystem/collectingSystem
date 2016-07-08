package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(String majorcode);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(String majorcode);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}
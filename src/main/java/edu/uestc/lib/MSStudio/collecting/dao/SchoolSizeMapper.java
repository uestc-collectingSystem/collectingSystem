package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;

public interface SchoolSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SchoolSize record);

    int insertSelective(SchoolSize record);

    SchoolSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchoolSize record);

    int updateByPrimaryKey(SchoolSize record);
}
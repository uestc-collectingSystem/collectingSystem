package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.MajorLayout;

public interface MajorLayoutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorLayout record);

    int insertSelective(MajorLayout record);

    MajorLayout selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorLayout record);

    int updateByPrimaryKey(MajorLayout record);
}
package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.MajorStuCount;

public interface MajorStuCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorStuCount record);

    int insertSelective(MajorStuCount record);

    MajorStuCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorStuCount record);

    int updateByPrimaryKey(MajorStuCount record);
}
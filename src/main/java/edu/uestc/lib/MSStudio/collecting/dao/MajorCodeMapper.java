package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.MajorCode;

public interface MajorCodeMapper {
    int deleteByPrimaryKey(String code);

    int insert(MajorCode record);

    int insertSelective(MajorCode record);

    MajorCode selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MajorCode record);

    int updateByPrimaryKey(MajorCode record);
}
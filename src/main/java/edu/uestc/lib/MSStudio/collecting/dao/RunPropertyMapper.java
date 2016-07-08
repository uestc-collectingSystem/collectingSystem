package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.RunProperty;

public interface RunPropertyMapper {
    int deleteByPrimaryKey(String code);

    int insert(RunProperty record);

    int insertSelective(RunProperty record);

    RunProperty selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(RunProperty record);

    int updateByPrimaryKey(RunProperty record);
}
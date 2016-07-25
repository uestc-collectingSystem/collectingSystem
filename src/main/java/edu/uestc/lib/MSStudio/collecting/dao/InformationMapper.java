package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Information;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}
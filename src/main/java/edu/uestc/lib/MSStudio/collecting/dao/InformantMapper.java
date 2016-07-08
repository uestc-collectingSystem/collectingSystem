package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Informant;

public interface InformantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Informant record);

    int insertSelective(Informant record);

    Informant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Informant record);

    int updateByPrimaryKey(Informant record);
}
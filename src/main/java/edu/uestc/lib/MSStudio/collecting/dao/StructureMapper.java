package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Structure;

public interface StructureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Structure record);

    int insertSelective(Structure record);

    Structure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Structure record);

    int updateByPrimaryKey(Structure record);
}
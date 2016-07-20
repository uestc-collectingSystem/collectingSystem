package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;

public interface SchoolSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SchoolSize record);

    int insertSelective(SchoolSize record);

    SchoolSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchoolSize record);

    int updateByPrimaryKey(SchoolSize record);
    
    List<SchoolSize> getAllSize(Integer begin,Integer end);
    
    /**
     * 0 for uncheck
     * 1 for check
     */
    int checkByID(Integer value,Integer id);
    
}
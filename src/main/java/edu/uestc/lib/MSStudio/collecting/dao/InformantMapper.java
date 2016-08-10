package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.GroupSchool;
import edu.uestc.lib.MSStudio.collecting.model.Informant;

public interface InformantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Informant record);

    int insertSelective(Informant record);

    Informant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Informant record);

    int updateByPrimaryKey(Informant record);

	List<GroupSchool> getAllObject(int begin, int size);
}
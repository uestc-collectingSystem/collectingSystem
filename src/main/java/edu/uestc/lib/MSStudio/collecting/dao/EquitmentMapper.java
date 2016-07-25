package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Equipment;

public interface EquitmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

	int checkByID(int i, Integer id);
	
	List<Equipment> getAllObject(Integer begin,Integer end);
}
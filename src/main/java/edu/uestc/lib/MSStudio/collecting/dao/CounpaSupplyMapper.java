package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.CounpaSupply;

public interface CounpaSupplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CounpaSupply record);

    int insertSelective(CounpaSupply record);

    CounpaSupply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CounpaSupply record);

    int updateByPrimaryKey(CounpaSupply record);
    
    int checkByID(int i, Integer id);

	List<CounpaSupply> getAllObject(int begin, int size);
}
package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Funds;

public interface FundsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Funds record);

    int insertSelective(Funds record);

    Funds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Funds record);

    int updateByPrimaryKey(Funds record);
    
    int checkByID(int i, Integer id);

	List<Funds> getAllObject(int begin, int size);

}
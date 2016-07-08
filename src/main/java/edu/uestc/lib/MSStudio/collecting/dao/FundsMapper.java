package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Funds;

public interface FundsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Funds record);

    int insertSelective(Funds record);

    Funds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Funds record);

    int updateByPrimaryKey(Funds record);
}
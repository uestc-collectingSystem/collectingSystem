package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Equitment;

public interface EquitmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equitment record);

    int insertSelective(Equitment record);

    Equitment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equitment record);

    int updateByPrimaryKey(Equitment record);
}
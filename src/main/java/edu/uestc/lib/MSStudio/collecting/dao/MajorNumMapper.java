package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.MajorNum;

public interface MajorNumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorNum record);

    int insertSelective(MajorNum record);

    MajorNum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorNum record);

    int updateByPrimaryKey(MajorNum record);

    int checkByID(int i, Integer id);

	List<MajorNum> getAllObject(int begin, int size);

}
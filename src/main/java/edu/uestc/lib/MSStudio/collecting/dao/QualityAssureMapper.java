package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.QualityAssure;

public interface QualityAssureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QualityAssure record);

    int insertSelective(QualityAssure record);

    QualityAssure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QualityAssure record);

    int updateByPrimaryKey(QualityAssure record);

    int checkByID(int i, Integer id);

	List<QualityAssure> getAllObject(int begin, int size);

}
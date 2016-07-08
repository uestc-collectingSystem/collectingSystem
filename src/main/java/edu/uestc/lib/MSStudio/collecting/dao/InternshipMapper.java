package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.Internship;

public interface InternshipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Internship record);

    int insertSelective(Internship record);

    Internship selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Internship record);

    int updateByPrimaryKey(Internship record);
}
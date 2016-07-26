package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.StudentQuality;

public interface StudentQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentQuality record);

    int insertSelective(StudentQuality record);

    StudentQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentQuality record);

    int updateByPrimaryKey(StudentQuality record);
    
    int checkByID(int i, Integer id);

	List<StudentQuality> getAllObject(int begin, int size);
}
package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.AuditSchool;

public interface AuditSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditSchool record);

    int insertSelective(AuditSchool record);

    AuditSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuditSchool record);

    int updateByPrimaryKey(AuditSchool record);
}
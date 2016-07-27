package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SchoolEnterprise;

public interface SchoolEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SchoolEnterprise record);

    int insertSelective(SchoolEnterprise record);

    SchoolEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchoolEnterprise record);

    int updateByPrimaryKey(SchoolEnterprise record);
    
    int checkByID(int i, Integer id);

	List<SchoolEnterprise> getAllObject(int begin, int size);
}
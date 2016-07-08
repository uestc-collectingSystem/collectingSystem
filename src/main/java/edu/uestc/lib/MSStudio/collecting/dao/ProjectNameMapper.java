package edu.uestc.lib.MSStudio.collecting.dao;

import edu.uestc.lib.MSStudio.collecting.model.ProjectName;

public interface ProjectNameMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(ProjectName record);

    int insertSelective(ProjectName record);

    ProjectName selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(ProjectName record);

    int updateByPrimaryKey(ProjectName record);
}
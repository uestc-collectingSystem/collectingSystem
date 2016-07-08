package edu.uestc.lib.MSStudio.collecting.dao;

import org.apache.ibatis.annotations.Param;

import edu.uestc.lib.MSStudio.collecting.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int countMembers(@Param("name")String name,@Param("pass")String pass);
}
package edu.uestc.lib.MSStudio.collecting.dao;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.SocialService;

public interface SocialServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SocialService record);

    int insertSelective(SocialService record);

    SocialService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SocialService record);

    int updateByPrimaryKey(SocialService record);
    
    int checkByID(int i, Integer id);

	List<SocialService> getAllObject(int begin, int size);
}
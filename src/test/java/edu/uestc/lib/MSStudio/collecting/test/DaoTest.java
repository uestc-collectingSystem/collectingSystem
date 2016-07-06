package edu.uestc.lib.MSStudio.collecting.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.dao.AuditSchoolMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DaoTest {
	
	private static Logger logProducer = Logger.getLogger(DaoTest.class);
	
	@Resource
	private AuditSchoolMapper dao;
	
	@Test
	public void DBTest(){
		logProducer.info(JSON.toJSON(dao.selectByPrimaryKey(1)));
	}
	
}
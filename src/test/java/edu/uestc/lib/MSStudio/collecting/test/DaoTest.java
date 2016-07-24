package edu.uestc.lib.MSStudio.collecting.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uestc.lib.MSStudio.collecting.dao.FileInfoMapper;
import edu.uestc.lib.MSStudio.collecting.service.SizeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DaoTest {
	
	private static Logger logProducer = Logger.getLogger(DaoTest.class);
	
	@Resource
	private FileInfoMapper dao;
	
	@Test
	public void DBTest(){
		logProducer.info(dao.getAllFile(0, 100));
	}
	
}
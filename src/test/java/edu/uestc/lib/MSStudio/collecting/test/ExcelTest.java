package edu.uestc.lib.MSStudio.collecting.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.excel.SizeReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class ExcelTest {

	private static Logger logProducer = Logger.getLogger(DaoTest.class);
	
	@Test
	public void readingTest() throws Exception{
//		logProducer.info(SizeReader.readFile("/Users/MT/Desktop/test.xls").get(1).get(1)); 
		logProducer.info(JSON.toJSON(SizeReader.getModelFromExcel("/Users/MT/Desktop/test.xlsx")));
	}
	
}

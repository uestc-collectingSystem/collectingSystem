package edu.uestc.lib.MSStudio.collecting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.uestc.lib.MSStudio.collecting.dao.SchoolSizeMapper;
import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;
import edu.uestc.lib.MSStudio.collecting.service.SizeService;

@Service("sizeService")
public class SizeServiceImpl implements SizeService {
	@Resource
	private SchoolSizeMapper dao;

	@Override
	public SchoolSize getSchoolSize(String id) {
		// 根据 id 选出一个指定的学校规模信息
		return dao.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public boolean save(SchoolSize record) {
		// 验证数据合法性之后再保存
		if (record.getArea().equals(0)){
			//System.out.println("yoo");
			return false;
		}
	
		if (record.getOwnproparea().compareTo(record.getArea())==1
			||record.getSchownconarea().compareTo(record.getTotalarea())==1
			||record.getStuarea().compareTo(record.getTotalarea())==1
			||record.getTeaauxarea().compareTo(record.getTotalarea())==1
			||record.getTrainarea().compareTo(record.getTotalarea())==1
			||record.getPsyarea().compareTo(record.getTotalarea())==1
			||record.getDormarea().compareTo(record.getTotalarea())==1
			||record.getDormperarea().compareTo(record.getTotalarea())==1
			||record.getDormperarea().compareTo(record.getDormarea())==1
			||record.getAnnualgraduate()>record.getTotalstudent()
			||record.getEnrollment()>record.getTotalstudent()
			)
			{
				System.out.println("yoo");
				return false;
			}
		
		dao.insert(record);
		return true;
	}

//	
//	public List<SchoolSize> listAllSize() {
//		// 列举所有的 School 类
//		return dao.getAllSize(0,20);
//	}
	
	@Override
	public List<SchoolSize> listAllSize(String num,String size) {
		// 列举所有的 School 类
		int pageNum = Integer.valueOf(num);
		int pageSize = Integer.valueOf(size);
		return dao.getAllSize((pageNum-1)*pageSize,pageNum*pageSize);
	}
	
	@Override
	public boolean deleteSizeByID(String id){
		dao.deleteByPrimaryKey(Integer.valueOf(id));
		return false;
	}
	
	@Override
	public boolean checkSchoolSize(String id){
		if (dao.checkByID(1,Integer.valueOf(id))!=0) return true;
		else return false;
	}
	
}

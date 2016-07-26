package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uestc.lib.MSStudio.collecting.excel.ReaderUtils;
import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;
import edu.uestc.lib.MSStudio.collecting.service.SizeService;

@Controller
@RequestMapping("basic/size")
public class SizeController implements OriginController {
	//这是一个用来描述基本情况模块中规模子模块中的东西
	//里面需要用到的是 size 表
	
	@Resource
	private SizeService sizeService;
	
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", sizeService.listAllSchoolSize(pageNum, pageSize));
		return PageRoutes.sizePage;
	}
	
	public static SchoolSize preSaveSchoolSize(
			 String Admcode,
			 String Year,
			 String SchoolRun,
			 String SchoolLevel,
			 String SchoolSubject,
			 String Area,
			 String OwnPropArea,
			 String TotalArea,
			 String SchOwnConArea,
			 String StuArea,
			 String OfficeArea,
			 String TeaAuxArea,
			 String TrainArea,
			 String PsyArea,
			 String DormArea,
			 String DormPerArea,
			 String TotalStudent,
			 String AnnualGraduate,
			 String ConsolidationRate,
			 String Enrollment,
			 String Majors
			){
		SchoolSize temp = new SchoolSize();
		try{
			temp.setAdmcode(Admcode);
			temp.setAnnualgraduate(ReaderUtils.transInteger(AnnualGraduate));
			temp.setArea(new BigDecimal(Area));
			temp.setAudit(0);
			temp.setDormarea(new BigDecimal(DormArea));
			temp.setDormperarea(new BigDecimal(DormPerArea));
			temp.setEnrollment(ReaderUtils.transInteger(Enrollment));
			temp.setMajors(ReaderUtils.transInteger(Majors));
			temp.setOfficearea(new BigDecimal(OfficeArea));
			temp.setOwnproparea(new BigDecimal(OwnPropArea));
			temp.setPsyarea(new BigDecimal(PsyArea));
			temp.setSchoollevel(SchoolLevel);
			temp.setSchoolrun(SchoolRun);
			temp.setSchoolsubject(SchoolSubject);
			temp.setSchownconarea(new BigDecimal(SchOwnConArea));
			temp.setStuarea(new BigDecimal(StuArea));
			temp.setTeaauxarea(new BigDecimal(TeaAuxArea));
			temp.setTotalarea(new BigDecimal(TotalArea));
			temp.setTotalstudent(ReaderUtils.transInteger(TotalStudent));
			temp.setTrainarea(new BigDecimal(TrainArea));
			temp.setConsolidationrate(Double.valueOf(ConsolidationRate));
			if (Year==null||Year.equals("")) temp.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			else temp.setYear(Year);
		}catch(Exception e){
			//e.printStackTrace();
			return null;
		}
		return temp;
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createSchoolSize(
			@RequestParam String Admcode,
			@RequestParam String SchoolRun,
			@RequestParam(value="Year",required=false) String Year,
			@RequestParam(defaultValue="一般") String SchoolLevel,
			@RequestParam String SchoolSubject,
			@RequestParam String Area,
			@RequestParam String OwnPropArea,
			@RequestParam String TotalArea,
			@RequestParam String SchOwnConArea,
			@RequestParam String StuArea,
			@RequestParam String OfficeArea,
			@RequestParam String TeaAuxArea,
			@RequestParam String TrainArea,
			@RequestParam String PsyArea,
			@RequestParam String DormArea,
			@RequestParam String DormPerArea,
			@RequestParam String TotalStudent,
			@RequestParam String AnnualGraduate,
			@RequestParam String Enrollment,
			@RequestParam String Majors,
			@RequestParam(defaultValue="1") String pageNum,
			@RequestParam(defaultValue="20") String pageSize,
			@RequestParam String ConsolidationRate,
			HttpServletRequest request,Model model){
		SchoolSize temp = SizeController.preSaveSchoolSize(
				Admcode, Year, SchoolRun, SchoolLevel, SchoolSubject, 
				Area, OwnPropArea, TotalArea, SchOwnConArea, 
				StuArea, OfficeArea, TeaAuxArea, TrainArea, PsyArea, DormArea, 
				DormPerArea, TotalStudent, AnnualGraduate, 
				ConsolidationRate, Enrollment, Majors);
		if (sizeService.save(temp)) {
			model.addAttribute("list", sizeService.listAllSchoolSize(pageNum, pageSize));
			return PageRoutes.sizePage;
		}else{
			model.addAttribute(PageRoutes.errorSourceParam, "SizePage");
			model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查");
			return PageRoutes.errorPage;
		}
	}
	
	public void deleteObject(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		SchoolSize temp = sizeService.getSchoolSize(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		sizeService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}
	
	public void checkObject(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		sizeService.checkObjectByID(id);
		response.sendRedirect("../");
		return ;
	}
	
}

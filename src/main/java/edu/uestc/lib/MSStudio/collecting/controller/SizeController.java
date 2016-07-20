package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Year;
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

import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;
import edu.uestc.lib.MSStudio.collecting.service.SizeService;

@Controller
@RequestMapping("/basic/size")
public class SizeController {
	//这是一个用来描述基本情况模块中规模子模块中的东西
	//里面需要用到的是 size 表
	
	private final String sizePage = "basic/size"; 
	
	private final String errorPage="error";
	
	private final String errorSourceParam="ErrorSource";
	
	private final String errorMsgParam="ErrorMsg";
	
	@Resource
	private SizeService sizeService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String schoolSizeList(
			@RequestParam(defaultValue="1") String pageNum,
			@RequestParam(defaultValue="20") String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", sizeService.listAllSize(pageNum, pageSize));
		return sizePage;
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
		SchoolSize temp = new SchoolSize();
		temp.setAdmcode(Admcode);
		temp.setAnnualgraduate(Integer.valueOf(AnnualGraduate));
		temp.setArea(new BigDecimal(Area));
		temp.setAudit(0);
		temp.setDormarea(new BigDecimal(DormArea));
		temp.setDormperarea(new BigDecimal(DormPerArea));
		temp.setEnrollment(Integer.valueOf(Enrollment));
		temp.setMajors(Integer.valueOf(Majors));
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
		temp.setTotalstudent(Integer.valueOf(TotalStudent));
		temp.setTrainarea(new BigDecimal(TrainArea));
		temp.setConsolidationrate(Double.valueOf(ConsolidationRate));
		if (Year==null||Year.equals("")) temp.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		else temp.setYear(Year);
		if (sizeService.save(temp)) {
			model.addAttribute("list", sizeService.listAllSize(pageNum, pageSize));
			return sizePage;
		}else{
			model.addAttribute(errorSourceParam, "SizePage");
			model.addAttribute(errorMsgParam, "参数有错，请检查");
			return errorPage;
		}
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public void deleteSchoolSize(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		sizeService.deleteSizeByID(id);	
		response.sendRedirect("../");
		return ;
	}
	
	@RequestMapping(value="check/{id}",method=RequestMethod.GET)
	public void checkSchoolSize(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		sizeService.checkSchoolSize(id);
		response.sendRedirect("../");
		return ;
	}
	
}

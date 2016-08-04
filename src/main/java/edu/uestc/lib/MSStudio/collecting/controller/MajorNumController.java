package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uestc.lib.MSStudio.collecting.excel.ReaderUtils;
import edu.uestc.lib.MSStudio.collecting.model.MajorNum;
import edu.uestc.lib.MSStudio.collecting.service.MajorNumService;

@Controller
@RequestMapping("qua/majnum")
public class MajorNumController implements OriginController{

	@Resource
	private MajorNumService majorNumService;
	
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("firstMenu", "质量保障措施");
		model.addAttribute("subMenu", "课程开设");
		model.addAttribute("list", majorNumService.listAllMajorNum(pageNum, pageSize));
		return PageRoutes.quaMajNumPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		MajorNum temp = majorNumService.getMajorNum(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		majorNumService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		majorNumService.checkObjectByID(id);
		response.sendRedirect("../");
	}

	public static MajorNum presaveMajorNum(
			String Admcode,
			String Year,
			String ClassCriter,
			String LeadNatShareMajor,
			String SchoolEnterMajor,
			String TextTeacEditMajor,
			String StatePlanText,
			String SchMajorMater,
			String ClassHour,
			String MajorHour,
			String MajorBHour,
			String MajorCHour,
			String DispClass,
			String BCClassHour,
			String Chinese,
			String Moral,
			String Math,
			String English,
			String Sports,
			String Art,
			String Computer,
			String History){
		MajorNum temp = new MajorNum();
		try{
			temp.setAdmcode(Admcode);
			temp.setArt(ReaderUtils.transInteger(Art));
			temp.setAudit(0);
			temp.setBcclasshour(ReaderUtils.transInteger(BCClassHour));
			temp.setChinese(ReaderUtils.transInteger(Chinese));
			temp.setClasscriter(ReaderUtils.transInteger(ClassCriter));
			temp.setClasshour(ReaderUtils.transInteger(ClassHour));
			temp.setComputer(ReaderUtils.transInteger(Computer));
			temp.setDispclass(ReaderUtils.transInteger(DispClass));
			temp.setEnglish(ReaderUtils.transInteger(English));
			temp.setHistory(ReaderUtils.transInteger(History));
			temp.setLeadnatsharemajor(ReaderUtils.transInteger(LeadNatShareMajor));
			temp.setMajorbhour(ReaderUtils.transInteger(MajorBHour));
			temp.setMajorchour(ReaderUtils.transInteger(MajorCHour));
			temp.setMajorhour(ReaderUtils.transInteger(MajorHour));
			temp.setMath(ReaderUtils.transInteger(Math));
			temp.setMoral(ReaderUtils.transInteger(Moral));
			temp.setSchmajormater(ReaderUtils.transInteger(SchMajorMater));
			temp.setSchoolentermajor(ReaderUtils.transInteger(SchoolEnterMajor));
			temp.setSports(ReaderUtils.transInteger(Sports));
			temp.setStateplantext(new BigDecimal(StatePlanText));
			temp.setTextteaceditmajor(ReaderUtils.transInteger(TextTeacEditMajor));
			temp.setYear(Year);
			return temp;
		}catch(Exception e){
			return null;
		}
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createTeachers(
			@RequestParam String Admcode,
			@RequestParam String Year,
			@RequestParam String ClassCriter,
			@RequestParam String LeadNatShareMajor,
			@RequestParam String SchoolEnterMajor,
			@RequestParam String TextTeacEditMajor,
			@RequestParam String StatePlanText,
			@RequestParam String SchMajorMater,
			@RequestParam String ClassHour,
			@RequestParam String MajorHour,
			@RequestParam String MajorBHour,
			@RequestParam String MajorCHour,
			@RequestParam String DispClass,
			@RequestParam String BCClassHour,
			@RequestParam String Chinese,
			@RequestParam String Moral,
			@RequestParam String Math,
			@RequestParam String English,
			@RequestParam String Sports,
			@RequestParam String Art,
			@RequestParam String Computer,
			@RequestParam String History,
	HttpServletRequest request,Model model){
		MajorNum temp = MajorNumController.presaveMajorNum(Admcode, Year, ClassCriter, LeadNatShareMajor, 
				SchoolEnterMajor, TextTeacEditMajor, StatePlanText, SchMajorMater,
				ClassHour, MajorHour, MajorBHour, MajorCHour, DispClass, BCClassHour, 
				Chinese, Moral, Math, English, Sports, Art, Computer, History);
		try{
				majorNumService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	
	@RequestMapping("update")
	public void testFormBean(@ModelAttribute("update") MajorNum record,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		//System.out.println(JSON.toJSON(record));
		if(!majorNumService.update(record)) System.out.println("wrong");;
		response.sendRedirect("./");
		return ;
	} 
}

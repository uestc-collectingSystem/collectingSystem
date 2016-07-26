package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.math.BigDecimal;

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
import edu.uestc.lib.MSStudio.collecting.model.Teachers;
import edu.uestc.lib.MSStudio.collecting.service.TeacherService;

@Controller
@RequestMapping("basic/teacher")
public class TeachersController implements OriginController{

	@Resource
	private TeacherService teacherService;
	
	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", teacherService.listAllTeacher(pageNum, pageSize));
		return PageRoutes.teacherPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		Teachers temp = teacherService.getTeacher(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		teacherService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
		
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		teacherService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static Teachers presaveTeacher(
			String Admcode,
			String Year,
			String StaffNum,
			String StaffAdmin,
			String StaffPrepJob,
			String FullTime,
			String BasicCourse,
			String Course,
			String IndustryEnterprise,
			String UndergraLess,
			String Undergra,
			String FullPostgrad,
			String SubHighMore,
			String IntermediateGrade,
			String JuniorTitle,
			String NoConferTeac,
			String ThreeFiveLess,
			String ThreeSixFourFive,
			String FourSixFiveFive,
			String FiveSixMore,
			String Male,
			String Female,
			String DoubleTeac,
			String FullClassHour,
			String CourseClassHour,
			String InduEnterHour,
			String CounselCertificate,
			String FulltimeCounsel,
			String CityDiscipLeader,
			String ProvSuper,
			String ExerProTeac,
			String ForeignTeac
			){
		Teachers temp = new Teachers();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setBasiccourse(ReaderUtils.transInteger(BasicCourse));
			temp.setCitydiscipleader(ReaderUtils.transInteger(CityDiscipLeader));
			temp.setCounselcertificate(ReaderUtils.transInteger(CounselCertificate));
			temp.setCourse(ReaderUtils.transInteger(Course));
			temp.setCourseclasshour(new BigDecimal(CourseClassHour));
			temp.setDoubleteac(ReaderUtils.transInteger(DoubleTeac));
			temp.setExerproteac(ReaderUtils.transInteger(ExerProTeac));
			temp.setFemale(ReaderUtils.transInteger(Female));
			temp.setFivesixmore(ReaderUtils.transInteger(FiveSixMore));
			temp.setForeignteac(ReaderUtils.transInteger(ForeignTeac));
			temp.setFoursixfivefive(ReaderUtils.transInteger(FourSixFiveFive));
			temp.setFullclasshour(new BigDecimal(FullClassHour));
			temp.setFullpostgrad(ReaderUtils.transInteger(FullPostgrad));
			temp.setFulltime(ReaderUtils.transInteger(FullTime));
			temp.setFulltimecounsel(ReaderUtils.transInteger(FulltimeCounsel));
			temp.setInduenterhour(ReaderUtils.transInteger(InduEnterHour));
			temp.setIndustryenterprise(ReaderUtils.transInteger(IndustryEnterprise));
			temp.setIntermediategrade(ReaderUtils.transInteger(IntermediateGrade));
			temp.setJuniortitle(ReaderUtils.transInteger(JuniorTitle));
			temp.setMale(ReaderUtils.transInteger(Male));
			temp.setNoconferteac(ReaderUtils.transInteger(NoConferTeac));
			temp.setProvsuper(ReaderUtils.transInteger(ProvSuper));
			temp.setStaffadmin(ReaderUtils.transInteger(StaffAdmin));
			temp.setStaffnum(ReaderUtils.transInteger(StaffNum));
			temp.setStaffprepjob(ReaderUtils.transInteger(StaffPrepJob));
			temp.setSubhighmore(ReaderUtils.transInteger(SubHighMore));
			temp.setThreefiveless(ReaderUtils.transInteger(ThreeFiveLess));
			temp.setThreesixfourfive(ReaderUtils.transInteger(ThreeSixFourFive));
			temp.setUndergra(ReaderUtils.transInteger(Undergra));
			temp.setUndergraless(ReaderUtils.transInteger(UndergraLess));
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
			@RequestParam String StaffNum,
			@RequestParam String StaffAdmin,
			@RequestParam String StaffPrepJob,
			@RequestParam String FullTime,
			@RequestParam String BasicCourse,
			@RequestParam String Course,
			@RequestParam String IndustryEnterprise,
			@RequestParam String UndergraLess,
			@RequestParam String Undergra,
			@RequestParam String FullPostgrad,
			@RequestParam String SubHighMore,
			@RequestParam String IntermediateGrade,
			@RequestParam String JuniorTitle,
			@RequestParam String NoConferTeac,
			@RequestParam String ThreeFiveLess,
			@RequestParam String ThreeSixFourFive,
			@RequestParam String FourSixFiveFive,
			@RequestParam String FiveSixMore,
			@RequestParam String Male,
			@RequestParam String Female,
			@RequestParam String DoubleTeac,
			@RequestParam String FullClassHour,
			@RequestParam String CourseClassHour,
			@RequestParam String InduEnterHour,
			@RequestParam String CounselCertificate,
			@RequestParam String FulltimeCounsel,
			@RequestParam String CityDiscipLeader,
			@RequestParam String ProvSuper,
			@RequestParam String ExerProTeac,
			@RequestParam String ForeignTeac,
			HttpServletRequest request,Model model){
		Teachers temp = presaveTeacher(Admcode, Year, StaffNum, StaffAdmin, 
				StaffPrepJob, FullTime, BasicCourse, Course, IndustryEnterprise,
				UndergraLess, Undergra, FullPostgrad, SubHighMore, IntermediateGrade, 
				JuniorTitle, NoConferTeac, ThreeFiveLess, ThreeSixFourFive, 
				FourSixFiveFive, FiveSixMore, Male, Female, DoubleTeac, 
				FullClassHour, CourseClassHour, InduEnterHour, CounselCertificate, 
				FulltimeCounsel, CityDiscipLeader, ProvSuper, ExerProTeac, ForeignTeac);
		try{
			teacherService.save(temp);
			return this.indexWithPage(request, model);
		}catch(Exception e){
			model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
			model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
			e.printStackTrace();
			return PageRoutes.errorPage;
		}
	}

}

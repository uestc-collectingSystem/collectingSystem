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
import edu.uestc.lib.MSStudio.collecting.model.SchoolEnterprise;
import edu.uestc.lib.MSStudio.collecting.service.SchoolEnterService;

@Controller
@RequestMapping("coor/enterprise")
public class SchoolEnterController implements OriginController{

	@Resource
	private SchoolEnterService schoolEnterService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", schoolEnterService.listAllSchoolEnterprise(pageNum, pageSize));
		return PageRoutes.coorSchoolenterPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		SchoolEnterprise temp = schoolEnterService.getSchoolEnterprise(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		schoolEnterService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		schoolEnterService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static SchoolEnterprise presaveSchoolEnterprise(
			String Admcode,
			String Year,
			String MajorNum,
			String CoopAgreeEnterp,
			String CoopAgreeMajor,
			String CoopEnterpJoinTeachMajor,
			String CoopEnterpJoinTeachTeacher,
			String CoopEnterpJoinTeachClass,
			String CoopEnterpFund,
			String CoopEnterpArrivalFund,
			String CoopEnterpEquitWorth,
			String EnterpBuildReseaDevelop,
			String OffSchoTeacherTrainBase,
			String ProdTrainBaseVal,
			String SchoEnterpCoopOrderClassNum,
			String SchoEnterpDevelopCourse,
			String FullEnterPrac,
			String FullEnterTime,
			String PartTimeClassRadio,
			String BookPublishCount,
			String FullTimeStu,
			String GraduEnterRate,
			String DevelopeIncomeCount,
			String TeacOutcomeCount,
			String CoopDonateCount,
			String ExperBaseCount
			){
		SchoolEnterprise temp = new SchoolEnterprise();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setBookpublishcount(ReaderUtils.transInteger(BookPublishCount));
			temp.setCoopagreeenterp(ReaderUtils.transInteger(CoopAgreeEnterp));
			temp.setCoopagreemajor(ReaderUtils.transInteger(CoopAgreeMajor));
			temp.setCoopdonatecount(new BigDecimal(CoopDonateCount));
			temp.setCoopenterparrivalfund(new BigDecimal(CoopEnterpArrivalFund));
			temp.setCoopenterpequitworth(new BigDecimal(CoopEnterpEquitWorth));
			temp.setCoopenterpfund(new BigDecimal(CoopEnterpFund));
			temp.setCoopenterpjointeachclass(ReaderUtils.transInteger(CoopEnterpJoinTeachClass));
			temp.setCoopenterpjointeachmajor(ReaderUtils.transInteger(CoopEnterpJoinTeachMajor));
			temp.setCoopenterpjointeachteacher(ReaderUtils.transInteger(CoopEnterpJoinTeachTeacher));
			temp.setDevelopeincomecount(new BigDecimal(DevelopeIncomeCount));
			temp.setEnterpbuildreseadevelop(ReaderUtils.transInteger(EnterpBuildReseaDevelop));
			temp.setExperbasecount(ReaderUtils.transInteger(ExperBaseCount));
			temp.setFullenterprac(new BigDecimal(FullEnterPrac));
			temp.setFullentertime(ReaderUtils.transInteger(FullEnterTime));
			temp.setFulltimestu(ReaderUtils.transInteger(FullTimeStu));
			temp.setGraduenterrate(ReaderUtils.transInteger(GraduEnterRate));
			temp.setMajornum(ReaderUtils.transInteger(MajorNum));
			temp.setOffschoteachertrainbase(ReaderUtils.transInteger(OffSchoTeacherTrainBase));
			temp.setParttimeclassradio(new BigDecimal(PartTimeClassRadio));
			temp.setProdtrainbaseval(new BigDecimal(ProdTrainBaseVal));
			temp.setSchoenterpcooporderclassnum(ReaderUtils.transInteger(SchoEnterpCoopOrderClassNum));
			temp.setSchoenterpdevelopcourse(ReaderUtils.transInteger(SchoEnterpDevelopCourse));
			temp.setTeacoutcomecount(new BigDecimal(TeacOutcomeCount));
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
			@RequestParam String MajorNum,
			@RequestParam String CoopAgreeEnterp,
			@RequestParam String CoopAgreeMajor,
			@RequestParam String CoopEnterpJoinTeachMajor,
			@RequestParam String CoopEnterpJoinTeachTeacher,
			@RequestParam String CoopEnterpJoinTeachClass,
			@RequestParam String CoopEnterpFund,
			@RequestParam String CoopEnterpArrivalFund,
			@RequestParam String CoopEnterpEquitWorth,
			@RequestParam String EnterpBuildReseaDevelop,
			@RequestParam String OffSchoTeacherTrainBase,
			@RequestParam String ProdTrainBaseVal,
			@RequestParam String SchoEnterpCoopOrderClassNum,
			@RequestParam String SchoEnterpDevelopCourse,
			@RequestParam String FullEnterPrac,
			@RequestParam String FullEnterTime,
			@RequestParam String PartTimeClassRadio,
			@RequestParam String BookPublishCount,
			@RequestParam String FullTimeStu,
			@RequestParam String GraduEnterRate,
			@RequestParam String DevelopeIncomeCount,
			@RequestParam String TeacOutcomeCount,
			@RequestParam String CoopDonateCount,
			@RequestParam String ExperBaseCount,
	HttpServletRequest request,Model model){
		SchoolEnterprise temp = SchoolEnterController.presaveSchoolEnterprise(Admcode, Year, MajorNum, 
				CoopAgreeEnterp, CoopAgreeMajor, CoopEnterpJoinTeachMajor, CoopEnterpJoinTeachTeacher,
				CoopEnterpJoinTeachClass, CoopEnterpFund, CoopEnterpArrivalFund, CoopEnterpEquitWorth, 
				EnterpBuildReseaDevelop, OffSchoTeacherTrainBase, ProdTrainBaseVal, 
				SchoEnterpCoopOrderClassNum, SchoEnterpDevelopCourse, FullEnterPrac, 
				FullEnterTime, PartTimeClassRadio, BookPublishCount, FullTimeStu, 
				GraduEnterRate, DevelopeIncomeCount, TeacOutcomeCount,
				CoopDonateCount, ExperBaseCount);
		try{
				schoolEnterService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "SchoolEnterprisePage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	
}

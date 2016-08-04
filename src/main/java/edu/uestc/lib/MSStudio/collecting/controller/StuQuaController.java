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

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.excel.ReaderUtils;
import edu.uestc.lib.MSStudio.collecting.model.StudentQuality;
import edu.uestc.lib.MSStudio.collecting.service.StuQuaService;


@Controller
@RequestMapping("dev/stu")
public class StuQuaController implements OriginController{

	@Resource
	private StuQuaService stuQuaService;
	
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		
		model.addAttribute("firstMenu", "学生发展");
		model.addAttribute("subMenu", "学生素质");

		model.addAttribute("list", stuQuaService.listAllStudentQuality(pageNum, pageSize));
		return PageRoutes.stuQuaPage;
	}


	@Override
	public void deleteObject(@PathVariable String id,
			HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		StudentQuality temp = stuQuaService.getStudentQuality(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		stuQuaService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, 
			HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		stuQuaService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static StudentQuality presaveStuQua(
			String Admcode,
			String Year,
			String MoralEquit,
			String PhyCenter,
			String Advanced,
			String MoralBase,
			String SchoolSpirit,
			String ManageSpirit,
			String Volunteer,
			String RedFlag,
			String OtherHonor,
			String GoodClass,
			String FulltimeMoral,
			String MoralTask,
			String MoralNum,
			String MoralPart,
			String MoralHour,
			String MoralText,
			String AssessOptimal,
			String AssessGood,
			String AssessMiddle,
			String AssessPoor,
			String PyhConselPer,
			String ProvGoodGrade,
			String ProvGoodCadre,
			String ProvGoodStud,
			String ProvOther,
			String CampusViolence,
			String CrimeRate,
			String ExamDiscip,
			String JoinOrgan,
			String JoinPraty,
			String SocailVolun,
			String SocailPrac,
			String StudentOrgan,
			String OrganStu,
			String StateCivil,
			String ProvinCivil,
			String CityCivil,
			String StateFirstAward,
			String StateSecondAward,
			String StateThirdAward,
			String ProvinFirstAward,
			String ProvinSecondAward,
			String ProvinThirdAward,
			String CityFirstAward,
			String CitySecondAward,
			String CityThirdAward,
			String OneConsol,
			String TwoConsol,
			String ThreeConsol,
			String CultDiviPassRate,
			String PhyAssessPassRate,
			String ProfSkillPassRate,
			String CareerCert,
			String DoubCert,
			String GradRate,
			String WorkFundPercent){
		StudentQuality temp = new StudentQuality();
		try{
			temp.setAdmcode(Admcode);
			temp.setAdvanced(Advanced);
			temp.setAssessgood(new BigDecimal(AssessGood));
			temp.setAssessmiddle(new BigDecimal(AssessMiddle));
			temp.setAssessoptimal(new BigDecimal(AssessOptimal));
			temp.setAssesspoor(new BigDecimal(AssessPoor));
			temp.setAudit(0);
			temp.setCampusviolence(ReaderUtils.transInteger(CampusViolence));
			temp.setCareercert(ReaderUtils.transInteger(CareerCert));
			temp.setCitycivil(ReaderUtils.transInteger(CityCivil));
			temp.setCityfirstaward(ReaderUtils.transInteger(CityFirstAward));
			temp.setCitysecondaward(ReaderUtils.transInteger(CitySecondAward));
			temp.setCitythirdaward(ReaderUtils.transInteger(CityThirdAward));
			temp.setCrimerate(ReaderUtils.transInteger(CrimeRate));
			temp.setCultdivipassrate(new BigDecimal(CultDiviPassRate));
			temp.setDoubcert(new BigDecimal(DoubCert));
			temp.setExamdiscip(ReaderUtils.transInteger(ExamDiscip));
			temp.setFulltimemoral(ReaderUtils.transInteger(FulltimeMoral));
			temp.setGoodclass(ReaderUtils.transInteger(GoodClass));
			temp.setGradrate(new BigDecimal(GradRate));
			temp.setJoinorgan(ReaderUtils.transInteger(JoinOrgan));
			temp.setJoinpraty(ReaderUtils.transInteger(JoinPraty));
			temp.setManagespirit(ManageSpirit);
			temp.setMoralbase(MoralBase);
			temp.setMoralequit(ReaderUtils.transInteger(MoralEquit));
			temp.setMoralhour(ReaderUtils.transInteger(MoralHour));
			temp.setMoralnum(ReaderUtils.transInteger(MoralNum));
			temp.setMoralpart(new BigDecimal(MoralPart));
			temp.setMoraltask(ReaderUtils.transInteger(MoralTask));
			temp.setMoraltext(ReaderUtils.transInteger(MoralText));
			temp.setOneconsol(new BigDecimal(OneConsol));
			temp.setOrganstu(ReaderUtils.transInteger(OrganStu));
			temp.setOtherhonor(OtherHonor);
			temp.setPhyassesspassrate(new BigDecimal(PhyAssessPassRate));
			temp.setPhycenter(PhyCenter);
			temp.setProfskillpassrate(new BigDecimal(ProfSkillPassRate));
			temp.setProvgoodcadre(ReaderUtils.transInteger(ProvGoodCadre));
			temp.setProvgoodgrade(ReaderUtils.transInteger(ProvGoodGrade));
			temp.setProvgoodstud(ReaderUtils.transInteger(ProvGoodStud));
			temp.setProvincivil(ReaderUtils.transInteger(ProvinCivil));
			temp.setProvinfirstaward(ReaderUtils.transInteger(ProvinFirstAward));
			temp.setProvinsecondaward(ReaderUtils.transInteger(ProvinSecondAward));
			temp.setProvinthirdaward(ReaderUtils.transInteger(ProvinSecondAward));
			temp.setProvother(ProvOther);
			temp.setPyhconselper(new BigDecimal(PyhConselPer));
			temp.setRedflag(RedFlag);
			temp.setSchoolspirit(SchoolSpirit);
			temp.setSocailprac(new BigDecimal(SocailPrac));
			temp.setSocailvolun(ReaderUtils.transInteger(SocailVolun));
			temp.setStatecivil(ReaderUtils.transInteger(StateCivil));
			temp.setStatefirstaward(ReaderUtils.transInteger(StateThirdAward));
			temp.setStatesecondaward(ReaderUtils.transInteger(StateSecondAward));
			temp.setStatethirdaward(ReaderUtils.transInteger(StateThirdAward));
			temp.setStudentorgan(ReaderUtils.transInteger(StudentOrgan));
			temp.setThreeconsol(new BigDecimal(ThreeConsol));
			temp.setTwoconsol(new BigDecimal(TwoConsol));
			temp.setVolunteer(Volunteer);
			temp.setWorkfundpercent(new BigDecimal(WorkFundPercent));
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
			@RequestParam String MoralEquit,
			@RequestParam String PhyCenter,
			@RequestParam String Advanced,
			@RequestParam String MoralBase,
			@RequestParam String SchoolSpirit,
			@RequestParam String ManageSpirit,
			@RequestParam String Volunteer,
			@RequestParam String RedFlag,
			@RequestParam String OtherHonor,
			@RequestParam String GoodClass,
			@RequestParam String FulltimeMoral,
			@RequestParam String MoralTask,
			@RequestParam String MoralNum,
			@RequestParam String MoralPart,
			@RequestParam String MoralHour,
			@RequestParam String MoralText,
			@RequestParam String AssessOptimal,
			@RequestParam String AssessGood,
			@RequestParam String AssessMiddle,
			@RequestParam String AssessPoor,
			@RequestParam String PyhConselPer,
			@RequestParam String ProvGoodGrade,
			@RequestParam String ProvGoodCadre,
			@RequestParam String ProvGoodStud,
			@RequestParam String ProvOther,
			@RequestParam String CampusViolence,
			@RequestParam String CrimeRate,
			@RequestParam String ExamDiscip,
			@RequestParam String JoinOrgan,
			@RequestParam String JoinPraty,
			@RequestParam String SocailVolun,
			@RequestParam String SocailPrac,
			@RequestParam String StudentOrgan,
			@RequestParam String OrganStu,
			@RequestParam String StateCivil,
			@RequestParam String ProvinCivil,
			@RequestParam String CityCivil,
			@RequestParam String StateFirstAward,
			@RequestParam String StateSecondAward,
			@RequestParam String StateThirdAward,
			@RequestParam String ProvinFirstAward,
			@RequestParam String ProvinSecondAward,
			@RequestParam String ProvinThirdAward,
			@RequestParam String CityFirstAward,
			@RequestParam String CitySecondAward,
			@RequestParam String CityThirdAward,
			@RequestParam String OneConsol,
			@RequestParam String TwoConsol,
			@RequestParam String ThreeConsol,
			@RequestParam String CultDiviPassRate,
			@RequestParam String PhyAssessPassRate,
			@RequestParam String ProfSkillPassRate,
			@RequestParam String CareerCert,
			@RequestParam String DoubCert,
			@RequestParam String GradRate,
			@RequestParam String WorkFundPercent,
	HttpServletRequest request,Model model){
		StudentQuality temp = StuQuaController.presaveStuQua(Admcode, Year, MoralEquit, PhyCenter, Advanced, MoralBase,
				SchoolSpirit, ManageSpirit, Volunteer, RedFlag, OtherHonor, GoodClass, FulltimeMoral, MoralTask, MoralNum, 
				MoralPart, MoralHour, MoralText, AssessOptimal, AssessGood, AssessMiddle, AssessPoor, PyhConselPer, 
				ProvGoodGrade, ProvGoodCadre, ProvGoodStud, ProvOther, CampusViolence, CrimeRate, ExamDiscip, JoinOrgan, 
				JoinPraty, SocailVolun, SocailPrac, StudentOrgan, OrganStu, StateCivil, ProvinCivil, CityCivil, StateFirstAward,
				StateSecondAward, StateThirdAward,ProvinFirstAward, ProvinSecondAward, ProvinThirdAward, CityFirstAward, 
				CitySecondAward, CityThirdAward, OneConsol, TwoConsol, ThreeConsol, CultDiviPassRate,
				PhyAssessPassRate, ProfSkillPassRate, CareerCert, DoubCert, GradRate,WorkFundPercent);
		try{
				stuQuaService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
			}
	}
	
	@RequestMapping("update")
	public void testFormBean(@ModelAttribute("update") StudentQuality record,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		System.out.println(JSON.toJSON(record));
		if(!stuQuaService.update(record)) System.out.println("wrong");;
		response.sendRedirect("./");
		return ;
	} 

}

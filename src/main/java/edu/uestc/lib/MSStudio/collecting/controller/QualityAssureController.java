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
import edu.uestc.lib.MSStudio.collecting.model.QualityAssure;
import edu.uestc.lib.MSStudio.collecting.service.QualityAssureService;


@Controller
@RequestMapping("qua/assure")
public class QualityAssureController implements OriginController{

	@Resource
	private QualityAssureService qualityAssureService;
	
	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("firstMenu", "质量保障措施");
		model.addAttribute("subMenu", " 质量保证");
		model.addAttribute("list", qualityAssureService.listAllQualityAssure(pageNum, pageSize));
		return PageRoutes.quaAssurePage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		QualityAssure temp = qualityAssureService.getQualityAssure(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		qualityAssureService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		qualityAssureService.checkObjectByID(id);
		response.sendRedirect("../");
	}

	public static QualityAssure presaveQualityAssure(
			String Admcode,
			String Year,
			String LeaderListen,
			String LeaderTalk,
			String SchoolWell,
			String SchoolGood,
			String SchoolBad,
			String StateClass,
			String ProvinClass,
			String CityClass,
			String Chinese,
			String Math,
			String English,
			String StateSkillWinTime,
			String StateFirstAward,
			String StateSecondAward,
			String StateThridAward,
			String ProvinSkillWinTime,
			String ProvinFirstAward,
			String ProvinSecondAward,
			String ProvinThirdAward,
			String CitySkillWinTime,
			String CityFirstAward,
			String CitySecondAward,
			String CityThirdAward){
		QualityAssure temp = new QualityAssure();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setChinese(new BigDecimal(Chinese));
			temp.setCityclass(ReaderUtils.transInteger(CityClass));
			temp.setCityfirstaward(ReaderUtils.transInteger(CityThirdAward));
			temp.setCitysecondaward(ReaderUtils.transInteger(CitySecondAward));
			temp.setCityskillwintime(ReaderUtils.transInteger(CitySkillWinTime));
			temp.setCitythirdaward(ReaderUtils.transInteger(CityThirdAward));
			temp.setEnglish(new BigDecimal(English));
			temp.setLeaderlisten(ReaderUtils.transInteger(LeaderListen));
			temp.setLeadertalk(ReaderUtils.transInteger(LeaderTalk));
			temp.setMath(new BigDecimal(Math));
			temp.setProvinclass(ReaderUtils.transInteger(ProvinClass));
			temp.setProvinfirstaward(ReaderUtils.transInteger(ProvinFirstAward));
			temp.setProvinsecondaward(ReaderUtils.transInteger(ProvinSecondAward));
			temp.setProvinskillwintime(ReaderUtils.transInteger(ProvinSkillWinTime));
			temp.setProvinthirdaward(ReaderUtils.transInteger(ProvinThirdAward));
			temp.setSchoolbad(new BigDecimal(SchoolBad));
			temp.setSchoolgood(new BigDecimal(SchoolGood));
			temp.setSchoolwell(new BigDecimal(SchoolWell));
			temp.setStateclass(ReaderUtils.transInteger(StateClass));
			temp.setStatefirstaward(ReaderUtils.transInteger(StateFirstAward));
			temp.setStatesecondaward(ReaderUtils.transInteger(StateSecondAward));
			temp.setStateskillwintime(ReaderUtils.transInteger(StateSkillWinTime));
			temp.setStatethridaward(ReaderUtils.transInteger(StateThridAward));
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
			@RequestParam String LeaderListen,
			@RequestParam String LeaderTalk,
			@RequestParam String SchoolWell,
			@RequestParam String SchoolGood,
			@RequestParam String SchoolBad,
			@RequestParam String StateClass,
			@RequestParam String ProvinClass,
			@RequestParam String CityClass,
			@RequestParam String Chinese,
			@RequestParam String Math,
			@RequestParam String English,
			@RequestParam String StateSkillWinTime,
			@RequestParam String StateFirstAward,
			@RequestParam String StateSecondAward,
			@RequestParam String StateThridAward,
			@RequestParam String ProvinSkillWinTime,
			@RequestParam String ProvinFirstAward,
			@RequestParam String ProvinSecondAward,
			@RequestParam String ProvinThirdAward,
			@RequestParam String CitySkillWinTime,
			@RequestParam String CityFirstAward,
			@RequestParam String CitySecondAward,
			@RequestParam String CityThirdAward,
	HttpServletRequest request,Model model){
		QualityAssure temp = QualityAssureController.presaveQualityAssure(Admcode, Year, LeaderListen, LeaderTalk, 
				SchoolWell, SchoolGood, SchoolBad, StateClass, ProvinClass, CityClass, 
				Chinese, Math, English, StateSkillWinTime, StateFirstAward, StateSecondAward, 
				StateThridAward, ProvinSkillWinTime, ProvinFirstAward, ProvinSecondAward, 
				ProvinThirdAward, CitySkillWinTime, CityFirstAward, CitySecondAward, CityThirdAward);
		try{
				qualityAssureService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	

	@RequestMapping("update")
		public void testFormBean(@ModelAttribute("update") QualityAssure record,HttpServletResponse response) throws IOException{
	//		return JSON.toJSON(sizeService.update(test));
			//System.out.println(JSON.toJSON(record));
			if(!qualityAssureService.update(record)) System.out.println("wrong");;
			response.sendRedirect("./");
			return ;
		} 

	
}

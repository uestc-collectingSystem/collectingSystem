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
import edu.uestc.lib.MSStudio.collecting.model.EducationTrain;
import edu.uestc.lib.MSStudio.collecting.service.impl.EducationTrainServiceImpl;

@Controller
@RequestMapping("qua/edu")
public class EducationTrainController implements OriginController{

	@Resource
	private EducationTrainServiceImpl educationTrainService;
	
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", educationTrainService.listAllEducationTrain(pageNum, pageSize));
		return PageRoutes.quaEducationPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		EducationTrain temp = educationTrainService.getEducationTrain(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		educationTrainService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		educationTrainService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static EducationTrain presaveEducationTrain(
			String Admcode,
			String Year,
			String DistTrainFullTea,
			String DistTrainHour,
			String CityTrainFullTea,
			String CityTrainHour,
			String ProvinTrainFullTea,
			String ProvinTrainHour,
			String StateTrainFullTea,
			String StateTrainHour,
			String StateOuterTrain,
			String StateOuterHour,
			String AbroadTrain,
			String AbroadHour,
			String Diploma,
			String TainFundPer,
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
			String CityThirdAward
			){
		EducationTrain temp = new EducationTrain();
		try{
			temp.setAbroadhour(ReaderUtils.transLong(AbroadHour));
			temp.setAbroadtrain(ReaderUtils.transInteger(AbroadTrain));
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setCityfirstaward(ReaderUtils.transInteger(CityFirstAward));
			temp.setCitysecondaward(ReaderUtils.transInteger(CitySecondAward));
			temp.setCityskillwintime(ReaderUtils.transInteger(CitySkillWinTime));
			temp.setCitythirdaward(ReaderUtils.transInteger(CityThirdAward));
			temp.setCitytrainfulltea(ReaderUtils.transInteger(CityTrainFullTea));
			temp.setCitytrainhour(new BigDecimal(CityTrainHour));
			temp.setDiploma(ReaderUtils.transInteger(Diploma));
			temp.setDisttrainfulltea(ReaderUtils.transInteger(DistTrainFullTea));
			temp.setDisttrainhour(new BigDecimal(DistTrainHour));
			temp.setProvinfirstaward(ReaderUtils.transInteger(ProvinFirstAward));
			temp.setProvinsecondaward(ReaderUtils.transInteger(ProvinSecondAward));
			temp.setProvinthirdaward(ReaderUtils.transInteger(ProvinThirdAward));
			temp.setProvinskillwintime(ReaderUtils.transInteger(ProvinSkillWinTime));
			temp.setProvintrainfulltea(ReaderUtils.transInteger(ProvinTrainFullTea));
			temp.setProvintrainhour(new BigDecimal(ProvinTrainHour));
			temp.setStatefirstaward(ReaderUtils.transInteger(StateFirstAward));
			temp.setStatesecondaward(ReaderUtils.transInteger(StateSecondAward));
			temp.setStatethridaward(ReaderUtils.transInteger(StateThridAward));
			temp.setStateskillwintime(ReaderUtils.transInteger(StateSkillWinTime));
			temp.setStatetrainfulltea(ReaderUtils.transInteger(StateTrainFullTea));
			temp.setStatetrainhour(new BigDecimal(StateTrainHour));
			temp.setStateoutertrain(ReaderUtils.transInteger(StateOuterTrain));
			temp.setStateouterhour(new BigDecimal(StateOuterHour));
			temp.setTainfundper(new BigDecimal(TainFundPer));
			temp.setYear(Year);
			
			return temp;
		}catch(Exception e){
			//e.printStackTrace();
			return null;
		}
	}

	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createTeachers(
			@RequestParam String Admcode,
			@RequestParam String Year,
			@RequestParam String DistTrainFullTea,
			@RequestParam String DistTrainHour,
			@RequestParam String CityTrainFullTea,
			@RequestParam String CityTrainHour,
			@RequestParam String ProvinTrainFullTea,
			@RequestParam String ProvinTrainHour,
			@RequestParam String StateTrainFullTea,
			@RequestParam String StateTrainHour,
			@RequestParam String StateOuterTrain,
			@RequestParam String StateOuterHour,
			@RequestParam String AbroadTrain,
			@RequestParam String AbroadHour,
			@RequestParam String Diploma,
			@RequestParam String TainFundPer,
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
		System.out.println(Admcode);
		EducationTrain temp = EducationTrainController.presaveEducationTrain(Admcode, Year, DistTrainFullTea,
				DistTrainHour, CityTrainFullTea, CityTrainHour, ProvinTrainFullTea, ProvinTrainHour, 
				StateTrainFullTea, StateTrainHour, StateOuterTrain, StateOuterHour, 
				AbroadTrain, AbroadHour, Diploma, TainFundPer, StateSkillWinTime, 
				StateFirstAward, StateSecondAward, StateThridAward, ProvinSkillWinTime, 
				ProvinFirstAward, ProvinSecondAward, ProvinThirdAward, CitySkillWinTime,
				CityFirstAward, CitySecondAward, CityThirdAward);
		try{
				educationTrainService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	
}

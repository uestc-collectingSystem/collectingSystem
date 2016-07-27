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
import edu.uestc.lib.MSStudio.collecting.model.SkillTrain;
import edu.uestc.lib.MSStudio.collecting.service.SkillTrainService;

@Controller
@RequestMapping("social/skill")
public class SkillTrainController implements OriginController{
	@Resource
	private SkillTrainService skillTrainService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", skillTrainService.listAllSkillTrain(pageNum, pageSize));
		return PageRoutes.skillTrainPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, org.springframework.ui.Model model,
			HttpServletResponse response) throws IOException {
		SkillTrain temp = skillTrainService.getSkillTrain(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		skillTrainService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
		
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, org.springframework.ui.Model model,
			HttpServletResponse response) throws IOException {
		skillTrainService.checkObjectByID(id);
		response.sendRedirect("../");
		
	}
	
	public static SkillTrain presaveSkillTrain(
			String Admcode,
			String Year,
			String LocalFoster,
			String LocalTrain,
			String DevelopName,
			String EcnomicSocial,
			String TrackProblemNum
			){
		SkillTrain temp = new SkillTrain();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setDevelopname(DevelopName);
			temp.setEcnomicsocial(new BigDecimal(EcnomicSocial));
			temp.setLocalfoster(ReaderUtils.transInteger(LocalFoster));
			temp.setLocaltrain(ReaderUtils.transInteger(LocalTrain));
			temp.setTrackproblemnum(ReaderUtils.transInteger(TrackProblemNum));
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
			@RequestParam String LocalFoster,
			@RequestParam String LocalTrain,
			@RequestParam String DevelopName,
			@RequestParam String EcnomicSocial,
			@RequestParam String TrackProblemNum,
	HttpServletRequest request,Model model){
		SkillTrain temp = SkillTrainController.presaveSkillTrain(Admcode, Year,
				LocalFoster, LocalTrain, DevelopName, EcnomicSocial, TrackProblemNum);
				
		try{
				skillTrainService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}

	
}

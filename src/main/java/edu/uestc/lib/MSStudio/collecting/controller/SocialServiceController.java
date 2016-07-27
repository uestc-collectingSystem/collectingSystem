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
import edu.uestc.lib.MSStudio.collecting.model.SocialService;
import edu.uestc.lib.MSStudio.collecting.service.SocialServService;

@Controller
@RequestMapping("social/service")
public class SocialServiceController implements OriginController{

	@Resource
	private SocialServService socialServService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", socialServService.listAllSocialService(pageNum, pageSize));
		return PageRoutes.socialServicePage;
	}
	
	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		SocialService temp = socialServService.getSocialService(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		socialServService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		socialServService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static SocialService presaveSocialService(
			String Admcode,
			String Year,
			String TrainStaff,
			String TrainUnabled,
			String TrainUnemStaff,
			String TrainFarmer,
			String TrainRetireSoldier,
			String SkillIdentNum,
			String TeachServe
			){
		SocialService temp = new SocialService();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setSkillidentnum(new BigDecimal(SkillIdentNum));
			temp.setTeachserve(ReaderUtils.transInteger(TeachServe));
			temp.setTrainfarmer(ReaderUtils.transInteger(TrainFarmer));
			temp.setTrainretiresoldier(ReaderUtils.transInteger(TrainRetireSoldier));
			temp.setTrainstaff(ReaderUtils.transInteger(TrainStaff));
			temp.setTrainunabled(ReaderUtils.transInteger(TrainUnabled));
			temp.setTrainunemstaff(ReaderUtils.transInteger(TrainStaff));
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
			@RequestParam String TrainStaff,
			@RequestParam String TrainUnabled,
			@RequestParam String TrainUnemStaff,
			@RequestParam String TrainFarmer,
			@RequestParam String TrainRetireSoldier,
			@RequestParam String SkillIdentNum,
			@RequestParam String TeachServe,
	HttpServletRequest request,Model model){
		SocialService temp = SocialServiceController.presaveSocialService(Admcode, Year, TrainStaff,
				TrainUnabled, TrainUnemStaff, TrainFarmer, TrainRetireSoldier, SkillIdentNum, TeachServe);
		try{
				socialServService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
}

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

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.excel.ReaderUtils;
import edu.uestc.lib.MSStudio.collecting.model.CounpaSupply;
import edu.uestc.lib.MSStudio.collecting.service.CounpaSuppService;

@Controller
@RequestMapping("social/support")
public class CounpaSuppController implements OriginController{

	@Resource
	private CounpaSuppService counpaSuppService;
	
	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", counpaSuppService.listAllCounpaSupply(pageNum, pageSize));
		System.out.println(JSON.toJSONString(counpaSuppService.getCounpaSupply("1")));
		return PageRoutes.counpaSupportPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		CounpaSupply temp = counpaSuppService.getCounpaSupply(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		counpaSuppService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
		
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		counpaSuppService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static CounpaSupply presaveCounpaSupply(
			String Admcode,
			String Year,
			String HelpObject,
			String PoverReducTarget,
			String Fund,
			String ServiceNum,
			String Skill,
			String Project){
			CounpaSupply temp = new CounpaSupply();
			try{
				temp.setAdmcode(Admcode);
				temp.setAudit(0);
				temp.setFund(new BigDecimal(Fund));
				temp.setHelpobject(ReaderUtils.transInteger(HelpObject));
				temp.setPoverreductarget(ReaderUtils.transInteger(PoverReducTarget));
				temp.setProject(Project);
				temp.setServicenum(ReaderUtils.transInteger(ServiceNum));
				temp.setSkill(Skill);
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
			@RequestParam String HelpObject,
			@RequestParam String PoverReducTarget,
			@RequestParam String Fund,
			@RequestParam String ServiceNum,
			@RequestParam String Skill,
			@RequestParam String Project,
	HttpServletRequest request,Model model){
		CounpaSupply temp = CounpaSuppController.presaveCounpaSupply(Admcode, Year, HelpObject, 
				PoverReducTarget, Fund, ServiceNum, Skill, Project);
		try{
				counpaSuppService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
}

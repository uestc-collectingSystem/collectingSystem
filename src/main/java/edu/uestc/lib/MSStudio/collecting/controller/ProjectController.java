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
import edu.uestc.lib.MSStudio.collecting.model.Project;
import edu.uestc.lib.MSStudio.collecting.service.ProjectService;

@Controller
@RequestMapping("qua/project")
public class ProjectController implements OriginController{

	@Resource
	private ProjectService projectService;
	
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", projectService.listAllProject(pageNum, pageSize));
		return PageRoutes.quaProjectPage;
	}

	
	
	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		Project temp = projectService.getProject(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		projectService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;

	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		projectService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static Project presaveProject(
			String Admcode,
			String Year,
			String Type,
			String Name,
			String Fund
			){
		Project temp = new Project();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setFund(new BigDecimal(Fund));
			temp.setName(Name);
			temp.setType(ReaderUtils.transInteger(Type));
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
			@RequestParam String Type,
			@RequestParam String Name,
			@RequestParam String Fund,
	HttpServletRequest request,Model model){
		Project temp = ProjectController.presaveProject(Admcode, Year, Type, Name, Fund);
		try{
				projectService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
}

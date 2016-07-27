package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;

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
import edu.uestc.lib.MSStudio.collecting.model.GroupSchool;
import edu.uestc.lib.MSStudio.collecting.service.GroupSchoolService;

@Controller
@RequestMapping("coor/group")
public class GroupSchoolController implements OriginController {

	@Resource
	private GroupSchoolService groupSchoolService;
	
	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", groupSchoolService.listAllGroupSchool(pageNum, pageSize));
		return PageRoutes.groupschoolPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		GroupSchool temp = groupSchoolService.getGroupSchool(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		groupSchoolService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
		
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		groupSchoolService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static GroupSchool presaveGroupSchool(
			String Admcode,
			String Year,
			String LeadVocEduGroup,
			String JoinVocEduGroup,
			String JoinLeadVocEduGroupScho,
			String JoinLeadVocEduGroupEnterp,
			String JoinLeadVocEduGroupMajor
			){
		GroupSchool temp = new GroupSchool();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setJoinleadvocedugroupenterp(ReaderUtils.transInteger(JoinLeadVocEduGroupEnterp));
			temp.setJoinleadvocedugroupmajor(ReaderUtils.transInteger(JoinLeadVocEduGroupMajor));
			temp.setJoinleadvocedugroupscho(ReaderUtils.transInteger(JoinLeadVocEduGroupScho));
			temp.setJoinvocedugroup(ReaderUtils.transInteger(JoinVocEduGroup));
			temp.setLeadvocedugroup(ReaderUtils.transInteger(LeadVocEduGroup));
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
			@RequestParam String LeadVocEduGroup,
			@RequestParam String JoinVocEduGroup,
			@RequestParam String JoinLeadVocEduGroupScho,
			@RequestParam String JoinLeadVocEduGroupEnterp,
			@RequestParam String JoinLeadVocEduGroupMajor,
	HttpServletRequest request,Model model){
		GroupSchool temp = GroupSchoolController.presaveGroupSchool(Admcode, Year, 
				LeadVocEduGroup, JoinVocEduGroup, JoinLeadVocEduGroupScho, 
				JoinLeadVocEduGroupEnterp, JoinLeadVocEduGroupMajor);
		try{
				groupSchoolService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
}

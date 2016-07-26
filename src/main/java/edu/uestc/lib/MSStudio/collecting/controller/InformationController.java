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
import edu.uestc.lib.MSStudio.collecting.model.Information;
import edu.uestc.lib.MSStudio.collecting.service.InformationService;


@Controller
@RequestMapping("basic/info")
public class InformationController implements OriginController{

	@Resource
	private InformationService infoService;
	
	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", infoService.listAllInformation(pageNum, pageSize));
		return PageRoutes.informationPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		Information temp = infoService.getInformation(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		infoService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		infoService.checkObjectByID(id);
		response.sendRedirect("../");
	}

	public static Information presaveInformation(
			String Admcode,
			String Year,
			String EducateInfo,
			String Server,
			String NetworkNum,
			String NetworkMain,
			String VideoStu,
			String ElecBookStu,
			String TeacComputer,
			String TeacCompStu,
			String NetMediaRoom,
			String NetClassCount
			){
		try{
			Information temp = new Information();
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setEducateinfo(ReaderUtils.transInteger(EducateInfo));
			temp.setElecbookstu(new BigDecimal(ElecBookStu));
			temp.setNetclasscount(ReaderUtils.transInteger(NetClassCount));
			temp.setNetmediaroom(ReaderUtils.transInteger(NetMediaRoom));
			temp.setNetworkmain(ReaderUtils.transInteger(NetworkMain));
			temp.setNetworknum(ReaderUtils.transInteger(NetworkNum));
			temp.setServer(ReaderUtils.transInteger(Server));
			temp.setTeaccompstu(new BigDecimal(TeacCompStu));
			temp.setTeaccomputer(ReaderUtils.transInteger(TeacComputer));
			temp.setVideostu(new BigDecimal(VideoStu));
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
			@RequestParam String EducateInfo,
			@RequestParam String Server,
			@RequestParam String NetworkNum,
			@RequestParam String NetworkMain,
			@RequestParam String VideoStu,
			@RequestParam String ElecBookStu,
			@RequestParam String TeacComputer,
			@RequestParam String TeacCompStu,
			@RequestParam String NetMediaRoom,
			@RequestParam String NetClassCount,
	HttpServletRequest request,Model model){
		Information temp = InformationController.presaveInformation(Admcode, Year, EducateInfo,
				Server, NetworkNum, NetworkMain, VideoStu, 
				ElecBookStu, TeacComputer, TeacCompStu, 
				NetMediaRoom, NetClassCount);
		try{
				infoService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	

}

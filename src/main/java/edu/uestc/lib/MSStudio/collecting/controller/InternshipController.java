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
import edu.uestc.lib.MSStudio.collecting.model.Internship;
import edu.uestc.lib.MSStudio.collecting.service.InternshipService;

@Controller
@RequestMapping("coor/internship")
public class InternshipController implements OriginController{
	
	@Resource
	private InternshipService internshipService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("firstMenu", "校企合作");
		model.addAttribute("subMenu", " 学生实习情况");
		model.addAttribute("list", internshipService.listAllInternship(pageNum, pageSize));
		return PageRoutes.internshipPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		Internship temp = internshipService.getInternship(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		internshipService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;

	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		internshipService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static Internship presaveInternship(
			String Admcode,
			String Year,
			String OffCamptTrainBase,
			String KownDuration,
			String PostDuration,
			String DisplaceDuration,
			String StuPostPartRadio,
			String StuDisPartRadio,
			String EnterpAssessDisOpt,
			String EnterpAssessDisGood,
			String EnterpAssessDisInter,
			String EnterpAssessDisBad,
			String CoopEnterpEmployStud
			){
		Internship temp = new Internship();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setCoopenterpemploystud(new BigDecimal(CoopEnterpEmployStud));
			temp.setDisplaceduration(DisplaceDuration);
			temp.setEnterpassessdisbad(new BigDecimal(EnterpAssessDisBad));
			temp.setEnterpassessdisgood(new BigDecimal(EnterpAssessDisGood));
			temp.setEnterpassessdisinter(new BigDecimal(EnterpAssessDisInter));
			temp.setEnterpassessdisopt(new BigDecimal(EnterpAssessDisOpt));
			temp.setKownduration(ReaderUtils.transInteger(KownDuration));
			temp.setOffcampttrainbase(ReaderUtils.transInteger(OffCamptTrainBase));
			temp.setPostduration(ReaderUtils.transInteger(PostDuration));
			temp.setStudispartradio(new BigDecimal(StuDisPartRadio));
			temp.setStupostpartradio(new BigDecimal(StuPostPartRadio));
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
			@RequestParam String OffCamptTrainBase,
			@RequestParam String KownDuration,
			@RequestParam String PostDuration,
			@RequestParam String DisplaceDuration,
			@RequestParam String StuPostPartRadio,
			@RequestParam String StuDisPartRadio,
			@RequestParam String EnterpAssessDisOpt,
			@RequestParam String EnterpAssessDisGood,
			@RequestParam String EnterpAssessDisInter,
			@RequestParam String EnterpAssessDisBad,
			@RequestParam String CoopEnterpEmployStud,
	HttpServletRequest request,Model model){
		Internship temp = InternshipController.presaveInternship(Admcode,Year,OffCamptTrainBase, KownDuration, 
				PostDuration, DisplaceDuration, StuPostPartRadio, StuDisPartRadio, EnterpAssessDisOpt, 
				EnterpAssessDisGood, EnterpAssessDisInter, EnterpAssessDisBad, CoopEnterpEmployStud);
		try{
				internshipService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	
	@RequestMapping("update")
	public void testFormBean(@ModelAttribute("update") Internship record,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		//System.out.println(JSON.toJSON(record));
		if(!internshipService.update(record)) System.out.println("wrong");;
		response.sendRedirect("./");
		return ;
	} 
}

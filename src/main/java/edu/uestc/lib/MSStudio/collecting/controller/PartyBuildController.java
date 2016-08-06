package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;

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
import edu.uestc.lib.MSStudio.collecting.model.PartyBuild;
import edu.uestc.lib.MSStudio.collecting.service.PartyBuildService;

@Controller
@RequestMapping("social/party")
public class PartyBuildController implements OriginController{

	@Resource
	private PartyBuildService partyBuildService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("firstMenu", "党建工作");
		model.addAttribute("subMenu", " 学校党建工作");
		model.addAttribute("list", partyBuildService.listAllPartyBuild(pageNum, pageSize));
		return PageRoutes.partyBuildPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		PartyBuild temp = partyBuildService.getPartyBuild(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		partyBuildService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		partyBuildService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static PartyBuild presavePartyBuild(
				String Admcode,
				String PartyMember,
				String BranchNum,
				String StuPartyNum,
				String PartyWorkTrain,
				String PartyTain,
				String PartyActivistTrainNum,
				String PartyActivistTrainTime,
				String DevelopPartyNum,
				String SubscribNum,
				String Punish,
				String StatePer,
				String ProvinPer,
				String CityPer,
				String StateOrgan,
				String ProvinOrgan,
				String CityOrgan,
				String Year
			){
		PartyBuild temp = new PartyBuild();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setBranchnum(ReaderUtils.transInteger(BranchNum));
			temp.setCityorgan(ReaderUtils.transInteger(CityOrgan));
			temp.setCityper(ReaderUtils.transInteger(CityPer));
			temp.setDeveloppartynum(ReaderUtils.transInteger(DevelopPartyNum));
			temp.setPartyactivisttrainnum(ReaderUtils.transInteger(PartyActivistTrainNum));
			temp.setPartyactivisttraintime(ReaderUtils.transInteger(PartyActivistTrainTime));
			temp.setPartymember(ReaderUtils.transInteger(PartyMember));
			temp.setPartytain(ReaderUtils.transInteger(PartyTain));
			temp.setPartyworktrain(ReaderUtils.transInteger(PartyWorkTrain));
			temp.setProvinorgan(ReaderUtils.transInteger(ProvinOrgan));
			temp.setProvinper(ReaderUtils.transInteger(ProvinPer));
			temp.setPunish(ReaderUtils.transInteger(Punish));
			temp.setStateorgan(ReaderUtils.transInteger(StateOrgan));
			temp.setStateper(ReaderUtils.transInteger(StatePer));
			temp.setStupartynum(ReaderUtils.transInteger(StuPartyNum));
			temp.setSubscribnum(ReaderUtils.transInteger(SubscribNum));
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
			@RequestParam String PartyMember,
			@RequestParam String BranchNum,
			@RequestParam String StuPartyNum,
			@RequestParam String PartyWorkTrain,
			@RequestParam String PartyTain,
			@RequestParam String PartyActivistTrainNum,
			@RequestParam String PartyActivistTrainTime,
			@RequestParam String DevelopPartyNum,
			@RequestParam String SubscribNum,
			@RequestParam String Punish,
			@RequestParam String StatePer,
			@RequestParam String ProvinPer,
			@RequestParam String CityPer,
			@RequestParam String StateOrgan,
			@RequestParam String ProvinOrgan,
			@RequestParam String CityOrgan,
	HttpServletRequest request,Model model){
		PartyBuild temp = PartyBuildController.presavePartyBuild(Admcode, PartyMember, 
				BranchNum, StuPartyNum, PartyWorkTrain, PartyTain, PartyActivistTrainNum, 
				PartyActivistTrainTime, DevelopPartyNum, SubscribNum, Punish, StatePer,
				ProvinPer, CityPer, StateOrgan, ProvinOrgan, CityOrgan, Year);
		try{
				partyBuildService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "TeachersPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	@RequestMapping("update")
	public void testFormBean(@ModelAttribute("update") PartyBuild record,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		//System.out.println(JSON.toJSON(record));
		if(!partyBuildService.update(record)) System.out.println("wrong");;
		response.sendRedirect("./");
		return ;
	}
}

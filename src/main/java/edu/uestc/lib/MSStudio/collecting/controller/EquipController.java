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
import edu.uestc.lib.MSStudio.collecting.model.Equipment;
import edu.uestc.lib.MSStudio.collecting.service.EquipService;

@Controller
@RequestMapping("basic/equip")
public class EquipController implements OriginController{

	@Resource
	private EquipService equipService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", equipService.listAllEquipment(pageNum, pageSize));
		return PageRoutes.equipmentPage;
	}

	@Override
	public void deleteObject(@PathVariable String id,
			HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		Equipment temp = equipService.getEquipment(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		equipService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id,
			HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		equipService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	public static Equipment presaveEquip(
			 String AdmCode,
			 String Year,
			 String TotalAssertWorth,
			 String TeacEquitWorth,
			 String TrainEquitWorth,
			 String YearTeacEquitWorth,
			 String YearTrainEquitWorth,
			 String StuTracEquitWorth,
			 String StuTrainEquitWorth,
			 String TraPracWorkPe,
			 String InTrainBase,
			 String OutTrainBase,
			 String LibBooks,
			 String LibBooksElec,
			 String YearBooks,
			 String ReadSeats,
			 String StuBook,
			 String SubScribs,
			 String ElecBooks,
			 String ElecSeats){
		Equipment temp = new Equipment();
		try{
			temp.setAdmcode(AdmCode);
			temp.setAudit(0);
			temp.setElecbooks(ReaderUtils.transInteger(ElecBooks));
			temp.setElecseats(ReaderUtils.transInteger(ElecSeats));
			temp.setIntrainbase(ReaderUtils.transInteger(InTrainBase));
			temp.setLibbooks(ReaderUtils.transInteger(LibBooks));
			temp.setLibbookselec(ReaderUtils.transInteger(LibBooksElec));
			temp.setOuttrainbase(ReaderUtils.transInteger(OutTrainBase));
			temp.setReadseats(ReaderUtils.transInteger(ReadSeats));
			temp.setStubook(new BigDecimal(StuBook));
			temp.setStutracequitworth(new BigDecimal(StuTracEquitWorth));
			temp.setStutrainequitworth(new BigDecimal(StuTrainEquitWorth));
			temp.setSubscribs(ReaderUtils.transInteger(SubScribs));
			temp.setTeacequitworth(new BigDecimal(TeacEquitWorth));
			temp.setTotalassertworth(ReaderUtils.transLong(TotalAssertWorth));
			temp.setTrainequitworth(new BigDecimal(TrainEquitWorth));
			temp.setTrapracworkpe(new BigDecimal(TraPracWorkPe));
			temp.setYear(Year);
			temp.setYearbooks(ReaderUtils.transInteger(YearBooks));
			temp.setYearteacequitworth(new BigDecimal(YearTeacEquitWorth));
			temp.setYeartrainequitworth(new BigDecimal(YearTrainEquitWorth));
			return temp;
		}catch(Exception e){
			return null;
		}
		
	};
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createEquipment(
			@RequestParam String AdmCode,
			@RequestParam String Year,
			@RequestParam String TotalAssertWorth,
			@RequestParam String TeacEquitWorth,
			@RequestParam String TrainEquitWorth,
			@RequestParam String YearTeacEquitWorth,
			@RequestParam String YearTrainEquitWorth,
			@RequestParam String StuTracEquitWorth,
			@RequestParam String StuTrainEquitWorth,
			@RequestParam String TraPracWorkPe,
			@RequestParam String InTrainBase,
			@RequestParam String OutTrainBase,
			@RequestParam String LibBooks,
			@RequestParam String LibBooksElec,
			@RequestParam String YearBooks,
			@RequestParam String ReadSeats,
			@RequestParam String StuBook,
			@RequestParam String SubScribs,
			@RequestParam String ElecBooks,
			@RequestParam String ElecSeats,
			HttpServletRequest request,Model model){
		Equipment temp = presaveEquip(AdmCode, Year, TotalAssertWorth, TeacEquitWorth, 
				TrainEquitWorth, YearTeacEquitWorth, YearTrainEquitWorth, StuTracEquitWorth,
				StuTrainEquitWorth, TraPracWorkPe, InTrainBase, OutTrainBase, 
				LibBooks, LibBooksElec, YearBooks, ReadSeats, StuBook, SubScribs, 
				ElecBooks, ElecSeats);
		try{
			equipService.save(temp);
			return this.indexWithPage("1", request, model);
		}catch(Exception e){
			model.addAttribute(PageRoutes.errorSourceParam, "EquipPage");
			model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
			//e.printStackTrace();
			return PageRoutes.errorPage;
		}
	}
	
	
}

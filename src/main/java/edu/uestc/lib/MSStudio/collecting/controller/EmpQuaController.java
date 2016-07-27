package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.io.Reader;
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
import edu.uestc.lib.MSStudio.collecting.model.EmployQuality;
import edu.uestc.lib.MSStudio.collecting.service.EmpQuaServicee;

@Controller
@RequestMapping("dev/emp")
public class EmpQuaController implements OriginController{
	
	@Resource
	private EmpQuaServicee empQuaService;

	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", empQuaService.listAllEmployQuality(pageNum, pageSize));
		return PageRoutes.empQuaPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		EmployQuality temp = empQuaService.getEmployquality(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		empQuaService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		empQuaService.checkObjectByID(id);
		response.sendRedirect("../");
		
	}
	
	public static EmployQuality presaveEmpQua(
			String Admcode,
			String Year,
			String EmployRateFirst,
			String CouPartEmployRate,
			String SixMonthSteadRate,
			String FirstEmployMonIncome,
			String VentureRate,
			String StateOwn,
			String PrivateOwn,
			String ForeignOwn,
			String One,
			String Two,
			String Three,
			String Soldier,
			String CollegeEntance,
			String CouterPart,
			String OneYearInner,
			String OneYearOuter
			){
		EmployQuality temp = new EmployQuality();
		try{
			temp.setAdmcode(Admcode);
			temp.setAudit(0);
			temp.setCollegeentance(new BigDecimal(CollegeEntance));
			temp.setCoupartemployrate(new BigDecimal(CouPartEmployRate));
			temp.setCouterpart(new BigDecimal(CouterPart));
			temp.setEmployratefirst(new BigDecimal(EmployRateFirst));
			temp.setFirstemploymonincome(new BigDecimal(FirstEmployMonIncome));
			temp.setForeignown(new BigDecimal(ForeignOwn));
			temp.setOne(new BigDecimal(One));
			temp.setOneyearinner(new BigDecimal(OneYearInner));
			temp.setOneyearouter(new BigDecimal(OneYearOuter));
			temp.setPrivateown(new BigDecimal(PrivateOwn));
			temp.setSixmonthsteadrate(new BigDecimal(SixMonthSteadRate));
			temp.setSoldier(ReaderUtils.transInteger(Soldier));
			temp.setStateown(new BigDecimal(StateOwn));
			temp.setThree(new BigDecimal(Three));
			temp.setTwo(new BigDecimal(Two));
			temp.setVenturerate(new BigDecimal(VentureRate));
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
			@RequestParam String EmployRateFirst,
			@RequestParam String CouPartEmployRate,
			@RequestParam String SixMonthSteadRate,
			@RequestParam String FirstEmployMonIncome,
			@RequestParam String VentureRate,
			@RequestParam String StateOwn,
			@RequestParam String PrivateOwn,
			@RequestParam String ForeignOwn,
			@RequestParam String One,
			@RequestParam String Two,
			@RequestParam String Three,
			@RequestParam String Soldier,
			@RequestParam String CollegeEntance,
			@RequestParam String CouterPart,
			@RequestParam String OneYearInner,
			@RequestParam String OneYearOuter,
	HttpServletRequest request,Model model){
		EmployQuality temp = EmpQuaController.presaveEmpQua(Admcode, Year, EmployRateFirst, 
				CouPartEmployRate, SixMonthSteadRate, FirstEmployMonIncome,
				VentureRate, StateOwn, PrivateOwn, ForeignOwn, 
				One, Two, Three, Soldier, CollegeEntance, CouterPart, 
				OneYearInner, OneYearOuter);
		try{
				empQuaService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "EmpQuaPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
		}
	}
	
	
	
	
}

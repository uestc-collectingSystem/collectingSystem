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

import edu.uestc.lib.MSStudio.collecting.model.Funds;
import edu.uestc.lib.MSStudio.collecting.service.FundsService;

@Controller
@RequestMapping("basic/funds")
public class FundsController implements OriginController{

	@Resource
	private FundsService fundsService;
	
	@Override
	@RequestMapping(value="{pageNum}&{pageSize}",method=RequestMethod.GET)
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model){
		model.addAttribute("list", fundsService.listAllFunds(pageNum, pageSize));
		return PageRoutes.fundPage;
	}

	@Override
	public void deleteObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		Funds temp = fundsService.getFunds(id);
		if (temp.getAudit()==1){
			response.sendError(401,"You Can Not Delete An Record After It's Checked");
			return ;
		}
		fundsService.deleteObjectByID(id);
		response.sendRedirect("../");
		return ;
	}

	@Override
	public void checkObject(@PathVariable String id, HttpServletRequest request, Model model, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		fundsService.checkObjectByID(id);
		response.sendRedirect("../");
	}
	
	
	public static Funds presaveFunds(
			String Admcode,
			String Year,

			String CenterFund,
			String LocalFund,
			String Debt,
			String Loan,
			String Appropriation,
			String TeacInputRadio,
			String TeacherTrain,
			String TeachChange,
			String FundBudget){
		Funds temp = new Funds();
		try{
			temp.setAdmcode(Admcode);
			temp.setAppropriation(new BigDecimal(Appropriation));
			temp.setAudit(0);
			temp.setCenterfund(new BigDecimal(CenterFund));
			temp.setDebt(new BigDecimal(Debt));
			temp.setFundbudget(new BigDecimal(FundBudget));
			temp.setLoan(new BigDecimal(Loan));
			temp.setLocalfund(new BigDecimal(LocalFund));
			temp.setTeachchange(new BigDecimal(TeachChange));
			temp.setTeachertrain(new BigDecimal(TeacherTrain));
			temp.setTeacinputradio(new BigDecimal(TeacInputRadio));
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

			@RequestParam String CenterFund,
			@RequestParam String LocalFund,
			@RequestParam String Debt,
			@RequestParam String Loan,
			@RequestParam String Appropriation,
			@RequestParam String TeacInputRadio,
			@RequestParam String TeacherTrain,
			@RequestParam String TeachChange,
			@RequestParam String FundBudget,
	HttpServletRequest request,Model model){
		Funds temp = FundsController.presaveFunds(Admcode, Year, CenterFund, LocalFund,
				Debt, Loan, Appropriation, TeacInputRadio, 
				TeacherTrain, TeachChange, FundBudget);
		try{
				fundsService.save(temp);
				return this.indexWithPage("1",request, model);
			}catch(Exception e){
				model.addAttribute(PageRoutes.errorSourceParam, "FundsPage");
				model.addAttribute(PageRoutes.errorMsgParam, "参数有错，请检查:");
				//e.printStackTrace();
				return PageRoutes.errorPage;
			}
	}

	@RequestMapping("update")
	public void testFormBean(@ModelAttribute("update") Funds test,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		if(!fundsService.update(test)) System.out.println("wrong");;
		response.sendRedirect("./");
		return ;
	} 
	
}
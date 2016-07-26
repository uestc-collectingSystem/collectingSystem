package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface OriginController {
	//每个控制器都必须实现的部分
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public default String indexWithPage(
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		if (request.getRequestURL().reverse().charAt(0)!='/'){
			response.sendRedirect(request.getRequestURL().append('/').toString());
		}
		
		return indexWithPage("1", "20", request, model);
	}
	
	@RequestMapping(value="{pageNum}*",method=RequestMethod.GET)
	public default String indexWithPage(
			@PathVariable String pageNum,
			HttpServletRequest request,Model model){
		return indexWithPage(pageNum, "20", request, model);
	}
	
	public String indexWithPage(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
			HttpServletRequest request,Model model);
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public void deleteObject(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException;
	
	@RequestMapping(value="check/{id}",method=RequestMethod.GET)
	public void checkObject(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException;
}

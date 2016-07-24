package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import edu.uestc.lib.MSStudio.collecting.model.FileInfo;
import edu.uestc.lib.MSStudio.collecting.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {
	@Resource
	private FileService fileService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String listFiles(HttpServletRequest request,Model model){
		model.addAttribute("list", fileService.listFilePage("1","2"));
		return PageRoutes.filePage;
	}
	
	public static FileInfo preSaveFileInfo(
				String name,
				String writer,
				String source,
				String writeTime,
				String url
			){
		FileInfo temp = new FileInfo();
		try {
			temp.setAudit(0);
			temp.setName(name);
			temp.setSource(source);
			temp.setWritetime(writeTime);
			temp.setWriter(writer);
			temp.setUrl(url);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return temp;
	}
	
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createFile(
			@RequestParam String name,
			@RequestParam String writer,
			@RequestParam String source,
			@RequestParam String writeTime,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		CommonsMultipartResolver multipartResolver = 
		new CommonsMultipartResolver(request.getSession().getServletContext());
		
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			Iterator<String> nameList = multiRequest.getFileNames();
			//获取当前路径
			String currentPath = request.getServletContext().getRealPath("");
			//先判断当前路径中是否存在该模组文件夹，没有则创建
			String sourcePath = currentPath+source+"/";
			File sourceDirectory = new File(sourcePath);
			if (!sourceDirectory.exists()){
				sourceDirectory.mkdirs();
				//System.out.println(sourceDirectory.exists());
			}
			while (nameList.hasNext()){
				MultipartFile file = multiRequest.getFile(nameList.next());
				//System.out.println(file.getOriginalFilename());
				file.transferTo(new File(sourcePath+file.getOriginalFilename()));
				FileInfo temp = FileController.preSaveFileInfo(name, writer, source, writeTime, sourcePath+file.getOriginalFilename());
				if (temp==null){
					response.sendError(400, "Request Parameters Illegal");
					return PageRoutes.errorPage;
				}
				else {
					if(!fileService.save(temp)){
						response.sendError(400, "Request Parameters Illegal");
						return PageRoutes.errorPage;
					}
				}
			}
			//System.out.println(request.getServletContext().getRealPath(""));
		}
		else {
			response.sendError(400, "None Request Parameters:file/files");
		}
		model.addAttribute("list", fileService.listFilePage("1","2"));
		return PageRoutes.filePage;
	}
	
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public String deleteSchoolSize(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		FileInfo temp = fileService.findById(id);
		if (temp!=null) {
			File fopen = new File(temp.getUrl());
			if (!fopen.exists()){
				response.sendError(404, "File Does Not Exist");
			}
			else {
				if (temp.getAudit()==1||fopen.delete()){
					response.sendError(403, "Can Not Execute Delete Operation");
				}
				fileService.deleteFileById(id);
			}
		}
		else response.sendError(404, "Can Not Find Object");
		model.addAttribute("list", fileService.listFilePage("1","2"));
		return PageRoutes.filePage;
	}
	
	@RequestMapping(value="/check/{id}",method=RequestMethod.GET)
	public void checkSchoolSize(
			@PathVariable String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		if (fileService.checkFileInfo(id)) {
			response.sendRedirect("../");
		}
		else response.sendError(404, "Can Not Find Object");
		return ;
	}
}

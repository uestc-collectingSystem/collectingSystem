package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

public class Page {
	public List<Object> result;
	private int pageNumber;//页面号
	private int pageSize=20;//页面大小
	
	private Page(){}
	
	public Page(int num,int size,List<Object> result){
		pageNumber=num;
		pageSize=size;
		this.result=result;
	}
	
	public Page(int num,List<Object> result){
		pageSize=20;
		pageNumber=num;
		this.result=result;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	
	public int getPageNumber(){
		return pageNumber;
	}
}

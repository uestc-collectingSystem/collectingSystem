package edu.uestc.lib.MSStudio.collecting.controller;

public class AjaxMessage {
	private Integer code;
	private String msg;
	private Object result;
	
	
	public Integer getCode() {
		return code;
	}
	private void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	private void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
	public void OK(){
		this.setCode(200);
		this.setMsg("OK");
	}
	
}

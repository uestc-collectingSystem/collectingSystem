<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../header.jspf"%>
	<table border="1" class = "id_22">
	<thread>
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>对口帮扶对象单位数</td>
		<td>扶贫对象数</td>
		<td>资金扶贫（万元）</td>
		<td>服务人数</td>
		<td>扶贫技术名称</td>
		<td>扶贫项目名称</td>
		
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.HelpObject}</td>
			<td>${li.PoverReducTarget}</td>
			<td>${li.Fund}</td>
			<td>${li.ServiceNum}</td>
			<td>${li.Skill}</td>
			<td>${li.Project}</td>

			<td> 
				<c:if test="${li.Audit==1}">通过</c:if>
				<c:if test="${li.Audit==0}">未通过</c:if>
			</td>
			<td>
				<c:if test="${li.Audit==0}"><a href="delete/<c:out value="${li.ID}"/>">删除该信息</a></c:if>
				<c:if test="${li.Audit==1}">信息已通过审批</c:if>
			</td>
			<td>
				<c:if test="${li.Audit==0}">
				<a href="check/<c:out value="${li.ID}"/>">通过审核</a></c:if>
				<c:if test="${li.Audit==1}">信息已通过审批</c:if>
			</td>
		</tr>
		
		<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>

			<td><input name ="admcode"/></td>
			<td><input name ="year"/></td>

			<td><input name = "helpobject"/></td>
			<td><input name = "poverreductarget"/></td>
			<td><input name = "fund"/></td>
			<td><input name = "servicenum"/></td>
			<td><input name = "skill"/></td>
			<td><input name = "project"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
		</form>
	</c:forEach>
		
	</table>
<%@include file="../footer.jspf"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>
<body>
<h1>校企：合作情况</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
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
	</c:forEach>
		<tr>
			<td><input name ="Admcode"/></td>
			<td><input name ="Year"/></td>

			<td><input name = "HelpObject"/></td>
			<td><input name = "PoverReducTarget"/></td>
			<td><input name = "Fund"/></td>
			<td><input name = "ServiceNum"/></td>
			<td><input name = "Skill"/></td>
			<td><input name = "Project"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
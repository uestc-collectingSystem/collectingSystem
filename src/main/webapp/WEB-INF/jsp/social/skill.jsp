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
		
		<td>为当地主要产业培养技术技能人才数</td>
		<td>为当地培训技术技能人才数</td>
		<td>承担、参与改进或推广技术名称</td>
		<td>产生的经济效益和社会效益（万元）</td>
		<td>学校师生参与当地产业发展或结构调整技术攻关人数</td>
		
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.LocalFoster}</td>
			<td>${li.LocalTrain}</td>
			<td>${li.DevelopName}</td>
			<td>${li.EcnomicSocial}</td>
			<td>${li.TrackProblemNum}</td>
			
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

			<td><input name = "LocalFoster"/></td>
			<td><input name = "LocalTrain"/></td>
			<td><input name = "DevelopName"/></td>
			<td><input name = "EcnomicSocial"/></td>
			<td><input name = "TrackProblemNum"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
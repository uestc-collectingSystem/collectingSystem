<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>信息采集系统：文件</title>
</head>
<body>
	<h1>基础情况：规模</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	<table border="1">
		<tr>
		<td>文件名</td>
		<td>上传时间</td>
		<td>上传人员帐号</td>
		<td>文件所属模块</td>
		<td>文件审核情况</td>
		<td>下载链接</td>
		<td>删除文件</td>
		<td>审核文件</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Name}</td>
			<td>${li.WriteTime}</td>
			<td>${li.Writer}</td>
			<td>${li.Source}</td>
			<td> 
				<c:if test="${li.Audit==1}">通过</c:if>
				<c:if test="${li.Audit==0}">未通过</c:if>
			</td>
			<td><a target="_blank" href="./download/<c:out value="${li.ID}"/>">下载</a></td>
			<td>
				<c:if test="${li.Audit==0}"><a href="./delete/<c:out value="${li.ID}"/>">删除该文件</a></c:if>
				<c:if test="${li.Audit==1}">信息已通过审批</c:if>
			</td>
			<td>
				<c:if test="${li.Audit==0}">
				<a href="./check/<c:out value="${li.ID}"/>">通过审核</a></c:if>
				<c:if test="${li.Audit==1}">信息已通过审批</c:if>
			</td>
			
		</tr>
	</c:forEach>
	</table>
</body>
</html>
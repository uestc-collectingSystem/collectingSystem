<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>数据录入部分</title>
</head>
<body>
<h1>基础情况：信息化建设</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>是否设立教育信息是否设立教育信息化技术中心(0：没有，1：有)</td>
		<td>服务器台数</td>
		<td>校园网络出口总带宽(bps)</td>
		<td>校园网主干带宽(bps)</td>
		<td>生均数字教学视频资源量(小时/生)</td>
		<td>生均电子图书总量(册/生)</td>
		<td>教学用计算机台数</td>
		<td>生均教学用计算机台数</td>
		<td>网络多媒体教室数</td>
		<td>上网课程总量</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>
				<c:if test="${li.Audit==0}">设立</c:if>
				<c:if test="${li.Audit==1}">未设立</c:if>
			</td>
			<td>${li.Server}</td>
			<td>${li.NetworkNum}</td>
			<td>${li.NetworkMain}</td>
			<td>${li.VideoStu}</td>
			<td>${li.ElecBookStu}</td>
			<td>${li.TeacComputer}</td>
			<td>${li.TeacCompStu}</td>
			<td>${li.NetMediaRoom}</td>
			<td>${li.NetClassCount}</td>
			
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
			<td><input name="Admcode"/></td>
			<td><input name="Year"/></td>

			<td><input name="EducateInfo"/></td>
			<td><input name="Server"/></td>
			<td><input name="NetworkNum"/></td>
			<td><input name="NetworkMain"/></td>
			<td><input name="VideoStu"/></td>
			<td><input name="ElecBookStu"/></td>
			<td><input name="TeacComputer"/></td>
			<td><input name="TeacCompStu"/></td>
			<td><input name="NetMediaRoom"/></td>
			<td><input name="NetClassCount"/></td>
			
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>


<!-- 

@RequestParam String EducateInfo,
@RequestParam String Server,
@RequestParam String NetworkNum,
@RequestParam String NetworkMain,
@RequestParam String VideoStu,
@RequestParam String ElecBookStu,
@RequestParam String TeacComputer,
@RequestParam String TeacCompStu,
@RequestParam String NetMediaRoom,
@RequestParam String NetClassCount,

 -->
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
<h1>质量审核：课程开设</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>已制定实施型教学计划专业数</td>
		<td>牵头开发国家共建共享计划课程数</td>
		<td>校企联合开发课程数</td>
		<td>教师参编公开出版的教材数</td>
		<td>使用教育部教材目录教材比</td>
		<td>校本教材数</td>
		<td>各专业课程平均学时总数</td>
		<td>各专业专业课平均学时总数</td>
		<td>其中专业基础课学时总数</td>
		<td>其中专业技能课学时总数</td>
		<td>其中顶岗实习课学时总数</td>
		<td>各专业公共基础课平均学时总数</td>
		<td>其中语文课学时总数</td>
		<td>其中德育课学时总数</td>
		<td>其中数学课学时总数</td>
		<td>其中外语课学时总数</td>
		<td>其中体育健康课学时总数</td>
		<td>其中公共艺术课学时总数</td>
		<td>其中计算机应用课学时总数</td>
		<td>其中历史课学时总数</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.ClassCriter}</td>
			<td>${li.LeadNatShareMajor}</td>
			<td>${li.SchoolEnterMajor}</td>
			<td>${li.TextTeacEditMajor}</td>
			<td>${li.StatePlanText}</td>
			<td>${li.SchMajorMater}</td>
			<td>${li.ClassHour}</td>
			<td>${li.MajorHour}</td>
			<td>${li.MajorBHour}</td>
			<td>${li.MajorCHour}</td>
			<td>${li.DispClass}</td>
			<td>${li.BCClassHour}</td>
			<td>${li.Chinese}</td>
			<td>${li.Moral}</td>
			<td>${li.Math}</td>
			<td>${li.English}</td>
			<td>${li.Sports}</td>
			<td>${li.Art}</td>
			<td>${li.Computer}</td>
			<td>${li.History}</td>
			
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

			<td><input name="ClassCriter"/></td>
			<td><input name="LeadNatShareMajor"/></td>
			<td><input name="SchoolEnterMajor"/></td>
			<td><input name="TextTeacEditMajor"/></td>
			<td><input name="StatePlanText"/></td>
			<td><input name="SchMajorMater"/></td>
			<td><input name="ClassHour"/></td>
			<td><input name="MajorHour"/></td>
			<td><input name="MajorBHour"/></td>
			<td><input name="MajorCHour"/></td>
			<td><input name="DispClass"/></td>
			<td><input name="BCClassHour"/></td>
			<td><input name="Chinese"/></td>
			<td><input name="Moral"/></td>
			<td><input name="Math"/></td>
			<td><input name="English"/></td>
			<td><input name="Sports"/></td>
			<td><input name="Art"/></td>
			<td><input name="Computer"/></td>
			<td><input name="History"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>

<!--
@RequestParam String ClassCriter,
@RequestParam String LeadNatShareMajor,
@RequestParam String SchoolEnterMajor,
@RequestParam String TextTeacEditMajor,
@RequestParam String StatePlanText,
@RequestParam String SchMajorMater,
@RequestParam String ClassHour,
@RequestParam String MajorHour,
@RequestParam String MajorBHour,
@RequestParam String MajorCHour,
@RequestParam String DispClass,
@RequestParam String BCClassHour,
@RequestParam String Chinese,
@RequestParam String Moral,
@RequestParam String Math,
@RequestParam String English,
@RequestParam String Sports,
@RequestParam String Art,
@RequestParam String Computer,
@RequestParam String History,
-->
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
	<h1>基础情况：规模</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>办学性质</td>
		<td>办学水平</td>
		<td>办学主体</td>
		<td>学校占地面积</td>
		<td>自有产权占地面积</td>
		<td>总建筑面积</td>
		<td>学校自有产权建筑面积</td>
		<td>行政办公用房面积</td>
		<td>生均建筑面积</td>
		<td>教学及辅助用房面积</td>
		<td>校内实训用房面积</td>
		<td>心理咨询室建筑面积</td>
		<td>学生宿舍面积</td>
		<td>生均宿舍面积</td>
		<td>在校生数</td>
		<td>毕业生数</td>
		<td>三年巩固率</td>
		<td>当年招生总数</td>
		<td>专业数</td>
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.SchoolRun}</td>
			<td>${li.SchoolLevel}</td>
			<td>${li.SchoolSubject}</td>
			<td>${li.Area}</td>
			<td>${li.OwnPropArea}</td>
			<td>${li.TotalArea}</td>
			<td>${li.SchOwnConArea}</td>
			<td>${li.OfficeArea}</td>
			<td>${li.StuArea}</td>
			<td>${li.TeaAuxArea}</td>
			<td>${li.TrainArea}</td>
			<td>${li.PsyArea}</td>
			<td>${li.DormArea}</td>
			<td>${li.DormPerArea}</td>
			<td>${li.TotalStudent}</td>
			<td>${li.AnnualGraduate}</td>
			<td><fmt:formatNumber value="${li.ConsolidationRate*100}" pattern="##.##" minFractionDigits="2" />%</td>
			<td>${li.Enrollment}</td>
			<td>${li.Majors}</td>
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
		
		<form action = "./test" method="post"> 
			<input name="temp/"></input>
		</form>
		
	</c:forEach>
	</table>
</body>
</html>
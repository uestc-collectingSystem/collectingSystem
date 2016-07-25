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
		<td>录入年份</td>
		<td>固定资产总值</td>
		<td>教学设备资产值</td>
		<td>实训设备资产值</td>
		<td>年新增教学设备资产值</td>
		<td>年新增实训设备资产值</td>
		<td>生均教学设备资产值</td>
		<td>生均实训设备资产值</td>
		<td>生均实训实习工位数</td>
		<td>校内实训基地数</td>
		<td>校外实训基地数</td>
		<td>图书馆纸质图书藏书量(册)</td>
		<td>图书馆电子图书藏书量(册)</td>
		<td>年度新增图书(册)</td>
		<td>阅览室座位数</td>
		<td>生均图书(册)</td>
		<td>期刊订阅种类数</td>
		<td>电子图书数</td>
		<td>电子阅览室座位数</td>
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.AdmCode}</td>
			<td>${li.Year}</td>
			
			<td>${li.TotalAssertWorth}</td>
			<td>${li.TeacEquitWorth}</td>
			<td>${li.TrainEquitWorth}</td>
			<td>${li.YearTeacEquitWorth}</td>
			<td>${li.YearTrainEquitWorth}</td>
			<td>${li.StuTracEquitWorth}</td>
			<td>${li.StuTrainEquitWorth}</td>
			<td>${li.TraPracWorkPe}</td>
			<td>${li.InTrainBase}</td>
			<td>${li.OutTrainBase}</td>
			<td>${li.LibBooks}</td>
			<td>${li.LibBooksElec}</td>
			<td>${li.YearBooks}</td>
			<td>${li.ReadSeats}</td>
			<td>${li.StuBook}</td>
			<td>${li.SubScribs}</td>
			<td>${li.ElecBooks}</td>
			<td>${li.ElecSeats}</td>
			
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
	<form action="./create" method="POST">
		<tr>
			<td><input name="AdmCode"/></td>
			<td><input name="Year"/></td>
			<td><input name="TotalAssertWorth"/></td>
			<td><input name="TeacEquitWorth"/></td>
			<td><input name="TrainEquitWorth"/></td>
			<td><input name="YearTeacEquitWorth"/></td>
			<td><input name="YearTrainEquitWorth"/></td>
			<td><input name="StuTracEquitWorth"/></td>
			<td><input name="StuTrainEquitWorth"/></td>
			<td><input name="TraPracWorkPe"/></td>
			<td><input name="InTrainBase"/></td>
			<td><input name="OutTrainBase"/></td>
			<td><input name="LibBooks"/></td>
			<td><input name="LibBooksElec"/></td>
			<td><input name="YearBooks"/></td>
			<td><input name="ReadSeats"/></td>
			<td><input name="StuBook"/></td>
			<td><input name="SubScribs"/></td>
			<td><input name="ElecBooks"/></td>
			<td><input name="ElecSeats"/></td>
			<td><input type="submit" value="确定"/></td>
		</tr>
	</form>
	</table>
</body>
</html>

<!-- 
@RequestParam String AdmCode,
@RequestParam String Year,
@RequestParam String TotalAssertWorth,
@RequestParam String TeacEquitWorth,
@RequestParam String TrainEquitWorth,
@RequestParam String YearTeacEquitWorth,
@RequestParam String YearTrainEquitWorth,
@RequestParam String StuTracEquitWorth,
@RequestParam String StuTrainEquitWorth,
@RequestParam String TraPracWorkPe,
@RequestParam String InTrainBase,
@RequestParam String OutTrainBase,
@RequestParam String LibBooks,
@RequestParam String LibBooksElec,
@RequestParam String YearBooks,
@RequestParam String ReadSeats,
@RequestParam String StuBook,
@RequestParam String SubScribs,
@RequestParam String ElecBooks,
@RequestParam String ElecSeats,



 -->
 

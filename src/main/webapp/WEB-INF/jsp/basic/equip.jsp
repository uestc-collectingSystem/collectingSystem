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
		
		<tr class="hidden">
			<form action="./update" method="POST">
				<input name="id" type="hidden" value='${li.ID}'/>
				<td><input name="Admcode" value='${li.AdmCode}'/></td>
				<td><input name="Year" value='${li.Year}'/></td>
				
				<td><input name="totalassertworth"/></td>
				<td><input name="teacequitworth"/></td>
				<td><input name="trainequitworth"/></td>
				<td><input name="yearteacequitworth"/></td>
				<td><input name="yeartrainequitworth"/></td>
				<td><input name="stutracequitworth"/></td>
				<td><input name="stutrainequitworth"/></td>
				<td><input name="trapracworkpe"/></td>
				<td><input name="intrainbase"/></td>
				<td><input name="outtrainbase"/></td>
				<td><input name="libbooks"/></td>
				<td><input name="libbookselec"/></td>
				<td><input name="yearbooks"/></td>
				<td><input name="readseats"/></td>
				<td><input name="stubook"/></td>
				<td><input name="subscribs"/></td>
				<td><input name="elecbooks"/></td>
				<td><input name="elecseats"/></td>
				<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>
	
	</table>
<%@include file="../footer.jspf"%>
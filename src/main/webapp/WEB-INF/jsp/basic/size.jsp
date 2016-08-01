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
		<td>年份</td>
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
	</thread>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
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
		
		<tr class="hidden">
			<form action="./update" method="POST">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name="admcode" value ="${li.Admcode}" /></td>
			<td><input name="year" value = "${li.Year}"/></td>
			<td><input name = "schoolrun" value ="${li.SchoolRun}"/></td>
			<td><input name = "schoollevel" value ="${li.SchoolLevel}"/></td>
			<td><input name = "schoolsubject" value="${li.SchoolSubject}" /></td>
			<td><input name = "area"/></td>
			<td><input name = "ownproparea"/></td>
			<td><input name = "totalarea"/></td>
			<td><input name = "schownconarea"/></td>
			<td><input name = "officearea"/></td>
			<td><input name = "stuarea"/></td>
			<td><input name = "teaauxarea"/></td>
			<td><input name = "trainarea"/></td>
			<td><input name = "psyarea"/></td>
			<td><input name = "dormarea"/></td>
			<td><input name = "dormperarea"/></td>
			<td><input name = "totalstudent"/></td>
			<td><input name = "annualgraduate"/></td>
			<td><input name = "consolidationrate"/></td>
			<td><input name = "enrollment"/></td>
			<td><input name = "majors"/></td>
			<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>
</table>
<%@include file="../footer.jspf"%>
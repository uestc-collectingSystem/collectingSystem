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
		<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name="admcode"/></td>
			<td><input name="year"/></td>

			<td><input name="classcriter"/></td>
			<td><input name="leadnatsharemajor"/></td>
			<td><input name="schoolentermajor"/></td>
			<td><input name="textteaceditmajor"/></td>
			<td><input name="stateplantext"/></td>
			<td><input name="schmajormater"/></td>
			<td><input name="classhour"/></td>
			<td><input name="majorhour"/></td>
			<td><input name="majorbhour"/></td>
			<td><input name="majorchour"/></td>
			<td><input name="dispclass"/></td>
			<td><input name="bcclasshour"/></td>
			<td><input name="chinese"/></td>
			<td><input name="moral"/></td>
			<td><input name="math"/></td>
			<td><input name="english"/></td>
			<td><input name="sports"/></td>
			<td><input name="art"/></td>
			<td><input name="computer"/></td>
			<td><input name="history"/></td>
			 
			<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>
		
	</table>
<%@include file="../footer.jspf"%>
	
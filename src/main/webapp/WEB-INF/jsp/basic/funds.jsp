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
		
		<td>中央财政投入经费</td>
		<td>地方财政投入经费</td>
		<td>学校负债总额</td>
		<td>贷款总额</td>
		<td>生均拨款</td>
		<td>日常教学经费投入比例</td>
		<td>当年教师培训经费</td>
		<td>教学改革经费</td>
		<td>教科研经费</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	</thread>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.CenterFund}</td>
			<td>${li.LocalFund}</td>
			<td>${li.Debt}</td>
			<td>${li.Loan}</td>
			<td>${li.Appropriation}</td>
			<td>${li.TeacInputRadio}</td>
			<td>${li.TeacherTrain}</td>
			<td>${li.TeachChange}</td>
			<td>${li.FundBudget}</td>
			
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
				<td><input name="admcode" value ="${li.Admcode}"/></td>
				<td><input name="year" value ="${li.Year}"/></td>
	
				<td><input name="centerfund"/></td>
				<td><input name="localfund"/></td>
				<td><input name="debt"/></td>
				<td><input name="loan"/></td>
				<td><input name="appropriation"/></td>
				<td><input name="teacinputradio"/></td>
				<td><input name="teachertrain"/></td>
				<td><input name="teachchange"/></td>
				<td><input name="fundbudget"/></td>
				
				<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>	
	</table>
<%@include file="../footer.jspf"%>
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
		
		<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name ="admcode"/></td>
			<td><input name ="year"/></td>

			<td><input name = "localfoster"/></td>
			<td><input name = "localtrain"/></td>
			<td><input name = "developname"/></td>
			<td><input name = "ecnomicsocial"/></td>
			<td><input name = "trackproblemnum"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
		</form>
	</c:forEach>
		
	</table>
<%@include file="../footer.jspf"%>
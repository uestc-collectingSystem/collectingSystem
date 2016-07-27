<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>
<body>
<h1>社会建设：社会服务</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>培训企业员工数</td>
		<td>培训残疾人人数</td>
		<td>培训失业人员人数</td>
		<td>培训农民工人数</td>
		<td>培训退役士兵人数</td>
		<td>技能鉴定项目人次</td>
		<td>师生参与当地技术服务才次</td>
		
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.TrainStaff}</td>
			<td>${li.TrainUnabled}</td>
			<td>${li.TrainUnemStaff}</td>
			<td>${li.TrainFarmer}</td>
			<td>${li.TrainRetireSoldier}</td>
			<td>${li.SkillIdentNum}</td>
			<td>${li.TeachServe}</td>
			
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
			<td><input name ="Admcode"/></td>
			<td><input name ="Year"/></td>

			<td><input name = "TrainStaff"/></td>
			<td><input name = "TrainUnabled"/></td>
			<td><input name = "TrainUnemStaff"/></td>
			<td><input name = "TrainFarmer"/></td>
			<td><input name = "TrainRetireSoldier"/></td>
			<td><input name = "SkillIdentNum"/></td>
			<td><input name = "TeachServe"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
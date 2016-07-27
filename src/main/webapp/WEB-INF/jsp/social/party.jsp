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
<h1>党建工作</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>学校党员总数</td>
		<td>党支部数</td>
		<td>学生党员数</td>
		<td>党务工作人员培训人次</td>
		<td>党组织开展党员教育培训次数</td>
		<td>入党积极分子培训人数</td>
		<td>入党积极分子培训次数</td>
		<td>发展党员人数</td>
		<td>党报党刊订阅数</td>
		<td>受党纪政治处分党员数</td>
		<td>获国家级优秀表彰的人数</td>
		<td>获省级优秀表彰的人数</td>
		<td>获市级优秀表彰的人数</td>
		<td>获国家级优秀表彰的党组织数</td>
		<td>获省级优秀表彰的党组织数</td>
		<td>获市级优秀表彰的党组织数</td>

		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.PartyMember}</td>
			<td>${li.BranchNum}</td>
			<td>${li.StuPartyNum}</td>
			<td>${li.PartyWorkTrain}</td>
			<td>${li.PartyTain}</td>
			<td>${li.PartyActivistTrainNum}</td>
			<td>${li.PartyActivistTrainTime}</td>
			<td>${li.DevelopPartyNum}</td>
			<td>${li.SubscribNum}</td>
			<td>${li.Punish}</td>
			<td>${li.StatePer}</td>
			<td>${li.ProvinPer}</td>
			<td>${li.CityPer}</td>
			<td>${li.StateOrgan}</td>
			<td>${li.ProvinOrgan}</td>
			<td>${li.CityOrgan}</td>
			
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

			<td><input name = "PartyMember"/></td>
			<td><input name = "BranchNum"/></td>
			<td><input name = "StuPartyNum"/></td>
			<td><input name = "PartyWorkTrain"/></td>
			<td><input name = "PartyTain"/></td>
			<td><input name = "PartyActivistTrainNum"/></td>
			<td><input name = "PartyActivistTrainTime"/></td>
			<td><input name = "DevelopPartyNum"/></td>
			<td><input name = "SubscribNum"/></td>
			<td><input name = "Punish"/></td>
			<td><input name = "StatePer"/></td>
			<td><input name = "ProvinPer"/></td>
			<td><input name = "CityPer"/></td>
			<td><input name = "StateOrgan"/></td>
			<td><input name = "ProvinOrgan"/></td>
			<td><input name = "CityOrgan"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
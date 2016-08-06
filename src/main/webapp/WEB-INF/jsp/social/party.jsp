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
		
		<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name ="admcode"/></td>
			<td><input name ="year"/></td>

			<td><input name = "partymember"/></td>
			<td><input name = "branchnum"/></td>
			<td><input name = "stupartynum"/></td>
			<td><input name = "partyworktrain"/></td>
			<td><input name = "partytain"/></td>
			<td><input name = "partyactivisttrainnum"/></td>
			<td><input name = "partyactivisttraintime"/></td>
			<td><input name = "developpartynum"/></td>
			<td><input name = "subscribnum"/></td>
			<td><input name = "punish"/></td>
			<td><input name = "stateper"/></td>
			<td><input name = "provinper"/></td>
			<td><input name = "cityper"/></td>
			<td><input name = "stateorgan"/></td>
			<td><input name = "provinorgan"/></td>
			<td><input name = "cityorgan"/></td>
			 
			<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>		
	</table>
<%@include file="../footer.jspf"%>
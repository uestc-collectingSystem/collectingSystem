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
		
		<td>毕业生初次就业率</td>
		<td>专业对口就业率</td>
		<td>顶岗实习半年以上稳定率</td>
		<td>初次就业月平均收入</td>
		<td>自主创业率</td>
		<td>到国有企业事业单位服务比例</td>
		<td>到民营企业服务比例</td>
		<td>到外资企业服务比例</td>
		<td>到一产业就业比例</td>
		<td>到二产业就业比例</td>
		<td>到三产业就业比例</td>
		<td>参军人数</td>
		<td>高考统招升学学生数占毕业生总数比例</td>
		<td>对口单招升学学生数占毕业生总数比例</td>
		<td>签订一年及以内就业合同比例</td>
		<td>签订一年以上就业合同比例</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.EmployRateFirst}</td>
			<td>${li.CouPartEmployRate}</td>
			<td>${li.SixMonthSteadRate}</td>
			<td>${li.FirstEmployMonIncome}</td>
			<td>${li.VentureRate}</td>
			<td>${li.StateOwn}</td>
			<td>${li.PrivateOwn}</td>
			<td>${li.ForeignOwn}</td>
			<td>${li.One}</td>
			<td>${li.Two}</td>
			<td>${li.Three}</td>
			<td>${li.Soldier}</td>
			<td>${li.CollegeEntance}</td>
			<td>${li.CouterPart}</td>
			<td>${li.OneYearInner}</td>
			<td>${li.OneYearOuter}</td>
			
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

			<td><input name = "employratefirst"/></td> 
			<td><input name = "coupartemployrate"/></td>
			<td><input name = "sixmonthsteadrate"/></td>
			<td><input name = "firstemploymonincome"/></td>
			<td><input name = "venturerate"/></td>
			<td><input name = "stateown"/></td>
			<td><input name = "privateown"/></td>
			<td><input name = "foreignown"/></td>
			<td><input name = "one"/></td>
			<td><input name = "two"/></td>
			<td><input name = "three"/></td>
			<td><input name = "soldier"/></td>
			<td><input name = "collegeentance"/></td>
			<td><input name = "couterpart"/></td>
			<td><input name = "oneyearinner"/></td>
			<td><input name = "oneyearouter"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</form>
		</tr>
	</c:forEach>
		
	</table>
<%@include file="../footer.jspf"%>
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
<h1>质量保证：教育训练</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>参加区县级培训专任教师数</td>
		<td>参加区县级培训人均课时数</td>
		<td>参加市级培训专任教师数</td>
		<td>参加市级培训人均课时数</td>
		<td>参加省级培训专任教师数</td>
		<td>参加省级培训人均课时数</td>
		<td>参加国家级培训专任教师数</td>
		<td>参加国家级培训人均课时数</td>
		<td>参加国外培训专任教师数</td>
		<td>参加国外培训人均课时数</td>
		<td>参加境外培训专任教师数</td>
		<td>参加境外培训人均课时数</td>
		<td>教师参加学历提升获得毕业证书人数</td>
		<td>用于教师培养培训经费占学校公用经费的比例</td>
		<td>教师参加国家级教学或技能大赛人数</td>
		<td>其中一等奖获得人数</td>
		<td>其中二等奖获得人数</td>
		<td>其中三等奖获得人数</td>
		<td>教师参加省级教学或技能大赛人数</td>
		<td>其中一等奖获得人数</td>
		<td>其中二等奖获得人数</td>
		<td>其中三等奖获得人数</td>
		<td>教师参加市级教学或技能大赛人数</td>
		<td>其中一等奖获得人数</td>
		<td>其中二等奖获得人数</td>
		<td>其中三等奖获得人数</td>
		
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.DistTrainFullTea}</td>
			<td>${li.DistTrainHour}</td>
			<td>${li.CityTrainFullTea}</td>
			<td>${li.CityTrainHour}</td>
			<td>${li.ProvinTrainFullTea}</td>
			<td>${li.ProvinTrainHour}</td>
			<td>${li.StateTrainFullTea}</td>
			<td>${li.StateTrainHour}</td>
			<td>${li.StateOuterTrain}</td>
			<td>${li.StateOuterHour}</td>
			<td>${li.AbroadTrain}</td>
			<td>${li.AbroadHour}</td>
			<td>${li.Diploma}</td>
			<td>${li.TainFundPer}</td>
			<td>${li.StateSkillWinTime}</td>
			<td>${li.StateFirstAward}</td>
			<td>${li.StateSecondAward}</td>
			<td>${li.StateThridAward}</td>
			<td>${li.ProvinSkillWinTime}</td>
			<td>${li.ProvinFirstAward}</td>
			<td>${li.ProvinSecondAward}</td>
			<td>${li.ProvinThirdAward}</td>
			<td>${li.CitySkillWinTime}</td>
			<td>${li.CityFirstAward}</td>
			<td>${li.CitySecondAward}</td>
			<td>${li.CityThirdAward}</td>
			
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
			<td><input name="Admcode"/></td>
			<td><input name="Year"/></td>

			<td><input name ="DistTrainFullTea"/></td>
			<td><input name ="DistTrainHour"/></td>
			<td><input name ="CityTrainFullTea"/></td>
			<td><input name ="CityTrainHour"/></td>
			<td><input name ="ProvinTrainFullTea"/></td>
			<td><input name ="ProvinTrainHour"/></td>
			<td><input name ="StateTrainFullTea"/></td>
			<td><input name ="StateTrainHour"/></td>
			<td><input name ="StateOuterTrain"/></td>
			<td><input name ="StateOuterHour"/></td>
			<td><input name ="AbroadTrain"/></td>
			<td><input name ="AbroadHour"/></td>
			<td><input name ="Diploma"/></td>
			<td><input name ="TainFundPer"/></td>
			<td><input name ="StateSkillWinTime"/></td>
			<td><input name ="StateFirstAward"/></td>
			<td><input name ="StateSecondAward"/></td>
			<td><input name ="StateThridAward"/></td>
			<td><input name ="ProvinSkillWinTime"/></td>
			<td><input name ="ProvinFirstAward"/></td>
			<td><input name ="ProvinSecondAward"/></td>
			<td><input name ="ProvinThirdAward"/></td>
			<td><input name ="CitySkillWinTime"/></td>
			<td><input name ="CityFirstAward"/></td>
			<td><input name ="CitySecondAward"/></td>
			<td><input name ="CityThirdAward"/></td>

			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
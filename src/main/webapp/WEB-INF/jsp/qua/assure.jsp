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
<h1>基础情况：信息化建设</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>校领导人均听课课时数</td>
		<td>校领导人均上课课时数</td>
		<td>教师教学质量考核-优秀比例</td>
		<td>教师教学质量考核-合格比例</td>
		<td>教师教学质量考核-不合格比例</td>
		<td>国家级课题立项数</td>
		<td>省级课题立项数</td>
		<td>市级课题立项数</td>
		<td>市级文化课检测语文课合格率</td>
		<td>市级文化课检测数学课合格率</td>
		<td>市级文化课检测外语合格率</td>
		<td>学生参加国家级技能大赛人数</td>
		<td>其中一等奖获得人数</td>
		<td>其中二等奖获得人数</td>
		<td>其中三等奖获得人数</td>
		<td>学生参加省级技能大赛人数</td>
		<td>其中一等奖获得人数</td>
		<td>其中二等奖获得人数</td>
		<td>其中三等奖获得人数</td>
		<td>学生参加市级技能大赛人数</td>
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
			
			<td>${li.LeaderListen}</td>
			<td>${li.LeaderTalk}</td>
			<td>${li.SchoolWell}</td>
			<td>${li.SchoolGood}</td>
			<td>${li.SchoolBad}</td>
			<td>${li.StateClass}</td>
			<td>${li.ProvinClass}</td>
			<td>${li.CityClass}</td>
			<td>${li.Chinese}</td>
			<td>${li.Math}</td>
			<td>${li.English}</td>
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

			<td><input name="LeaderListen"/></td>
			<td><input name="LeaderTalk"/></td>
			<td><input name="SchoolWell"/></td>
			<td><input name="SchoolGood"/></td>
			<td><input name="SchoolBad"/></td>
			<td><input name="StateClass"/></td>
			<td><input name="ProvinClass"/></td>
			<td><input name="CityClass"/></td>
			<td><input name="Chinese"/></td>
			<td><input name="Math"/></td>
			<td><input name="English"/></td>
			<td><input name="StateSkillWinTime"/></td>
			<td><input name="StateFirstAward"/></td>
			<td><input name="StateSecondAward"/></td>
			<td><input name="StateThridAward"/></td>
			<td><input name="ProvinSkillWinTime"/></td>
			<td><input name="ProvinFirstAward"/></td>
			<td><input name="ProvinSecondAward"/></td>
			<td><input name="ProvinThirdAward"/></td>
			<td><input name="CitySkillWinTime"/></td>
			<td><input name="CityFirstAward"/></td>
			<td><input name="CitySecondAward"/></td>
			<td><input name="CityThirdAward"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
<!-- 
<td>校领导人均听课课时数</td>
<td>校领导人均上课课时数</td>
<td>教师教学质量考核-优秀比例</td>
<td>教师教学质量考核-合格比例</td>
<td>教师教学质量考核-不合格比例</td>
<td>国家级课题立项数</td>
<td>省级课题立项数</td>
<td>市级课题立项数</td>
<td>市级文化课检测语文课合格率</td>
<td>市级文化课检测数学课合格率</td>
<td>市级文化课检测外语合格率</td>
<td>学生参加国家级技能大赛人数</td>
<td>其中一等奖获得人数</td>
<td>其中二等奖获得人数</td>
<td>其中三等奖获得人数</td>
<td>学生参加省级技能大赛人数</td>
<td>其中一等奖获得人数</td>
<td>其中二等奖获得人数</td>
<td>其中三等奖获得人数</td>
<td>学生参加市级技能大赛人数</td>
<td>其中一等奖获得人数</td>
<td>其中二等奖获得人数</td>
<td>其中三等奖获得人数</td>


<td>${li.LeaderListen}</td>
<td>${li.LeaderTalk}</td>
<td>${li.SchoolWell}</td>
<td>${li.SchoolGood}</td>
<td>${li.SchoolBad}</td>
<td>${li.StateClass}</td>
<td>${li.ProvinClass}</td>
<td>${li.CityClass}</td>
<td>${li.Chinese}</td>
<td>${li.Math}</td>
<td>${li.English}</td>
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

@RequestParam String LeaderListen,
@RequestParam String LeaderTalk,
@RequestParam String SchoolWell,
@RequestParam String SchoolGood,
@RequestParam String SchoolBad,
@RequestParam String StateClass,
@RequestParam String ProvinClass,
@RequestParam String CityClass,
@RequestParam String Chinese,
@RequestParam String Math,
@RequestParam String English,
@RequestParam String StateSkillWinTime,
@RequestParam String StateFirstAward,
@RequestParam String StateSecondAward,
@RequestParam String StateThridAward,
@RequestParam String ProvinSkillWinTime,
@RequestParam String ProvinFirstAward,
@RequestParam String ProvinSecondAward,
@RequestParam String ProvinThirdAward,
@RequestParam String CitySkillWinTime,
@RequestParam String CityFirstAward,
@RequestParam String CitySecondAward,
@RequestParam String CityThirdAward,

 -->
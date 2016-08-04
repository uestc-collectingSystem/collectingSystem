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
		
		<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name="admcode"/></td>
			<td><input name="year"/></td>
			<td><input name="leaderlisten"/></td>
			<td><input name="leadertalk"/></td>
			<td><input name="schoolwell"/></td>
			<td><input name="schoolgood"/></td>
			<td><input name="schoolbad"/></td>
			<td><input name="stateclass"/></td>
			<td><input name="provinclass"/></td>
			<td><input name="cityclass"/></td>
			<td><input name="chinese"/></td>
			<td><input name="math"/></td>
			<td><input name="english"/></td>
			<td><input name="stateskillwintime"/></td>
			<td><input name="statefirstaward"/></td>
			<td><input name="statesecondaward"/></td>
			<td><input name="statethridaward"/></td>
			<td><input name="provinskillwintime"/></td>
			<td><input name="provinfirstaward"/></td>
			<td><input name="provinsecondaward"/></td>
			<td><input name="provinthirdaward"/></td>
			<td><input name="cityskillwintime"/></td>
			<td><input name="cityfirstaward"/></td>
			<td><input name="citysecondaward"/></td>
			<td><input name="citythirdaward"/></td>
			<td><input type="submit" value="确定"/></td>
		</form>
		</tr>
	</c:forEach>
		
	</table>
<%@include file="../footer.jspf"%>
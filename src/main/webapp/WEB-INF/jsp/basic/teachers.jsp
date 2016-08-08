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
		
		<td>教职工总人数</td>
		<td>教职工编制数</td>
		<td>在编教职工数</td>
		<td>专任教师数</td>
		<td>其中公共基础课专任教师数</td>
		<td>其中专业课专任教师数</td>
		<td>行业企业兼职教师数</td>
		<td>本科以下学历专任教师数</td>
		<td>本科学历专任教师数</td>
		<td>具有研究生学历或学位的专任教师数</td>
		<td>高级职称专任教师数</td>
		<td>中级职称专任教师数</td>
		<td>初级职称专任教师数</td>
		<td>未评职称专任教师数</td>
		<td>35岁及以下专任教师数</td>
		<td>36~45 岁专任教师数</td>
		<td>46~55 岁专任教师数</td>
		<td>56 岁及以上专任教师数</td>
		<td>男教师数</td>
		<td>女教师数</td>
		<td>双师型教师数</td>
		<td>专任教师课平均每周课时数</td>
		<td>专业课教师平均每周课时数</td>
		<td>行业企业兼职教师课时总量</td>
		<td>持有心理咨询证书的教师数</td>
		<td>专职心理咨询教师数</td>
		<td>市(州)级以上学科带头人教师数</td>
		<td>省特级教师数</td>
		<td>实践教学专职指导教师数</td>
		<td>外籍教师数量</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
		</thread>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.StaffNum}</td>
			<td>${li.StaffAdmin}</td>
			<td>${li.StaffPrepJob}</td>
			<td>${li.FullTime}</td>
			<td>${li.BasicCourse}</td>
			<td>${li.Course}</td>
			<td>${li.IndustryEnterprise}</td>
			<td>${li.UndergraLess}</td>
			<td>${li.Undergra}</td>
			<td>${li.FullPostgrad}</td>
			<td>${li.SubHighMore}</td>
			<td>${li.IntermediateGrade}</td>
			<td>${li.JuniorTitle}</td>
			<td>${li.NoConferTeac}</td>
			<td>${li.ThreeFiveLess}</td>
			<td>${li.ThreeSixFourFive}</td>
			<td>${li.FourSixFiveFive}</td>
			<td>${li.FiveSixMore}</td>
			<td>${li.Male}</td>
			<td>${li.Female}</td>
			<td>${li.DoubleTeac}</td>
			<td>${li.FullClassHour}</td>
			<td>${li.CourseClassHour}</td>
			<td>${li.InduEnterHour}</td>
			<td>${li.CounselCertificate}</td>
			<td>${li.FulltimeCounsel}</td>
			<td>${li.CityDiscipLeader}</td>
			<td>${li.ProvSuper}</td>
			<td>${li.ExerProTeac}</td>
			<td>${li.ForeignTeac}</td>
			
			
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
				<td><input name="Admcode" value='${li.Admcode}'/></td>
				<td><input name="Year" value='${li.Year}'/></td>
				
				<td><input name="staffnum"/></td>
				<td><input name="staffadmin"/></td>
				<td><input name="staffprepjob"/></td>
				<td><input name="fulltime"/></td>
				<td><input name="basiccourse"/></td>
				<td><input name="course"/></td>
				<td><input name="industryenterprise"/></td>
				<td><input name="undergraless"/></td>
				<td><input name="undergra"/></td>
				<td><input name="fullpostgrad"/></td>
				<td><input name="subhighmore"/></td>
				<td><input name="intermediategrade"/></td>
				<td><input name="juniortitle"/></td>
				<td><input name="noconferteac"/></td>
				<td><input name="threefiveless"/></td>
				<td><input name="threesixfourfive"/></td>
				<td><input name="foursixfivefive"/></td>
				<td><input name="fivesixmore"/></td>
				<td><input name="male"/></td>
				<td><input name="female"/></td>
				<td><input name="doubleteac"/></td>
				<td><input name="fullclasshour"/></td>
				<td><input name="courseclasshour"/></td>
				<td><input name="induenterhour"/></td>
				<td><input name="counselcertificate"/></td>
				<td><input name="fulltimecounsel"/></td>
				<td><input name="citydiscipleader"/></td>
				<td><input name="provsuper"/></td>
				<td><input name="exerproteac"/></td>
				<td><input name="foreignteac"/></td>
				
				<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>
	
	</table>
<%@include file="../footer.jspf"%>
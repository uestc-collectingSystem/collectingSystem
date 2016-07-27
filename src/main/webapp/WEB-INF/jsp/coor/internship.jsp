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

<h1>校企：合作情况</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		<td>校外学生实训基地数</td>
		<td>生均认识实习时长（天）</td>
		<td>生均跟岗实习时长（天）</td>
		<td>生均顶岗实习时长（天）</td>
		<td>学生跟岗实习对口率</td>
		<td>学生顶岗实习对口率</td>
		<td>企业对学生顶岗实习考核结果（优秀）比例</td>
		<td>企业对学生顶岗实习考核结果（良好）比例</td>
		<td>企业对学生顶岗实习考核结果（合格）比例</td>
		<td>企业对学生顶岗实习考核结果（不合格）比例</td>
		<td>合作企业接收学生就业比例</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.OffCamptTrainBase}</td>
			<td>${li.KownDuration}</td>
			<td>${li.PostDuration}</td>
			<td>${li.DisplaceDuration}</td>
			<td>${li.StuPostPartRadio}</td>
			<td>${li.StuDisPartRadio}</td>
			<td>${li.EnterpAssessDisOpt}</td>
			<td>${li.EnterpAssessDisGood}</td>
			<td>${li.EnterpAssessDisInter}</td>
			<td>${li.EnterpAssessDisBad}</td>
			<td>${li.CoopEnterpEmployStud}</td>
			
			
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

			<td><input name ="OffCamptTrainBase"/></td>
			<td><input name ="KownDuration"/></td>
			<td><input name ="PostDuration"/></td>
			<td><input name ="DisplaceDuration"/></td>
			<td><input name ="StuPostPartRadio"/></td>
			<td><input name ="StuDisPartRadio"/></td>
			<td><input name ="EnterpAssessDisOpt"/></td>
			<td><input name ="EnterpAssessDisGood"/></td>
			<td><input name ="EnterpAssessDisInter"/></td>
			<td><input name ="EnterpAssessDisBad"/></td>
			<td><input name ="CoopEnterpEmployStud"/></td>
			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>

</body>
</html>
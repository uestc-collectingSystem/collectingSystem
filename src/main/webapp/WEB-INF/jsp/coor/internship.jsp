<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../header.jspf"%>
	<table border="1" class = "id_22">
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
		<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name ="admcode"/></td>
			<td><input name ="year"/></td>

			<td><input name ="offcampttrainbase"/></td>
			<td><input name ="kownduration"/></td>
			<td><input name ="postduration"/></td>
			<td><input name ="displaceduration"/></td>
			<td><input name ="stupostpartradio"/></td>
			<td><input name ="studispartradio"/></td>
			<td><input name ="enterpassessdisopt"/></td>
			<td><input name ="enterpassessdisgood"/></td>
			<td><input name ="enterpassessdisinter"/></td>
			<td><input name ="enterpassessdisbad"/></td>
			<td><input name ="coopenterpemploystud"/></td>
			<td><input type="submit" value="确定"/></td>
		</tr>
		</form>
	</c:forEach>
	</table>
<%@include file="../footer.jspf"%>
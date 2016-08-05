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
		
		<td>本校牵头组织的职教集团数</td>
		<td>本校参与的职教集团数</td>
		<td>参加本校牵头的职教集团学校数</td>
		<td>参加本校牵头的职教集团企业数</td>
		<td>参加本校牵头的职教集团专业数</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.LeadVocEduGroup}</td>
			<td>${li.JoinVocEduGroup}</td>
			<td>${li.JoinLeadVocEduGroupScho}</td>
			<td>${li.JoinLeadVocEduGroupEnterp}</td>
			<td>${li.JoinLeadVocEduGroupMajor}</td>
			
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

			<td><input name = "leadvocedugroup"/></td>
			<td><input name = "joinvocedugroup"/></td>
			<td><input name = "joinleadvocedugroupscho"/></td>
			<td><input name = "joinleadvocedugroupenterp"/></td>
			<td><input name = "joinleadvocedugroupmajor"/></td>
			<td><input type="submit" value="确定"/></td>
		</tr>
		</form>
	</c:forEach>
	</table>
<%@include file="../footer.jspf"%>
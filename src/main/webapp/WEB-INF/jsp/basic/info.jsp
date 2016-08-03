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
		
		<td>是否设立教育信息是否设立教育信息化技术中心(0：没有，1：有)</td>
		<td>服务器台数</td>
		<td>校园网络出口总带宽(bps)</td>
		<td>校园网主干带宽(bps)</td>
		<td>生均数字教学视频资源量(小时/生)</td>
		<td>生均电子图书总量(册/生)</td>
		<td>教学用计算机台数</td>
		<td>生均教学用计算机台数</td>
		<td>网络多媒体教室数</td>
		<td>上网课程总量</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>
				<c:if test="${li.Audit==0}">设立</c:if>
				<c:if test="${li.Audit==1}">未设立</c:if>
			</td>
			<td>${li.Server}</td>
			<td>${li.NetworkNum}</td>
			<td>${li.NetworkMain}</td>
			<td>${li.VideoStu}</td>
			<td>${li.ElecBookStu}</td>
			<td>${li.TeacComputer}</td>
			<td>${li.TeacCompStu}</td>
			<td>${li.NetMediaRoom}</td>
			<td>${li.NetClassCount}</td>
			
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
				<td><input name="Admcode" value="${li.Admcode}"/></td>
				<td><input name="Year" value="${li.Year}"/></td>
	
				<td><input name="educateinfo"/></td>
				<td><input name="server"/></td>
				<td><input name="networknum"/></td>
				<td><input name="networkmain"/></td>
				<td><input name="videostu"/></td>
				<td><input name="elecbookstu"/></td>
				<td><input name="teaccomputer"/></td>
				<td><input name="teaccompstu"/></td>
				<td><input name="netmediaroom"/></td>
				<td><input name="netclasscount"/></td>
				
				<td>
					<c:if test="${li.Audit==0}"><input type="submit"/></c:if>
					<c:if test="${li.Audit==1}">信息已通过审批</c:if>
				</td>
			</form>
		</tr>
	</c:forEach>
	</table>
<%@include file="../footer.jspf"%>
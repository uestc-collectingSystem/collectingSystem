<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../header.jspf"%>
	<!-- 表2 用于显示 informant内容 -->
	<table border="1" class = "id_22">
	<thead>
			<th>用户工号</th>
			<th>用户姓名</th>
			<th>用户职务</th>
			<th>用户职位</th>
			<th>用户电话</th>
			<th>用户邮箱</th>
	</thead>
	<c:forEach items="${informantList}" var = "informant">
		<tr>
			<td>${informant.Usercode}</td>
			<td>${informant.Name}</td>
			<td>${informant.Post}</td>
			<td>${informant.Position}</td>
			<td>${informant.TelNumber}</td>
			<td>${informant.Mailbox}</td>
		</tr>
	</c:forEach>
	</table>

<%@include file="../footer.jspf"%>
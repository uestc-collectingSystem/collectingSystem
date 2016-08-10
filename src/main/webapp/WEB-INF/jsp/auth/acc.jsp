<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../header.jspf"%>
<table border="1" class = "id_22">
<thead>
	<th>工号</th>
	<th>密码</th>
	<th>学校名</th>
</thead>
<tr>
<td>${me.usercode}</td>
<td>${me.password}</td>
<td>${me.schoolname}</td>
</tr>
<tr class="hidden">
	<form action="./update" method="POST" onsubmit="return check(this)">
		<input name="id" type="hidden" value='${me.id}'/>
		<td>不可修改</td>
		<td><input name ="password"/></td>
		<td><input name ="schoolname"/></td>
		<td><input type="submit" value="确定"/></td>
	</form>
</tr>
</table>
<%@include file="../footer.jspf"%>
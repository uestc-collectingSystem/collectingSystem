<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../header.jspf"%>
	<table border="1" class = "id_22">
		<thead>
			<td>用户工号</td>
			<td>用户姓名</td>
			<td>用户职务</td>
			<td>用户职位</td>
			<td>用户电话</td>
			<td>用户邮箱</td>
		</thead>
		<tr>
			<td>${li.usercode}</td>
			<td>${li.name}</td>
			<td>${li.post}</td>
			<td>${li.position}</td>
			<td>${li.telnumber}</td>
			<td>${li.mailbox}</td>
		</tr>
		<tr class="hidden">
			<form action="./update" method="POST" onsubmit="return check(this)">
				<input name="id" type="hidden" value='${li.id}'/>
				<input name="usercode" type="hidden" value='${li.usercode}'/>
				<td>不可更改</td>
				<td><input name ="name"/></td>
				<td><input name ="post"/></td>
				<td><input name ="position"/></td>
				<td><input name ="telnumber"/></td>
				<td><input name ="mailbox"/></td>
				<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</table>
<%@include file="../footer.jspf"%>
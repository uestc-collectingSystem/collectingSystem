<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="./common.jspf"%>
<tbody>
<tr>
<td>工号</td>
<td><input class="id_28" name = "usercode"/></td>
</tr>
<td>密码</td>
<td><input class="id_28" name="password"/></td>
</tr>
<td>身份等级</td>
<td><input name="level" value="1" style="visibility: hidden;"/>
<select onchange="this.parentNode.children[0].value=this.value">
  <option value="1">录入员</option>
  <option value ="2">检查员</option>
  <option value ="3">管理员</option>
</select></td>
</tr>
<td>学校名称</td>
<td><input class="id_28" name="schoolname"/></td>
</tr>
<%@include file="./tail.jspf"%>
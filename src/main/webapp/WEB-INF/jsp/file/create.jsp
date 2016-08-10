<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../header.jspf"%>

<form action="./create" enctype="multipart/form-data" method="post">  
	<li>上传时间（年）：<input type="text" class="file" name="writeTime"/></li>
    <li>文件名：<input type="text" class="file" name="name"/></li>
    <li>上传人：<input type="text" class="file" name="writer"/></li>
    <li>模块名：<input type="hidden" class="file" name="source" value="${path}"/></li>
    
    <div id="upload">
        <input type="file" name="file"/>
    </div><!-- 想加 js 自己加,用 jQuery 增加行数可以做到多文件上传 -->
        	
        <input type="submit" value="上传"/>
</form>
<%@include file="../footer.jspf"%>
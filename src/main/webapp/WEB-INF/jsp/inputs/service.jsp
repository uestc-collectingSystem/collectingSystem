<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="./common.jspf"%>
<tbody>
<td>
<li>学校代码</li>
<li>录入年份</li>

<li>培训企业员工数</li>
<li>培训残疾人人数</li>
<li>培训失业人员人数</li>
<li>培训农民工人数</li>
<li>培训退役士兵人数</li>
<li>技能鉴定项目人次</li>
<li>师生参与当地技术服务才次</li>
</td>
<td>
<li><input class="id_28" name ="Admcode"/></li></br>
<li><input class="id_28" name ="Year"/></li></br>

<li><input class="id_28" name = "TrainStaff"/></li></br>
<li><input class="id_28" name = "TrainUnabled"/></li></br>
<li><input class="id_28" name = "TrainUnemStaff"/></li></br>
<li><input class="id_28" name = "TrainFarmer"/></li></br>
<li><input class="id_28" name = "TrainRetireSoldier"/></li></br>
<li><input class="id_28" name = "SkillIdentNum"/></li></br>
<li><input class="id_28" name = "TeachServe"/></li></br>
</td>

<%@include file="./tail.jspf"%>
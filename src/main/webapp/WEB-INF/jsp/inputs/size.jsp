<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据采集系统</title>
<link href="../../../static/css/sjcj.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="id_25">
	<div class="id_26">
	<form id = "test" action="../test" method="POST">
		<table class="id_27">
		   <tbody>
				<tr><th scope="row">学校代码</th>
				<td><input class="id_28" name="Admcode"/></td>
				</tr>
				<tr><th scope="row">年份</th>
				<td><input class="id_28" name="Year"/></td>
				</tr>
				<tr><th scope="row">办学性质</th>
				<td><input class="id_28" name = "SchoolRun"/></td>
				</tr>
				<tr><th scope="row">办学水平</th>
				<td><input class="id_28" name = "SchoolLevel"/></td>
				</tr>
				<tr><th scope="row">办学主体</th>
				<td><input class="id_28" name = "SchoolSubject"/></td>
				</tr>
				<tr><th scope="row">学校占地面积</th>
				<td><input class="id_28" name = "Area"/></td>
				</tr>
				<tr><th scope="row">自有产权占地面积</th>
				<td><input class="id_28" name = "OwnPropArea"/></td>
				</tr>
				<tr><th scope="row">总建筑面积</th>
				<td><input class="id_28" name = "TotalArea"/></td>
				</tr>
				<tr><th scope="row">学校自有产权建筑面积</th>
				<td><input class="id_28" name = "SchOwnConArea"/></td>
				</tr>
				<tr><th scope="row">行政办公用房面积</th>
				<td><input class="id_28" name = "OfficeArea"/></td>
				</tr>
				<tr><th scope="row">生均建筑面积</th>
				<td><input class="id_28" name = "StuArea"/></td>
				</tr>
				<tr><th scope="row">教学及辅助用房面积</th>
				<td><input class="id_28" name = "TeaAuxArea"/></td>
				</tr>
				<tr><th scope="row">校内实训用房面积</th>
				<td><input class="id_28" name = "TrainArea"/></td>
				</tr>
				<tr><th scope="row">心理咨询室建筑面积</th>
				<td><input class="id_28" name = "PsyArea"/></td>
				</tr>
				<tr><th scope="row">学生宿舍面积</th>
				<td><input class="id_28" name = "DormArea"/></td>
				</tr>
				<tr><th scope="row">生均宿舍面积</th>
				<td><input class="id_28" name = "DormPerArea"/></td>
				</tr>
				<tr><th scope="row">在校生数</th>
				<td><input class="id_28" name = "TotalStudent"/></td>
				</tr>
				<tr><th scope="row">毕业生数</th>
				<td><input class="id_28" name = "AnnualGraduate"/></td>
				</tr>
				<tr><th scope="row">三年巩固率</th>
				<td><input class="id_28" name = "ConsolidationRate"/></td>
				</tr>
				<tr><th scope="row">当年招生总数</th>
				<td><input class="id_28" name = "Enrollment"/></td>
				</tr>
				<tr><th scope="row">专业数</th>
				<td><input class="id_28" name = "Majors"/></td>
				</tr>
		   </tbody>
		</table>
	    <div class="id_29"><input class="id_30" type="button" value="取消">
	    <input class="id_31" type="submit" value="提交"></div>
	    </form>
	</div>
</div>
<!-- <script>
total = document.documentElement.clientHeight;
colHeight = total-document.getElementById("id_25").offsetTop;
document.getElementById("id_25").style.height=colHeight+"px";
</script> -->
</body>
</html>
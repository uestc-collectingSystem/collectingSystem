<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>数据录入部分</title>
</head>
<body>
<h1>校企：合作情况</h1>
	<h2>错误信息：${ErrorMsg}</h2>
	
	<form action="./create" method="POST">
	<table border="1">
		<tr>
		<td>学校代码</td>
		<td>录入年份</td>
		
		 
		<td>校企合作覆盖专业数</td>
		<td>签订合作协议的企业数</td>
		<td>签订合作协议的专业数</td>
		<td>合作企业参与教学的专业数</td>
		<td>合作企业参与的教学教师数</td>
		<td>合作企业参与教学课时数</td>
		<td>合作企业投入资金总额</td>
		<td>合作企业投入到账资金</td>
		<td>合作企业投入设备总值</td>
		<td>与企业共建研发中心数</td>
		<td>校外教师培训基地数</td>
		<td>生产性实训基地产值</td>
		<td>校企合作订单班人数</td>
		<td>校企合作开发课程数</td>
		<td>专任教师企业实习实践人次</td>
		<td>专任教师人均企业实习实践时间（天）</td>
		<td>企业兼职教师专业课课时占比</td>
		<td>接收顶岗实习学生比例 </td>
		<td>录取应届毕业生比例  </td>
		<td>校企合作研发成果产值</td>
		<td>年支付企业兼职教师课酬（万元） </td>
		<td>企业捐赠总值（万元）</td>
		<td>校外实践教学基地数量</td>
		
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.MajorNum}</td>
			<td>${li.CoopAgreeEnterp}</td>
			<td>${li.CoopAgreeMajor}</td>
			<td>${li.CoopEnterpJoinTeachMajor}</td>
			<td>${li.CoopEnterpJoinTeachTeacher}</td>
			<td>${li.CoopEnterpJoinTeachClass}</td>
			<td>${li.CoopEnterpFund}</td>
			<td>${li.CoopEnterpArrivalFund}</td>
			<td>${li.CoopEnterpEquitWorth}</td>
			<td>${li.EnterpBuildReseaDevelop}</td>
			<td>${li.OffSchoTeacherTrainBase}</td>
			<td>${li.ProdTrainBaseVal}</td>
			<td>${li.SchoEnterpCoopOrderClassNum}</td>
			<td>${li.SchoEnterpDevelopCourse}</td>
			<td>${li.FullEnterPrac}</td>
			<td>${li.FullEnterTime}</td>
			<td>${li.PartTimeClassRadio}</td>
			<td>${li.BookPublishCount}</td>
			<td>${li.FullTimeStu}</td>
			<td>${li.GraduEnterRate}</td>
			<td>${li.DevelopeIncomeCount}</td>
			<td>${li.TeacOutcomeCount}</td>
			<td>${li.CoopDonateCount}</td>
			<td>${li.ExperBaseCount}</td>
			
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
	</c:forEach>
		<tr>
			<td><input name="Admcode"/></td>
			<td><input name="Year"/></td>

			<td><input name ="MajorNum"/></td>
			<td><input name ="CoopAgreeEnterp"/></td>
			<td><input name ="CoopAgreeMajor"/></td>
			<td><input name ="CoopEnterpJoinTeachMajor"/></td>
			<td><input name ="CoopEnterpJoinTeachTeacher"/></td>
			<td><input name ="CoopEnterpJoinTeachClass"/></td>
			<td><input name ="CoopEnterpFund"/></td>
			<td><input name ="CoopEnterpArrivalFund"/></td>
			<td><input name ="CoopEnterpEquitWorth"/></td>
			<td><input name ="EnterpBuildReseaDevelop"/></td>
			<td><input name ="OffSchoTeacherTrainBase"/></td>
			<td><input name ="ProdTrainBaseVal"/></td>
			<td><input name ="SchoEnterpCoopOrderClassNum"/></td>
			<td><input name ="SchoEnterpDevelopCourse"/></td>
			<td><input name ="FullEnterPrac"/></td>
			<td><input name ="FullEnterTime"/></td>
			<td><input name ="PartTimeClassRadio"/></td>
			<td><input name ="BookPublishCount"/></td>
			<td><input name ="FullTimeStu"/></td>
			<td><input name ="GraduEnterRate"/></td>
			<td><input name ="DevelopeIncomeCount"/></td>
			<td><input name ="TeacOutcomeCount"/></td>
			<td><input name ="CoopDonateCount"/></td>
			<td><input name ="ExperBaseCount"/></td>

			 
			<td><input type="submit" value="确定"/></td>
		</tr>
	</table>
</form>
</body>
</html>
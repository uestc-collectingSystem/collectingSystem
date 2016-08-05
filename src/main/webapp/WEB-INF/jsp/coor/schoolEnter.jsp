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
		
		<td>校企合作开发资料</td>
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
		
	<tr class="hidden">
		<form action="./update" method="POST" onsubmit="return check(this)">
			<input name="id" type="hidden" value='${li.ID}'/>
			<td><input name="admcode"/></td>
			<td><input name="year"/></td>

			<td><input name ="majornum"/></td>
			<td><input name ="coopagreeenterp"/></td>
			<td><input name ="coopagreemajor"/></td>
			<td><input name ="coopenterpjointeachmajor"/></td>
			<td><input name ="coopenterpjointeachteacher"/></td>
			<td><input name ="coopenterpjointeachclass"/></td>
			<td><input name ="coopenterpfund"/></td>
			<td><input name ="coopenterparrivalfund"/></td>
			<td><input name ="coopenterpequitworth"/></td>
			<td><input name ="enterpbuildreseadevelop"/></td>
			<td><input name ="offschoteachertrainbase"/></td>
			<td><input name ="prodtrainbaseval"/></td>
			<td><input name ="schoenterpcooporderclassnum"/></td>
			<td><input name ="schoenterpdevelopcourse"/></td>
			<td><input name ="fullenterprac"/></td>
			<td><input name ="fullentertime"/></td>
			<td><input name ="parttimeclassradio"/></td>
			<td><input name ="bookpublishcount"/></td>
			<td><input name ="fulltimestu"/></td>
			<td><input name ="graduenterrate"/></td>
			<td><input name ="developeincomecount"/></td>
			<td><input name ="teacoutcomecount"/></td>
			<td><input name ="coopdonatecount"/></td>
			<td><input name ="experbasecount"/></td>

			 
			<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>
		
	</table>

<%@include file="../footer.jspf"%>
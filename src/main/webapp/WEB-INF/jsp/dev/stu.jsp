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
		
		<td>文档里面没说是个啥字段</td>
		<td>德育教材配备是否使用国家规范化教材</td>
		<td>是否设立了心理辅导中心或心理咨询室</td>
		<td>德育先进单位</td>
		<td>教育部德育实验基地</td>
		<td>四川省校风示范校</td>
		<td>四川省中等职业学校内务管理示范校</td>
		<td>青年志愿者先进集体</td>
		<td>红旗团委</td>
		<td>其他德育相关荣誉(市级及以上)</td>
		<td>省级以上优秀班级数</td>
		<td>专职德育工作人员数</td>
		<td>各级德育课题立项数</td>
		<td>德育课教师数量</td>
		<td>德育课教师专业对口率</td>
		<td>班级每周德育课课时数</td>
		<td>德育校本教材开发数</td>
		<td>学生操行考核优的比例</td>
		<td>学生操行考核良的比例</td>
		<td>学生操行考核中的比例</td>
		<td>学生操行考核差的比例</td>
		<td>接受心理咨询的学生占比</td>
		<td>省级优秀毕业生数</td>
		<td>省级优秀干部数</td>
		<td>省级优秀三好学生数</td>
		<td>其他(省级以上)</td>
		<td>年度校园暴力事件次数</td>
		<td>学生犯罪人次</td>
		<td>严重违纪学生数</td>
		<td>积极申请入团学生数</td>
		<td>积极申请入党学生数</td>
		<td>社会志愿服务活动人次</td>
		<td>社会实践活动参与次数(生/年)</td>
		<td>学生社团数量</td>
		<td>学生参与社团人数</td>
		<td>学生参加文明风采大赛获奖人数(国家级)</td>
		<td>学生参加文明风采大赛获奖人数(省级)</td>
		<td>学生参加文明风采大赛获奖人数(市级)</td>
		<td>参与国家级技能竞赛获得一等奖人数</td>
		<td>参与国家级技能竞赛获得二等奖人数</td>
		<td>参与国家级技能竞赛获得三等奖人数</td>
		<td>参与省级技能竞赛获得一等奖人数</td>
		<td>参与省级技能竞赛获得二等奖人数</td>
		<td>参与省级技能竞赛获得三等奖人数</td>
		<td>参与市级技能竞赛获得一等奖人数</td>
		<td>参与市级技能竞赛获得二等奖人数</td>
		<td>参与市级技能竞赛获得三等奖人数</td>
		<td>一年级巩固率</td>
		<td>二年级巩固率</td>
		<td>三年级巩固率</td>
		<td>文化课合格率</td>
		<td>体质测评合格率</td>
		<td>专业技能合格率</td>
		<td>职业资格证书数</td>
		<td>双证书获取率</td>
		<td>毕业率</td>
		
		<td>审核状态</td>
		<td>删除记录</td>
		<td>通过审核</td>
		</tr>
	<c:forEach items="${list}" var="li">
		<tr>
			<td>${li.Admcode}</td>
			<td>${li.Year}</td>
			
			<td>${li.WorkFundPercent}</td>
			<td>${li.MoralEquit}</td>
			<td>${li.PhyCenter}</td>
			<td>${li.Advanced}</td>
			<td>${li.MoralBase}</td>
			<td>${li.SchoolSpirit}</td>
			<td>${li.ManageSpirit}</td>
			<td>${li.Volunteer}</td>
			<td>${li.RedFlag}</td>
			<td>${li.OtherHonor}</td>
			<td>${li.GoodClass}</td>
			<td>${li.FulltimeMoral}</td>
			<td>${li.MoralTask}</td>
			<td>${li.MoralNum}</td>
			<td>${li.MoralPart}</td>
			<td>${li.MoralHour}</td>
			<td>${li.MoralText}</td>
			<td>${li.AssessOptimal}</td>
			<td>${li.AssessGood}</td>
			<td>${li.AssessMiddle}</td>
			<td>${li.AssessPoor}</td>
			<td>${li.PyhConselPer}</td>
			<td>${li.ProvGoodGrade}</td>
			<td>${li.ProvGoodCadre}</td>
			<td>${li.ProvGoodStud}</td>
			<td>${li.ProvOther}</td>
			<td>${li.CampusViolence}</td>
			<td>${li.CrimeRate}</td>
			<td>${li.ExamDiscip}</td>
			<td>${li.JoinOrgan}</td>
			<td>${li.JoinPraty}</td>
			<td>${li.SocailVolun}</td>
			<td>${li.SocailPrac}</td>
			<td>${li.StudentOrgan}</td>
			<td>${li.OrganStu}</td>
			<td>${li.StateCivil}</td>
			<td>${li.ProvinCivil}</td>
			<td>${li.CityCivil}</td>
			<td>${li.StateFirstAward}</td>
			<td>${li.StateSecondAward}</td>
			<td>${li.StateThirdAward}</td>
			<td>${li.ProvinFirstAward}</td>
			<td>${li.ProvinSecondAward}</td>
			<td>${li.ProvinThirdAward}</td>
			<td>${li.CityFirstAward}</td>
			<td>${li.CitySecondAward}</td>
			<td>${li.CityThirdAward}</td>
			<td>${li.OneConsol}</td>
			<td>${li.TwoConsol}</td>
			<td>${li.ThreeConsol}</td>
			<td>${li.CultDiviPassRate}</td>
			<td>${li.PhyAssessPassRate}</td>
			<td>${li.ProfSkillPassRate}</td>
			<td>${li.CareerCert}</td>
			<td>${li.DoubCert}</td>
			<td>${li.GradRate}</td>
			
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
				<td><input name="Admcode" value='${li.Admcode}'/></td>
				<td><input name="Year" value='${li.Year}'/></td>
	
				<td><input name="workfundpercent"/></td>
				<td><input name="moralequit"/></td>
				<td><input name="phycenter"/></td>
				<td><input name="advanced"/></td>
				<td><input name="moralbase" /></td>
				<td><input name="schoolspirit" /></td>
				<td><input name="managespirit" /></td>
				<td><input name="volunteer"/></td>
				<td><input name="redflag"/></td>
				<td><input name="otherhonor"/></td>
				<td><input name="goodclass"/></td>
				<td><input name="fulltimemoral"/></td>
				<td><input name="moraltask"/></td>
				<td><input name="moralnum"/></td>
				<td><input name="moralpart"/></td>
				<td><input name="moralhour"/></td>
				<td><input name="moraltext"/></td>
				<td><input name="assessoptimal"/></td>
				<td><input name="assessgood"/></td>
				<td><input name="assessmiddle"/></td>
				<td><input name="assesspoor"/></td>
				<td><input name="pyhconselper"/></td>
				<td><input name="provgoodgrade"/></td>
				<td><input name="provgoodcadre"/></td>
				<td><input name="provgoodstud"/></td>
				<td><input name="provother"/></td>
				<td><input name="campusviolence"/></td>
				<td><input name="crimerate"/></td>
				<td><input name="examdiscip"/></td>
				<td><input name="joinorgan"/></td>
				<td><input name="joinpraty"/></td>
				<td><input name="socailvolun"/></td>
				<td><input name="socailprac"/></td>
				<td><input name="studentorgan"/></td>
				<td><input name="organstu"/></td>
				<td><input name="statecivil"/></td>
				<td><input name="provincivil"/></td>
				<td><input name="citycivil"/></td>
				<td><input name="statefirstaward"/></td>
				<td><input name="statesecondaward"/></td>
				<td><input name="statethirdaward"/></td>
				<td><input name="provinfirstaward"/></td>
				<td><input name="provinsecondaward"/></td>
				<td><input name="provinthirdaward"/></td>
				<td><input name="cityfirstaward"/></td>
				<td><input name="citysecondaward"/></td>
				<td><input name="citythirdaward"/></td>
				<td><input name="oneconsol"/></td>
				<td><input name="twoconsol"/></td>
				<td><input name="threeconsol"/></td>
				<td><input name="cultdivipassrate"/></td>
				<td><input name="phyassesspassrate"/></td>
				<td><input name="profskillpassrate"/></td>
				<td><input name="careercert"/></td>
				<td><input name="doubcert"/></td>
				<td><input name="gradrate"/></td>
				 
				<td><input type="submit" value="确定"/></td>
			</form>
		</tr>
	</c:forEach>
	
		
	</table>
<%@include file="../footer.jspf"%>
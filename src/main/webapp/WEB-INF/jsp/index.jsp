<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="./common.jspf"%>
<title>数据采集系统</title>
<script type="text/javascript">

$(function(){
$('input, textarea').placeholder();
});
$(function() {
    $(".id_10");
    $(".id_08").click(function(){
        $(this).toggleClass("open").next().slideToggle("fast");
    });
});

$(document).ready(function(){
	  htmlobj=$.ajax({url:"./current",async:false});
	  $("#currentUser").html(htmlobj.responseText.replace("\"","").replace("\"",""));
	});
</script>
</head>
<body>
<div class="id_01">
<div class="id_02"></div>
<div class="id_03"><span id=currentUser></span><a href="#" id = click class="id_04">个人信息</a><a href="#" class="id_04">修改密码</a><a id="logout" href="" class="id_04">退出系统</a></div>
</div>

<div id="id_content">
<!--左边导航栏-->
<div id="id_05">
    <div class="id_06">
        <div class="id_07"></div>
        <p><span id="ctl00_Label_dept">四川省教科所</span></p>
       
    </div>
    <a href="#" class="id_08">
        <div class="icon_01"></div>
        <span>基本情况</span></a>
    <div class="id_10">
        <a id = "size" href="">规模</a>
        <a id = "equip" href="">设施设备</a>
        <a id = "teachers" href="">教师队伍</a>
        <a id = "funds" href="">经费</a>
        <a id = "info" href="">信息化建设</a>
    </div>
    <a href="#" class="id_08">
        <div class="icon_02"></div>
        <span>学生发展</span></a>
    <div class="id_10">
        <a id = "stu" href="">学生素质</a>
        <a id = "emp" href="">就业质量</a>
    </div>
    <a href="#" class="id_08">
        <div class="icon_03"></div>
        <span>质量保障措施</span></a>
    <div class="id_10">
        <a id = "" href="">专业布局</a>
        <a id = "majnum" href="">课程开设</a>
        <a id = "assure" href="">质量保证</a>
        <a id = "edu" href="">教师培养培训</a>
    </div>
    <a href="#" class="id_08">
        <div class="icon_04"></div>
        <span>校企合作</span></a>
    <div class="id_10">
        <a id="schoolEnter" href="">合作情况</a>
        <a id="internship" href="">学生实习情况</a>
        <a id="group" href="">集团化办学情况</a>
    </div>
    <a href="#" class="id_08">
        <div class="icon_05"></div>
        <span>社会贡献</span></a>
    <div class="id_10">
        <a id="skilltrain" href="">技术技能人才培养</a>
        <a id="service" href="">社会服务</a>
        <a id="support" href="">对口支援</a>
    </div>
    <a href="#" class="id_08">
        <div class="icon_06"></div>
        <span>党建工作</span></a>
    <div class="id_10">
        <a id = "party" href="">学校党建工作</a>
    </div>
    <a href="#" class="id_08">
        <div class="icon_07"></div>
        <span>资料上传</span></a>
    <div class="id_11">
        <a href="/File/MoralWork.aspx">德育工作经验措施</a>
        <a href="/File/StudentPolitical.aspx">学生思想政治状况</a>
        <a href="/File/OutstandingGraduate.aspx">优秀毕业生典型案例</a>
        <a href="/File/QualifyControl.aspx">质量监控体系建设</a>
        <a href="/File/GroupRun.aspx">学校集团化办学</a>
        <a href="/File/Culture.aspx">传统文化（地方特色）教育活动开展情况</a>
        <a href="/File/HelpPoverty.aspx">对口帮扶（扶贫）情况</a>
        <a href="/File/Innovation.aspx">特色创新</a>
        <a href="/File/PartyBuild.aspx">党建工作</a>
        <a href="File/ProblemMeasure.aspx">主要问题和改进措施</a>
    </div>
</div>
<!--右边内容区-->
	<div id="id_11">
		<!--添加删除修改-->
		<div class="id_12">
			<div class="id_13"><span>主页</span><i></i><a href="#">规模</a></div>
			<div class="id_14">
			<a href="#" class="id_15"></a><!-- 删除 -->
			<a href="#" class="id_16"></a><!-- 新增 -->
			<a href="#" class="id_17"></a><!-- 修改 -->
			<div class="id_18"><input type="text" class="id_19" placeholder="请输入年份查询"><input type="submit" value="" class="id_20"></div>
			</div>
		</div>
	</div>
</div>
<script>
total = document.documentElement.clientHeight;
colHeight = total-document.getElementById("id_05").offsetTop;
document.getElementById("id_05").style.height=colHeight+"px";
document.getElementById("id_11").style.height=colHeight+"px";
document.getElementById("id_content").style.height=colHeight+"px";
//绑定路由串
var $rootPath;
$rootPath=this.location.host;
$rootPath="http://"+$rootPath+"/collectingSystem/";
var $routeLogOut=$rootPath+"loggout/";

var $routeSize=$rootPath+"basic/size/";
var $routeFunds=$rootPath+"basic/funds/";
var $routeInfo = $rootPath+"basic/info/";
var $routeTeac = $rootPath+"basic/teacher/";
var $routeEquip = $rootPath+"basic/equip/";

var $routeEmp = $rootPath+"dev/emp/";
var $routeStu = $rootPath+"dev/stu/";

var $routeAssure = $rootPath+"qua/assure/";
var $routeEducation = $rootPath+"qua/edu/";
var $routeMajNum = $rootPath+"qua/majnum/";

var $routeGroup = $rootPath+"coor/group/";
var $routeInternship = $rootPath+"coor/internship/";
var $routeSchoolEnter = $rootPath+"coor/enterprise/";

var $routeParty = $rootPath+"social/party/";
var $routeService = $rootPath+"social/service/";
var $routeSkill = $rootPath+"social/skill/";
var $routeSupport = $rootPath+"social/support";

var $routeFile = $rootPath+"file/";

$("#logout").attr("href",$routeLogOut);
//基础信息
$("#size").attr("href",$routeSize);
$("#info").attr("href",$routeInfo);
$("#funds").attr("href",$routeFunds);
$("#teachers").attr("href",$routeTeac);
$("#equip").attr("href",$routeEquip);
//学生发展
$("#stu").attr("href",$routeStu);
$("#emp").attr("href",$routeEmp);
//质量保证

// TODO 专业开设
$("#majnum").attr("href",$routeMajNum);
$("#assure").attr("href",$routeAssure);
$("#edu").attr("href",$routeEducation);


//校企合作
$("#schoolEnter").attr("href",$routeSchoolEnter);
$("#internship").attr("href",$routeInternship);
$("#group").attr("href",$routeGroup);

//社会相关
$("#party").attr("href",$routeParty);
$("#skilltrain").attr("href",$routeSkill);
$("#support").attr("href",$routeSupport);
$("#service").attr("href",$routeService);

var $routeFile = $rootPath+"file/";
//$("#targetTable").attr("src",$rootPath+"basic/info");
</script>
</body>
</html>
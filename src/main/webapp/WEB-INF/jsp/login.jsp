<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据采集系统</title>
<%@include file="./common.jspf"%>
    <script type="text/javascript">
        $(function () {
            $('input, textarea').placeholder();
        });
    </script>
</head>

<body class="lg_bg">
    <form name="form1" method="post" action="http://localhost:8080/collectingSystem/auth/login" id="form1">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTI4NzY1OTExN2QYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFDmlzc2F2ZUFjY291bnQxsjlQjq8j2PR6goZRVU/znYgJmSU=" />
</div>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBgLB0O/uDgLxz+7pAwLF8aT7BgKGuIO4BwKhwImNCwKiwImNC0u0OrbBF7uSFKyiETJhW7Fyyv1r" />
</div>
    <div class="lg_01">
        <div class="lg_02">
            <div class="lg_03"></div>
            <div class="lg_04"></div>
            <div class="lg_05">
                <ul>
                    <li class="lg_07">USER&nbsp;LOGIN</li>
                    <li>${welcomeMsg}</li>
                    <li>
                        <input name="name" type="text" id="tb_Username1" class="lg_08" placeholder="请输入用户名" />
                    <li>
                        <input name="password" type="text" id="tb_Password1" class="lg_09" placeholder="请输入密码" />
                    <li>
                        <input type="submit" name="ctl00" value="重新填写" class="lg_13" />
                        <input type="submit" name="ctl01" value="登录系统" class="lg_14" />
                    </li>
                </ul>
            </div>
             <div id="down_center"><br/>
                 <span id="lb_Err" style="font-weight: bold;
                                                    color: red"></span>

             </div>
        </div>
        <p class="lg_06">版权所有：四川省教育科学研究所&nbsp;&nbsp;&nbsp;&nbsp;技术支持：电子科技大学网络信息系统团队</p>
    </div>
   </form>
</body>
</html>



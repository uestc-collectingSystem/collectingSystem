<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="./common.jspf"%>
<!-- <tbody>
<td>
<li>教职工总人数</li>
<li>教职工编制数</li>
<li>在编教职工数</li>
<li>专任教师数</li>
<li>其中公共基础课专任教师数</li>
<li>其中专业课专任教师数</li>
<li>行业企业兼职教师数</li>
<li>本科以下学历专任教师数</li>
<li>本科学历专任教师数</li>
<li>具有研究生学历或学位的专任教师数</li>
<li>高级职称专任教师数</li>
<li>中级职称专任教师数</li>
<li>初级职称专任教师数</li>
<li>未评职称专任教师数</li>
<li>35岁及以下专任教师数</li>
<li>36~45 岁专任教师数</li>
<li>46~55 岁专任教师数</li>
<li>56 岁及以上专任教师数</li>
<li>男教师数</li>
<li>女教师数</li>
<li>双师型教师数</li>
<li>专任教师课平均每周课时数</li>
<li>专业课教师平均每周课时数</li>
<li>行业企业兼职教师课时总量</li>
<li>持有心理咨询证书的教师数</li>
<li>专职心理咨询教师数</li>
<li>市(州)级以上学科带头人教师数</li>
<li>省特级教师数</li>
<li>实践教学专职指导教师数</li>
<li>外籍教师数量</li>
</td>
<td>
<li><input class ="id_28" name="StaffNum"/></li><br>
<li><input class ="id_28" name="StaffAdmin"/></li><br>
<li><input class ="id_28" name="StaffPrepJob"/></li><br>
<li><input class ="id_28" name="FullTime"/></li><br>
<li><input class ="id_28" name="BasicCourse"/></li><br>
<li><input class ="id_28" name="Course"/></li><br>
<li><input class ="id_28" name="IndustryEnterprise"/></li><br>
<li><input class ="id_28" name="UndergraLess"/></li><br>
<li><input class ="id_28" name="Undergra"/></li><br>
<li><input class ="id_28" name="FullPostgrad"/></li><br>
<li><input class ="id_28" name="SubHighMore"/></li><br>
<li><input class ="id_28" name="IntermediateGrade"/></li><br>
<li><input class ="id_28" name="JuniorTitle"/></li><br>
<li><input class ="id_28" name="NoConferTeac"/></li><br>
<li><input class ="id_28" name="ThreeFiveLess"/></li><br>
<li><input class ="id_28" name="ThreeSixFourFive"/></li><br>
<li><input class ="id_28" name="FourSixFiveFive"/></li><br>
<li><input class ="id_28" name="FiveSixMore"/></li><br>
<li><input class ="id_28" name="Male"/></li><br>
<li><input class ="id_28" name="Female"/></li><br>
<li><input class ="id_28" name="DoubleTeac"/></li><br>
<li><input class ="id_28" name="FullClassHour"/></li><br>
<li><input class ="id_28" name="CourseClassHour"/></li><br>
<li><input class ="id_28" name="InduEnterHour"/></li><br>
<li><input class ="id_28" name="CounselCertificate"/></li><br>
<li><input class ="id_28" name="FulltimeCounsel"/></li><br>
<li><input class ="id_28" name="CityDiscipLeader"/></li><br>
<li><input class ="id_28" name="ProvSuper"/></li><br>
<li><input class ="id_28" name="ExerProTeac"/></li><br>
<li><input class ="id_28" name="ForeignTeac"/></li><br>
</td> -->
<tbody>

<tr><th scope="row">学校代码</th>
<td><input class="id_28" name="Admcode"/></td>
</tr>
<tr><th scope="row">年份</th>
<td><input class="id_28" name="Year"/></td>
</tr>

<tr><th scope = "row">教职工总人数</th>
<td><input class ="id_28" name="StaffNum"/></td>
</tr>
<tr><th scope = "row">教职工编制数</th>
<td><input class ="id_28" name="StaffAdmin"/></td>
</tr>
<tr><th scope = "row">在编教职工数</th>
<td><input class ="id_28" name="StaffPrepJob"/></td>
</tr>
<tr><th scope = "row">专任教师数</th>
<td><input class ="id_28" name="FullTime"/></td>
</tr>
<tr><th scope = "row">其中公共基础课专任教师数</th>
<td><input class ="id_28" name="BasicCourse"/></td>
</tr>
<tr><th scope = "row">其中专业课专任教师数</th>
<td><input class ="id_28" name="Course"/></td>
</tr>
<tr><th scope = "row">行业企业兼职教师数</th>
<td><input class ="id_28" name="IndustryEnterprise"/></td>
</tr>
<tr><th scope = "row">本科以下学历专任教师数</th>
<td><input class ="id_28" name="UndergraLess"/></td>
</tr>
<tr><th scope = "row">本科学历专任教师数</th>
<td><input class ="id_28" name="Undergra"/></td>
</tr>
<tr><th scope = "row">具有研究生学历或学位的专任教师数</th>
<td><input class ="id_28" name="FullPostgrad"/></td>
</tr>
<tr><th scope = "row">高级职称专任教师数</th>
<td><input class ="id_28" name="SubHighMore"/></td>
</tr>
<tr><th scope = "row">中级职称专任教师数</th>
<td><input class ="id_28" name="IntermediateGrade"/></td>
</tr>
<tr><th scope = "row">初级职称专任教师数</th>
<td><input class ="id_28" name="JuniorTitle"/></td>
</tr>
<tr><th scope = "row">未评职称专任教师数</th>
<td><input class ="id_28" name="NoConferTeac"/></td>
</tr>
<tr><th scope = "row">35岁及以下专任教师数</th>
<td><input class ="id_28" name="ThreeFiveLess"/></td>
</tr>
<tr><th scope = "row">36~45 岁专任教师数</th>
<td><input class ="id_28" name="ThreeSixFourFive"/></td>
</tr>
<tr><th scope = "row">46~55 岁专任教师数</th>
<td><input class ="id_28" name="FourSixFiveFive"/></td>
</tr>
<tr><th scope = "row">56 岁及以上专任教师数</th>
<td><input class ="id_28" name="FiveSixMore"/></td>
</tr>
<tr><th scope = "row">男教师数</th>
<td><input class ="id_28" name="Male"/></td>
</tr>
<tr><th scope = "row">女教师数</th>
<td><input class ="id_28" name="Female"/></td>
</tr>
<tr><th scope = "row">双师型教师数</th>
<td><input class ="id_28" name="DoubleTeac"/></td>
</tr>
<tr><th scope = "row">专任教师课平均每周课时数</th>
<td><input class ="id_28" name="FullClassHour"/></td>
</tr>
<tr><th scope = "row">专业课教师平均每周课时数</th>
<td><input class ="id_28" name="CourseClassHour"/></td>
</tr>
<tr><th scope = "row">行业企业兼职教师课时总量</th>
<td><input class ="id_28" name="InduEnterHour"/></td>
</tr>
<tr><th scope = "row">持有心理咨询证书的教师数</th>
<td><input class ="id_28" name="CounselCertificate"/></td>
</tr>
<tr><th scope = "row">专职心理咨询教师数</th>
<td><input class ="id_28" name="FulltimeCounsel"/></td>
</tr>
<tr><th scope = "row">市(州)级以上学科带头人教师数</th>
<td><input class ="id_28" name="CityDiscipLeader"/></td>
</tr>
<tr><th scope = "row">省特级教师数</th>
<td><input class ="id_28" name="ProvSuper"/></td>
</tr>
<tr><th scope = "row">实践教学专职指导教师数</th>
<td><input class ="id_28" name="ExerProTeac"/></td>
</tr>
<tr><th scope = "row">外籍教师数量</th>
<td><input class ="id_28" name="ForeignTeac"/></td>
</tr>
<%@include file="./tail.jspf"%>
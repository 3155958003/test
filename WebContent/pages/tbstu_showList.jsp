<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center">学生信息列表</h1>
	<table border="1" width="65%" style="text-align:center">
	<tr>
	<td>编号</td><td>姓名</td><td>年龄</td><td>性别</td>
	<td>入学时间</td><td>班级</td><td>管理</td>
	</tr>
	<c:forEach items="${stuList }" var="stu" varStatus="ids">
	<tr>
	<td>${ids.count }</td><td>${stu[0].sname }</td><td>${stu[0].sage }</td><td>${stu[0].ssex }</td>
	<td>${stu[0].sintime}</td><td>${stu[1].cname }</td>
	<td>
		&nbsp;<a href="<%=basePath%>tbStuAction/deleteTbStu?sno=${stu[0].sno}">删除</a>&nbsp;|&nbsp;
		<a href="<%=basePath%>tbStuAction/toUpdateTbStu?stu.sno=${stu[0].sno}">修改</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	<br/>
	<a href="<%=basePath%>tbStuAction/showTbCls">添加学生</a>
</body>
</html>
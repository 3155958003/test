<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=basePath%>pages/tbcls_add.jsp">添加班级</a><br/>
	<a href="<%=basePath%>pages/tbcls_showList.jsp">班级管理</a><br/>
	<hr>
	<a href="<%=basePath%>tbStuAction/showTbCls">添加学生</a><br/>
	<a href="<%=basePath%>tbStuAction/showAllTbStuList">学生管理</a><br/>
</body>
</html>